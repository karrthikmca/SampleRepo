import java.util.ArrayList;
import java.util.List;

public class Bridge {
	public static void main(final String[] args) {
		final Bridge test = new Bridge();
		System.out.println(test.test(1, "({A,B,C,D,E,F},{(A,C),(B,C),(C,E),(B,E),(B,D),(E,F)})"));

	}

	private String test(final int input1, final String input2) {
		final String[] cases = input2.split("}\\),");
		final StringBuilder builder = new StringBuilder("{");
		for (int i = 0; i < input1; i++) {
			if (input1 > 1) {
				builder.append("{");
			}
			String fullCase = cases[i];
			if (i != input1 - 1) {
				fullCase = fullCase + "})";
			}
			final String[] fullcities = fullCase.split("},");
			final int j = 0;
			final List<String> list = new ArrayList<String>();
			String totalcities = fullcities[0];
			final String cities = fullcities[1].substring(0, fullcities[1].length() - 1);
			totalcities = totalcities.replace("(", "");
			totalcities = totalcities.replace(")", "");
			totalcities = totalcities.replace("}", "");
			totalcities = totalcities.replace("{", "");
			final String[] temp = cities.split("\\),\\(");
			for (String setValue : temp) {
				setValue = setValue.replace("(", "");
				setValue = setValue.replace(")", "");
				setValue = setValue.replace("}", "");
				setValue = setValue.replace("{", "");
				list.add(setValue);
			}
			System.out.println(list);
			System.out.println(totalcities);
			//[A,C, B,C, C,E, B,E, B,D, E,F]
			//		A,B,C,D,E,F			
			final String[] temp2 = totalcities.split(",");
			int check = 0;
			final StringBuilder value = new StringBuilder();
			for (final String city : temp2) {
				int count = 0;
				for (final String bridge : list) {
					if (bridge.contains(city)) {
						count += 1;
					}
				}
				if (count == 1) {
					for (final String bridge : list) {
						if (bridge.contains(city)) {
							value.append("(").append(bridge).append("),");
							check = 1;
						}
					}
				}
			}
			final String ret = value.toString();
			builder.append(ret.substring(0, ret.length() - 1));
			if (check == 0) {
				builder.append("NA");
			}
			if (input1 > 1) {
				builder.append("},");
			} else {
				builder.append(",");
			}

		}
		final String ret = builder.toString();
		final String output = ret.substring(0, ret.length() - 1);

		return output + "}";

		//{(A,C),(B,D),(E,F)}
	}
}
