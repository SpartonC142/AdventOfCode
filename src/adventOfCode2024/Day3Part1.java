package adventOfCode2024;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_3_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		long sum = 0;
		String input = file.nextLine();
		while(file.hasNext())
			input+=file.nextLine();
		int index = input.indexOf("don't()");
		while(index != -1)
		{
			input = input.substring(0, index) + input.substring(input.indexOf("do()",index)+1);
			index = input.indexOf("don't()");
		}
		
	    final String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";

	    final Matcher m = Pattern.compile(regex).matcher(input);

	    final List<String> matches = new ArrayList<>();
	    while (m.find()) 
	    {
	        matches.add(m.group(0));
	    }
	    for(String data : matches)
	    {
	    	sum += Integer.parseInt(data.substring(4, data.indexOf(','))) * Integer.parseInt(data.substring(data.indexOf(',')+1, data.indexOf(')')));
	    }
		System.out.println(sum);
	}

}
