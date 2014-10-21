package com.softuni.earth.base;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public abstract class GameObject {

	// protected int id;

	protected Point2D position;

	private Node node;

	// protected String getId() {
	// return id;
	// }
	//
	// protected void setId(String id) {
	// this.id = id;
	// }

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D moveBy) {
		this.position = moveBy;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
    /**
     * Update current object
     */
    public abstract void update();
    
    /**
     * Do we have a collision between two objects?
     *
     */
    public boolean collide(GameObject other) {
    	//TODO version 0.0 Update logic
    	
        return false;
    }
}
