/**
 * 
 */
package com.softuni.earth;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import com.softuni.earth.base.GameObject;
import com.softuni.earth.base.GameWorld;
import com.softuni.earth.base.objects.Player;
import com.softuni.earth.listeners.ExitButtonOnClickListener;
import com.softuni.earth.listeners.SceneKeyPressedListener;
import com.softuni.earth.listeners.StartGameButtonOnClickListener;
import com.softuni.earth.utils.Constants;

/**
 * @author kpetkova
 *
 */
public class GameWorldInitializer extends GameWorld {

	private Group root;

	private int width;

	private int height;

	private int rows;

	private int cols;

	private int squareWidht;

	private int squareHeight;

	public GameWorldInitializer(int fps, String title) {
		super(fps, title);
	}

	public GameWorldInitializer(int fps, String title, int width, int height) {
		super(fps, title);
		this.width = width;
		this.height = height;
	}

	public GameWorldInitializer(int fps, String title, int width, int height,
			int rows, int cols) {
		super(fps, title);
		this.width = width;
		this.height = height;
		this.rows = rows;
		this.cols = cols;
		initStageSquare();
	}

	/**
	 * This method will call the handle update which will update the characters,
	 * field etc on every frame.
	 * 
	 * @param object
	 *            - the object that will be updated if needed.
	 */
	public void callHandleUpdate(GameObject object) {
		handleUpdate(object);
	}

	@Override
	protected void handleUpdate(GameObject object) {

	}

	@Override
	public void initGame(Stage primaryStage) {
		root = new Group();

		// Create the scene
		// Create main menu and characters
		initCharacters();
		createMainMenu(root);
		
		setSceneNodes(root);
		Scene scene = createScene();
		setGameSurface(scene);
		primaryStage.setScene(getGameSurface());
		primaryStage.setTitle(this.getGameTitle());
		primaryStage.show();
	}

	/**
	 * Creates the button for the main menu in a vertical order and sets their
	 * appropriate click listeners.
	 * 
	 * @param charactersList
	 * 
	 * @param border
	 */
	private void createMainMenu(Group root) {
		// Create a layout to hold the menu buttons.
		BorderPane border = new BorderPane();

		// Create the buttons.
		Button startGameButton = new Button(Constants.START_GAME_BUTTON_LABEL);
		startGameButton.setOnAction(new StartGameButtonOnClickListener(border,
				this));
		Button exitButton = new Button(Constants.EXIT_GAME_BUTTON_LABEL);
		// Set click listeners
		exitButton.setOnAction(new ExitButtonOnClickListener());

		// Add the buttons to this list to avoid repeating longer code.
		List<Button> mainMenuButtons = new ArrayList<Button>();
		mainMenuButtons.add(startGameButton);
		mainMenuButtons.add(exitButton);

		// Create a vertical box to hold the buttons in a vertical order.
		VBox buttonHolder = new VBox(10f);
		// Center the buttons in the border layout.
		buttonHolder.setAlignment(Pos.CENTER);
		buttonHolder.getChildren().addAll(mainMenuButtons);

		// Add the box containing the buttons into the root holder.
		border.setCenter(buttonHolder);

		// Add it to the root so it is displayed in the frame.
		root.getChildren().add(border);
	}

	private void initCharacters() {
		Circle circle = new Circle(20f);
		circle.setFill(Color.RED);
		circle.setVisible(false);
		circle.setId("TestCircle");

		Player circlePlayer = new Player("Asd", null, 1, 1, 1, 1);
		circlePlayer.setNode(circle);
		circlePlayer.setPosition(new Point(50, 50));

		getGameObjectManager().addObject(circlePlayer);
		root.getChildren().add(circle);
	}

	private void initStageSquare() {
		squareWidht = this.width / cols;
		squareHeight = this.height / rows;
	}

	/**
	 * Create a scene, attach it to the root, apply the styling from the css and
	 * set the scene on key press listener.
	 * 
	 * @return - the scene to be drawn on.
	 */
	private Scene createScene() {
		Scene scene = new Scene(root, width, height, Color.YELLOW);
		scene.getStylesheets().add(
				getClass().getResource("application.css").toExternalForm());
		scene.setOnKeyPressed(new SceneKeyPressedListener(this));
		return scene;
	}
}
