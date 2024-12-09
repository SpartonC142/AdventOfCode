package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day6Part1
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_6_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<String>();
		while(file.hasNext())
		{
			input.add(file.nextLine());
		}
		char[][] mat = new char[input.size()][];
		int x = 0;
		int y = 0;
		for(int a = 0; a < input.size(); a++)	
		{
			String tem = input.get(a);
			if(tem.contains("^"))
			{
				y = a;
				x = tem.indexOf('^');
			}
			mat[a] = tem.toCharArray();
		}
		mat[y][x] = 'X';
		sum++;
		boolean end = false;
		int[] help = {-1,0,1,0,-1};
		int dir = 0;
		while(!end)
		{
			try 
			{
				char next = mat[y+help[dir]][x+help[dir+1]];
				if(next == '#')
					dir = (dir + 1) % 4;
				else 
				{
					if(next == '.')
					{
						sum++;
						mat[y+help[dir]][x+help[dir+1]] = 'X';
					}
					y += help[dir];
					x += help[dir+1];
				}
			} 
			catch (IndexOutOfBoundsException e) 
			{
				end = true;
			}
		}
		System.out.println(sum);
	}

}
