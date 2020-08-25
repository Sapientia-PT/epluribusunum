import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

	class Main extends Applet{
	
	
	private static final long serialVersionUID = 994522450733042303L;

	public void paint (Graphics g){
		FileReader fr;
		try {
			fr = new FileReader("generated_solo.gsol");
			String show[] = getAll(getFileCont(fr));
			for(int i=1;i<7;i++) {
				g.drawString(show[i],10,10 * i);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public static void main(String[] args) throws IOException {
		JFrame fra = new JFrame("Solo Visualizer");
        Main a = new Main ();
        fra.getContentPane().add(a, BorderLayout.CENTER);
        fra.setSize(new Dimension(500,100));
        fra.setVisible(true);
        fra.setResizable(false);
	}
	
	public static String getFileCont(final FileReader file) throws IOException { // Function to read the output file's first line which contains the solo.
        final BufferedReader bufferedr = new BufferedReader(file);
        final String res = bufferedr.readLine();
        bufferedr.close();
        return res;
    }
	
	public String[] getAll(String fileCont) {
		int nNote = 0;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		StringBuilder sb6 = new StringBuilder();
		sb1.append("|-");
		sb2.append("|-");
		sb3.append("|-");
		sb4.append("|-");
		sb5.append("|-");
		sb6.append("|-");
		for(int i=0;i<fileCont.length();i++) {
			if(fileCont.charAt(i) == '(') {
				if(fileCont.charAt(i+1) == '1') {
					for(int j=0;j<nNote;j++) {
						sb1.append("--");
					}
					sb1.append(fileCont.charAt(i-1));
					nNote++;
				}
				if(fileCont.charAt(i+1) == '2') {
					for(int j=0;j<nNote;j++) {
						sb2.append("--");
					}
					sb2.append(fileCont.charAt(i-1));
					nNote++;
				}
				if(fileCont.charAt(i+1) == '3') {
					for(int j=0;j<nNote;j++) {
						sb3.append("--");
					}
					sb3.append(fileCont.charAt(i-1));
					nNote++;
				}
				if(fileCont.charAt(i+1) == '4') {
					for(int j=0;j<nNote;j++) {
						sb4.append("--");
					}
					sb4.append(fileCont.charAt(i-1));
					nNote++;
				}
				if(fileCont.charAt(i+1) == '5') {
					for(int j=0;j<nNote;j++) {
						sb5.append("--");
					}
					sb5.append(fileCont.charAt(i-1));
					nNote++;
				}
				if(fileCont.charAt(i+1) == '6') {
					for(int j=0;j<nNote;j++) {
						sb6.append("--");
					}
					sb6.append(fileCont.charAt(i-1));
					nNote++;
				}
			}
		}
		
		String res[] = new String[7];
		res[1] = sb1.toString();
		res[2] = sb2.toString();
		res[3] = sb3.toString();
		res[4] = sb4.toString();
		res[5] = sb5.toString();
		res[6] = sb6.toString();
		
		return res;
	}
	
	
}
