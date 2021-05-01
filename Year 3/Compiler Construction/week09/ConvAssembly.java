
/**
 * Write a Java program to  convert a simple calculation into assembly language
 * @author Shrey Mathur
 */
import java.io.*;

class ConvAssembly {
	public static void main(String[] args) throws IOException {
		String line = "";
		String inputFilename = args[0];
		String outputFilename = args[1];
		BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
		PrintWriter writer = new PrintWriter(new FileWriter(outputFilename));

		writer.println(".global main");
		writer.println("\tmsg: .string \"Final result of LHS var = %d\\n\"");
		writer.println("\t.comm a, 4");
		writer.println("\t.comm b, 4");
		writer.println("\t.comm c, 4");
		writer.println("\t.comm d, 4");
		writer.println("\t.comm e, 4");
		writer.println("\t.comm f, 4");
		writer.println("\t.comm z, 4");
		writer.println("main:");
		writer.println("\tpushl %ebp");
		writer.println("\tmovl %esp, %ebp ");

		System.out.println(".global main");
		System.out.println("\tmsg: .string \"Final result of LHS var = %d\\n\"");
		System.out.println("\t.comm a, 4");
		System.out.println("\t.comm b, 4");
		System.out.println("\t.comm c, 4");
		System.out.println("\t.comm d, 4");
		System.out.println("\t.comm e, 4");
		System.out.println("\t.comm f, 4");
		System.out.println("\t.comm z, 4");
		System.out.println("main:");
		System.out.println("\tpushl %ebp");
		System.out.println("\tmovl %esp, %ebp ");

		while ((line = reader.readLine()) != null) {
			String[] word = line.split(" ");
			for (int i = 1; i < word.length; i++) {
				boolean isEA = word[i].equals("eax") || word[i].equals("ebx") || word[i].equals("ecx") || word[i].equals("edx");
				if (isEA)
					word[i] = "%" + word[i];
				char c = word[i].charAt(0);
				int a = c;
				if (a >= 0x30 && a <= 0x39)
					word[i] = "$" + word[i];
			}

			switch (word[0]) {
			case "+":
				writer.println("\taddl " + word[1] + ", " + word[2]);
				System.out.println("\taddl " + word[1] + ", " + word[2]);
				break;
			case "-":
				writer.println("\tsubl " + word[1] + ", " + word[2]);
				System.out.println("\tsubl " + word[1] + ", " + word[2]);
				break;
			case "=":
				writer.println("\tmovl " + word[1] + ", " + word[3]);
				System.out.println("\tmovl " + word[1] + ", " + word[3]);
				break;
			}
		}
		writer.println("\tpushl z");
		writer.println("\tpushl $msg");
		writer.println("\tcall printf");
		writer.println("\tleave");
		writer.println("ret");
		reader.close();
		writer.close();

		System.out.println("\tpushl z");
		System.out.println("\tpushl $msg");
		System.out.println("\tcall printf");
		System.out.println("\tleave");
		System.out.println("ret");
	}
}
