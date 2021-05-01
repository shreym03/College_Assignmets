import java.io.*;
import java.util.ArrayList;

class Symbol {
	ArrayList<String> table[];

	Symbol() {
		table = new ArrayList[6];
		for (int i = 0; i < table.length; i++)
			table[i] = new ArrayList<String>();
	}

	public static long compmap(long key) {
		return key % 6L;
	}

	public static long hashvalue(String symbol) {
		char[] data = symbol.toCharArray();
		long value = 0;
		int len = data.length;
		for (int i = 0; i < len; i++) {
			char ltr = data[(len - 1) - i];
			if (Character.isLetter(ltr))
				value = value + (int) ltr;
			else if (Character.isDigit(ltr))
				value = value + 2 * (int) ltr;
		}
		value = value * 17 + 5;
		return value;
	}

	public void insert(String symbol) {
		int index = (int) compmap(hashvalue(symbol));
		table[index].add(symbol); // Avoids Colision using Seperate Chaining
	}

	public void display() {
		ArrayList<String> subList;
		for (int i = 0; i < table.length; i++) {
			subList = table[i];
			System.out.println("Symbol Table index:" + i);
			for (int j = 0; j < subList.size(); j++)
				System.out.print(subList.get(j) + "\t");
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		Symbol st = new Symbol();
		String input;
		File inputFile = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		input = br.readLine();
		while (input != null) {
			st.insert(input);
			input = br.readLine();
		}
		st.display();
		br.close();
	}
}
