package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day7Part1
{

	public static void main(String[] args)throws IOException
	{
//		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_7_input.txt"));
		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		long sum = 0;
		ArrayList<String> input = new ArrayList<String>();
		while(file.hasNext())
			input.add(file.nextLine());
		for(String line : input)
		{
			long total = Long.parseLong(line.substring(0, line.indexOf(":")));
			line = line.substring(line.indexOf(":")+2);
			String[] temp = line.split(" ");
			int[] nums = new int[temp.length];
			for(int a = 0; a < temp.length; a++)
				nums[a] = Integer.parseInt(temp[a]);
			Day7Part1 name = new Day7Part1();
			if(name.match(total, "", nums))
				sum += total;
		}
		
		System.out.println(sum);
	}
	
	public boolean match(long total, String operators, int[] nums)
	{
		if(operators.length() < nums.length-1)
			return match(total, operators + "+", nums) || match(total, operators + "*", nums);
		return total == evaluate(operators, nums);
	}

	public long evaluate(String operators, int[] nums)
	{
		long total = nums[0];
		for(int a = 1; a < nums.length; a++)
			if(operators.charAt(a-1) == '+')
				total += nums[a];
			else
				total *= nums[a];
		return total;
	}
}
