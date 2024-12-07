/* Developer: Noel Miranda
* Date of creation: December 4, 2024
* Program objective: Write a program that displays four images randomly selected from a deck of 52 cards
* (directory with 52 images of cards). Include a button below the cards which will shuffle them and display 
* 4 new random cards.
*/

// Declared package
package edu.intermediatejava.module10;

// Imported JavaFX Classes
import javafx.application.Application; // Required for JavaFX applications
import javafx.scene.Scene; // Represents the UI scene
import javafx.stage.Stage; // Represents the main application window
import javafx.geometry.Pos; // Used to align elements within a layout
import javafx.scene.layout.HBox; // Horizontal box layout for UI
import javafx.scene.control.Button; // Represents a clickable button in the UI
import javafx.scene.image.Image; // Represents images to display
import javafx.scene.image.ImageView; // Displays the images
import javafx.scene.layout.BorderPane; // Layout with predefined regions
import javafx.geometry.Insets; // Adds padding or margins around UI elements

// Other imported classes
import java.util.Collections; // Utility class for shuffling lists
import java.io.File; // For working with files and directories
import java.util.ArrayList; //Dynamic array implementation of List
import java.util.List; // General interface for working with lists

public class RandomCardDisplayGenerator extends Application {
	
	// Declaring class field of HBox with loaded images 
	private HBox loadedHbox;
	
	// Main entry point for the JavaFX application
	@Override
	public void start(Stage primaryStage) {
		
		// Loads 52 card images from the "cards" folder which is found in the project root directory
		List<Image> loadedCardImages = loadCardImages();
		
		// Checks to see if images were loaded, if not it exits the program
		if (loadedCardImages.isEmpty()) {
			System.out.println("No cards found in the cards directory.");
			return;
		}
		
		// selects  4 random cards from the list of the loaded card images
		List<Image> fourRandomCardImages = shuffleCardImages(loadedCardImages);
		
		// Creates HBox (horizontal) layout with random cards
		loadedHbox = addImagesToHbox(fourRandomCardImages);
		loadedHbox.setAlignment(Pos.CENTER); // Centers the images 
		loadedHbox.setPadding(new Insets(20)); // Adds padding around the images
		
		// Creates a BorderPane layout to organize the UI
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(loadedHbox);
	
		// Creates a button for the function of shuffling and redisplaying four random cards
		Button generatorButton = new Button("Shuffle Cards");
		
		// Create an HBox to hold the button and center it
		HBox buttonContainer = new HBox(generatorButton);
		buttonContainer.setAlignment(Pos.TOP_CENTER);
		borderPane.setCenter(buttonContainer);
		
		// Sets up the button's action to shuffle and update the displayed cards within the class field
		generatorButton.setOnAction(e -> {
			// Gets a new set of 4 random card images
			List<Image> randomCardImagesAfterClick = shuffleCardImages(loadedCardImages);
			
			// Clears the existing images in the HBox
			loadedHbox.getChildren().clear();
			
			// Adds the newly shuffled card images to the HBox
			loadedHbox.getChildren().addAll(addImagesToHbox(randomCardImagesAfterClick).getChildren());
		});
		
		// Creation of scene, adding of scene to stage, setting stage title, and showing stage
		Scene scene = new Scene(borderPane, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Random Generator to Display Four Random Cards");
		primaryStage.show();
	}
	
	// Method to load 52 card images from the "cards" directory
	private List<Image> loadCardImages() {
		
		// Makes an instance of the File class to represent the "cards" directory
		File cardsDirectory = new File("cards");
		
		// ArrayList to store the card images
		List<Image> loadedCardImages = new ArrayList<>();
		
		// for loop to iterate through the "cards" directory to retrieve individual card files
		for (int i = 1; i <= 52; i++) {
			// Creates a File object for each card
			File eachCardFile = new File(cardsDirectory, i + ".png");
			
			// Checks if the files exist to prevent exceptions
			if (eachCardFile.exists()) {
				// if it exist, it loads the image file using "file:" prefix
				loadedCardImages.add(new Image("file:" + eachCardFile.getAbsolutePath()));
			} else { 
				// Prints a message in case a file is missing
				System.out.println("Missing file: " + eachCardFile.getName());
			}
		}
		
		// returns the list of all the loaded images
		return loadedCardImages;
	}
	
	// Method to shuffle elements in the list and then returns a new list with 4 random card images
	private List<Image> shuffleCardImages(List<Image> loadedCardImages) {
		
		Collections.shuffle(loadedCardImages);
		
		return loadedCardImages.subList(0, 4);
		
	}
	
	// Method to create a horizontal layout (HBox) for displaying the cards
	private HBox addImagesToHbox(List<Image> fourRandomCards) {
		
		// HBox creation with 40px spacing between each card displayed
		HBox hBox = new HBox(40);
		
		// Loop through the random selected cards List to add to the HBox
		for (Image card : fourRandomCards) {
			// Creates an ImageView for each card
			ImageView viewableCard = new ImageView(card);
			viewableCard.setFitWidth(72); // Sets the width of the card to 72px
			viewableCard.setFitHeight(96); // Sets the height of the card to 96px
			hBox.getChildren().add(viewableCard); // Adds the ImageView to the HBox
		}
		
		// returns the HBox with all the card images ready to be displayed
		return hBox;
		
	}
		
	// Not required, but included to ensure the program runs correctly in different setups
	public static void main(String[] args) {
		launch(args); // Launches the JavaFX application (calls the start() method)
	}

}
