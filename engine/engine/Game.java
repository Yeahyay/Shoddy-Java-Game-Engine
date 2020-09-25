package engine;

public interface Game {
	public void init();
	public void update(double dt);
	public void draw();
	public void cleanup();
}
