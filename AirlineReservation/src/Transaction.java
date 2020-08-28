import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {
	
	String ID;
	BufferedReader br;
	File bal;
	
	public Transaction(String id) {
		this.ID = id;
		bal = new File("../JBank/registry/balance/" + this.ID + ".txt");
	}
	
	public String getBalance() throws IOException {
		br = new BufferedReader(new FileReader(bal)); 
		String content = br.readLine();
		return content;
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