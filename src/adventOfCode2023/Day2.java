package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Day2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_2_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		TreeMap<String, Integer> poss = new TreeMap<>();
		
		while(file.hasNext())
		{
			poss.put("blue", 0);
			poss.put("red", 0);
			poss.put("green", 0);
			String line = file.nextLine();
			line = line.substring(line.indexOf(":")+2);
//			System.out.println(line);
			String[] sets = line.split("; ");
			for(String set : sets)
			{
				String[] cubes = set.split(", ");
				for(String cube : cubes)
				{
					String[] tem = cube.split(" ");
					if(poss.get(tem[1])<Integer.parseInt(tem[0]))
					{
						poss.put(tem[1], Integer.parseInt(tem[0]));
					}
				}
			}
			sum+= poss.get("blue") * poss.get("green") * poss.get("red");
		}
		System.out.println(sum);
	}
}