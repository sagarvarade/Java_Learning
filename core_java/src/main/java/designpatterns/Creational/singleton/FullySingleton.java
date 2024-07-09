package designpatterns.Creational.singleton;

import java.io.Serializable;

public final class FullySingleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	static FullySingleton fullySingleton = new FullySingleton();

	private FullySingleton() {
	}

	
	public static FullySingleton getInstance() {
		return fullySingleton;
	}

	// For serialization
	protected Object readResolve() {
		return fullySingleton;
	}
	
	// For clone able 
	public FullySingleton clone() throws CloneNotSupportedException {
		return fullySingleton;
	}
}
