package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day10Part2
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_10_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<String>();
		while(file.hasNext())
		{
			input.add(file.nextLine());
		}
		char[][] mat = new char[input.size()][];
		for(int a = 0; a < input.size(); a++)
			mat[a] = input.get(a).toCharArray();
		ArrayList<Point> starts = new ArrayList<Point>();
		for(int a = 0; a < mat.length; a++)
			for(int b = 0; b < mat[a].length; b++)
				if(mat[a][b] == '0')
					starts.add(new Point(a,b));
		int[] help = {-1,0,1,0,-1};
		for(Point start : starts)
		{
			ArrayList<Point> list = new ArrayList<Point>();
			list.add(start);
			while(!list.isEmpty())
			{
				Point current = list.remove(0);
				for(int a = 0; a < 4; a++)
				{
					try 
					{
						Point next = new Point(current.y + help[a], current.x + help[a+1]);
						if(mat[next.y][next.x] == mat[current.y][current.x]+1)
							if(mat[next.y][next.x] == '9')
							{
								sum++;
							}
							else 
							{
								list.add(next);
							}
					} 
					catch (IndexOutOfBoundsException e) {}
				}
			}
		}
		System.out.println(sum);
	}

}

//class Point
//{
//	int x;
//	int y;
//	Point(int y, int x)
//	{
//		this.x = x;
//		this.y = y;
//	}
//}