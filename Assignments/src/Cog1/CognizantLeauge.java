import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CognizantLeauge {

	static int endpointx = 0;
	static int endpointy = 0;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(final String[] args) {
		String input1 = "{2#6#8#6#9,2#5#5#5#0,1#3#8#8#7,3#2#0#6#9,2#1#4#5#8,5#6#7#4#7}";
		input1 = input1.substring(1, input1.length() - 1);
		final String[] lines = input1.split(",");
		System.out.println(test(lines));
	}

	public static int test(final String[] input1) {
		if (input1 == null) {
			return 0;
		}
		final String[] lines = input1;
		int rowcount = 0;
		int colcount = 0;
		for (final String line : lines) {
			final String[] cells = line.split("#");
			colcount = cells.length;
			rowcount += 1;
		}
		final int[][] values = new int[rowcount][colcount];
		int row = 0;
		for (final String line : lines) {
			int col = 0;
			final String[] cells = line.split("#");
			for (final String cell : cells) {
				values[row][col] = Integer.parseInt(cell);
				col = col + 1;
			}
			row = row + 1;
		}
		endpointx = rowcount - 1;
		endpointy = colcount - 1;
		final int s1 = 0;
		final int s2 = 0;
		final int total = values[s1][s2];
		recur(values, s1, s2, total);
		Collections.sort(list);
		int returnvalue = 0;
		if (list.size() > 0) {
			returnvalue = list.get(0);
		}
		return returnvalue;
	}

	private static void recur(final int[][] multi, final int s1, final int s2, final int total) {
		final Map<Integer, Integer[]> ret = getnext(multi, s1, s2, total);
		for (final Entry temp : ret.entrySet()) {
			final Integer[] number = (Integer[]) temp.getValue();
			if (number[1] == endpointx && number[2] == endpointy) {
				list.add(number[3]);
				continue;
			}
			recur(multi, number[1], number[2], number[3]);
		}
	}

	private static Map<Integer, Integer[]> getnext(final int[][] multi, int s1, int s2, final int total) {
		final Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		s1 += 1;
		try {
			final int i = multi[s1][s2];
			final int temp = total + i;
			map.put(1, new Integer[] { i, s1, s2, temp });
		} catch (final ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
		}
		s2 += 1;
		s1 -= 1;
		try {
			final int i = multi[s1][s2];
			final int temp = total + i;
			map.put(2, new Integer[] { i, s1, s2, temp });
		} catch (final ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
		}
		return map;
	}

}
