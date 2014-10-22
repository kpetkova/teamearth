package com.softuni.earth.listeners;

import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
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

	private Player player;

	private GameObject bullet;

	private GameObjectManager gameObjectManager;

	private Group root;

	public SceneKeyPressedListener(GameWorldInitializer gameWorldInitializer,
			Group root) {
		this.root = root;
		gameObjectManager = gameWorldInitializer.getGameObjectManager();
		List<GameObject> allObjects = gameObjectManager.getAllObjects();
		// bullet = allObjects.get(2);
		initObjects(allObjects);
	}

	private void initObjects(List<GameObject> allObjects) {
		for (GameObject currentObject : allObjects) {
			if (currentObject instanceof Player) {
				player = (Player) currentObject;
			}
		}
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
		} else if (code.equals(KeyCode.A)) {
			shoot("west");
		} else if (code.equals(KeyCode.D)) {
			shoot("east");
		} else if (code.equals(KeyCode.W)) {
			shoot("north");
		} else if (code.equals(KeyCode.X)) {
			shoot("south");
		}
		

		event.consume();
	}

	private void shoot(String shootingDirection) {
		Bullet bullet = new Bullet(player);
		gameObjectManager.addObject(bullet);
		root.getChildren().add(bullet.getNode());
		bullet.setShootingDirection(shootingDirection);
		bullet.update();

	}

	private void moveDown() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(0, 20f);
			player.updatePosition(moveBy);
			player.update();
		}
	}

	private void moveUp() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(0, -20f);
			player.updatePosition(moveBy);
			player.update();
		}
	}

	private void moveLeft() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(-20f, 0);
			player.updatePosition(moveBy);
			player.setFacingRightDirection(false);
			player.update();
		}
	}

	private void moveRight() {
		if (player instanceof Player) {
			Point2D moveBy = new Point2D(20f, 0);
			player.updatePosition(moveBy);
			player.setFacingRightDirection(true);
			player.update();
		}
	}

}
