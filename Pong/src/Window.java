import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window {
	
	ImageIcon img;
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		img = new ImageIcon("images/logo.png");
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(img.getImage());
		frame.setVisible(true);
		
	}
	
}
