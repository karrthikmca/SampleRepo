import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary1 {

	public static void main(final String[] args) throws IOException {
		final String path = new File("").getAbsolutePath() + "\\src\\T9 Dictionary\\";
		File inputfile = new File(path + "C-small-practice.in");
		File outputfile = new File(path + "C-small-practice.out");
		reverseString(inputfile, outputfile);
		inputfile = new File(path + "C-large-practice.in");
		outputfile = new File(path + "C-large-practice.out");
		reverseString(inputfile, outputfile);
	}

	public static void reverseString(final File inputfile, final File outputfile) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(inputfile));
		try {
			final String cases = br.readLine();
			final StringBuilder builder = new StringBuilder();
			final Map<String, String> map = new HashMap<String, String>();
			map.put("a", "2");
			map.put("b", "22");
			map.put("c", "222");
			map.put("d", "3");
			map.put("e", "33");
			map.put("f", "333");
			map.put("g", "4");
			map.put("h", "44");
			map.put("i", "444");
			map.put("j", "5");
			map.put("k", "55");
			map.put("l", "555");
			map.put("m", "6");
			map.put("n", "66");
			map.put("o", "666");
			map.put("p", "7");
			map.put("q", "77");
			map.put("r", "777");
			map.put("s", "7777");
			map.put("t", "8");
			map.put("u", "88");
			map.put("v", "888");
			map.put("w", "9");
			map.put("x", "99");
			map.put("y", "999");
			map.put("z", "9999");
			map.put("0", "0");
			if (cases != null) {
				for (int i = 1; i <= Integer.valueOf(cases); i++) {
					builder.append("Case #").append(i).append(": ");
					final char[] words = br.readLine().toCharArray();
					int j;
					for (j = 0; j < words.length; j++) {
						String key = words[j] + "";
						if (key.equals(" ")) {
							key = "0";
						}
						builder.append(map.get(key));
						if (words.length - 1 > j) {
							String nextkey = words[j + 1] + "";
							if(nextkey.equals(" ")) {
								nextkey = "0";
							}
							if ( map.get(key).contains(map.get(nextkey)) || map.get(nextkey).contains(map.get(key))) {
								builder.append(" ");
							}
						}
					}
					builder.append("\n");
				}
			}
			System.out.println(builder);
			final BufferedWriter output = new BufferedWriter(new FileWriter(outputfile));
			output.write(builder.toString());
			output.close();
		} finally {
			br.close();
		}
	}
}