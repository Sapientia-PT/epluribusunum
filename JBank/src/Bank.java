import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bank {
	
	String ID;
	BufferedReader br;
	File bal;
	
	public Bank(String id) {
		this.ID = id;
		bal = new File("registry/balance/" + this.ID + ".txt");
	}
	
	public boolean hasRegistry(){
		try {
			br = new BufferedReader(new FileReader(bal));
			System.out.println("Successful Authentication!");
			System.out.println("Welcome, User: " + this.ID);
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Unsuccessful Authentication!");
			return false;
		} 
	}
	
	public String getBalance() throws IOException {
		br = new BufferedReader(new FileReader(bal)); 
		String content = br.readLine();
		return content;
	}
	
	public void deposit(int num) throws IOException {
		br = new BufferedReader(new FileReader(bal)); 
		String content = br.readLine();
		int con = Integer.parseInt(content);
		FileWriter fw = new FileWriter(bal);
		int res = con + num;
		fw.write(String.valueOf(res));
		fw.flush();
		fw.close();
	}
	
	public void withdraw(int num) throws IOException {
		br = new BufferedReader(new FileReader(bal)); 
		String content = br.readLine();
		int con = Integer.parseInt(content);
		FileWriter fw = new FileWriter(bal);
		int res = con - num;
		fw.write(String.valueOf(res));
		fw.flush();
		fw.close();
	}
	
}
