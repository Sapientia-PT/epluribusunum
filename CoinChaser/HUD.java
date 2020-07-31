import java.awt.Color;
import java.awt.Graphics;

public class HUD{
	
	public static int health = 100;
	public static int score = 0;
	

	public void tick() {
		if(health <= 0) health = 0;
		if(health >= 100) health = 100; 
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, health * 2, 32);
		g.setColor(Color.black);
		g.drawRect(15, 15, 200, 32);
		g.setColor(Color.white);
		g.drawString("Score: " + Integer.toString(score), 15, 70);
	}
	
}
