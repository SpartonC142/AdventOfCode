package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day16Part1 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_16_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<>();
		while(file.hasNext())
			input.add(file.nextLine());
			
		char[][] mat = new char[input.size()][];
		for(int a = 0; a < input.size(); a++)
			mat[a] = input.get(a).toCharArray();
		boolean[][] energized = new boolean[mat.length][mat[0].length];
		
		ArrayList<Position2> points = new ArrayList<Position2>();
		points.add(new Position2(0, -1, 2));
		ArrayList<String> past = new ArrayList<String>();
		while(!points.isEmpty())
		{
			Position2 pos = points.remove(0);
			if(past.contains(""+pos.x+" "+pos.y+" "+pos.dir))
				continue;
			past.add(""+pos.x+" "+pos.y+" "+pos.dir);
			try 
			{
				switch (pos.dir) 
				{
					case 1: 
						pos.x -= 1;
						energized[pos.x][pos.y] = true;
						switch(mat[pos.x][pos.y])
						{
							case '\\':
								points.add(new Position2(pos.x, pos.y, 4));
								break;
							
							case '/':
								points.add(new Position2(pos.x, pos.y, 2));
								break;
								
							case '-':
								points.add(new Position2(pos.x, pos.y, 2));
								points.add(new Position2(pos.x, pos.y, 4));
								break;
								
							default:
								points.add(new Position2(pos.x, pos.y, 1));
						}
						break;
						
					case 2: 
						pos.y += 1;
						energized[pos.x][pos.y] = true;
						switch(mat[pos.x][pos.y])
						{
							case '\\':
								points.add(new Position2(pos.x, pos.y, 3));
								break;
							
							case '/':
								points.add(new Position2(pos.x, pos.y, 1));
								break;
								
							case '|':
								points.add(new Position2(pos.x, pos.y, 1));
								points.add(new Position2(pos.x, pos.y, 3));
								break;
								
							default:
								points.add(new Position2(pos.x, pos.y, 2));
						}
						break;
						
					case 3: 
						pos.x += 1;
						energized[pos.x][pos.y] = true;
						switch(mat[pos.x][pos.y])
						{
							case '\\':
								points.add(new Position2(pos.x, pos.y, 2));
								break;
							
							case '/':
								points.add(new Position2(pos.x, pos.y, 4));
								break;
								
							case '-':
								points.add(new Position2(pos.x, pos.y, 2));
								points.add(new Position2(pos.x, pos.y, 4));
								break;
								
							default:
								points.add(new Position2(pos.x, pos.y, 3));
						}
						break;
						
					case 4: 
						pos.y -= 1;
						energized[pos.x][pos.y] = true;
						switch(mat[pos.x][pos.y])
						{
							case '\\':
								points.add(new Position2(pos.x, pos.y, 1));
								break;
							
							case '/':
								points.add(new Position2(pos.x, pos.y, 3));
								break;
								
							case '|':
								points.add(new Position2(pos.x, pos.y, 1));
								points.add(new Position2(pos.x, pos.y, 3));
								break;
								
							default:
								points.add(new Position2(pos.x, pos.y, 4));
						}
						break;
				}
			} catch (IndexOutOfBoundsException e) {}
		}
		
		for(int a = 0; a < energized.length; a++)
			for(int b = 0; b< energized[0].length; b++)
				if(energized[a][b])
					sum++;

		System.out.println(sum);
	}
}

class Position
{
	int x;
	int y;
	int dir;
	
	Position(int x, int y, int dir)
	{
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}