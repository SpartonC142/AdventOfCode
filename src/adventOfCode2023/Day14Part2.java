package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14Part2 
{
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
		ArrayList<String> pos = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		int start = 0;
		int end = 0;
		for(int z = 0; z < 1000000000; z++)
		{
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
				
			for(int a = 1; a < mat.length; a++)
				for(int b = 0; b < mat[a].length; b++)
					if(mat[b][a] == 'O')
					{
						int c = a;
						while(c > 0 && mat[b][c-1] == '.')
							c--;
						mat[b][a] = '.';
						mat[b][c] = 'O';
					}
				
			for(int a = mat.length-2; a >= 0; a--)
				for(int b = mat[a].length-1; b >= 0; b--)
					if(mat[a][b] == 'O')
					{
						int c = a;
						while(c < mat.length-1 && mat[c+1][b] == '.')
							c++;
						mat[a][b] = '.';
						mat[c][b] = 'O';
					}
				
			for(int a = mat[0].length-2; a >= 0; a--)
				for(int b = mat.length-1; b >= 0; b--)
					if(mat[b][a] == 'O')
					{
						int c = a;
						while(c < mat[0].length-1 && mat[b][c+1] == '.')
							c++;
						mat[b][a] = '.';
						mat[b][c] = 'O';
					}

			String temp = "";
			for(int a = 0; a < mat.length; a++)
			{
				for(int b = 0; b < mat[a].length; b++)
				{
					temp += mat[a][b];
				}
				temp+="\n";
			}
			
			if(pos.contains(temp))
			{
				start = pos.indexOf(temp);
				end = z;
				z = Integer.MAX_VALUE-1;
			}
			else 
			{
				pos.add(temp);
				sum = 0;
				for(int a = 0; a < mat.length; a++)
				{
					for(int b = 0; b < mat[a].length; b++)
					{
						if(mat[mat.length-1-a][b] == 'O')
							sum += a+1;
					}
				}
				num.add(sum);
			}
		}
		int ans = (1000000000-start)%(end-start)+start-1;
		System.out.println(num.get(ans));
		file.close();
	}
}
