package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day4Part1
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_4_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<String>();
		while(file.hasNext())
		{
			input.add(file.nextLine());
		}
		for(int a = 0; a < input.size(); a++)
			for(int b = 0; b < input.get(a).length(); b++)
				if(input.get(a).charAt(b) == 'X')
				{
					ArrayList<String> test = new ArrayList<String>();
					int[] help = {1,0,-1,0,1,1,-1,-1,1};
					for(int c = 0; c < help.length-1; c++)
					{
						try 
						{
							String tem = "X";
							for(int d = 1; d < 4; d++)
							{
								tem += input.get(a+help[c]*d).charAt(b+help[c+1]*d);
							}
							test.add(tem);
						} 
						catch (Exception e) {}
					}
					for(String t : test)
						if(t.equals("XMAS"))
							sum++;
				}
		System.out.println(sum);
	}

}
