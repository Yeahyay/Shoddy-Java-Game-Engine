package engine.GameObjectSystem.Component;

public abstract class AbstractUpdateableComponent extends AbstractComponent {	
	protected AbstractUpdateableComponent(String name) {
		super(name);
	}

	public abstract void update(double dt);
}
