package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day1Part1
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_1_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int sum = 0;
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		while(file.hasNext())
		{
			left.add(file.nextInt());
			right.add(file.nextInt());
		}
		Collections.sort(left);
		Collections.sort(right);
		for(int a = 0; a < left.size(); a++)
			sum += Math.abs(left.get(a)-right.get(a));
		System.out.println(sum);
	}

}
