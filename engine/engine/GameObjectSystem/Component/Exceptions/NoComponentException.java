package engine.GameObjectSystem.Component.Exceptions;

public class NoComponentException extends RuntimeException {
	public NoComponentException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 2428336311146221446L;
}
