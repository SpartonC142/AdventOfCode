package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10Part1
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_10_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int step = 1;
		ArrayList<String> input = new ArrayList<>();
		while(file.hasNext())
			input.add(file.nextLine());
		char[][] map = new char[input.size()][];
		for(int a = 0; a < input.size(); a++)
			map[a] = input.get(a).toCharArray();
		Point start = null;
		for(int a = 0; a < map.length; a++)
			for(int b = 0; b< map[a].length; b++)
				if(map[a][b] == 'S')
				{
					start = new Point(b,a);
					map[a][b] = 125;
				}
		ArrayList<Point> steps = new ArrayList<Point>();
		try 
		{
			if(map[start.y-1][start.x] == '|' || map[start.y-1][start.x] == 'F' || map[start.y-1][start.x] == '7')
				steps.add(new Point(start.x, start.y-1));
		}
		catch (IndexOutOfBoundsException e) {}
		try 
		{
			if(map[start.y+1][start.x] == '|' || map[start.y+1][start.x] == 'L' || map[start.y+1][start.x] == 'J')
				steps.add(new Point(start.x, start.y+1));
		}
		catch (IndexOutOfBoundsException e) {}
		try 
		{
			if(map[start.y][start.x-1] == '-' || map[start.y][start.x-1] == 'L' || map[start.y][start.x-1] == 'F')
				steps.add(new Point(start.x-1, start.y));
		}
		catch (IndexOutOfBoundsException e) {}
		try 
		{
			if(map[start.y][start.x+1] == '-' || map[start.y][start.x+1] == '7' || map[start.y][start.x+1] == 'J')
				steps.add(new Point(start.x+1, start.y));
		}
		catch (IndexOutOfBoundsException e) {}
		Point path1 = steps.get(0);
		Point path2 = steps.get(1);
		while(path1.x != path2.x || path1.y != path2.y)
		{
			Point tem = next(map, path1);
			map[path1.y][path1.x] = (char)(125 + step);
			path1 = tem;
			tem = next(map, path2);
			map[path2.y][path2.x] = (char)(125 + step);
			path2 = tem;
			step++;
		}	
		
		System.out.println(step);
	}

	public static Point next(char[][] map, Point current)
	{
		char spot = map[current.y][current.x];
		if(spot == '|')
		{
			try 
			{
				if(map[current.y-1][current.x] < 125)
					return new Point(current.x, current.y-1);
				else
					return new Point(current.x, current.y+1);
			}
			catch (IndexOutOfBoundsException e) 
			{
				return new Point(current.x, current.y+1);
			}
		}
		if(spot == 'L')
		{
			try 
			{
				if(map[current.y-1][current.x] < 125)
					return new Point(current.x, current.y-1);
				else
					return new Point(current.x+1, current.y);
			}
			catch (IndexOutOfBoundsException e) 
			{
				return new Point(current.x+1, current.y);
			}
		}
		if(spot == 'J')
		{
			try 
			{
				if(map[current.y-1][current.x] < 125)
					return new Point(current.x, current.y-1);
				else
					return new Point(current.x-1, current.y);
			}
			catch (IndexOutOfBoundsException e) 
			{
				return new Point(current.x-1, current.y);
			}
		}
		if(spot == '-')
		{
			try 
			{
				if(map[current.y][current.x-1] < 125)
					return new Point(current.x-1, current.y);
				else
					return new Point(current.x+1, current.y);
			}
			catch (IndexOutOfBoundsException e) 
			{
				return new Point(current.x+1, current.y);
			}
		}
		if(spot == '7')
		{
			try 
			{
				if(map[current.y+1][current.x] < 125)
					return new Point(current.x, current.y+1);
				else
					return new Point(current.x-1, current.y);
			}
			catch (IndexOutOfBoundsException e) 
			{
				return new Point(current.x-1, current.y);
			}
		}
		if(spot == 'F')
		{
			try 
			{
				if(map[current.y+1][current.x] < 125)
					return new Point(current.x, current.y+1);
				else
					return new Point(current.x+1, current.y);
			}
			catch (IndexOutOfBoundsException e) 
			{
				return new Point(current.x+1, current.y);
			}
		}
		return null;	
	}
}
class Point
{
	int x;
	int y;
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}