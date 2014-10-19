/**
 * 
 */
package com.softuni.earth.base;

import java.util.List;

import com.softuni.earth.listeners.KeyFrameEventListener;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author kpetkova
 *
 */
public abstract class GameWorld {

	/** The JavaFX Scene as the game surface */
	private Scene gameSurface;

	/** All nodes to be displayed in the game window. */
	private Group sceneNodes;

	/** The game loop using JavaFX's TimelineAPI. */
	private static Timeline gameLoop;

	/** Number of frames per second. */
	private final int framesPerSecond;

	public Scene getGameSurface() {
		return gameSurface;
	}

	public void setGameSurface(Scene gameSurface) {
		this.gameSurface = gameSurface;
	}

	public Group getSceneNodes() {
		return sceneNodes;
	}

	public void setSceneNodes(Group sceneNodes) {
		this.sceneNodes = sceneNodes;
	}

	public GameObjectManager getGameObjectManager() {
		return gameObjectManager;
	}

	public void setGameObjectManager(GameObjectManager gameObjectManager) {
		this.gameObjectManager = gameObjectManager;
	}

	public static Timeline getGameLoop() {
		return gameLoop;
	}

	public int getFramesPerSecond() {
		return framesPerSecond;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	/** Title in the application window. */
	private final String gameTitle;

	private GameObjectManager gameObjectManager = new GameObjectManager();

	public GameWorld(final int fps, final String title) {
		framesPerSecond = fps;
		gameTitle = title;
		// create and set timeline for the game loop
		assembleGame();
	}

	/**
     * 
     */
	private void assembleGame() {
		final Duration oneFrameAmt = Duration
				.millis(1000 / getFramesPerSecond());

		final KeyFrame oneFrame = new KeyFrame(oneFrameAmt,
				new KeyFrameEventListener(this)); // oneFrame

		// sets the game world's game loop (Timeline)
		Timeline timeLine = new Timeline();
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.getKeyFrames().add(oneFrame);

		setGameLoop(timeLine);
	}

	private void setGameLoop(Timeline build) {
		GameWorld.gameLoop = build;
	}

	protected void updateSprites() {
		List<GameObject> gameObjects = gameObjectManager.getAllObjects();
		for (GameObject object : gameObjects) {
			handleUpdate(object);
		}
	}

	protected abstract void handleUpdate(GameObject object);

	public abstract void initGame(final Stage primaryStage);

	public void beginGame() {
		getGameLoop().play();
	}
}
