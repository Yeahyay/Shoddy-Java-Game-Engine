package engine.GameObjectSystem.FunctionalInterfaces;

@FunctionalInterface
public interface TimeUpdateCallback {
	public void update(double dt);
}
