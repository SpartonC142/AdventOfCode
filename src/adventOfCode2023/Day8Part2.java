package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8Part2
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_8_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		String instr = file.nextLine();
		file.nextLine();
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Node> indexs = new ArrayList<Node>();
		long steps = 0;
		int index = 0;
		while(file.hasNext())
		{
			String[] line = file.nextLine().trim().replaceAll("[=,()]","").split(" +");
			Node[] current = new Node[3];
			for(int a = 0; a<3; a++)
			{
				for(Node node : nodes)
					if(node.name.equals(line[a]))
						current[a] = node;
				if(current[a] == null)
					current[a] = new Node(line[a]);
				nodes.add(current[a]);
			}
			current[0].left = current[1];
			current[0].right = current[2];
			
			if(line[0].charAt(2)=='A')
				indexs.add(current[0]);
		}
		boolean cont = true;
		long prev = 0;
		int a = 5;
		while(cont)
		{
//			for(int a = 0; a< indexs.size(); a++)
//			{
				if(instr.charAt(index)=='L')
					indexs.set(a, indexs.get(a).left);
				else
					indexs.set(a, indexs.get(a).right);
//			}
//			cont = false;
//			G:for(Node elem : indexs)
				if(indexs.get(a).name.charAt(2)=='Z')
				{
					System.out.println(steps-prev);
					prev = steps;
//					cont = true;
//					break G;
				}
					
			steps++;
			index = (index + 1) % instr.length();
			if(steps % 1000000000 == 0)
				System.out.println(steps);
		}
		System.out.println(steps);
	}
}
class Node
{
	String name;
	Node left;
	Node right;
	
	Node(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name + " " + left.name + " " + right.name;
	}
}