package com.softuni.earth.base.objects;

import com.softuni.earth.base.GameObject;

public abstract class Item extends GameObject {

	protected int healthEffect;

	protected int manaEffect;

	protected int defenseEffect;

	protected int attackEffect;

	public int getHealthEffect() {
		return healthEffect;
	}

	public void setHealthEffect(int healthEffect) {
		this.healthEffect = healthEffect;
	}

	public int getManaEffect() {
		return manaEffect;
	}

	public void setManaEffect(int manaEffect) {
		this.manaEffect = manaEffect;
	}

	public int getDefenseEffect() {
		return defenseEffect;
	}

	public void setDefenseEffect(int defenseEffect) {
		this.defenseEffect = defenseEffect;
	}

	public int getAttackEffect() {
		return attackEffect;
	}

	public void setAttackEffect(int attackEffect) {
		this.attackEffect = attackEffect;
	}
}
