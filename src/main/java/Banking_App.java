import java.util.Scanner;

class BankDetails {
	private String accno;
	private String name;
	private String acc_type;
	private long balance;
	Scanner sc = new Scanner(System.in);
	//Method to open new account
	public void openAccount() {
		System.out.print("Enter the Account number:");
		accno = sc.next();
		System.out.print("Enter the Account type:");
		acc_type = sc.next();
		System.out.print("Enter Name:");
		name = sc.next();
		System.out.print("Enter the balance:");
		balance = sc.nextLong();
	}
	
	//Method to show account details
	
	public void showAccount() {
		System.out.println("Account holder name: " + name);
		System.out.println("Account Number : " + accno);
		System.out.println("Account type: " + acc_type);
		System.out.println("Account Balance: " + balance);
	}
	
	//Method to deposit money
	
	public void deposit() {
		System.out.println("Enter the amount you want to deposit:");
		long amt = sc.nextLong();
		balance += amt;
		System.out.println("Your account balance is " + balance);
	}
	
	//Method to withdraw money
	
	public void withdraw() {
		System.out.println("Enter the amount you want to withdraw");
		long amt = sc.nextLong();
		if (amt > balance)
			System.out.println("You don't have enough money in the account to withdraw");
		else {
			balance = balance - amt;
			System.out.println("Your account balance is " + balance);
		}
	}
	public boolean search(String acc_no) {
		if(accno.equals(acc_no)) {
			return true;
		}
		else return false;
	}
}

public class Banking_App {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		//Create initial accounts
		
		System.out.println("Enter the number of accounts you want to input:");
		
		int noOfaccs = sc.nextInt();
		BankDetails holders[] = new BankDetails[noOfaccs];
		for (int i = 0; i < holders.length; i++) {
			holders[i] = new BankDetails();
			holders[i].openAccount();
		}
		
		//loop runs until number 5 is not pressed to exit
		int ch;
		do {
			String no;
			System.out.println("1.Display all accounts \n2. Search by account number \n3.Deposit \n4.With Draw");
			ch = sc.nextInt();
			switch (ch) {
			case 1: 
				if (holders.length >= 1)
					for (int i = 0; i < holders.length; i++)
						holders[i].showAccount();
				else System.out.println("Bank doesn't have any accounts");
				break;
			case 2: 
				System.out.println("Enter the account number:");
				no = sc.next();
				for (int i = 0; i < holders.length; i++) {
					if (holders[i].search(no)) {
						holders[i].showAccount();
						break;
					}
					else
						if (i == holders.length - 1)
							System.out.println("The account number " + no + " is not existed");
				}
				break;
			case 3:
				System.out.println("Enter the account number");
				no = sc.next();
				for (int i = 0; i < holders.length; i++) {
					if (holders[i].search(no)) {
						holders[i].deposit();
						break;
					}
					else
						if (i == holders.length - 1)
							System.out.println("Account doesn't exist");
				}
				break;
			case 4:
				System.out.println("Enter the account number");
				no = sc.next();
				for (int i = 0; i < holders.length; i++) {
					if (holders[i].search(no)) {
						holders[i].withdraw();
						break;
					}
					else
						if (i == holders.length - 1)
							System.out.println("Account doesn't exist");
				}
				break;
			case 5:
				System.out.println("See you soon!");
				break;
			}
			
		}while(ch != 5);
		sc.close();
	}
}