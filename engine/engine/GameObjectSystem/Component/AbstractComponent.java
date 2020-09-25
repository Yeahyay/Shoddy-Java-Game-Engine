package engine.GameObjectSystem.Component;

import engine.GameObject;
import engine.GameObjectSystem.Component.Exceptions.NoNameException;

public abstract class AbstractComponent implements Component {
	private GameObject parent = null;
	private String name = null;
	
	protected AbstractComponent(String name) {
		this.name = name;
		if (name == null) {
			throw new NoNameException(String.format("Component %s", this));
		}
	}

	public String getName() {
		return name;
	}
	public GameObject getParent() {
		return parent;
	}
	public void setParent(GameObject parent) {
		this.parent = parent;
	}
}
