package com.softuni.earth.base.objects;

import java.awt.Point;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.util.Duration;

/**
 * Class representing the Player character, inheriting the Character class.
 */

public class Player extends Character {

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
		TranslateTransition smoothMove = new TranslateTransition(Duration.millis(200), this.getNode());
		smoothMove.setByX(this.getPosition().getX());
		smoothMove.setByY(this.getPosition().getY());
		smoothMove.setAutoReverse(true);
		smoothMove.play();
	}

}
