package com.softuni.earth.base;

import java.awt.Point;

import javafx.scene.Node;

public abstract class GameObject {

	// protected int id;

	protected Point position;

	private Node node;

	// protected String getId() {
	// return id;
	// }
	//
	// protected void setId(String id) {
	// this.id = id;
	// }

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
