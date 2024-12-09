package adventOfCode2024;
import java.io.*;
import java.util.*;

public class Day5Part2
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
		LinkedHashMap<String, ArrayList<String>> after = new LinkedHashMap<String, ArrayList<String>>();
		LinkedHashMap<String, ArrayList<String>> before = new LinkedHashMap<String, ArrayList<String>>();
		for(String rule : order)
		{
			String first = rule.substring(0,2);
			String second = rule.substring(3);
			if(!after.containsKey(first))
				after.put(first, new ArrayList<String>());
			after.get(first).add(second);
			if(!before.containsKey(second))
				before.put(second, new ArrayList<String>());
			before.get(second).add(first);
		}
		G:for(String update : updates)
		{
			String[] pages = update.split(",");
			ArrayList<String> prev = new ArrayList<String>();
			for(String page : pages)
			{
				if(after.containsKey(page))
					for(String check : prev)
						if(after.get(page).contains(check))
						{
							CustomStringComparator t = new CustomStringComparator(after, before);
							Arrays.sort(pages, t);
							sum += Integer.parseInt(pages[pages.length/2]);
							continue G;
						}
							
				prev.add(page);
			}
			
		}
		System.out.println(sum);
	}
}

class CustomStringComparator implements Comparator<String> 
{

	static Map<String, ArrayList<String>> after = new LinkedHashMap<String, ArrayList<String>>();
	static Map<String, ArrayList<String>> before = new LinkedHashMap<String, ArrayList<String>>();
	
	public CustomStringComparator(LinkedHashMap<String, ArrayList<String>> after, LinkedHashMap<String, ArrayList<String>> before) 
	{
		CustomStringComparator.after = after;
		CustomStringComparator.before = before;
	}
	
    @Override
    public int compare(String str1, String str2) 
    {
        if(after.containsKey(str1))
        	if(after.get(str1).contains(str2))
        		return -1;
        if(before.containsKey(str1))
        	if(before.get(str1).contains(str2))
        		return 1;
        return 0; 
    }
}