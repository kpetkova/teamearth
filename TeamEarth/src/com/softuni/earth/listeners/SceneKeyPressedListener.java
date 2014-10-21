package com.softuni.earth.listeners;

import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.softuni.earth.GameWorldInitializer;
import com.softuni.earth.base.GameObject;
import com.softuni.earth.base.GameObjectManager;
import com.softuni.earth.base.objects.Bullet;
import com.softuni.earth.base.objects.Player;

/**
 * Listener that should be set to the scene in order to update the objects when
 * specific key events occur. For example the main character ( the player)
 * should move right when the user clicks the right arrow. This listener is
 * responsible for setting the position of the character which is then visually
 * updated by the scene itself.
 * 
 * @author marto
 *
 */
public class SceneKeyPressedListener implements EventHandler<KeyEvent> {

	private GameObject player;
	private GameObject bullet;

	public SceneKeyPressedListener(GameWorldInitializer gameWorldInitializer) {
		GameObjectManager gameObjectManager = gameWorldInitializer
				.getGameObjectManager();
		List<GameObject> allObjects = gameObjectManager.getAllObjects();
		// This should be the player.
		player = allObjects.get(0);
		bullet = allObjects.get(2);
		
	}

	public void handle(final KeyEvent event) {
		KeyCode code = event.getCode();

		if (code.equals(KeyCode.RIGHT)) {
			moveRight();
		} else if (code.equals(KeyCode.LEFT)) {
			moveLeft();
		} else if (code.equals(KeyCode.UP)) {
			moveUp();
		} else if (code.equals(KeyCode.DOWN)) {
			moveDown();
		} else if(code.equals(KeyCode.SPACE)) {
			shoot();
		}

		event.consume();
	}

	private void shoot() {
		Point2D shootDirection = new Point2D(5f, 5f);
		if(bullet instanceof Bullet) {
			Bullet thisBullet = (Bullet) bullet;
			thisBullet.setDirection(shootDirection);
			thisBullet.update();
		}
	}

	private void moveDown() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(0, 20f);
			player.setPosition(moveBy);
			player.update();			
		}
	}

	private void moveUp() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(0, -20f);
			player.setPosition(moveBy);
			player.update();	
		}
	}

	private void moveLeft() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(-20f, 0);
			player.setPosition(moveBy);
			player.update();		
		}
	}

	private void moveRight() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(20f, 0);
			player.setPosition(moveBy);
			player.update();
		}
	}
	
	
}
