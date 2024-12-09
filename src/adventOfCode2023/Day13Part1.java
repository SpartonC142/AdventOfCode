package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13Part1
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
			for(int a = 1; a < lines.size(); a++)
			{
				reflect = true;
				G:for(int b = a; b < lines.size(); b++)
				{
					try
					{
						if(!lines.get(b).equals(lines.get(a-1-(b-a))))
						{
							reflect = false;
							break G;
						}
					} 
					catch (IndexOutOfBoundsException e)
					{
						break G;
					}
				}
				
				if(reflect)
				{
					System.out.println("h " + a);
					sum += 100*a;
					break;
				}
					
			}
			if(!reflect)
			{
				for(int a = 1; a < lines.get(0).length(); a++)
				{
					reflect = true;
					G:for(int b = a; b < lines.get(0).length(); b++)
					{
						try
						{
							for(int c = 0; c < lines.size(); c++)
								if(lines.get(c).charAt(b)!=lines.get(c).charAt(a-1-(b-a)))
								{
									reflect = false;
									break G;
								}
						} 
						catch (IndexOutOfBoundsException e)
						{
							break G;
						}
					}
					if(reflect)
					{
						System.out.println("v " + a);
						sum += a;
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
