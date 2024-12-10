package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day6Part2
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_6_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<String>();
		while(file.hasNext())
			input.add(file.nextLine());
		Poin[][] mat = new Poin[input.size()][input.get(0).length()];
		int x = 0;
		int y = 0;
		for(int a = 0; a < input.size(); a++)	
			for(int b = 0; b< input.get(a).length(); b++)
			{
				char tem = input.get(a).charAt(b);
				if(tem == '^')
				{
					y = a;
					x = b;
				}
				mat[a][b] = new Poin(tem);
			}
		int xOrigin = x;
		int yOrigin = y;
		boolean end = false;
		int[] help = {-1,0,1,0,-1};
		int dir = 0;
		ArrayList<Poin> path = new ArrayList<Poin>();
		while(!end)
		{
			try 
			{
				Poin next = mat[y+help[dir]][x+help[dir+1]];
				if(next.c == '#')
					dir = (dir + 1) % 4;
				else 
				{
					if(!path.contains(next))
						path.add(next);	
					y += help[dir];
					x += help[dir+1];
				}
			} 
			catch (IndexOutOfBoundsException e) 
			{
				end = true;
			}
		}
		path.remove(mat[yOrigin][xOrigin]);
		for(Poin p : path)
		{
			
				
			x = xOrigin;
			y = yOrigin;
			dir = 0;
			p.c = '#';
			reset(mat);
			end = false;
			while(!end)
			{
				try 
				{
					Poin next = mat[y+help[dir]][x+help[dir+1]];
					if(next.c == '#')
						dir = (dir + 1) % 4;
					else 
					{
						if(next.dirs.contains(dir))
						{
							sum++;
							end = true;
						}
						next.dirs.add(dir);
						y += help[dir];
						x += help[dir+1];
					}
				} 
				catch (IndexOutOfBoundsException e) 
				{
					end = true;
				}
			}
			p.c = '.';
		}
		System.out.println(sum);
	}
	
	public static void reset(Poin[][] mat)
	{
		for(int a = 0; a < mat.length; a++)	
			for(int b = 0; b< mat[a].length; b++)
				mat[a][b].dirs.clear();
	}
}

class Poin
{
	char c;
	ArrayList<Integer> dirs = new ArrayList<Integer>();
	Poin(char c)
	{
		this.c = c;
	}
}