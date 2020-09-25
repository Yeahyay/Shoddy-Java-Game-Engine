package pong.components;

import engine.GameObjectSystem.Component.AbstractUpdateableComponent;
import utilities.Vec2;

public class PhysicsPrimitive extends AbstractUpdateableComponent {
	public Vec2 velocity = new Vec2(0, 0);
	public double moveSpeed = 2d;
	public double damping = 0.9d;
	
	public PhysicsPrimitive() {
		super("PhysicsPrimitive");
	}

	@Override
	public void update(double dt) {
		Transform transform = getParent().getComponent(Transform.class);
		Vec2 position = transform.getPosition();
		
		Vec2.mul(velocity, damping);
		transform.setPosition(Vec2.add(position, velocity));
	}
}
