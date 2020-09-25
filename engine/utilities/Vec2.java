package utilities;

public class Vec2 {
	public double x;
	public double y;

	public String toString() {
		return String.format("(%fd , %fd)", x, y);
	}
	
	public Vec2() {
		set(0, 0);
	}	
	public Vec2(double x) {
		set(x, x);
	}
	public Vec2(double x, double y) {
		set(x, y);
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static double dot(Vec2 a, Vec2 b) {
		return a.x * b.x + a.y * b.y;
	}
	public static double mag(Vec2 a) {
		return Math.sqrt(a.x * a.x + a.y * a.y);
	}
	public static double magSq(Vec2 a) {
		return a.x * a.x + a.y * a.y;
	}
	public static double angle(Vec2 a, Vec2 b) {
		return Math.atan2(b.x - a.x, b.y - a.y);
	}
	
	public static Vec2 add(Vec2 a, Vec2 b) {
		a.x += b.x;
		a.y += b.y;
		return a;
	}
	public static Vec2 sub(Vec2 a, Vec2 b) {
		a.x -= b.x;
		a.y -= b.y;
		return a;
	}
	public static Vec2 mul(Vec2 a, Vec2 b) {
		a.x *= b.x;
		a.y *= b.y;
		return a;
	}
	public static Vec2 mul(Vec2 a, double b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2 mul(Vec2 a, float b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2 mul(Vec2 a, int b) {
		a.x *= b;
		a.y *= b;
		return a;
	}
	public static Vec2 div(Vec2 a, Vec2 b) {
		a.x /= b.x;
		a.y /= b.y;
		return a;
	}
	public static Vec2 div(Vec2 a, double b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
	public static Vec2 div(Vec2 a, float b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
	public static Vec2 div(Vec2 a, int b) {
		a.x /= b;
		a.y /= b;
		return a;
	}
}
