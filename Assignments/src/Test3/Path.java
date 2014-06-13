import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Path {
	static int totalways = 0;
	static int endpointx = 0;
	static int endpointy = 0;

	public static void main(final String[] args) {
		final String input1 = "{4,6}";
		final String input2 = "{1,3,0,0,0,0,0,0,4,5,1,0,0,0,0,6,7,6,0,0,0,0,5,0}";
		final String rows = input1.substring(1, input1.length() - 1);
		final String values = input2.substring(1, input2.length() - 1);
		final String[] fullvalues = values.split(",");
		final String[] table = rows.split(",");
		final int[] temp = new int[fullvalues.length];
		int i = 0;
		for (final String t : fullvalues) {
			temp[i] = Integer.parseInt(t);
			i++;
		}
		//System.out.println(temp.length);
		final int[] tempa = new int[2];
		tempa[0] = Integer.parseInt(table[0]);
		tempa[1] = Integer.parseInt(table[1]);
		//System.out.println(tempa.length);
		System.out.println(Path.run(tempa, temp));
	}

	private static int run(final int[] input1, final int[] input2) {
		final int row = input1[0];
		final int col = input1[1];
		final int[][] multi = new int[row][col];
		int k = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				multi[i][j] = input2[k];
				k++;
			}
		}
		endpointx = row - 1;
		endpointy = col - 1;
		//System.out.println("endpointx" + endpointx);
		//System.out.println("endpointy" + endpointy);
		final int s1 = 0;
		final int s2 = 0;
		final int startnumber = multi[s1][s2];
		if (startnumber == 0) {
			return 0;
		}
		recur(startnumber, multi, s1, s2);
		return totalways;
	}

	private static void recur(final int startnumber, final int[][] multi, final int s1, final int s2) {
		final Map<Integer, Integer[]> ret = getnext(startnumber, multi, s1, s2);
		if (ret != null) {
			for (final Entry temp : ret.entrySet()) {
				final Integer[] number = (Integer[]) temp.getValue();
				if (number[1] == endpointx && number[2] == endpointy) {
					totalways += 1;
					continue;
				}
				if (number[0] > 0)
					recur(number[0], multi, number[1], number[2]);
				else {
					continue;
				}
			}
		}
	}

	private static Map<Integer, Integer[]> getnext(final int startnumber, final int[][] multi, int s1, int s2) {
		final Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		switch (startnumber) {
		case 1:
			s2 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		case 2:
			s1 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		case 3:
			s1 += 1;
			s2 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		case 4:
			s1 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			s2 += 1;
			s1 -= 1;
			try {
				final int i = multi[s1][s2];
				map.put(2, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		case 5:
			s2 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			s1 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(2, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		case 6:
			s1 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			s2 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(2, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		case 7:
			s1 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(1, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			s2 += 1;
			try {
				final int i = multi[s1][s2];
				map.put(2, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			s1 -= 1;
			try {
				final int i = multi[s1][s2];
				map.put(3, new Integer[] { i, s1, s2 });
			} catch (final ArrayIndexOutOfBoundsException e) {
				//System.out.println(e.getMessage());
			}
			return map;
		}
		return null;
	}
}