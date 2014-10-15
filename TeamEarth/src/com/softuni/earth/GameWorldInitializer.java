/**
 * 
 */
package com.softuni.earth;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import com.softuni.earth.base.GameObject;
import com.softuni.earth.base.GameWorld;

/**
 * @author kpetkova
 *
 */
public class GameWorldInitializer extends GameWorld {

	public GameWorldInitializer(int fps, String title) {
		super(fps, title);
	}

	@Override
	protected void handleUpdate(GameObject object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initGame(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(
				getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle(this.getGameTitle());
	}


}
