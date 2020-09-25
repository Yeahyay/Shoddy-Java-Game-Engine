package pong.components;

import engine.GameObjectSystem.Component.AbstractComponent;
import utilities.Vec2;

public class Paddle extends AbstractComponent {
	public Paddle() {
		super("Paddle");
	}
	
	public int score = 0;
	
	public void up() {
		PhysicsPrimitive physicsPrimitive = getParent().getComponent(PhysicsPrimitive.class);
		Vec2 velocity = physicsPrimitive.velocity;
		double moveSpeed = physicsPrimitive.moveSpeed;
		velocity.y += moveSpeed;
	}
	
	public void down() {
		PhysicsPrimitive physicsPrimitive = getParent().getComponent(PhysicsPrimitive.class);
		Vec2 velocity = physicsPrimitive.velocity;
		double moveSpeed = physicsPrimitive.moveSpeed;
		velocity.y -= moveSpeed;
	}

}
