package com.softuni.earth;

import com.softuni.earth.base.GameField;
import com.softuni.earth.base.GameWorld;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
    GameWorld gameWorld = new GameWorldInitializer(60, "Team Earth game");
    
	@Override
	public void start(Stage primaryStage) {
		try {		
			
	        // setup title, scene, stats, controls, and actors.
	        gameWorld.initGame(primaryStage);
	 
	        // kick off the game loop
	        gameWorld.beginGame();	 
			
			primaryStage.show();
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
