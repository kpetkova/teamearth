/**
 * 
 */
package com.softuni.earth.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kpetkova
 *
 */
public class GameObjectManager {

	public final static List<GameObject> GAME_OBJECTS = new ArrayList<GameObject>();
	
	public List<GameObject> getAllObjects() {
		return GAME_OBJECTS;
	}
	
	public void addObjects(List<GameObject> objects) {
		GAME_OBJECTS.addAll(objects);
	}
	 
	public void remoteObjects(List<GameObject> objects) {
		GAME_OBJECTS.removeAll(objects);
	}
}
