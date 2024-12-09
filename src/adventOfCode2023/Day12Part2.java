package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day12Part2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_12_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		long sum = 0;
//		int cnt = 0;
		while(file.hasNext())
		{
			String line = file.nextLine();
			String springs = line.substring(0,line.indexOf(" ")).replaceAll("[.]", "x");
			String regex = line.substring(line.indexOf(" ")+1);
			String tem1 = springs;
			String tem2 = regex;
			for(int a = 0; a< 4; a++)
			{
				tem1+= "?" + springs;
				tem2+= "," + regex;
			}
			springs = tem1;
			regex = tem2;
//			System.out.println(springs);
//			System.out.println(regex);
			String[] tem = regex.split(",");
			int[] sizes = new int[tem.length];
			for(int a = 0; a < sizes.length; a++)
				sizes[a] = Integer.parseInt(tem[a]);
			Day12Part2 twlve = new Day12Part2();
			long count = twlve.match(springs, sizes);
			sum+=count;
			System.out.println(count);
		}
		System.out.println(sum);
	}

	public long match(String springs, int[] sizes)
	{
		System.out.println(springs);
		if(!springs.contains("?"))
		{
			if(springs.indexOf("#")==-1)
				return 0;
			String [] tem = springs.substring(springs.indexOf("#")).split("x+");
			if(tem.length != sizes.length)
				return 0;
			return help(tem, sizes) ? 1 : 0;
		}
		String[] t = springs.split("x+");
		if(t.length < sizes.length)
		{
			boolean skip = true;
			for(String tem : t)
				if(tem.length() >2)
				{
					skip = false;
					break;
				}
			if(skip)
				return 0;
		}
			
		int index = springs.indexOf("?");
		int index3 = index;
		while(index3 > 0 && springs.charAt(index3)!='x')
			index3--;
		int index2 = springs.indexOf("#");
		if(index3 > index2 && index2 != -1)
		{
			String[] tem = springs.substring(index2,index3).split("x+");
			if(tem.length > sizes.length)
				return 0;
			if(!help(tem,sizes))
				return 0;
		}
		
		long sum = 0;
		sum += match(springs.substring(0,index) + "x" + springs.substring(index+1), sizes);
		sum += match(springs.substring(0,index) + "#" + springs.substring(index+1), sizes);
		return sum;
	}

	public boolean help(String[] springs, int[] sizes)
	{
		for(int a = 0; a < springs.length; a++)
			if(springs[a].length() != sizes[a])
				return false;
		return true;
	}
}
