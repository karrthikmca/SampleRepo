import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {

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
			final Set<String> zero = new HashSet<String>();
			zero.add(" ");
			final Set<String> two = new HashSet<String>();
			two.add("a");
			two.add("b");
			two.add("c");
			final Set<String> three = new HashSet<String>();
			three.add("d");
			three.add("e");
			three.add("f");
			final Set<String> four = new HashSet<String>();
			four.add("g");
			four.add("h");
			four.add("i");
			final Set<String> five = new HashSet<String>();
			five.add("j");
			five.add("k");
			five.add("l");
			final Set<String> six = new HashSet<String>();
			six.add("m");
			six.add("n");
			six.add("o");
			final Set<String> seven = new HashSet<String>();
			seven.add("p");
			seven.add("q");
			seven.add("r");
			seven.add("s");
			final Set<String> eight = new HashSet<String>();
			eight.add("t");
			eight.add("u");
			eight.add("v");
			final Set<String> nine = new HashSet<String>();
			nine.add("w");
			nine.add("x");
			nine.add("y");
			nine.add("z");

			final Map<String, Object> map = new HashMap<String, Object>();
			final ValueHolder holdera = new ValueHolder();
			holdera.setValue("2");
			holdera.setCurrentSet(two);
			map.put("a", holdera);

			final ValueHolder holderb = new ValueHolder();
			holderb.setValue("22");
			holderb.setCurrentSet(two);
			map.put("b", holderb);

			final ValueHolder holderc = new ValueHolder();
			holderc.setValue("222");
			holderc.setCurrentSet(two);
			map.put("c", holderc);

			final ValueHolder holderd = new ValueHolder();
			holderd.setValue("3");
			holderd.setCurrentSet(three);
			map.put("d", holderd);

			final ValueHolder holdere = new ValueHolder();
			holdere.setValue("33");
			holdere.setCurrentSet(three);
			map.put("e", holdere);

			final ValueHolder holderf = new ValueHolder();
			holderf.setValue("333");
			holderf.setCurrentSet(three);
			map.put("f", holderf);

			final ValueHolder holderg = new ValueHolder();
			holderg.setValue("4");
			holderg.setCurrentSet(four);
			map.put("g", holderg);

			final ValueHolder holderh = new ValueHolder();
			holderh.setValue("44");
			holderh.setCurrentSet(four);
			map.put("h", holderh);

			final ValueHolder holderi = new ValueHolder();
			holderi.setValue("444");
			holderi.setCurrentSet(four);
			map.put("i", holderi);

			final ValueHolder holderj = new ValueHolder();
			holderj.setValue("5");
			holderj.setCurrentSet(five);
			map.put("j", holderj);

			final ValueHolder holderk = new ValueHolder();
			holderk.setValue("55");
			holderk.setCurrentSet(five);
			map.put("k", holderk);

			final ValueHolder holderl = new ValueHolder();
			holderl.setValue("555");
			holderl.setCurrentSet(five);
			map.put("l", holderl);

			final ValueHolder holderm = new ValueHolder();
			holderm.setValue("6");
			holderm.setCurrentSet(six);
			map.put("m", holderm);

			final ValueHolder holdern = new ValueHolder();
			holdern.setValue("66");
			holdern.setCurrentSet(six);
			map.put("n", holdern);

			final ValueHolder holdero = new ValueHolder();
			holdero.setValue("666");
			holdero.setCurrentSet(six);
			map.put("o", holdero);

			final ValueHolder holderp = new ValueHolder();
			holderp.setValue("7");
			holderp.setCurrentSet(seven);
			map.put("p", holderp);

			final ValueHolder holderq = new ValueHolder();
			holderq.setValue("77");
			holderq.setCurrentSet(seven);
			map.put("q", holderq);

			final ValueHolder holderr = new ValueHolder();
			holderr.setValue("777");
			holderr.setCurrentSet(seven);
			map.put("r", holderr);

			final ValueHolder holders = new ValueHolder();
			holders.setValue("7777");
			holders.setCurrentSet(seven);
			map.put("s", holders);

			final ValueHolder holdert = new ValueHolder();
			holdert.setValue("8");
			holdert.setCurrentSet(eight);
			map.put("t", holdert);

			final ValueHolder holderu = new ValueHolder();
			holderu.setValue("88");
			holderu.setCurrentSet(eight);
			map.put("u", holderu);

			final ValueHolder holderv = new ValueHolder();
			holderv.setValue("888");
			holderv.setCurrentSet(eight);
			map.put("v", holderv);

			final ValueHolder holderw = new ValueHolder();
			holderw.setValue("9");
			holderw.setCurrentSet(nine);
			map.put("w", holderw);

			final ValueHolder holderx = new ValueHolder();
			holderx.setValue("99");
			holderx.setCurrentSet(nine);
			map.put("x", holderx);

			final ValueHolder holdery = new ValueHolder();
			holdery.setValue("999");
			holdery.setCurrentSet(nine);
			map.put("y", holdery);

			final ValueHolder holderz = new ValueHolder();
			holderz.setValue("9999");
			holderz.setCurrentSet(nine);
			map.put("z", holderz);

			final ValueHolder holder = new ValueHolder();
			holder.setValue("0");
			holder.setCurrentSet(zero);
			map.put("empty", holder);

			final String cases = br.readLine();
			final StringBuilder builder = new StringBuilder();
			if (cases != null) {
				for (int i = 1; i <= Integer.valueOf(cases); i++) {
					builder.append("Case #").append(i).append(": ");
					final String textwords = br.readLine();
					final char[] temp = textwords.toCharArray();
					int j;
					for (j = 0; j < temp.length - 1 ; j++) {
						final char c = temp[j];
						final char d = temp[j + 1];
						String key = String.valueOf(c) ;
						if (key.equals(" ")) {
							key = "empty";
						}
						final ValueHolder hol = (ValueHolder) map.get(key);
						builder.append(hol.getValue());
						if(hol.getCurrentSet().contains(d+"")) {
							builder.append(" ");
						}
					}
					final String dup = ((temp[j] == ' '? "empty" : temp[j]))+"";
					final ValueHolder hol = (ValueHolder) map.get(dup);
					System.out.println(hol.getCurrentSet() +" -- "+ ((j > 0)? temp[j-1] : " null" ));
					if(j > 0 && hol.getCurrentSet().contains(temp[j-1]+"")) {
						builder.append(" ");
					}
					builder.append(hol.getValue()).append("\n");
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

class ValueHolder {
	private String value;
	private Set<String> currentSet;

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public Set<String> getCurrentSet() {
		return currentSet;
	}

	public void setCurrentSet(final Set<String> currentSet) {
		this.currentSet = currentSet;
	}

}