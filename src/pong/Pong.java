package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import engine.Engine;
import engine.Game;
import engine.GameObject;
import engine.Time;
import pong.components.*;
import utilities.Vec2;

@SuppressWarnings("unused")
public class Pong extends Engine implements Game {
	public static Pong game;
	
	@Override
	public void init() {
		ArrayList<GameObject> GameObjects = getGameObjects();
		Time.timeScale = 0.1;
		GameObject paddle = new GameObject();
		{
			Transform transform;
			{
				Vec2 size = new Vec2(50, 200);
				transform = new Transform(new Vec2(resolution.x/2-size.x/2-500, resolution.y/2-size.y/2), size);
			}
			
			Renderer renderer;
			{
				renderer = new Renderer((component, graphics) -> {
					GameObject parent = component.getParent();
					Vec2 position = parent.getComponent(Transform.class).getPosition();
					Vec2 size = parent.getComponent(Transform.class).getSize();
					graphics.setColor(Color.WHITE);
					graphics.drawRect((int) position.x, (int) position.y, (int) size.x, (int) size.y);
				});
			}
			
			paddle.addComponent(transform);
			paddle.addComponent(renderer);
			paddle.addComponent(new PhysicsPrimitive());
			paddle.addComponent(new Paddle());
			
			GameObjects.add(paddle);
		}
		
		GameObject paddleAI = new GameObject();
		{
			Transform transform;
			{
				Vec2 size = new Vec2(50, 200);
				transform = new Transform(new Vec2(resolution.x/2-size.x/2+500, resolution.y/2-size.y/2), size);
			}
			
			Renderer renderer;
			{
				renderer = new Renderer((component, graphics) -> {
					GameObject parent = component.getParent();
					Vec2 position = parent.getComponent(Transform.class).getPosition();
					Vec2 size = parent.getComponent(Transform.class).getSize();
					graphics.setColor(Color.WHITE);
					graphics.drawRect((int) position.x, (int) position.y, (int) size.x, (int) size.y);
				});
			}
			
			paddleAI.addComponent(transform);
			paddleAI.addComponent(renderer);
			paddleAI.addComponent(new PhysicsPrimitive());
			paddleAI.addComponent(new Paddle());
			
			GameObjects.add(paddleAI);
		}
		
		GameObject ball = new GameObject();
		{
			Transform transform;
			{
				Vec2 size = new Vec2(50, 50);
				transform = new Transform(new Vec2(resolution.x/2-size.x/2, resolution.y/2-size.y/2), size);
			}
			ball.addComponent(transform);
			
			Renderer renderer;
			{
				renderer = new Renderer((component, graphics) -> {
					GameObject parent = component.getParent();
					Vec2 position = parent.getComponent(Transform.class).getPosition();
					Vec2 size = parent.getComponent(Transform.class).getSize();
					graphics.setColor(Color.WHITE);
					graphics.drawOval((int) position.x, (int) position.y, (int) size.x, (int) size.y);
				});
			}
			ball.addComponent(renderer);

			PhysicsPrimitive physics;
			{
				physics = new PhysicsPrimitive();
				physics.damping = 1;
				physics.moveSpeed = 1;
				physics.velocity = new Vec2(-5, -(((int) Math.random()) * 2 - 1)*5);
			}
			ball.addComponent(physics);
			ball.addComponent(new Ball());

			GameObjects.add(ball);
		}

		defaultFont = graphics.getFont();
		scoreboardFont = defaultFont.deriveFont(defaultFont.getSize() * 4F);
	}
	Font defaultFont;
	Font scoreboardFont;
	
	@Override
	public void update(double dt) {
		ArrayList<GameObject> GameObjects = getGameObjects();
		for (GameObject object : getGameObjects()) {
			object.update(dt);
		}
//		GameObjects.get(0).getComponent(Paddle.class).up();
//		GameObjects.get(0).getComponent(Transform.class).getPosition().y += 1;
//		for (int i = 0; i < Math.random()*2500000+50000; i++) {
//			new GameObject();
//		}
	}
	

	@Override
	public void draw() {
		ArrayList<GameObject> GameObjects = getGameObjects();
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		graphics.setColor(Color.WHITE);

		graphics.setFont(defaultFont);
		
		graphics.drawString(String.format("FPS:"), 20, 20+15);
		graphics.drawString(String.format("%12s%.4f", "", Time.fps), 20, 50);
		graphics.drawString(String.format("Frame Time:"), 20, 65);
		graphics.drawString(String.format("%12s%.4fs", "", Time.delta), 20, 80);
		graphics.drawString(String.format("%12s%.4fms", "", Time.deltaMilli), 20, 95);
		graphics.drawString(String.format("%12s%dns", "", Time.deltaNano), 20, 110);

		graphics.setFont(scoreboardFont);
		
		graphics.drawString(String.format("%d | %d",
				GameObjects.get(0).getComponent(Paddle.class).score,
				GameObjects.get(0).getComponent(Paddle.class).score), resolution.x/2-50, 60);
//		graphics.drawString(String.format("FPS: %f\n", Time.fps), 20, 50);

		for (GameObject object : getGameObjects()) {
			object.draw(graphics);
		}
	}
	
	@Override
	public void cleanup() {
	}

	public static void main(String[] args) {
		game = new Pong();
	}	
}
