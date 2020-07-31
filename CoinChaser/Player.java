import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Player extends GameObject{
	
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,25,25); // Get a hitbox
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(x <= 0) setX(0); // Boundaries
		if(x >= Game.WIDTH - 40) setX(Game.WIDTH - 40); // Boundaries
		if(y <= 0) setY(0); // Boundaries
		if(y >= Game.HEIGHT - 65) setY(Game.HEIGHT - 65); // Boundaries
		
		collision(); // Check collisions
		checkScore();
		if(HUD.health == 0) { 
			JOptionPane.showMessageDialog(null, "Game Over!\nScore was: " + HUD.score);
			System.exit(1);
			} // Game Over
	}
	
	private void checkScore() {
		if(HUD.score % 100 == 0) {
			HUD.health = 100;
			HUD.score += 5;
		}
		if(HUD.score % 250 == 0) {
			for(int i = 0; i < handler.object.size();i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.Enemy) {
					if(tempObject.getVelX() < 0) tempObject.setVelX(tempObject.getVelX() - 1);
					if(tempObject.getVelX() > 0) tempObject.setVelX(tempObject.getVelX() + 1);
					if(tempObject.getVelY() < 0) tempObject.setVelY(tempObject.getVelY() - 1);
					if(tempObject.getVelY() > 0) tempObject.setVelY(tempObject.getVelY() + 1);
				}
				
			}
			HUD.score += 5;
		}
		
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Enemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.health-=2; // Hitpoints
				}
			}
			if(tempObject.getId() == ID.Point) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.score+=5; // Give score
					handler.removeObject(tempObject); // Remove point once catched
					handler.addObject(new Point(Game.WIDTH / 2 - 25, Game.HEIGHT / 2 - 25, ID.Point)); // Respawn a new point
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(x, y, 25, 25);
	}

}
