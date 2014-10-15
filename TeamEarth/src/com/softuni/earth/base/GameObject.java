package com.softuni.earth.base;

import javafx.scene.Node;
import javafx.scene.effect.Light.Point;

public abstract class GameObject {
	

	protected int id;
	
	protected Point position;
	
	private Node node;

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
}
