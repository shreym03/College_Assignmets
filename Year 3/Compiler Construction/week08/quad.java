
/**
  Week 8
  Create an intermediate code for given equation
  @author Shrey Mathur
  @since 29/03/2019
 */
import java.io.*;

class Quad {
	public static void main(String[] args) throws IOException {
		String line, RHS;
		String arg1 = "";
		String arg2 = "";
		String res = "";
		char operatorCheck;
		int tempCounter = 0;
		int div = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the equation");
		line = br.readLine();
		System.out.println("Operator\tArgument 1 \tArgument 2 \tResult");
		for (int i = 0; i < line.length(); i++) {
			operatorCheck = line.charAt(i);
			if (operatorCheck == '=') {
				div = i;
				break;
			}
		}
		RHS = line.substring(div + 1);
		for (int i = 0; i < RHS.length(); i++) {
			int j = i + 1;
			operatorCheck = RHS.charAt(i);
			if (operatorCheck == '+' || operatorCheck == '-') {
				if (tempCounter == 0) {
					tempCounter++;
					arg1 = RHS.substring(0, i);
					while ((RHS.charAt(j) != '+') && (RHS.charAt(j) != '-') && (j != RHS.length()))
						j++;
					arg2 = RHS.substring(i + 1, j);
					res = "temp" + tempCounter;
					System.out.println(operatorCheck + " \t\t" + arg1 + " \t\t" + arg2 + " \t\t" + res);
				} else {
					tempCounter++;
					arg1 = res;
					while ((RHS.charAt(j) != '+') && (RHS.charAt(j) != '-') && (j != RHS.length()))
						j++;
					arg2 = RHS.substring(i + 1, j);
					res = "temp" + tempCounter;
					System.out.println(operatorCheck + " \t\t" + arg1 + " \t\t" + arg2 + " \t\t" + res);
				}
			}
		}
		if (tempCounter == 0)
			arg1 = RHS;
		else
			arg1 = res;
		res = line.substring(0, div);
		System.out.println("= \t\t" + arg1 + " \t\t--- \t\t" + res);
	}
}
