package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class Day17Part1 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_17_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		ArrayList<String> input = new ArrayList<>();
		while(file.hasNext())
			input.add(file.nextLine());
			
//		int[][] hell = {{ 1, 0, -1, 0, 1 }, { 0, -1, 0, 1, 0 }, { -1, 0, 1, 0, -1 }, { 0, 1, 0, -1, 0 }};
		Step[][][] mat = new Step[input.size()][input.get(0).length()][4];
		for(int a = 0; a < input.size(); a++)
			for(int b = 0; b<input.get(a).length(); b++)
				for(int c = 0; c < 4; c++)
					mat[a][b][c] = new Step(input.get(a).charAt(b)-48);
		
		mat[0][0][0].least = 0;

		ArrayList<Point2> list = new ArrayList<Point2>();
		list.add(new Point2(0,0,0));
		
		int[] help = { -1, 0, 1, 0, -1 };
//		int[] help = { 1, 0, -1, 0, 1 };
		while(!list.isEmpty())
		{
			Point2 pnt = list.removeFirst();
			Step current = mat[pnt.x][pnt.y][pnt.dir];
			for(int a = 0; a < 4; a++)
			{
				
					try 
					{
						Step next = mat[pnt.x+help[a]][pnt.y+help[a+1]][a];
						if(current.dir != (a+2)%4)
							if(current.least + next.loss < next.least)
							{
								if(current.dir == a)
								{
//									if(current.steps < 3)
									{
										mat[pnt.x+help[a]][pnt.y+help[a+1]][a] = new Step(next.loss, current.least + next.loss, a, current.steps + 1);
										list.add(new Point2(pnt.x+help[a], pnt.y+help[a+1], a));
									}
								}
								else 
								{
									mat[pnt.x+help[a]][pnt.y+help[a+1]][a] = new Step(next.loss, current.least + next.loss, a, 1);
									list.add(new Point2(pnt.x+help[a], pnt.y+help[a+1], a));
								}
							}
								
					} 
					catch (IndexOutOfBoundsException e) {}
			}
		}
//		System.out.println(Arrays.toString(mat[1][0]));
//		System.out.println();
//		System.out.println(Arrays.toString(mat[1][0]));
//		System.out.println();
//		System.out.println(Arrays.toString(mat[1][1]));
//		System.out.println();
//		System.out.println(Arrays.toString(mat[0][1]));
//		System.out.println();
//		
//		System.out.println(Arrays.toString(mat[mat.length-1][mat[0].length-1]));
		long low1 = Math.min(mat[mat.length-1][mat[0].length-1][0].least, mat[mat.length-1][mat[0].length-1][1].least);
		long low2 = Math.min(mat[mat.length-1][mat[0].length-1][2].least, mat[mat.length-1][mat[0].length-1][3].least);
		System.out.println(Math.min(low1, low2));
	}
}

class Step
{
	int loss;
	long least = Integer.MAX_VALUE;
	int dir = -2;
	int steps = 0;
	
	Step(int loss)
	{
		this.loss = loss;
	}
	
	Step(int loss, long least, int dir, int steps)
	{
		this.loss = loss;
		this.least = least;
		this.dir = dir;
		this.steps = steps;
	}
	
}

class Point2
{
	int x;
	int y;
	int dir;
	
	Point2(int x, int y, int dir)
	{
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}