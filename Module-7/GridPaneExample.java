/* Developer: Noel Miranda
 * Date of creation: November 21, 2024
 * Program objective: JavaFX gridPane example referenced in module 7 assignment paper. 
*/

// Declared package
package edu.intermediatejava.module7;

// Imported classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GridPaneExample extends Application {
	// Required to start application
	@Override
	public void start(Stage primaryStage) {
		// Utilizing the gridPane layout for specific placement of textfields and labels within the scene/stage
		GridPane gridPane = new GridPane();
		
		// Methods for spacing
		gridPane.setHgap(5); // Horizontal spacing of 5px
		gridPane.setVgap(8); // Vertical spacing of 8px
		
		// Creation of a Label node 
		Label prompt1 = new Label("First Name: ");
		gridPane.add(prompt1, 3, 4); // Adding Label to column 3 and row 4 of GridPane
		
		// Creation of a TextField node
		TextField textfield1 = new TextField();
		gridPane.add(textfield1, 4, 4); //Adding TextField to column 4 row 4 of GridPane
		
		// Creation of a second Label node 
		Label prompt2 = new Label("Last Name: ");
		gridPane.add(prompt2, 3, 5); // Adding second Label to column 3 and row 5 of GridPane
		
		// Creation of a TextField node
		TextField textfield2 = new TextField();
		gridPane.add(textfield2, 4, 5); //Adding TextField to column 4 row 5 of GridPane
		
		// Creation of scene, adding of scene to stage, setting stage title, and showing stage
		Scene scene = new Scene(gridPane, 400, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Module 7 GridPane Example");
		primaryStage.show();
	}
	
	// Not required, but included to ensure the program runs correctly in different setups
	public static void main(String[] args) {
		launch(args);
	}
}
