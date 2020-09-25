package engine;

import java.awt.Graphics2D;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
import java.util.HashMap;

//import engine.Components.Transform;
import engine.GameObjectSystem.Component.*;
import engine.GameObjectSystem.Component.Exceptions.NoComponentException;

public class GameObject {
	private HashMap<String, AbstractUpdateableComponent> components = new HashMap<>();
	private HashMap<String, AbstractRenderableComponent> renderers = new HashMap<>();
	private HashMap<String, AbstractComponent> raws = new HashMap<>();
	private String name = new String();
	
	public <T extends AbstractUpdateableComponent> void addComponent(T component) {
		components.put(component.getClass().getName(), component);
		component.setParent(this);
		System.out.printf("Added component %s to GameObject %s\n", component.getName(), this);
	}
	public <T extends AbstractRenderableComponent> void addComponent(T component) {
		renderers.put(component.getClass().getName(), component);
		component.setParent(this);
		System.out.printf("Added renderable component %s to GameObject %s\n", component.getName(), this);
	}
	public <T extends AbstractComponent> void addComponent(T component) {
		raws.put(component.getClass().getName(), component);
		component.setParent(this);
		System.out.printf("Added raw component %s to GameObject %s\n", component.getName(), this);
	}
	
	public void update(double dt) {
		for (AbstractUpdateableComponent component : components.values()) {
			component.update(dt);
		}
	}
	
	public void draw(Graphics2D graphics) {
		for (AbstractRenderableComponent renderer : renderers.values()) {
			renderer.draw(graphics);
		}
	}
	
	public HashMap<String, AbstractUpdateableComponent> getComponents() {
		return components;
	}
	
	public <T extends AbstractComponent> T getComponent(Class<T> key) {
		T component;
		component = key.cast(components.get(key.getName()));
		if (component == null) {
			component = key.cast(renderers.get(key.getName()));	
		}
		if (component == null) {
			component = key.cast(raws.get(key.getName()));	
		}
		if (component == null) {
			throw new NoComponentException(String.format("Game object %s does not have component %s", this, key.getName()));
		}
		return component;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
