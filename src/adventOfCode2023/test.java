package adventOfCode2023;

import java.math.BigInteger;

public class test
{
	public static void main(String args[]) {
	      String num = "1111111111110000000000000000000000000000000000000000000000000000";
	      double val = Double.longBitsToDouble(new BigInteger(num, 2).longValue());
	      System.out.println(val);
	    }
}
