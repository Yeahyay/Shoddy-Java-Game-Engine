package engine;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
//import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
//import javax.swing.WindowConstants;

import pong.components.Paddle;
import utilities.*;

@SuppressWarnings("unused")
public class Engine implements Runnable, KeyListener {
	protected static final long serialVersionUID = -6876111330624142640L;
	public final int WIDTH = 1280;
	public final int HEIGHT = 720;
	public Vec2I resolution = new Vec2I(1280, 720);
	
	public JFrame frame;

	protected BufferStrategy strategy;
	protected BufferedImage buffer;
	protected Graphics2D graphics;
	protected Canvas canvas;
	protected Thread thread;

	private GraphicsConfiguration config =
			GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice()
				.getDefaultConfiguration();

	protected final BufferedImage create(final int width, final int height, final boolean alpha) {
		return config.createCompatibleImage(width, height, alpha ? Transparency.TRANSLUCENT : Transparency.OPAQUE);
	}

	protected void init() {};
	protected void update(double dt) {};
	protected void draw() {};
	protected void cleanup() {};

	public Engine() {
		Time.setInitFunction(this::init);
		Time.setUpdateFunction(this::update);
		Time.setDrawFunction(() -> {
			draw();
			
			Graphics2D sGraphics = (Graphics2D) strategy.getDrawGraphics();
			sGraphics.drawImage(buffer, 0, 0, null);
			sGraphics.dispose();
		});
		Time.setCleanupFunction(this::cleanup);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setSize(WIDTH, HEIGHT);
		frame.add(canvas, 0);
		
//		buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		buffer = create(WIDTH, HEIGHT, false);
		canvas.createBufferStrategy(1);
		do {
			strategy = canvas.getBufferStrategy();
		} while (strategy == null);

		frame.addKeyListener(this);

		Thread thread = new Thread(this);
		thread.start();
	}

	private ArrayList<GameObject> GameObjects = new ArrayList<>(2);
	
	public ArrayList<GameObject> getGameObjects() {
		return GameObjects;
	}

//	public void paint(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		
////		draw(g2d);
//		
//		g2d.drawImage(buffer, 0, 0, null);
//	}


	@Override
	public void run() {
		graphics = buffer.createGraphics();
		
		Time.run();
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setStrategy(BufferStrategy strategy) {
		this.strategy = strategy;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}

	public void setGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public void setGameObjects(ArrayList<GameObject> gameObjects) {
		GameObjects = gameObjects;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();		if (key == KeyEvent.VK_DOWN) {
			GameObjects.get(0).getComponent(Paddle.class).up();
		}
		if (key == KeyEvent.VK_UP) {
			GameObjects.get(0).getComponent(Paddle.class).down();
		}
	}
}
