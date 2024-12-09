package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day15Part1 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_15_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		String input = "";
		while(file.hasNext())
			input += file.nextLine();
		String[] in = input.split(",");
		for(String step : in)
		{
			int subSum = 0;
			for(char l : step.toCharArray())
			{
				subSum += l;
				subSum *= 17;
				subSum %= 256;
			}
			System.out.println(subSum);
			sum += subSum;
		}
		System.out.println(sum);
	}
}
