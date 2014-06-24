package org.sella.learning.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program1 {

	public static void main(final String[] args) throws IOException {
		final String path = new File("").getAbsolutePath() + "\\src\\Pair\\";
		File inputfile = new File(path + "A-small-practice.in");
		File outputfile = new File(path + "A-small-practice.out");
		FindNotPairNumber(inputfile, outputfile);
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
					builder.append("Case #").append(i).append(":");
					final String wordcount = br.readLine();
					if (wordcount != null) {
						final String[] words = br.readLine().split(" ");
						final List<String> list = Arrays.asList(words);
						for (int j = 0; j < Integer.valueOf(wordcount); j++) {
							final int count = Collections.frequency(list, words[j]);
							if (count % 2 == 1) {
								builder.append(" " + words[j] + "\n");
								break;
							}
						}
					}
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