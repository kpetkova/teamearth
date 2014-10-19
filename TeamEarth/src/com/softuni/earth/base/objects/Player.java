package com.softuni.earth.base.objects;

import java.awt.Point;

/**
 * Class representing the Player character, inheriting the Character class.
 */

public class Player extends Character {

	public Player(String name, Point position, int healthPoints,
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

}
