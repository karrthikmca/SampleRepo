package it.sella.mec;


public class Square {
	public static void main(final String[] args) {
		final String input = "{1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1,1#1#1#1#1#1#1#1}";
		//final String input = "{1,1}";
		final String temp = input.substring(1, input.length() - 1);
		final String[] temps = temp.split(",");
		System.out.println(calculate(temps));
	}

	private static String calculate(final String[] input1) {
		final String[][] inputs = new String[input1.length][];
		for (int i = 0; i < input1.length; i++) {
			inputs[i] = input1[i].split("#");
		}
		return check(inputs);
	}

	private static String check(final String[][] inputs) {
		String output= null;
		int limit = inputs.length;
		while (limit >= 1) {
			for (int i = 0; i < inputs.length; i++) {
				for (int j = 0; j < inputs.length; j++) {
					boolean isvalid = checkhori(inputs, i, j, limit);
					if (isvalid) {
						isvalid = checkvert(inputs, i, j, limit);
					}
					if(isvalid){
						output = setoutput(inputs, i ,j, limit);
						return output;
					}
				}
			}
			limit--;
		}
		return output;
	}

	private static String setoutput(final String[][] inputs, final int i, final int j, final int limit) {
		//  {(3#0,3#1,3#2,3#3),(4#0,4#1,4#2,4#3),(5#0,5#1,5#2,5#3),(6#0,6#1,6#2,6#3)}
		final StringBuilder builder = new StringBuilder("{");
		int temp =1;
		final StringBuilder tmpbuilder = new StringBuilder();
		for (int k = i; temp <= limit; k++) {
			tmpbuilder.append("(");
			int temp1 =1;
			String test = "";
			for (int k2 = j; temp1 <= limit; k2++) {
				test = test +k+"#"+k2+",";
				temp1++;
			}
			test = test.substring(0, test.length()-1);
			temp++;
			tmpbuilder.append(test);
			tmpbuilder.append("),");
		}
		String test1 = tmpbuilder.toString();
		test1 = test1.substring(0, test1.length()-1);
		builder.append(test1);
		builder.append("}");
		return builder.toString();
	}

	private static boolean checkvert(final String[][] inputs, final int i, final int j, final int limit) {
		boolean isvalid = true;
		for (int k = 1; k < limit; k++) {
			isvalid = checkhori(inputs, i+k, j, limit);
			if(!isvalid){
				break;
			}
		}
		return isvalid;
	}

	private static boolean checkhori(final String[][] inputs, final int i, final int j, final int limit) {
		boolean isvalid = true;
		for (int k = 0; k < limit; k++) {
			try {
				if (Integer.parseInt(inputs[i][j + k]) == 0) {
					isvalid = false;
					break;
				}
			} catch (final ArrayIndexOutOfBoundsException e) {
				isvalid = false;
			}
		}
		return isvalid;
	}
}
