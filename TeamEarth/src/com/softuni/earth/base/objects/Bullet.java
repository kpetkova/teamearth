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

	private boolean isRight;

	public GameObject getHolder() {
		return holder;
	}

	public void setHolder(GameObject holder) {
		this.holder = holder;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
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
		int direction = 0;
		if (isRight) {
			direction = 1000;
		} else {
			direction = -1000;
		}
		smoothMove.setByX(this.getPosition().getX() + direction);
		smoothMove.setByY(this.getPosition().getY());
		smoothMove.setAutoReverse(true);
		smoothMove.setCycleCount(1);
		smoothMove.play();
	}

	private void createNode() {
		Circle bulletCircle = new Circle(5f);
		bulletCircle.setFill(Color.BLUE);
		bulletCircle.setVisible(true);
		bulletCircle.setId("Player Bullet");
		bulletCircle.setTranslateX(holder.getPosition().getX() + 30f);
		bulletCircle.setTranslateY(holder.getPosition().getY());
		setNode(bulletCircle);
	}
}
