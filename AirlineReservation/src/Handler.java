import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Handler {
	
	String newId;
	BufferedReader br;
	File bal;
	File newReg;
	FileWriter fw;
	
	public Handler(String newId){
		this.newId = newId;
		bal = new File("../JBank/registry/balance/" + this.newId + ".txt");
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