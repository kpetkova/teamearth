/**
 * 
 */
package com.softuni.earth.base.objects;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import com.softuni.earth.base.GameObject;
/**
 * @author kpetkova
 *
 */
public class Bullet extends Item {
	
	GameObject holder ; 
	Point2D direction;
	
	

	public GameObject getHolder() {
		return holder;
	}



	public void setHolder(GameObject holder) {
		this.holder = holder;
	}



	public Point2D getDirection() {
		return direction;
	}



	public void setDirection(Point2D direction) {
		this.direction = direction;
	}



	public Bullet(GameObject holder) {
		super();
		this.holder = holder;
		
	}



	/* (non-Javadoc)
	 * @see com.softuni.earth.base.GameObject#update()
	 */
	@Override
	public void update() {
		Point2D playerPosition = holder.getPosition();
		this.position = playerPosition;
		TranslateTransition smoothMove = new TranslateTransition(Duration.millis(20), this.getNode());
		smoothMove.setByX(this.getPosition().getX() + direction.getX());
		smoothMove.setByY(this.getPosition().getY() + direction.getY());
		smoothMove.setAutoReverse(true);
		smoothMove.setCycleCount(1000);
		smoothMove.play();
	}

}
