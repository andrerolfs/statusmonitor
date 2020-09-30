package de.wartbar.model.basic;

public class WartbarLevel {

	String name;
	int background;

	public WartbarLevel(String name, int background) {
		this.name = name;
		this.background = background;
	}

	public int getBackground() {
		return background;
	}

	public String getName() {
		return name;
	}
}
