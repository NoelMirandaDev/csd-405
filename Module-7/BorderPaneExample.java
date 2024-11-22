/* Developer: Noel Miranda
 * Date of creation: November 21, 2024
 * Program objective: JavaFX borderPane example referenced in module 7 assignment paper. 
*/

// Declared package
package edu.intermediatejava.module7;

// Imported classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneExample extends Application {
	// Required to start application
	@Override
	public void start(Stage primaryStage) {
		// Utilizing the borderPane layout to assign the button a placement within the scene/stage
		BorderPane borderPane = new BorderPane();
		
		// Creation of Button
		Button exampleButton = new Button("JavaFX Example Button");
		
		// Extra code to test binding method for the width and height of the button in accordance to the stage 
		exampleButton.prefWidthProperty().bind(primaryStage.widthProperty().divide(4)); // stage width divided by 4
		exampleButton.prefHeightProperty().bind(primaryStage.heightProperty().divide(13)); // stage height and divided by 13
		
		// Utilizes borderPane's layout to place the button in the bottom section of the Pane
		borderPane.setBottom(exampleButton);
		
		// Extra code to align the button in the center of the bottom section
		BorderPane.setAlignment(exampleButton, Pos.CENTER);
		
		// Creation of scene, adding of scene to stage, setting stage title, and showing stage
		Scene exampleScene = new Scene(borderPane, 800, 800);
		primaryStage.setScene(exampleScene); 
		primaryStage.setTitle("Module 7 BorderPane Example");
		primaryStage.show();
		
	}
	// Not required, but included to ensure the program runs correctly in different setups
	public static void main(String[] args) {
		launch(args);
	}
}
