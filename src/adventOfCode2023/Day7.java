package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day7
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("inputFIles/adventofcode.com_2023_day_7_input.txt"));
//		Scanner file = new Scanner(new File("inputFIles/test.txt"));
		long sum = 0;
		ArrayList<Hand> hands = new ArrayList<>();
		while(file.hasNext())
		{
			String[] line = file.nextLine().split(" +");
			hands.add(new Hand(line[0], Integer.parseInt(line[1])));
		}
		Collections.sort(hands);
		for(int a = 0; a < hands.size(); a++)
		{
			sum+= hands.get(a).bid * (a+1);
		}
		System.out.println(hands);
		System.out.println(sum);
	}

}
class Hand implements Comparable<Hand>
{
	String cards;
	int bid;
	
	public Hand(String cards, int bid)
	{
		this.cards = cards;
		this.bid = bid;
	}
	
	public int compareTo(Hand hand)
	{
		int current = highest(cards);
		int comp = highest(hand.cards);
		if(current > comp)
			return 1;
		if(current < comp)
			return -1;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		map.put('T', 10);
		map.put('J', 1);
		map.put('Q', 12);
		map.put('K', 13);
		map.put('A', 14);
		for(int a = 0; a < 5; a++)
		{
			int val1 = map.get(cards.charAt(a));
			int val2 = map.get(hand.cards.charAt(a));
			if(val1 > val2)
				return 1;
			if(val1 < val2)
				return -1;
		}
		return 0;
	}
	
	public int highest(String hand)
	{
		int high = 0;
		ArrayList<Character> list = new ArrayList<>();
		for(char tem : hand.toCharArray())
			if(tem!='J' && !list.contains(tem))
				list.add(tem);
		if(list.size() == 0 || list.size() == 5)
			return value(hand);
		for(char tem : list)
			high = Math.max(high, value(hand.replaceAll("J",tem+"")));
		return high;
	}
	
	
	public int value(String tem)
	{
		char[] hand = tem.toCharArray();
		Arrays.sort(hand);
		boolean found = true;
		
		for(int a = 0; a<4; a++)
			if(hand[a]!=hand[a+1])
				found = false;
		if(found)
			return 6;
		
		found = true;
		for(int a = 0; a<3; a++)
			if(hand[a]!=hand[a+1])
				found = false;
		if(found)
			return 5;
		found = true;
		for(int a = 1; a<4; a++)
			if(hand[a]!=hand[a+1])
				found = false;
		if(found)
			return 5;
		
		if(hand[0]==hand[1]&&hand[0]==hand[2])
			if(hand[3]==hand[4])
				return 4;
			else
				return 3;
		if(hand[2]==hand[3]&&hand[2]==hand[4])
			if(hand[0]==hand[1])
				return 4;
			else
				return 3;
		if(hand[1]==hand[2]&&hand[1]==hand[3])
			return 3;
		int pairs = 0;
		for(int a = 0; a< 4; a++)
			if(hand[a] == hand[a+1])
				pairs++;
		return pairs;
	}
	public String toString()
	{
		return cards;
	}
}