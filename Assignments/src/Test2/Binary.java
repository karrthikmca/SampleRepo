import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Binary {

	public static void main(final String[] args) {
		System.out.println(getBinary("eda"));
	}

	private static String getBinary(final String input1) {
		final char[] word = input1.toCharArray();
		final StringBuilder builder = new StringBuilder();
		if (word.length == 1) {
			return builder.append("0").toString();
		}
		final Map<String, String> map = generatemap(input1);
		for (final char c : word) {
			final String s = String.valueOf(c);
			builder.append(map.get(s));
		}
		return builder.toString();
	}

	private static Map<String, String> generatemap(final String input1) {
		final Map<String, Double> fullmap = new HashMap<String, Double>();
		fullmap.put("a", 0.5);
		fullmap.put("b", 0.4);
		fullmap.put("e", 0.3);
		fullmap.put("c", 0.2);
		fullmap.put("d", 0.1);		
		final char[] word = input1.toCharArray();		
		final Set<String> set = new TreeSet<String>();
		for(final char c: word) {
			set.add(String.valueOf(c));		
		}
		final Map<Double, String> order = new TreeMap<Double, String>();
		for(final String value : set) {
			order.put(fullmap.get(value), value);
		}
		final Map<String, String> map = new HashMap<String, String>();		
		switch(set.size()){
		case 1:						
			final String[] array0 = new String[] {"0"};
			int i0= 0; 
			for(final Entry<Double, String> entry : order.entrySet()) {
				final String value= entry.getValue();			
				map.put(value, array0[i0]);
				i0++;
			}
			break;
		case 2:
			final String[] array = new String[] {"1","0"};
			int i= 0; 
			for(final Entry<Double, String> entry : order.entrySet()) {
				final String value= entry.getValue();
				map.put(value, array[i]);
				i++;
			}
			break;
		case 3:
			final String[] array1 = new String[] {"11","10","0"};
			int i1= 0; 
			for(final Entry<Double, String> entry : order.entrySet()) {
				final String value= entry.getValue();
				map.put(value, array1[i1]);
				i1++;
			}
			break;
		case 4:
			final String[] array2 = new String[] {"111","110","10","0"};
			int i2= 0; 
			for(final Entry<Double, String> entry : order.entrySet()) {
				final String value= entry.getValue();
				map.put(value, array2[i2]);
				i2++;
			}
			break;
		case 5:
			final String[] array3 = new String[] {"1111","1110","110","10","0"};
			int i3= 0; 
			for(final Entry<Double, String> entry : order.entrySet()) {
				final String value= entry.getValue();
				map.put(value, array3[i3]);
				i3++;
			}
			break;		
		}
		return map;
	}
}
