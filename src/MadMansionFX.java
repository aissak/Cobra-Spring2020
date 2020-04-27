/* 
 * This class is meant to be the the View aspect of the MVC model for our project.
 * 
 * When editing:
 * It should be noted that modifying the appearance can be tricky with JavaFX;
 * typically, combining CSS and JFX graphics libs on an element won't work.
 * 
 * 
 */

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/* the JavaFX environment adaption of MadMansion */
public class MadMansionFX extends Application {
	
	/* the most parent container */
	private static BorderPane window;
	
	/* basically something to hold the title */
	private static FlowPane topFlow;
	
	/* for the list of available commands */
	private static GridPane rightPane;
	
	/* */
	private static TextArea commandArea;
	
	/* where you enter in stuff */
	private static TextArea console;
	
	/* where stuff comes up at */ 
	private static TextArea interactionPane;
	
	private static Player player;
	
	private static Room[] roomTracker;
	
	private static ArrayList<Puzzle> puzzleList;
	
	static void createAndShowGUI(Stage primaryStage) {
		window = new BorderPane();
		rightPane = new GridPane();
		Font titleFont = Font.font("Chalkboard", FontWeight.THIN, 32);
		topFlow = new FlowPane();

		Label titleLabel = new Label("MadMansion FX");
		topFlow.getChildren().add(titleLabel);
		
		CommandHandler handler = new CommandHandler();
		
		titleLabel.setFont(titleFont);
		window.setTop(titleLabel);
		commandArea = new TextArea();
		console = new TextArea();
		console.setOnKeyPressed(handler);
		window.setBottom(console);
		rightPane.add(commandArea, 0, 0);
		
		commandArea.setEditable(false);
		commandArea.setText("go west: w" + "\n" + "go east: e" );
		window.setRight(rightPane);
		titleLabel.setStyle("-fx-padding: 10; -fx-background-color: #CCFF99;");
		commandArea.setWrapText(true);
		commandArea.setPrefWidth(100);
		commandArea.setStyle("-fx-background-color: #0000FF;");
		topFlow.setStyle(titleLabel.getStyle());
		topFlow.setStyle("-fx-background-color: #CCFF99;");
		
		Button b1 = new Button("Hello");
		Button b2 = new Button("World");
		Button b3 = new Button("test");
		GridPane g = new GridPane();
		GridPane leftPanel = new GridPane();
		leftPanel.add(b1, 0, 0);
		leftPanel.add(b2, 0, 1);
		leftPanel.add(b3, 0, 2);
		leftPanel.setPadding(new Insets(5));
		leftPanel.setVgap(10);

		window.setLeft(leftPanel);
		
		interactionPane = new TextArea();
		interactionPane.setEditable(false);
		Font font = Font.font("Futura", FontWeight.EXTRA_LIGHT, 28);
		
		interactionPane.setFont(font);
		window.setCenter(g);
		interactionPane.setStyle("-fx-focus-color: transparent;\n" + 
				"-fx-border-style: none;\n" + 
				"-fx-background-radius: 0.0px;\n" + 
				"-fx-border-radius: 0.0px;-fx-font-family: Consolas; -fx-highlight-fill: #00ff00; "
				+ "-fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; "
				+ "-fx-background-color:#000000;");
		
		
		g.add(interactionPane, 0, 1);
		
		Scene scene = new Scene(window, 600, 1000);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MadMansion FX");
		primaryStage.show();
	}
	
	/* this method gets the last user-entered command */
	public static String getCommand() {
		return console.getText();
	}
	
	/* this method defines what happens after the user clicks ENTER */
	public static void relay() {
		
		/* this is the connection between View and Controller */
		interactionPane.setText(interactionPane.getText() + "\n" + "> " + CommandHandler.peekCommand());
		
		if (roomTracker[player.getRoom()].getPuzzle() != null) {
			if (roomTracker[player.getRoom()].getPuzzle().getAttempts() == 1) {
				System.out.println("You lost:(");
			}
			else if (CommandHandler.peekCommand().trim().toLowerCase().contains(roomTracker[player.getRoom()].getPuzzle().getAnswer())) {
				roomTracker[player.getRoom()].removePuzzle(roomTracker[player.getRoom()].getPuzzle());
				System.out.println("SOLVED");
			}
			else {
				System.out.println(roomTracker[player.getRoom()].getPuzzle().getAnswer());
				System.out.println("Not solved!");
				System.out.println(roomTracker[player.getRoom()].getPuzzle().getAttempts());
				roomTracker[player.getRoom()].getPuzzle().setAttempts(roomTracker[player.getRoom()].getPuzzle().getAttempts() - 1);
			}
		}
		else 
		{
			if (CommandHandler.peekCommand().contains("north")) {
				player.setRoomNumber(roomTracker[roomTracker[player.getRoom()].getNorth()].getNumber());
				interactionPane.setText(interactionPane.getText() + "\n" + player.getPlayerID() + " entered Room " + player.getRoom() + "!");
				System.out.println(player.getRoom());
			}
			else if (CommandHandler.peekCommand().contains("south")) {
				player.setRoomNumber(roomTracker[roomTracker[player.getRoom()].getSouth()].getNumber());
				interactionPane.setText(interactionPane.getText() + "\n" + player.getPlayerID() + " entered Room " + player.getRoom() + "!");
				System.out.println(player.getRoom());
			}
			else if (CommandHandler.peekCommand().contains("east")) {
				player.setRoomNumber(roomTracker[roomTracker[player.getRoom()].getEast()].getNumber());
				interactionPane.setText(interactionPane.getText() + "\n" + player.getPlayerID() + " entered Room " + player.getRoom() + "!");
				System.out.println(player.getRoom());
			}
			else if (CommandHandler.peekCommand().contains("west")) {
				player.setRoomNumber(roomTracker[roomTracker[player.getRoom()].getWest()].getNumber());
				interactionPane.setText(interactionPane.getText() + "\n" + player.getPlayerID() + " entered Room " + player.getRoom() + "!");
				System.out.println(player.getRoom());
			}
			else {
				interactionPane.setText(interactionPane.getText() + "\n" + "\n" + "[SYSTEM]: Error: Unrecognizable command." + "\n");
			}
		}
		
		
		updateView();
		console.clear();
		
	}
	
	public static void main(String[] args) {
		GameLoader.init();
		GameLoader.run();
		roomTracker = GameLoader.getRooms();
		PlayerLoader.init();
		PlayerLoader.run();
		player = PlayerLoader.getPlayer();
		PuzzleLoader.init();
		PuzzleLoader.run();
		puzzleList = PuzzleLoader.getPuzzles();
		ItemLoader.init();
		ItemLoader.run();
		
		for (Puzzle p : puzzleList) {
			roomTracker[p.getRoom()].setPuzzle(p);
			System.out.println(p.getRoom());
		}
		
		launch(args);
	}
	
	
	public void start(Stage primaryStage) {
		createAndShowGUI(primaryStage);
		updateView();
	}
	
	private static void updateView() {
		
		/* that TextArea on the right */
		commandArea.clear();
		
		/* we're lazy so let's use a sentinel value */
		if (roomTracker[player.getRoom()].getNorth() != 0) {
			commandArea.setText(commandArea.getText() + "\n" + "[NORTH]: \n- Room " + roomTracker[player.getRoom()].getNorth() + "\n");
		}
		
		if (roomTracker[player.getRoom()].getEast() != 0) {
			commandArea.setText(commandArea.getText() + "\n" + "[EAST]: \n- Room " + roomTracker[player.getRoom()].getEast() + "\n");
		}
		
		if (roomTracker[player.getRoom()].getSouth() != 0) {
			commandArea.setText(commandArea.getText() + "\n" + "[SOUTH]: \n- Room " + roomTracker[player.getRoom()].getSouth() + "\n");
		}
		
		if (roomTracker[player.getRoom()].getWest() != 0) {
			commandArea.setText(commandArea.getText() + "\n" + "[WEST]: \n- Room " + roomTracker[player.getRoom()].getWest() + "\n");
		}
		
		if (roomTracker[player.getRoom()].getPuzzle() != null) {
			runPuzzle();
		}
		else {
			interactionPane.setText(interactionPane.getText() + "\n" + roomTracker[player.getRoom()].getDescription());
		}
		
	}
	
	private static void runPuzzle() {
		interactionPane.setText(interactionPane.getText() 
				+ "\n"
				+ "\n" + "# Hey... champ in the making!" 
				+ "\n" + "# ..." 
				+ "\n" + "# Riddle me this!" 
				+ "\n"
				+ "\n" + roomTracker[player.getRoom()].getPuzzle().getDescription());
		
	}
	
}
