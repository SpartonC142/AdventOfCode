package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_8_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		String instr = file.nextLine();
		file.nextLine();
		ArrayList<String> element = new ArrayList<String>();
		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> right = new ArrayList<String>();
		int steps = 0;
		while(file.hasNext())
		{
			String[] line = file.nextLine().trim().replaceAll("[=,()]","").split(" +");
			element.add(line[0]);
			left.add(line[1]);
			right.add(line[2]);
		}
		int index = element.indexOf("AAA");
		while(!element.get(index).equals("ZZZ"))
		{
			if(instr.charAt(steps%instr.length())=='L')
				index = element.indexOf(left.get(index));
			else
				index = element.indexOf(right.get(index));
			steps++;
		}
		System.out.println(steps);
	}

}