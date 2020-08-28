import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Front {
	
	static Handler handler;

	public static void main(String[] args) {
		Scanner core = new Scanner(System.in);
		System.out.print("Please enter your bank account's ID: ");
		handler = new Handler(core.nextLine());
		
		if(handler.alreadyExists()) {
			System.out.println("Welcome user with account ID: " + handler.newId);
			chooseTicket();
		}else {
			System.out.println("No bank account found for the given ID.");
			core.close();
			return;
		}
		
		core.close();
	}
	
	public static void chooseTicket() {
		int price;
		Scanner core = new Scanner(System.in);
		System.out.print("Write departure airport's ICAO code here: ");
		String departure = core.next();
		System.out.print("Write arrival airport's ICAO code here: ");
		String arrival = core.next();
		System.out.println("You chose the following flight: " + departure +"->" + arrival);
		System.out.println("Please enter your desired ticket class's number\n(1-economy,2-premium economy,3-business,4-first class): ");
		int ticketClass = core.nextInt();
		price = ticketClass * 50;
		System.out.print("Do you confirm the ticket purchase(Y/N)?: ");
		String confirm = core.next();
		if(confirm.equals("Y") || confirm.equals("y")) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			System.out.println("Processing payment.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			System.out.println("Processing payment..");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			System.out.println("Processing payment...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			try {
				Transaction tra = new Transaction(handler.newId);
				tra.withdraw(price);
				System.out.println("Payment complete!");
				printTicket(departure, arrival, ticketClass);
			}catch(Exception e) {
				System.out.println("There was an error processing payment.");
				core.close();
				return;
			}
		}else if(confirm.equals("N") || confirm.equals("n")){
			System.out.println("Transaction canceled.");
			core.close();
			return;
		}
		core.close();
	}
	
	public static void printTicket(String departure, String arrival, int ticketClass) throws IOException {
		File fl = new File(departure + "_" + arrival + ".ticket");
		FileWriter fw = new FileWriter(fl);
		fw.write("This ticket is valid for the following flight: " + departure + "->" + arrival);
		switch(ticketClass) {
		   default: break;
		   case 1:
			   fw.write("\nTicket Class: Economy");
			   break;
		   case 2:
			   fw.write("\nTicket Class: Premium Economy");
			   break;
		   case 3:
			   fw.write("\nTicket Class: Business");
			   break;
		   case 4:
			   fw.write("\nTicket Class: First Class");
			   break;
		}
		fw.flush();
		fw.close();
	}

}
