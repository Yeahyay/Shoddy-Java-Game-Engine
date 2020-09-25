package utilities;

public class Vec2F {
	public float x;
	public float y;

	public String toString() {
		return String.format("(%ff , %ff)", x, y);
	}
	
	public Vec2F() {
		set(0, 0);
	}	
	public Vec2F(float x) {
		set(x, x);
	}
	public Vec2F(float x, float y) {
		set(x, y);
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public static double dot(Vec2F a, Vec2F b) {
		return a.x * b.x + a.y * b.y;
	}
	public static double mag(Vec2F a) {
		return Math.sqrt(a.x * a.x + a.y * a.y);
	}
	public static double magSq(Vec2F a) {
		return a.x * a.x + a.y * a.y;
	}
	public static double angle(Vec2F a, Vec2F b) {
		return Math.atan2(b.x - a.x, b.y - a.y);
	}
	
	public static Vec2F add(Vec2F a, Vec2F b) {
		a.x += b.x;
		a.y += b.y;
		return a;
	}
	public static Vec2F sub(Vec2F a, Vec2F b) {
		a.x -= b.x;
		a.y -= b.y;
		return a;
	}
	public static Vec2F mul(Vec2F a, Vec2F b) {
		a.x *= b.x;
		a.y *= b.y;
		return a;
	}
	public static Vec2F mul(Vec2F a, double b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2F mul(Vec2F a, float b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2F mul(Vec2F a, int b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2F div(Vec2F a, Vec2F b) {
		a.x /= b.x;
		a.y /= b.y;
		return a;
	}
	public static Vec2F div(Vec2F a, double b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
	public static Vec2F div(Vec2F a, float b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
	public static Vec2F div(Vec2F a, int b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
}
