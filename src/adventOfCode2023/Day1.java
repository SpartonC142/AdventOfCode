package adventOfCode2023;
import java.io.*;
import java.util.*;

public class Day1
{

	public static void main(String[] args)throws IOException
	{
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_1_input.txt"));
		Scanner file = new Scanner(new File("inputFiles/test.txt"));
		int sum = 0;
		while(file.hasNext())
		{
			String line = file.nextLine();
//			System.out.println(line);
			line = line.replaceAll("one", "o1e");
			line = line.replaceAll("two", "t2o");
			line = line.replaceAll("three", "t3e");
			line = line.replaceAll("four", "f4r");
			line = line.replaceAll("five", "f5e");
			line = line.replaceAll("six", "s6x");
			line = line.replaceAll("seven", "s7n");
			line = line.replaceAll("eight", "e8t");
			line = line.replaceAll("nine", "n9e");
			line = line.replaceAll("[a-zA-Z]", "");
			int num = Integer.parseInt(line.charAt(0)+""+line.charAt(line.length()-1));
//			System.out.println(num);
			sum+=num;
		}
		System.out.println(sum);
	}

}
