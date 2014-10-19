package com.softuni.earth.listeners;

import java.util.List;

import com.softuni.earth.GameWorldInitializer;
import com.softuni.earth.base.GameObject;
import com.softuni.earth.base.GameObjectManager;
import com.softuni.earth.base.GameWorld;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class KeyFrameEventListener implements EventHandler<ActionEvent> {

	private GameWorld gameWorld;

	public KeyFrameEventListener(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}

	@Override
	public void handle(ActionEvent event) {
		updateSprites();
	}

	protected void updateSprites() {
		GameObjectManager gameObjectManager = gameWorld.getGameObjectManager();
		List<GameObject> gameObjects = gameObjectManager.getAllObjects();

		for (GameObject object : gameObjects) {
			((GameWorldInitializer) gameWorld).callHandleUpdate(object);
		}
	}
}
