import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reverse {

	public static void main(final String[] args) throws IOException {
		final String path = new File("").getAbsolutePath() + "\\src\\Reverse\\";
		File inputfile = new File(path + "B-small-practice.in");
		File outputfile = new File(path + "B-small-practice.out");
		reverseString(inputfile, outputfile);
		inputfile = new File(path + "B-large-practice.in");
		outputfile = new File(path + "B-large-practice.out");
		reverseString(inputfile, outputfile);
	}

	public static void reverseString(final File inputfile, final File outputfile) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(inputfile));
		try {
			//this is a test
			//Case #1: test a is this
			final String cases = br.readLine();
			final StringBuilder builder = new StringBuilder();
			if (cases != null) {
				for (int i = 1; i <= Integer.valueOf(cases); i++) {
					builder.append("Case #").append(i).append(": ");
					final String textwords = br.readLine();
					final String[] split = textwords.split(" ");
					//System.out.println("Split : "+split +" Length : "+split.length);
					final StringBuilder temp = new StringBuilder();
					for (int j = split.length-1 ; j >= 0; j--) {
						temp.append(split[j]).append(" ");
					}					
					builder.append(temp.toString().trim()).append("\n");

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