package com.softuni.earth.listeners;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import com.softuni.earth.GameWorldInitializer;
import com.softuni.earth.base.GameObject;

public class StartGameButtonOnClickListener implements
		EventHandler<ActionEvent> {

	private BorderPane border;

	private GameWorldInitializer gameWorldInitializer;

	public StartGameButtonOnClickListener(BorderPane border,
			GameWorldInitializer gameWorldInitializer) {
		this.border = border;
		this.gameWorldInitializer = gameWorldInitializer;
	}

	@Override
	public void handle(ActionEvent event) {
		// Clear the buttons from the main screen to set up the game field.
		border.getChildren().clear();
		List<GameObject> allObjects = gameWorldInitializer
				.getGameObjectManager().getAllObjects();

		for (GameObject currentObject : allObjects) {
			Node node = currentObject.getNode();
			Point2D position = currentObject.getPosition();
			if(position!=null) {
				node.setTranslateX(position.getX());
				node.setTranslateY(position.getY());
				
			}
			
			node.setVisible(true);
		}
	}
}
