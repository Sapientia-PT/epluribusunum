import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -8921419424614180143L;
	
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	private HUD hud;
	
	public Game() {
		new Window(1024,768,"Pong",this);
		hud = new HUD();
		start();
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		handler.addObject(new Pad(20 , 300, ID.Pad, handler));
		handler.addObject(new PadTwo(980 , 300, ID.PadTwo, handler));
		handler.addObject(new Ball(512 , 384, ID.Ball, handler));
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta= 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(isRunning) render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 1024, 768);
		
		handler.render(g);
		hud.render(g);	
		
		g.dispose();
		bs.show();
		
	}

	public static void main(String[] args) {
		new Game();
	}

}
