package pong.components;

import engine.GameObjectSystem.Component.AbstractRenderableComponent;
import engine.GameObjectSystem.FunctionalInterfaces.RenderableStatic;

public class Renderer extends AbstractRenderableComponent {
	public Renderer() {
		super("Renderer");
	}
	public Renderer(RenderableStatic drawFunction) {
		super("Renderer", drawFunction);
	}
}
