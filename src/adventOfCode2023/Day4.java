package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_4_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		ArrayList<String> cards = new ArrayList<String>();
		while(file.hasNext())
		{
			cards.add(file.nextLine().substring(8).trim());
		}
		int[] points = new int[cards.size()];
		Arrays.fill(points, 1);
		for(int a = 0; a< cards.size(); a++)
		{
			String line = cards.get(a);
			String[] winners = line.substring(0, line.indexOf("|")).split(" +");
			String[] test = line.substring(line.indexOf("|")+1).split(" +");
			int pnt = 0;
			for(String num : test)
			{
				for(int b = 0; b < winners.length; b++)
					if(num.equals(winners[b]))
						pnt++;
			}
			for(int b = a+1; b< pnt + a+1; b++)
			{
				points[b]+=points[a];
			}
		}
		for(int tem : points)
			sum+=tem;
		System.out.println(sum);
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_4_input.txt"));
////		Scanner file = new Scanner(new File("inputFIles/test.txt"));
//		int sum = 0;
//		while(file.hasNext())
//		{
//			String line = file.nextLine();
//			line = line.substring(8).trim();
//			String[] winners = line.substring(0, line.indexOf("|")).split(" +");
//			String[] test = line.substring(line.indexOf("|")+1).split(" +");
//			int points = 0;
//			for(String num : test)
//			{
//				for(int a = 0; a < winners.length; a++)
//					if(num.equals(winners[a]))
//					{
//						if(points == 0)
//							points++;
//						else {
//							points*=2;
//						}
//					}
//			}
//			sum += points;
//		}
//		System.out.println(sum);
	}
}