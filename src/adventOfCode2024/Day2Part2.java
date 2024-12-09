package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day2Part2
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_2_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int count = 0;
		while(file.hasNext())
		{
			String[] tem = file.nextLine().split(" ");
			ArrayList<Integer> report = new ArrayList<Integer>();
			for(String t : tem)
				report.add(Integer.parseInt(t));
			if(ultraSafe(report))
				count++;
		}

		System.out.println(count);
	}
	
	public static boolean safe(ArrayList<Integer> report)
	{
		
		ArrayList<Integer> comp = new ArrayList<Integer>(report);
		Collections.sort(comp);
		if(!report.equals(comp))
		{
			Collections.reverse(comp);
			if(!report.equals(comp))
				return false;
		}
		for(int a = 0; a < report.size()-1; a++)
		{
			int num = Math.abs(report.get(a) - report.get(a+1));
			if(num < 1 || num > 3)
				return false;
		}
		return true;
	}
	
	public static boolean ultraSafe(ArrayList<Integer> report)
	{
		if(safe(report))
			return true;
		for(int a = 0; a < report.size(); a++)
		{
			ArrayList<Integer> tem = new ArrayList<Integer>(report);
			tem.remove(a);
			if(safe(tem))
				return true;
		}
		return false;
	}

}