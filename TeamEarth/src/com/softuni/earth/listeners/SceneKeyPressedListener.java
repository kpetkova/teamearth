package com.softuni.earth.listeners;

import java.util.List;

import com.softuni.earth.GameWorldInitializer;
import com.softuni.earth.base.GameObject;
import com.softuni.earth.base.GameObjectManager;
import com.softuni.earth.base.objects.Player;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

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

	public SceneKeyPressedListener(GameWorldInitializer gameWorldInitializer) {
		GameObjectManager gameObjectManager = gameWorldInitializer
				.getGameObjectManager();
		List<GameObject> allObjects = gameObjectManager.getAllObjects();
		// This should be the player.
		player = allObjects.get(0);
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
		}

		event.consume();
	}

	private void moveDown() {
		if (player instanceof Player) {
			Node playerNode = player.getNode();
//			double translateY = playerNode.getTranslateY();

			TranslateTransition smoothMove = new TranslateTransition(Duration.millis(200), playerNode);
			smoothMove.setByY(20f);
			smoothMove.setAutoReverse(true);
			smoothMove.play();
		}
	}

	private void moveUp() {
		if (player instanceof Player) {
			Node playerNode = player.getNode();
//			double translateY = playerNode.getTranslateY();

			TranslateTransition smoothMove = new TranslateTransition(Duration.millis(200), playerNode);
			smoothMove.setByY(-20f);
			smoothMove.setAutoReverse(true);
			smoothMove.play();
		}
	}

	private void moveLeft() {
		if (player instanceof Player) {
			Node playerNode = player.getNode();
//			double translateX = playerNode.getTranslateX();

			TranslateTransition smoothMove = new TranslateTransition(Duration.millis(200), playerNode);
			smoothMove.setByX(-20f);
			smoothMove.setAutoReverse(true);
			smoothMove.play();
		}
	}

	private void moveRight() {
		if (player instanceof Player) {
			Node playerNode = player.getNode();
//			double translateX = playerNode.getTranslateX();

			//playerNode.setTranslateX(translateX + 20f);
			TranslateTransition smoothMove = new TranslateTransition(Duration.millis(200), playerNode);
			smoothMove.setByX(20f);
			smoothMove.setAutoReverse(true);
			smoothMove.play();
		}
	}
}
