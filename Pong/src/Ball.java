import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Ball extends GameObject{
	
	Handler handler;
	Random random;

	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		random = new Random();
		do {
		if(Math.random()<0.5) {
			velX = -5;
		}else {
			velX = 5;
		 }
		}while(velX == 0);
		if(Math.random()<0.5) {
			velY = random.nextInt(5) * (-1);
		}else {
			velY = random.nextInt(5);
		}
	}

	public void tick() {
		x += velX;
		y += velY;
		
		
		collision();
		
		if(x < 0) {
			 velX *= -1;
			 HUD.scoreTwo += 1;
		}
		if(x > 1000) {
			 velX *= -1;
			 HUD.scoreOne += 1;
		}
		if(y > 710) velY *= -1;
		if(y < 0) velY *= -1;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, 15, 15);
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Pad || tempObject.getId() == ID.PadTwo) {
				if(getBounds().intersects(tempObject.getBounds())) {
						velX *= (-1);
						try {
							playSound("pop.wav");
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (UnsupportedAudioFileException e) {
							e.printStackTrace();
						} catch (IOException e) {
							System.out.println("Audio file missing!");
						} catch (LineUnavailableException e) {
							e.printStackTrace();
						}
				}
			}
			
		}
	}
	

	public Rectangle getBounds() {
		return new Rectangle(x,y,15,15);
	}
	
	void playSound(String soundFile) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
	    File f = new File("sounds/" + soundFile);
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioIn);
	    clip.start();
	}

}
