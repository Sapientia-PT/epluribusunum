import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int scoreOne = 0;
	public static int scoreTwo = 0;
	
	
	public void tick() {
		if(scoreOne <= 0) scoreOne = 0;
		if(scoreTwo <= 0) scoreTwo = 0;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Points: " + Integer.toString(scoreOne), 15, 15);
		g.drawString("Points: " + Integer.toString(scoreTwo), 950, 15);
	}
	

}
