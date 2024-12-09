package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day5Part1
{

	public static void main(String[] args)throws IOException
	{
		Scanner file = new Scanner(new File("inputFiles2024/adventofcode.com_2024_day_5_input.txt"));
//		Scanner file = new Scanner(new File("inputFiles2024/test.txt"));
		int sum = 0;
		ArrayList<String> order = new ArrayList<String>();
		ArrayList<String> updates = new ArrayList<String>();
		while(file.hasNext())
		{
			String tem = file.next();
			if(tem.contains("|"))
				order.add(tem);
			else
				updates.add(tem);
		}
		Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		for(String rule : order)
		{
			String first = rule.substring(0,2);
			String second = rule.substring(3);
			if(!map.containsKey(first))
				map.put(first, new ArrayList<String>());
			map.get(first).add(second);
		}
		G:for(String update : updates)
		{
			String[] pages = update.split(",");
			ArrayList<String> prev = new ArrayList<String>();
			for(String page : pages)
			{
				if(map.containsKey(page))
					for(String check : prev)
						if(map.get(page).contains(check))
							continue G;
				prev.add(page);
			}
			sum += Integer.parseInt(pages[pages.length/2]);
		}
		System.out.println(sum);
	}

}
