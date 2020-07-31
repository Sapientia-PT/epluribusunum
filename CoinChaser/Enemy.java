import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject{

	public Enemy(int x, int y, ID id) {
		super(x, y, id);
		
		Random r = new Random();
		if(Math.random() < 0.5) {
			velY = r.nextInt(5) + 1;
		}else {
			velY = -(r.nextInt(5) + 1);
		}
		if(Math.random() < 0.5) {
			velX = r.nextInt(5) + 1;
		}else {
			velX = -(r.nextInt(5) + 1);
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,25,25);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 60) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 45) velX *= -1;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, 25, 25);
	}

}
