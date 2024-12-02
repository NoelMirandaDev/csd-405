/* Developer: Noel Miranda
* Date of creation: December 1, 2024
* Program objective: Code example using lambda to supplement Module 9 essay. 
*/

// Declared package
package edu.intermediatejava.module9;

//Imported classes for JavaFX
import javafx.application.Application; // Main application class
import javafx.scene.layout.HBox; // HBox layout container for horizontal arrangement
import javafx.scene.layout.BorderPane; // BorderPane layout container for flexible positioning
import javafx.stage.Stage; // Represents the main window (stage) of the application
import javafx.scene.text.Text; // Text element for displaying text on the UI
import javafx.scene.text.Font; // Font class to define the style and size of text
import javafx.scene.Scene; // Scene object to hold the layout and UI components
import javafx.geometry.Pos; // Used for setting alignment of UI components
import javafx.scene.control.Button; // Button class for creating clickable buttons

public class LambdaExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Creates a text element with a message
		Text text = new Text("The buttons below were coded using lambda!");
		text.setFont(new Font("Arial", 18)); // Sets the font style and size for the text
		
		/************************************* Lambda Expression Example 1 **************************/
		// Creates a button that reveals a message on click
		Button msgButton = new Button("Reveal Message");
		// Below is the code without lambdas to handle the button's ActionEvent when clicked
		
		/* msgButton.setOnAction(new EventHandler<ActionEvent>() {
		*	 @Override
		*	 public void handle(ActionEvent event) {
		*		 System.out.println("Lambda Executed!");
		*	 }
		*  });
		*/
		
		// This code uses a lambda expression to handle the ActionEvent of msgButton (Line Below)
		msgButton.setOnAction(event -> System.out.println("Lambda Executed!"));
		/********************************************************************************************/
		
		/************************************* Lambda Expression Example 2 **************************/
		 // Creates a button that exits the application
		Button extButton = new Button("Exit");
		// Below is the code without lambdas to handle the button's ActionEvent when clicked
	
		/* extButton.setOnAction(new EventHandler<ActionEvent>() {
		*	 @Override
		*	 public void handle(ActionEvent event) {
		*		 System.exit(0);
		*	 }
		*  });
		*/
		
		// This code uses a lambda expression to handle the ActionEvent of extButton (Line Below)
		extButton.setOnAction(event -> System.exit(0));
		/********************************************************************************************/
		
		// Creates an HBox to hold the buttons horizontally with spacing of 10px
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(msgButton, extButton); // Adds buttons to HBox
		hBox.setAlignment(Pos.CENTER); // Aligns the buttons in the center
        
		// Creates a BorderPane layout
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(text); // Places the text at the center
		borderPane.setBottom(hBox); // Places the HBox (buttons) at the bottom
        
		// Creates a scene with the BorderPane layout
		Scene scene = new Scene(borderPane, 400, 350);
		primaryStage.setScene(scene); // Sets the scene on the stage
		primaryStage.setTitle("Lambda Example"); // Sets the window title
		primaryStage.show(); // Displays the window
		
	}
	// Not required, but included to ensure the program runs correctly in different setups
	public static void main(String[] args) {
		launch(args); // Launches the JavaFX application (calls the start() method)
	}
}