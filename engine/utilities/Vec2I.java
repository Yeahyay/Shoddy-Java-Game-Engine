package utilities;

public class Vec2I {
	public int x;
	public int y;

	public String toString() {
		return String.format("(%d , %d)", x, y);
	}
	
	public Vec2I() {
		set(0, 0);
	}	
	public Vec2I(int x) {
		set(x, x);
	}
	public Vec2I(int x, int y) {
		set(x, y);
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static double dot(Vec2I a, Vec2I b) {
		return a.x * b.x + a.y * b.y;
	}
	public static double mag(Vec2I a) {
		return Math.sqrt(a.x * a.x + a.y * a.y);
	}
	public static double magSq(Vec2I a) {
		return a.x * a.x + a.y * a.y;
	}
	public static double angle(Vec2I a, Vec2I b) {
		return Math.atan2(b.x - a.x, b.y - a.y);
	}
	
	public static Vec2I add(Vec2I a, Vec2I b) {
		a.x += b.x;
		a.y += b.y;
		return a;
	}
	public static Vec2I sub(Vec2I a, Vec2I b) {
		a.x -= b.x;
		a.y -= b.y;
		return a;
	}
	public static Vec2I mul(Vec2I a, Vec2I b) {
		a.x *= b.x;
		a.y *= b.y;
		return a;
	}
	public static Vec2I mul(Vec2I a, double b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2I mul(Vec2I a, float b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2I mul(Vec2I a, int b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2I div(Vec2I a, Vec2I b) {
		a.x /= b.x;
		a.y /= b.y;
		return a;
	}
	public static Vec2I div(Vec2I a, double b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
	public static Vec2I div(Vec2I a, float b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
	public static Vec2I div(Vec2I a, int b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
}
