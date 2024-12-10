package adventOfCode2024;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9Part1 
{
	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_9_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		long sum = 0;
		String line = file.nextLine();
		if(line.length()%2 ==1)
			line += "0";
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int a = 0; a*2 < line.length(); a++)
		{
			int num = line.charAt(a*2)-48;
			for(int b = 0; b < num; b++)
				list.add(a);
		}
		int index = line.charAt(0)-48;
		int place = 1;
		while(index < list.size())
		{
			for(int a = 0; a < line.charAt(place)-48; a++)
				list.add(index++, list.remove(list.size()-1));
			index+=line.charAt(place+1)-48;
			place+=2;
		}
//		System.out.println(list);
		for(int a = 0; a < list.size(); a++)
			sum += a* list.get(a);
		System.out.println(sum);
	}
}
