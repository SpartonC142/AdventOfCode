package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day4Part2
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
		ArrayList<Character> test = new ArrayList<Character>();
		test.add('A');
		test.add('M');
		test.add('S');
		for(int a = 0; a < input.size(); a++)
			for(int b = 0; b < input.get(a).length(); b++)
				if(input.get(a).charAt(b) == 'A')
				{
					try 
					{
						ArrayList<Character> test2 = new ArrayList<Character>();
						test2.add('A');
						test2.add(input.get(a-1).charAt(b-1));
						test2.add(input.get(a+1).charAt(b+1));
						Collections.sort(test2);
						ArrayList<Character> test3 = new ArrayList<Character>();
						test3.add('A');
						test3.add(input.get(a-1).charAt(b+1));
						test3.add(input.get(a+1).charAt(b-1));
						Collections.sort(test3);
						if(test.equals(test2) && test.equals(test3))
							sum++;
					} 
					catch (Exception e) {}
				}
		System.out.println(sum);
	}

}
