package com.softuni.earth.base;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public abstract class GameObject {

	// protected int id;

	protected Point2D position;

	private Node node;

	protected Point2D moveBy;

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

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Point2D getMoveBy() {
		return moveBy;
	}

	public void setMoveBy(Point2D moveBy) {
		this.moveBy = moveBy;
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
		if(this.position.getX() == other.position.getX() || this.position.getY() == other.position.getY()) {
			return true;
		}
		
		return false;
	}

	public void updatePosition(Point2D moveBy) {
//		double x = 0;
//		double y = 0;
//		if (position != null) {
//			x = position.getX();
//			y = position.getY();
//		}
//		Point2D newPosition = new Point2D(x + moveBy.getX(), y + moveBy.getY());
//		setMoveBy(new Point2D(moveBy.getX(), moveBy.getY()));
//		setPosition(newPosition);
	}
}
