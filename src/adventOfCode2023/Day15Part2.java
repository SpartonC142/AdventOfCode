package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day15Part2 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_15_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		String input = "";
		while(file.hasNext())
			input += file.nextLine();
		String[] in = input.split(",");
		Box[] boxes = new Box[256];
		for(int a = 0; a < 256; a++)
			boxes[a] = new Box();
		for(String step : in)
		{
			String label = step.replaceAll("[^a-z]", "");
			int subSum = 0;
			for(char l : label.toCharArray())
			{
				subSum += l;
				subSum *= 17;
				subSum %= 256;
			}
			if(step.charAt(label.length()) == '-')
				boxes[subSum].remove(label);
			else 
				boxes[subSum].add(label, step.charAt(label.length()+1)-48);
		}
		for(int a = 0; a < boxes.length; a++)
		{
//			if(boxes[a].list.size()>0)
//				System.out.println(boxes[a].list);
			for(int b = 0; b < boxes[a].list.size(); b++)
				sum+= (a+1) * (b+1) * boxes[a].list.get(b).focal;
		}
			
		System.out.println(sum);
	}
}

class Box
{
	ArrayList<Lense> list = new ArrayList<Lense>();
	
	public void remove(String label)
	{
		for(int a = 0; a < list.size(); a++)
			if(list.get(a).label.equals(label))
				list.remove(a);
	}
	
	public void add(String label, int focal)
	{
		for(Lense len : list)
			if(len.label.equals(label))
			{
				len.focal = focal;
				return;
			}
		list.add(new Lense(label, focal));
	}
}

class Lense
{
	String label;
	int focal;
	
	Lense(String label, int focal)
	{
		this.label = label;
		this.focal = focal;
	}

	public String toString()
	{
		return label + " " + focal;
	}
}