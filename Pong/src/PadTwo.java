import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PadTwo extends GameObject{
	
	Handler handler;

	public PadTwo(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y > 630) y = 630;
		if(y < 0) y = 0;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 10, 100);
	}
	

	public Rectangle getBounds() {
		return new Rectangle(x,y,10,100);
	}

}
