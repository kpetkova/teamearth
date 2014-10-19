package com.softuni.earth;

import javafx.application.Application;
import javafx.stage.Stage;

import com.softuni.earth.base.GameField;
import com.softuni.earth.base.GameWorld;

public class Main extends Application {

	private GameWorld gameWorld = new GameWorldInitializer(60,
			"Team Earth game", 500, 500);

	@Override
	public void start(Stage primaryStage) {
		try {
			// setup title, scene, stats, controls, and actors.
			gameWorld.initGame(primaryStage);

			// kick off the game loop
			gameWorld.beginGame();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		GameField field = new GameField();
		field.runGame();
	}
}
