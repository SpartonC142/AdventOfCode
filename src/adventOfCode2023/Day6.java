package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.Scanner;

public class Day6
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_6_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		file.next();
		long time = Long.parseLong(file.nextLine().replaceAll(" ", ""));
		file.next();
		long dist = Long.parseLong(file.nextLine().replaceAll(" ", ""));
		long speed = 0;
		int count = 0;
		for(; time > 0; time--)
		{
			if(speed * time > dist)
				count++;
			speed++;
		}
		System.out.println(count);
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_6_input.txt"));
////		Scanner file = new Scanner(new File("inputFIles/test.txt"));
//		file.next();
//		ArrayList<Integer> times = new ArrayList<>();
//		while(file.hasNextInt())
//			times.add(file.nextInt());
//		file.next();
//		ArrayList<Integer> distance = new ArrayList<>();
//		while(file.hasNextInt())
//			distance.add(file.nextInt());
//		int mult = 1;
//		for(int a = 0; a< times.size(); a++)
//		{
//			int time = times.get(a);
//			int dist = distance.get(a);
//			int speed = 0;
//			int count = 0;
//			for(; time > 0; time--)
//			{
//				if(speed * time > dist)
//					count++;
//				speed++;
//			}
//			mult*=count;
//		}
//		System.out.println(mult);
	}

}
