package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFiles/adventofcode.com_2023_day_5_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles/test.txt"));
		String[] seeds = file.nextLine().substring(7).trim().split(" ");
		ArrayList<ArrayList<String[]>> maps = new ArrayList<ArrayList<String[]>>();
		while(file.hasNext())
		{
			file.nextLine();
			file.nextLine();
			ArrayList<String[]> map = new ArrayList<>();
			while(file.hasNextLong())
			{
				String line = file.nextLine();
				map.add(line.split(" "));
			}
			maps.add(map);
		}
		boolean cont = true;
		long ans = -1;
		while(cont)
		{
			ans++;
			long seed = ans;
			for(int z = 6; z >= 0; z--)
			{
				ArrayList<String[]> map = maps.get(z);
				G:for(int b = 0; b< map.size(); b++)
				{
					long dest = Long.parseLong(map.get(b)[0]);
					long source = Long.parseLong(map.get(b)[1]);
					long range = Long.parseLong(map.get(b)[2]);
					if(seed >= dest && seed < dest+range)
					{
						seed = source + (seed - dest);
						break G;
					}
				}
			}
			for(int a = 0; a< seeds.length-1; a+=2)
			{
				long start = Long.parseLong(seeds[a]);
				long range = Long.parseLong(seeds[a+1]);
				if(seed>=start && seed < start+range)
					cont = false;
			}
		}
		System.out.println(ans);
		
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_5_input.txt"));
////		Scanner file = new Scanner(new File("inputFIles/test.txt"));
//		String[] seeds = file.nextLine().substring(7).trim().split(" ");
//		long smallest = Long.MAX_VALUE;
//		ArrayList<ArrayList<String[]>> maps = new ArrayList<ArrayList<String[]>>();
//		while(file.hasNext())
//		{
//			file.nextLine();
//			file.nextLine();
//			ArrayList<String[]> map = new ArrayList<>();
//			while(file.hasNextLong())
//			{
//				String line = file.nextLine();
//				map.add(line.split(" "));
//			}
//			maps.add(map);
//		}
//		System.out.println(seeds.length);
//		for(int a = 0; a< seeds.length; a+=2)
//		{
//			System.out.println(a);
//			long num = Long.parseLong(seeds[a]);
//			long ran = Long.parseLong(seeds[a+1])+num-1;
//			
//			for(long seed = num; seed < ran; seed++)
//			{
//				for(int z = 0; z < 7; z++)
//				{
//					ArrayList<String[]> map = maps.get(z);
//					G:for(int b = 0; b< map.size(); b++)
//					{
//						long dest = Long.parseLong(map.get(b)[0]);
//						long source = Long.parseLong(map.get(b)[1]);
//						long range = Long.parseLong(map.get(b)[2]);
//						if(num >= source && num < source+range)
//						{
//							num = dest + (num - source);
//							break G;
//						}
//					}
//				}
//				if(num<smallest)
//				{
//					smallest = num;
//				}
//				num = seed;
//			}
//			
//		}
//		System.out.println(smallest);
		
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_5_input.txt"));
////		Scanner file = new Scanner(new File("inputFIles/test.txt"));
//		String[] seeds = file.nextLine().substring(7).trim().split(" ");
//		while(file.hasNext())
//		{
//			file.nextLine();
//			file.nextLine();
//			ArrayList<String[]> map = new ArrayList<>();
//			while(file.hasNextLong())
//			{
//				String line = file.nextLine();
//				map.add(line.split(" "));
//			}
//			for(int a = 0; a< seeds.length; a++)
//			{
//				long num = Long.parseLong(seeds[a]);
//				G:for(int b = 0; b< map.size(); b++)
//				{
//					long dest = Long.parseLong(map.get(b)[0]);
//					long source = Long.parseLong(map.get(b)[1]);
//					long range = Long.parseLong(map.get(b)[2]);
//					if(num >= source && num < source+range)
//					{
//						num = dest + (num - source);
//						break G;
//					}
//				}
//				seeds[a] = num +"";
//			}
//		}
//		long smallest = Long.parseLong(seeds[0]);
//		for(int a = 1; a < seeds.length; a++)
//		{
//			long num = Long.parseLong(seeds[a]);
//			if(num < smallest)
//				smallest = num;
//		}
//		System.out.println(smallest);
	}
}