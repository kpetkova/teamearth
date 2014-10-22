/**
 * 
 */
package com.softuni.earth.base;

import java.util.ArrayList;
import java.util.List;

import com.softuni.earth.base.objects.Enemy;

/**
 * @author kpetkova
 *
 */
public class GameObjectManager {

	public final static List<GameObject> GAME_OBJECTS = new ArrayList<GameObject>();
	
	public List<GameObject> getAllObjects() {
		return GAME_OBJECTS;
	}
	
	public List<GameObject> getEnemies() {
		List<GameObject> enemies = new ArrayList();
		for(GameObject object : GAME_OBJECTS) {
			if(object instanceof Enemy) {
				enemies.add(object);
			}
		}
		return enemies;
	}
	
	public void addObjects(List<GameObject> objects) {
		GAME_OBJECTS.addAll(objects);
	}
	
	public void addObject(GameObject object) {
		GAME_OBJECTS.add(object);
	}
	 
	public void removeObjects(List<GameObject> objects) {
		GAME_OBJECTS.removeAll(objects);
	}
	
	public void removeObject(GameObject object) {
		GAME_OBJECTS.remove(object);
	}
}
