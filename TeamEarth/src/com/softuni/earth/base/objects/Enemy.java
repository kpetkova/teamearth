package com.softuni.earth.base.objects;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.util.Duration;


public class Enemy extends Character {
	public static final boolean isEnemy = true;
	
	public Enemy() {} 
	
	protected Enemy(String name, Point2D position, int healthPoints,
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
	public void updatePosition(Point2D position) {
		TranslateTransition smoothMove = new TranslateTransition(
				Duration.millis(300), this.getNode());
		smoothMove.setByX(this.getPosition().getX() + position.getX());
		smoothMove.setByY(this.getPosition().getY() + position.getY());
		smoothMove.setAutoReverse(true);
		smoothMove.play();
	}

	@Override
	public void update() {
		updatePosition(new Point2D(2f, 0f));
	}

}
