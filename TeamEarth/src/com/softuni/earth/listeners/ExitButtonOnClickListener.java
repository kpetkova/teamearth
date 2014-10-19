package com.softuni.earth.listeners;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Listener for the exit button in the main menu that terminates the application
 * when the button is clicked.
 * 
 * @author marto
 *
 */
public class ExitButtonOnClickListener implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		// TODO: Any saving that should occur before exit should happen here.
		Platform.exit();
	}
}
