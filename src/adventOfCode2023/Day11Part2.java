package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day11Part2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_11_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		long sum = 0;
		ArrayList<String> input = new ArrayList<>();
		ArrayList<Integer> horiz = new ArrayList<Integer>();
		ArrayList<Integer> vert = new ArrayList<Integer>();
		while(file.hasNext())
		{
			String line = file.nextLine();
			input.add(line);
			if(!line.contains("#"))
				horiz.add(input.size()-1);
		}
		char[][] map = new char[input.size()][];
		for(int a = 0; a < input.size(); a++)
			map[a] = input.get(a).toCharArray();
		
		G:for(int a = 0; a< map[0].length; a++)
		{
			for(int b = 0; b < map.length; b++)
				if(map[b][a] == '#')
					continue G;
			vert.add(a);
		}
//		System.out.println(horiz);
//		System.out.println(vert);
		
		ArrayList<Point> galaxies = new ArrayList<Point>();
		for(int a = 0; a< map.length; a++)
			for(int b = 0; b< map[0].length; b++)
				if(map[a][b] == '#')
					galaxies.add(new Point(b,a));
		int mod = 1000000;
		for(int a = 0; a < galaxies.size()-1; a++)
			for(int b = a+1; b < galaxies.size(); b++)
			{
				Point start = galaxies.get(a);
				Point end = galaxies.get(b);
				long steps = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
				for(int tem : vert)
					if((start.x < tem && end.x > tem)||(start.x > tem && end.x < tem))
						steps += mod - 1;
				for(int tem : horiz)
					if((start.y < tem && end.y > tem)||(start.y > tem && end.y < tem))
						steps += mod - 1;
				sum += steps;
			}
		System.out.println(sum);
	}

}
