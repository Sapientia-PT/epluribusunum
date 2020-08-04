import java.io.IOException;
import java.util.Scanner;

public class Front{
	
	static Bank b;
	static Handler handler;

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		System.out.println("Hello, please enter your account ID: ");
		System.out.println("(Enter 0 to register new account)");
		String id = scn.next();
		if(id.equals("0")) {
			// Create registry file for new account.
			System.out.print("Type the ID for your new account: ");
			String newId = scn.next();
			handler = new Handler(newId);
			if(handler.alreadyExists()) {
				System.out.println("Account already exists!");
				System.exit(1);
			}else {
				handler.createRegistry();
				System.out.println("Account registry created successfully!");
			}
			
		}else {
			b = new Bank(id); // Open bank class with registry file of an existing account.
			if(b.hasRegistry()) {
				System.out.println("What would you like to do?");
				System.out.println("Type 1 to check your balance");
				System.out.println("Type 2 to deposit to your balance");
				System.out.println("Type 3 to withdraw from your balance");
				String choice = scn.next();
				switch(choice) {
				  default: break;
				  case "1":
					  System.out.println("Balance is: " + b.getBalance()); 
					  break;
				  case "2":
					  System.out.println("How much do you wish to deposit?");
					  int num = scn.nextInt();
					  b.deposit(num);
					  System.out.println("Your new balance is: " + b.getBalance());
					  break;
				  case "3":
					  System.out.println("How much do you wish to withdraw?");
					  int num2 = scn.nextInt();
					  b.withdraw(num2);
					  System.out.println("Your new balance is: " + b.getBalance());
					  break;
				}
			}
		}
		
		scn.close();
	}
	
}
