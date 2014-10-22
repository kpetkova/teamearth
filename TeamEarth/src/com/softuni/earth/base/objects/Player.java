package com.softuni.earth.base.objects;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.util.Duration;

/**
 * Class representing the Player character, inheriting the Character class.
 */

public class Player extends Character {

	private boolean isFacingRightDirection = true;

	public Player(String name, Point2D position, int healthPoints,
			int defensePoints, int manaPoints, int range) {
		super(name, position, healthPoints, defensePoints, manaPoints, range);

	}

	@Override
	protected void addToInventory(Item item) {
		this.applyItemEffect(item);
		this.inventory.add(item);
	}

	@Override
	protected void removeFromInventory(Item item) {
		this.removeItemEffect(item);
		this.inventory.remove(item);
	}

	@Override
	public void update() {
		//Updating player with armory or health points
	}
	
	@Override
	public void updatePosition(Point2D position) {
		TranslateTransition smoothMove = new TranslateTransition(
				Duration.millis(200), this.getNode());
		smoothMove.setByX(position.getX());
		smoothMove.setByY(position.getY());
		smoothMove.setAutoReverse(true);
		smoothMove.play();
	}

	public boolean isFacingRight() {
		return isFacingRightDirection;
	}

	public void setFacingRightDirection(boolean isFacingRightDirection) {
		this.isFacingRightDirection = isFacingRightDirection;
	}
}
