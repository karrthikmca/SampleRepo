package it.sella.mec;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Disc {
	public static void main(final String[] args) {
		String temp = "{-3#8,9#3,-1#3,-8#9,1#10,3#1,-10#-10,2#8}";
		temp = temp.substring(1, temp.length()-1);
		final String[] test = sortPoints(temp.split(","),-3,8);
		for(final String t : test){
			System.out.println(t);
		}
	}

	public static String[] sortPoints(final String[] input1,final int input2,final int input3)
	{
		final TreeMap<BigDecimal, String> map = new TreeMap<BigDecimal, String>();
		for(final String input : input1){
			final String[] temp = input.split("#");
			final BigDecimal x = new BigDecimal(temp[0]);
			final BigDecimal y = new BigDecimal(temp[1]);
			final BigDecimal x1 = (x.subtract(new BigDecimal(input2)));
			final BigDecimal y1 = (y.subtract(new BigDecimal(input3)));
			final BigDecimal mul1 = x1.multiply(x1);
			final BigDecimal mul2 = y1.multiply(y1);
			final BigDecimal out = mul1.add(mul2);
			final double output = Math.sqrt(out.doubleValue());
			map.put(new BigDecimal(output), input);
		}
		final NavigableMap nmap=map.descendingMap();
		final Iterator<String> it = nmap.values().iterator();
		final List<String> list = new LinkedList<String>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		final String[] output = new String[input1.length];
		int i= 0;
		for(final String temp : list){
			output[i] = temp;
			i++;
		}
		return output;
	}
}
