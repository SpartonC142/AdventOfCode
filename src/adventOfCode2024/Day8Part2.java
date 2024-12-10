package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day8Part2
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_8_input.txt"));
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
		LinkedHashMap<Character, ArrayList<Point>> map = new LinkedHashMap<Character, ArrayList<Point>>();
		for(int a = 0; a < mat.length; a++)
			for(int b = 0; b < mat[a].length; b++)
				if(mat[a][b] != '.')
				{
					if(!map.containsKey(mat[a][b]))
						map.put(mat[a][b], new ArrayList<Point>());
					map.get(mat[a][b]).add(new Point(a,b));
				}
		for(char key : map.keySet())
			for(Point point1 : map.get(key))
				for(Point point2 : map.get(key))
					if(point1 != point2)
					{
						if(mat[point1.y][point1.x] != '#')
						{
							mat[point1.y][point1.x] = '#';
							sum++;
						}
						int xdif = point1.x - point2.x;
						int ydif = point1.y - point2.y;
						int cnt = 1;
						boolean stop = false;
						while(!stop)
						{
							cnt++;
							try 
							{
								if(mat[point1.y + ydif*cnt][point1.x + xdif*cnt] != '#')
								{
									mat[point1.y + ydif*cnt][point1.x + xdif*cnt] = '#';
									sum++;
								}
							} 
							catch (IndexOutOfBoundsException e) 
							{
								stop = true;
							}
						}
						cnt = 1;
						stop = false;
						while(!stop)
						{
							cnt++;
							try 
							{
								if(mat[point1.y - ydif*cnt][point1.x - xdif*cnt] != '#')
								{
									mat[point1.y - ydif*cnt][point1.x - xdif*cnt] = '#';
									sum++;
								}
							} 
							catch (IndexOutOfBoundsException e) 
							{
								stop = true;
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