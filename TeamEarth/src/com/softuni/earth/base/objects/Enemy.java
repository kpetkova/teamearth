package com.softuni.earth.base.objects;

import javafx.geometry.Point2D;


public class Enemy extends Character {
	public static final boolean isEnemy = true;
	
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
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
