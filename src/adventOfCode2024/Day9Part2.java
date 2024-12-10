package adventOfCode2024;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9Part2
{
	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_9_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		long sum = 0;
		String line = file.nextLine();
		if(line.length()%2 ==1)
			line += "0";
		ArrayList<FileSystem> f = new ArrayList<FileSystem>();
		for(int a = 0; a < line.length()/2; a++)
			f.add(new FileSystem(a, line.charAt(a*2)-48, line.charAt(a*2+1)-48));
		G:for(int a = f.size()-1; a >= 0; a--)
			for(int b = 0; b < a; b++)
				if(f.get(b).free >= f.get(a).space)
				{
					f.get(a-1).free += f.get(a).space + f.get(a).free;
					f.get(a).free = f.get(b).free - f.get(a).space;
					f.get(b).free = 0;
					f.add(b+1,f.remove(a));
					a++;
					continue G;
				}
		
		int index = 0;
		for(FileSystem fi : f)
		{
			for(int a = 0; a < fi.space; a++)
				sum += fi.id * index++;
			index += fi.free;
		}
			
		System.out.println(sum);
	}
}

class FileSystem
{
	int id;
	int space;
	int free;
	
	FileSystem(int id, int space, int free)
	{
		this.id = id;
		this.space = space;
		this.free = free;
	}
}