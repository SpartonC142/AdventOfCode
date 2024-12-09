package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day12Part1
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_12_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		while(file.hasNext())
		{
			String line = file.nextLine();
			String springs = line.substring(0,line.indexOf(" ")).replaceAll("[.]", "x");
			String regex = line.substring(line.indexOf(" ")+1);
			regex = regex.replaceAll("," , "}x+#{");
			regex = "x*#{"+regex+"}x*";
			Day12Part1 twlve = new Day12Part1();
			int count = twlve.match(springs, regex);
			sum+=count;
		}
		System.out.println(sum);
	}

	public int match(String springs, String regex)
	{
		if(!springs.contains("?"))
			return springs.matches(regex) ? 1 : 0;
			
		int index = springs.indexOf("?");
		int sum = 0;
		sum += match(springs.substring(0,index) + "x" + springs.substring(index+1), regex);
		sum += match(springs.substring(0,index) + "#" + springs.substring(index+1), regex);
		return sum;
	}
}
