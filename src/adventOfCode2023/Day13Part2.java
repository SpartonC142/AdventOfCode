package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13Part2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFiles/adventofcode.com_2023_day_13_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		while(file.hasNext())
		{
			ArrayList<String> lines = new ArrayList<String>();
			String line = file.nextLine();
			while(!line.equals(""))
			{
				lines.add(line);
				if(file.hasNext())
					line = file.nextLine();
				else 
					line = "";
				
			}
			boolean reflect = true;
			boolean smudge = false;
			for(int a = 1; a < lines.size(); a++)
			{
				reflect = true;
				smudge = false;
				G:for(int b = a; b < lines.size(); b++)
				{
					try
					{
						for(int c = 0; c < lines.get(b).length(); c++)
						{
							if(lines.get(b).charAt(c)!=lines.get(a-1-(b-a)).charAt(c))
								if(!smudge)
								{
									smudge = true;
								}
								else 
								{
									reflect = false;
									break G;
								}
						}
					} 
					catch (IndexOutOfBoundsException e)
					{
						break G;
					}
				}
				
				if(reflect && smudge)
				{
					System.out.println("h " + a);
					sum += 100*a;
					break;
				}
					
			}
			for(int a = 1; a < lines.get(0).length(); a++)
			{
				reflect = true;
				smudge = false;
				G:for(int b = a; b < lines.get(0).length(); b++)
				{
					try
					{
						for(int c = 0; c < lines.size(); c++)
							if(lines.get(c).charAt(b)!=lines.get(c).charAt(a-1-(b-a)))
							{
								if(!smudge)
								{
									smudge = true;
								}
								else 
								{
									reflect = false;
									break G;
								}
							}
					} 
					catch (IndexOutOfBoundsException e)
					{
						break G;
					}
				}
				if(reflect && smudge)
				{
					System.out.println("v " + a);
					sum += a;
					break;
				}
			}
		}
		System.out.println(sum);
	}

}
