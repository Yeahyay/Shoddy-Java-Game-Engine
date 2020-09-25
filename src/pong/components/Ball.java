package pong.components;

import java.util.ArrayList;

import engine.GameObject;
import engine.Time;
//import engine.GameObjectSystem.Component.AbstractComponent;
import engine.GameObjectSystem.Component.AbstractUpdateableComponent;
import pong.Pong;
import utilities.Vec2;

public class Ball extends AbstractUpdateableComponent {
	public Ball() {
		super("Ball");
	}
	
	public GameObject checkCollision() {
		ArrayList<GameObject> GameObjects = Pong.game.getGameObjects();

		Transform ballTransform = GameObjects.get(2).getComponent(Transform.class);
		Vec2 ballPosition = ballTransform.getPosition();
		Vec2 ballSize = ballTransform.getSize();
		
		for(int i = 0; i < 2; i++) {
			Transform transform = GameObjects.get(i).getComponent(Transform.class);
			Vec2 position = transform.getPosition();
			Vec2 size = transform.getSize();
			
			boolean vertical = false, horizontal = false;//, wall = false;
			if (ballPosition.y <= 0 || ballPosition.y + 2 * ballSize.y >= Pong.game.resolution.y) {
//				wall = true;
				hit(0);
			} else {
				if (ballPosition.x <= position.x+size.x && ballPosition.x+ballSize.x >= position.x) {
					horizontal = true;
				}
				if (ballPosition.y <= position.y+size.y && ballPosition.y+ballSize.y >= position.y) {
					vertical = true;
				}
				hit(vertical && horizontal ? 1 : -1);
			}

			
//			System.out.printf("%s, %s, %s\n", vertical, horizontal, wall);
		}
		return new GameObject(); // should return the collided object
	}
	
	public void hit(int type) {
		ArrayList<GameObject> GameObjects = Pong.game.getGameObjects();
		PhysicsPrimitive physics = GameObjects.get(2).getComponent(PhysicsPrimitive.class);
//		Transform transform = GameObjects.get(2).getComponent(Transform.class);
//		Vec2 position = transform.getPosition();
		
		double increase = 0.5;
		
		switch(type) {
			case 0:
				physics.velocity.y *= -1;
				physics.update(Time.rate);
				break;
			case 1:
				physics.velocity.x = -(Math.signum(physics.velocity.x) == 1.0 ? physics.velocity.x + increase : physics.velocity.x - increase);
				physics.update(Time.rate);
				break;
		}

	}

	@Override
	public void update(double dt) {
		checkCollision();
	}
}
