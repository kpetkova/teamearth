package com.softuni.earth.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a character in the game. Holds the information
 * that every character in the game should have.
 * 
 * @author marto
 *
 */
public abstract class Character {

	/**
	 * The name of the character. It could be used to identify different game
	 * characters.
	 */
	protected String name;

	/**
	 * The current position of the character - where the character is on the
	 * field (in the array)
	 */
	protected int[][] position;

	protected int healthPoints;

	protected int defensePoints;

	protected int manaPoints;

	protected List<Item> inventory;

	protected int range;

	protected int attackPower;

	protected boolean isAlive;

	protected Character(String name, int[][] position, int healthPoints,
			int defensePoints, int manaPoints, int range) {
		this.name = name;
		this.position = position;
		this.healthPoints = healthPoints;
		this.defensePoints = defensePoints;
		this.manaPoints = manaPoints;
		this.range = range;
		this.inventory = new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[][] getPosition() {
		return position;
	}

	public void setPosition(int[][] position) {
		this.position = position;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

	public int getManaPoints() {
		return manaPoints;
	}

	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	protected void applyItemEffect(Item item) {
		this.healthPoints = item.getHealthEffect();
		this.defensePoints = item.getDefenseEffect();
		this.manaPoints = item.getManaEffect();
		this.attackPower = item.getAttackEffect();
	}

	protected abstract void addToInventory(Item item);

	protected abstract void removeFromInventory(Item item);
}