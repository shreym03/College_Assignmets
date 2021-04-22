/*
	WAP to store bank account details for n number of Accounts with  Account ID,name, age, address and balance.Make a menu which does the following:
 Create an account
 Display Account details
 Perform a deposit
 Perform a withdrawal
 
 @author Shrey Mathir
 @since 17/9/17
 */
class Account {
	private String AcID, AcName, AcAddress;
	private double AcBal;

	// Getter
	public String getID() {
		return AcID;
	}

	public String getName() {
		return AcName;
	}

	public String getAddress() {
		return AcAddress;
	}

	public double getBal() {
		return AcBal;
	}

	// Setter
	public void setID(String NewValue) {
		AcID = NewValue;
	}

	public void setName(String NewValue) {
		AcName = NewValue;
	}

	public void setAddress(String NewValue) {
		AcAddress = NewValue;
	}

	public void setBal(double NewValue) {
		AcBal = NewValue;
	}

	public void Deposit(double dep) {
		double newBal = getBal() + dep;
		setBal(newBal);
		System.out.println(dep + " is deposited");
	}

	public void Withdrawal(double wth) {
		double newBal = getBal() - +wth;
		setBal(newBal);
		System.out.println(wth + " is withdrawn");
	}
}

public class BankAccount {
	public static void main() {
		Account acc = new Account();
		acc.setID("AJpQ56E");
		acc.setName("Shrey Mathur");
		acc.setAddress("BPDC Hostel");
		acc.setBal(2000.00);
		System.out.println("Current Balance is " + acc.getBal());
		acc.Deposit(500.00);
		System.out.println("Current Balance is " + acc.getBal());
		acc.Withdrawal(200.00);
		System.out.println("Current Balance is " + acc.getBal());
	}
}
