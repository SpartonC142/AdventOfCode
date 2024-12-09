package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11Part1
{

	public static void main(String[] args) throws FileNotFoundException
	{
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_11_input.txt"));
		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<>();
		while(file.hasNext())
		{
			String line = file.nextLine();
			input.add(line);
			if(!line.contains("#"))
				input.add(line);
		}
		for(int a = input.get(0).length()-1; a>=0; a--)
		{
			boolean empty = true;
			for(int b = 0; b< input.size(); b++)
				if(input.get(b).charAt(a)=='#')
					empty = false;
			if(empty)
				for(int b = 0; b< input.size(); b++)
				{
					String tem = input.get(b);
					input.set(b, tem.substring(0,a) + "." + tem.substring(a));
				}
		}
		char[][] map = new char[input.size()][];
		for(int a = 0; a < input.size(); a++)
			map[a] = input.get(a).toCharArray();
		ArrayList<Point> galaxies = new ArrayList<Point>();
		for(int a = 0; a< map.length; a++)
			for(int b = 0; b< map[0].length; b++)
				if(map[a][b] == '#')
					galaxies.add(new Point(b,a));
		for(int a = 0; a < galaxies.size()-1; a++)
			for(int b = a+1; b < galaxies.size(); b++)
			{
				map = new char[input.size()][];
				for(int c = 0; c < input.size(); c++)
					map[c] = input.get(c).toCharArray();
				Point end = galaxies.get(b);
				ArrayList<Point> currentList = new ArrayList<Point>();
				ArrayList<Point> newList = new ArrayList<Point>();
				currentList.add(galaxies.get(a));
				map[galaxies.get(a).y][galaxies.get(a).x] = 'X';
				int steps = 0;
				boolean found = false;
				while(!found)
				{
					while(!currentList.isEmpty())
					{
						Point current = currentList.remove(0);
						if(current.x == end.x && current.y == end.y)
						{
							found = true;
							currentList.clear();
						}
						else 
						{
							int[] help = {1,0,-1,0,1};
							for(int c = 0; c < 4; c++)
							{
								try
								{
									if(map[current.y + help[c]][current.x + help[c+1]] != 'X')
									{
										map[current.y + help[c]][current.x + help[c+1]]= 'X';
										newList.add(new Point(current.x + help[c+1],current.y + help[c]));
									}
								} 
								catch (IndexOutOfBoundsException e) {}
							}
						}
					}
					currentList = newList;
					newList = new ArrayList<Point>();				
					steps++;
				}
//				for(char[] tem : map)
//				{
//					for(char t : tem)
//						System.out.print(t);
//					System.out.println();
//				}
//				System.out.println(steps);
				sum += steps-1;	
			}
					
		
		System.out.println(sum);
	}

}