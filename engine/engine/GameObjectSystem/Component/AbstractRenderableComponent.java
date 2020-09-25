package engine.GameObjectSystem.Component;

import java.awt.Graphics2D;

import engine.GameObjectSystem.FunctionalInterfaces.RenderableStatic;

public abstract class AbstractRenderableComponent extends AbstractComponent {
	private RenderableStatic drawFunction = null;
	
	protected AbstractRenderableComponent(String name) {
		super(name);
	}
	protected AbstractRenderableComponent(String name, RenderableStatic drawFunction) {
		super(name);
		this.drawFunction = drawFunction;
	}
	
	public void draw(Graphics2D graphics) {
		drawFunction.draw(this, graphics);
	}
}
