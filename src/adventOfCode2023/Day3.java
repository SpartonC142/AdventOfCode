package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_3_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		int sum = 0;
		ArrayList<String> lines = new ArrayList<>();
		while(file.hasNext())
			lines.add(file.nextLine());
		char[][] matrix = new char[lines.size()][];
		boolean[][] hit = new boolean[lines.size()][lines.get(0).length()];
		for(int a = 0; a < lines.size(); a++)
		{
			matrix[a] = lines.get(a).toCharArray();
		}
		int[] help = {1,0,-1,0,1,1,-1,-1,1};
		for(int a = 0; a< matrix.length; a++)
		{
			for(int b = 0; b< matrix[a].length; b++)
			{
				hit = new boolean[lines.size()][lines.get(0).length()];
				if(matrix[a][b]== '*')
				{
					ArrayList<Integer> nums = new ArrayList<Integer>();
					for(int c = 0; c < 8; c++)
					{
						try
						{
							char tem = matrix[a+help[c]][b+help[c+1]];
							if(Character.isDigit(tem)&& tem!='.' &&!hit[a+help[c]][b+help[c+1]])
							{
								String num = tem + "";
								for(int d = 1; b+help[c+1]+d < matrix[a].length && Character.isDigit(matrix[a+help[c]][b+help[c+1]+d]); d++)
								{
									num += matrix[a+help[c]][b+help[c+1]+d];
									hit[a+help[c]][b+help[c+1]+d] = true;
								}
								for(int d = 1; b+help[c+1]-d >=0 && Character.isDigit(matrix[a+help[c]][b+help[c+1]-d]); d++)
								{
									num = matrix[a+help[c]][b+help[c+1]-d] + num;
									hit[a+help[c]][b+help[c+1]-d] = true;
								}
								nums.add(Integer.parseInt(num));
							}
								
						} catch (IndexOutOfBoundsException e)
						{
							
						}
					}
					if(nums.size()==2)
						sum += nums.get(0) * nums.get(1);
				}
			}
		}
		System.out.println(sum);
	}
//	public static void main(String[] args) throws FileNotFoundException
//	{
//		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_3_input.txt"));
////		Scanner file = new Scanner(new File("inputFIles/test.txt"));
//		int sum = 0;
//		ArrayList<String> lines = new ArrayList<>();
//		while(file.hasNext())
//			lines.add(file.nextLine());
//		char[][] matrix = new char[lines.size()][];
//		for(int a = 0; a < lines.size(); a++)
//		{
//			matrix[a] = lines.get(a).toCharArray();
//		}
//		int[] help = {1,0,-1,0,1,1,-1,-1,1};
//		for(int a = 0; a< matrix.length; a++)
//		{
//			boolean part = false;
//			String num = "";
//			for(int b = 0; b< matrix[a].length; b++)
//			{
//				if(Character.isDigit(matrix[a][b]))
//				{
//					num += matrix[a][b];
//					
//					if(!part)
//						for(int c = 0; c < 8; c++)
//						{
//							try
//							{
//								char tem = matrix[a+help[c]][b+help[c+1]];
//								if(!Character.isDigit(tem) && tem != '.')
//								{
//									part = true;
//								}
//									
//							} catch (IndexOutOfBoundsException e)
//							{
//								
//							}
//						}
//					if(b==matrix[a].length-1&&part)
//					{
//						sum+=Integer.parseInt(num);
//					}
//				}
//				else if(part)
//				{
//					sum+=Integer.parseInt(num);
//					num = "";
//					part = false;
//				}
//				else {
//					num = "";
//				}
//			}
//		}
//		System.out.println(sum);
//	}
}