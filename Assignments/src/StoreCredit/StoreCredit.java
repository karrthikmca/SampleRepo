import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StoreCredit {

	public static void main(final String[] args) throws IOException {
		final String path = new File("").getAbsolutePath() + "\\src\\StoreCredit\\";
		File inputfile = new File(path + "A-small-practice.in");
		File outputfile = new File(path + "A-small-practice.out");
		//FindNotPairNumber(inputfile, outputfile);
		inputfile = new File(path + "A-large-practice.in");
		outputfile = new File(path + "A-large-practice.out");
		FindNotPairNumber(inputfile, outputfile);
	}

	public static void FindNotPairNumber(final File inputfile, final File outputfile) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(inputfile));
		try {
			final String cases = br.readLine();
			final StringBuilder builder = new StringBuilder();
			if (cases != null) {
				for (int i = 1; i <= Integer.valueOf(cases); i++) {
					builder.append("Case #").append(i).append(": ");
					final double credit = Integer.parseInt(br.readLine());
					final double items = Integer.parseInt(br.readLine());
					final String[] words = br.readLine().split(" ");
					final int[] cword = new int[2];
					for (int j = 0; j < words.length - 1; j++) {
						boolean isclose =false;
						for (int k = j + 1; k < words.length; k++) {
							//System.out.println(" j : " + j + "  k " + k);
							final double a = Integer.parseInt(words[j]);
							final double b = Integer.parseInt(words[k]);
							//System.out.println("a " + a + " b" + b + " add " + (a + b) + " credit" + credit);
							if (a + b == credit) {
								if ( k > j ) {
									cword[0] = j + 1;
									cword[1] = k + 1;
								} else {
									cword[0] = k + 1;
									cword[1] = j + 1;
								}
								isclose = true;
								break;
							}
						}
						if(isclose) {
							break;
						}
					}
					builder.append(cword[0]).append(" ").append(cword[1]).append("\n");
					//System.out.println("Case "+i);
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