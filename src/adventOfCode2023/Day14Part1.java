package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14Part1 {

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_14_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		ArrayList<String> input = new ArrayList<String>();
		while(file.hasNext())
			input.add(file.nextLine());
		
		char[][] mat = new char[input.size()][];
		for(int a = 0; a < input.size(); a++)
			mat[a] = input.get(a).toCharArray();
		for(int a = 1; a < mat.length; a++)
			for(int b = 0; b < mat[a].length; b++)
				if(mat[a][b] == 'O')
				{
					int c = a;
					while(c > 0 && mat[c-1][b] == '.')
						c--;
					mat[a][b] = '.';
					mat[c][b] = 'O';
				}
		for(int a = 0; a < mat.length; a++)
		{
			for(int b = 0; b < mat[a].length; b++)
			{
//				System.out.print(mat[a][b]);
				if(mat[mat.length-1-a][b] == 'O')
					sum += a+1;
			}
//			System.out.println();
		}
			
		System.out.println(sum);
		file.close();
	}

}
