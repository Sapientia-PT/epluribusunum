import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Handler {
	
	String newId;
	BufferedReader br;
	File bal;
	File newReg;
	FileWriter fw;
	
	public Handler(String newId){
		this.newId = newId;
		bal = new File("registry/balance/" + this.newId + ".txt");
	}
	
	public void createRegistry() throws IOException {
		// Create file with the name of newId
		newReg = new File("registry/balance/" + newId + ".txt");
		// Set it's balance to 0
		fw = new FileWriter(newReg);
		fw.write("0");
		fw.flush();
		fw.close();
	}
	
	public boolean alreadyExists() {
		try {
			br = new BufferedReader(new FileReader(bal));
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} 
	}

}
