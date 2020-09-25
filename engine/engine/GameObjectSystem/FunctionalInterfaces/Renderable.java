package engine.GameObjectSystem.FunctionalInterfaces;

import java.awt.Graphics2D;

@FunctionalInterface
public interface Renderable {
	public void draw(Graphics2D graphics);
}
