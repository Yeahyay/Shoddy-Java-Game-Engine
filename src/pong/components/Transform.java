package pong.components;

import engine.GameObjectSystem.Component.AbstractUpdateableComponent;
import utilities.Vec2;

public class Transform extends AbstractUpdateableComponent {
	private Vec2 position = new Vec2(0d, 0d);
	private Vec2 size = new Vec2(0d, 0d);
	private double angle = 0;

	@Override
	public void update(double dt) {
	}

	public String toString() {
		return String.format("%s: %s", getName(), position);
	}
	
	public Transform() {
		super("Transform");
		System.out.printf("%s, %s\n", this, this.position);
	}
	public Transform(Vec2 position) {
		super("Transform");
		this.position = position;
	}
	public Transform(Vec2 position, Vec2 size) {
		super("Transform");
		this.position = position;
		this.size = size;
	}
	public Transform(Vec2 position, Vec2 size, double angle) {
		super("Transform");
		this.position = position;
		this.size = size;
		this.angle = angle;
	}
	
	public Vec2 getPosition() {
		return position;
	}
	public void setPosition(Vec2 position) {
		this.position = position;
	}
	public Vec2 getSize() {
		return size;
	}
	public void setSize(Vec2 size) {
		this.size = size;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
}
