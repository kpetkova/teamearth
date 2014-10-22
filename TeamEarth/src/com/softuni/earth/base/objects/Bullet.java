/**
 * 
 */
package com.softuni.earth.base.objects;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import com.softuni.earth.base.GameObject;

/**
 * @author kpetkova
 *
 */
public class Bullet extends Item {

	private GameObject holder;

	private String shootingDirection;
	
	private boolean isTop;

	public GameObject getHolder() {
		return holder;
	}

	public void setHolder(GameObject holder) {
		this.holder = holder;
	}


	public Bullet(GameObject holder) {
		super();
		this.holder = holder;
		createNode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softuni.earth.base.GameObject#update()
	 */
	@Override
	public void update() {
		double translateX = holder.getNode().getTranslateX();
		double translateY = holder.getNode().getTranslateY();
		Point2D playerPosition = new Point2D(translateX, translateY);

		this.position = playerPosition;
		TranslateTransition smoothMove = new TranslateTransition(
				Duration.millis(2000), this.getNode());
		smoothMove.setFromX(translateX);
		smoothMove.setFromY(translateY);
		// FIXME: Change 1000 to screenWidth()
		int leftRightDirection = 0;
		int upDownDirection = 0;
		
		switch (shootingDirection) {
		case ("west"):
			leftRightDirection = -1000;
			break;
		case ("east"):
			leftRightDirection = 1000;
			break;
		case ("north"):
			upDownDirection = -1000;
			break;
		case ("south"):
			upDownDirection = 1000;
			break;
		default:
			//some other directions?
			break;
		}
		
		smoothMove.setByX(this.getPosition().getX() + leftRightDirection);
		smoothMove.setByY(this.getPosition().getY() + upDownDirection);
		smoothMove.setAutoReverse(true);
		smoothMove.setCycleCount(1);
		smoothMove.play();
	}

	private void createNode() {
		Circle bulletCircle = new Circle(5f);
		bulletCircle.setFill(Color.BLUE);
		bulletCircle.setVisible(true);
		bulletCircle.setId("Player Bullet");
		Point2D playerPosition = holder.getPosition();
		double xPosition = playerPosition == null ? 0 : playerPosition.getX();
		double yPosition = playerPosition == null ? 0 : playerPosition.getY();
		bulletCircle.setTranslateX(xPosition);
		bulletCircle.setTranslateY(yPosition);
		setNode(bulletCircle);
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public String getShootingDirection() {
		return shootingDirection;
	}

	public void setShootingDirection(String shootingDirection) {
		this.shootingDirection = shootingDirection;
	}
}
