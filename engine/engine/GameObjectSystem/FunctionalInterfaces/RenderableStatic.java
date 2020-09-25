package engine.GameObjectSystem.FunctionalInterfaces;

import java.awt.Graphics2D;

//import engine.GameObject;
import engine.GameObjectSystem.Component.AbstractRenderableComponent;

@FunctionalInterface
public interface RenderableStatic {
	public void draw(AbstractRenderableComponent abstractRenderableComponent, Graphics2D graphics);
}
