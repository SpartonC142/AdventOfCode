package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9Part1
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_9_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		while(file.hasNext())
		{
			String[] line = file.nextLine().split(" ");
			ArrayList<int[]> list = new ArrayList<>();
			int[] tem = new int[line.length+1];
			for(int a = 0; a<line.length; a++)
				tem[a] = Integer.parseInt(line[a]);
			list.add(tem);
			int a = 0;
			boolean cont = true;;
			while(cont)
			{
				tem = new int[list.get(a).length-1];
				for(int b = 0; b< tem.length-1; b++)
					tem[b] = list.get(a)[b+1] - list.get(a)[b];
				list.add(tem);
				a++;
				cont = false;
				for(int t : tem)
					if(t!=0)
						cont = true;
			}
			a--;
			for(; a >= 0; a--)
			{
				list.get(a)[list.get(a).length-1] = list.get(a+1)[list.get(a+1).length-1] + list.get(a)[list.get(a).length-2];
			}
			sum+=list.get(0)[list.get(0).length-1];
		}
		System.out.println(sum);
	}
}
