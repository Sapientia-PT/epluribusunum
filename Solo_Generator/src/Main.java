import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static int pickedString;
	static int randomNote;
	static int baseNote;
	static int[] firstString = new int[4];
	static int[] secondString = new int[4];
	static int[] thirdString = new int[4];
	static int[] fourthString = new int[4];
	static int[] fifthString = new int[4];
	static int[] sixthString = new int[4];
	static int pickedOne;

	public static void main(String[] args) throws FileNotFoundException {
		Random r2 = new Random();
		PrintStream fora = new PrintStream(new FileOutputStream("generated_solo.txt"));
		Scanner core = new Scanner(System.in);
		System.out.println("Type in the key for the solo as a fret number(Ex: 1(F)): ");
		try {
		baseNote = core.nextInt(); // Get the key for the solo.
		}catch(Exception e) {
			System.out.println("You have entered an invalid expression. Please try again.");
			core.close();
			return;
		}
		getPossibleNotes();
		System.out.println("Type in the desired amount of the notes in your generated solo: ");
		try {
		int soloLength = core.nextInt(); // Get user input on the desired length of the solo.
		for(int i=0;i<soloLength;i++) {
			if(i!=(soloLength)-1) { // If loop designed to remove the last "-" once i reaches the final note.
				pickedOne = pickString();
				switch(pickedOne) {
				  default:
					  break;
				  case 1:
					  randomNote = firstString[r2.nextInt(4)];
					  break;
				  case 2:
					  randomNote = secondString[r2.nextInt(4)];
					  break;
				  case 3:
					  randomNote = thirdString[r2.nextInt(4)];
					  break;
				  case 4:
					  randomNote = fourthString[r2.nextInt(4)];
					  break;
				  case 5:
					  randomNote = fifthString[r2.nextInt(4)];
					  break;
				  case 6:
					  randomNote = sixthString[r2.nextInt(4)];
					  break;
				}
				System.out.print(randomNote + "(" + pickedOne + ")"); // Output the random note plus the respective string in parentheses.
				System.out.print("-");
				fora.print(randomNote + "(" + pickedOne + ")");
				fora.print("-");
			}else {
				pickedOne = pickString();
				switch(pickedOne) {
				  default:
					  break;
				  case 1:
					  randomNote = firstString[r2.nextInt(4)];
					  break;
				  case 2:
					  randomNote = secondString[r2.nextInt(4)];
					  break;
				  case 3:
					  randomNote = thirdString[r2.nextInt(4)];
					  break;
				  case 4:
					  randomNote = fourthString[r2.nextInt(4)];
					  break;
				  case 5:
					  randomNote = fifthString[r2.nextInt(4)];
					  break;
				  case 6:
					  randomNote = sixthString[r2.nextInt(4)];
					  break;
				}
				System.out.print(randomNote + "(" + pickedOne + ")\n"); // Output the random note plus the respective string in parentheses.
				System.out.println("In parentheses are the respective string numbers for which the note is to be played in.");
				fora.print(randomNote + "(" + pickedOne + ")\n");
				fora.println("In parentheses are the respective string numbers for which the note is to be played in.");
				
			}
		}
		}catch(Exception e) {
			System.out.println("You have entered and invalid number. Please try again."); // Catch errors on user input.
		}
		core.close();
		fora.close();
	}


	public static int pickString() { // Simple function to determine in which string the note will be played in.
		Random r = new Random();
		pickedString = r.nextInt(6) + 1;
		return pickedString;
	}
	
	public static void getPossibleNotes() {
		// Insert the minor pentatonic mode in the arrays.
		firstString[0] = baseNote;
		secondString[0] = baseNote;
		thirdString[0] = baseNote;
		fourthString[0] = baseNote;
		fifthString[0] = baseNote;
		sixthString[0] = baseNote;
		
			firstString[1] = baseNote + 3;
			secondString[1] = baseNote + 3;
			thirdString[1] = baseNote + 2;
			fourthString[1] = baseNote + 2;
			fifthString[1] = baseNote + 2;
			sixthString[1] = baseNote + 3;
			
			firstString[2] = firstString[1] + 2;
			secondString[2] = secondString[1] + 2;
			thirdString[2] = thirdString[1] + 2;
			fourthString[2] = fourthString[1] + 3;
			fifthString[2] = fifthString[1] + 3;
			sixthString[2] = sixthString[1] + 2;
			
			firstString[3] = firstString[2] + 2;
			secondString[3] = secondString[2] + 3;
			thirdString[3] = thirdString[2] + 3;
			fourthString[3] = fourthString[2] + 2;
			fifthString[3] = fifthString[2] + 2;
			sixthString[3] = sixthString[2] + 2;
	}
	
}
