/* Developer: Noel Miranda
* Date of creation: November 27, 2024
* Program objective: Write a program that displays four images randomly selected from a deck of 52 cards
* (directory with 52 images of cards). 
*/

// Declared package
package edu.intermediatejava.module8;

// Imported classes for JavaFX
import javafx.application.Application; // Required for JavaFX applications
import javafx.stage.Stage; // Represents the main application window
import javafx.scene.Scene; // Represents the UI scene
import javafx.scene.layout.HBox; // Horizontal box layout for UI
import javafx.scene.image.Image; // Represents images to display
import javafx.scene.image.ImageView; // Displays the images

// Other imported classes needed
import java.io.File; // For working with files and directories
import java.util.ArrayList; //Dynamic array implementation of List
import java.util.Collections; // Utility class for shuffling lists
import java.util.List; // General interface for working with lists



public class RandomCardDisplay extends Application {
	// Required to start application
	@Override 
	public void start(Stage primaryStage) {
		// Loads 52 card images from the "cards" folder which is found in the project root directory
		List<Image> allCards = loadCardImages();
		
		// Checks to see if images were loaded, if not it exits the program
		if (allCards.isEmpty()) {
			System.out.println("No cards found in the cards directory.");
			return;
		}
		
		// selects  4 random cards from the list of the loaded card images
		List<Image> randomCards = getRandomCards(allCards);
		
		// Creates HBox (horizontal) layout with random cards 
		HBox cardDisplay = createCardDisplay(randomCards);
		
		// Creation of scene, adding of scene to stage, setting stage title, and showing stage
		Scene scene = new Scene(cardDisplay, 450, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Random Card Display");
		primaryStage.show();
	}
	
	// Method to load 52 card images from the "cards" directory
	private List<Image> loadCardImages() {
		// ArrayList to store the card images
		List<Image> images = new ArrayList<>();
		
		// Makes an instance of the File class to represent the "cards" directory 
		File cardsDirectory = new File("cards");
		
		// for loop to iterate through the "cards" directory to retrieve individual card files
		for (int i = 1; i <= 52; i++) {
			// Creates a File object for each card
			File cardFile = new File(cardsDirectory, i + ".png");
			
			// Checks if the files exist to prevent exceptions
			if (cardFile.exists()) {
				// if it exist, it loads the image file using "file:" prefix
				images.add(new Image("file:" + cardFile.getAbsolutePath()));
			} else {
				// Prints a message in case a file is missing
				System.out.println("Missing file: " + cardFile.getName());
			}
		}
		// returns the list of all the loaded images
		return images;
	}
	
	// Method to shuffle elements in the list and then returns a new list with 4 random card images
	private List<Image> getRandomCards(List<Image> allCards) {
		Collections.shuffle(allCards);
		
		return allCards.subList(0, 4);
	}
	
	// Method to create a horizontal layout (HBox) for displaying the cards
	private HBox createCardDisplay(List<Image> cards) {
		// HBox creation with 50px spacing between each card displayed
		HBox cardDisplay = new HBox(50);
		
		// Loop through the random selected cards List to add to the HBox
		for (Image card : cards) {
			// Creates an ImageView for each card
			ImageView cardView = new ImageView(card);
			cardView.setFitWidth(72); // Sets the width of the card to 72px
			cardView.setFitHeight(96); // Sets the height of the card to 96 px
			cardDisplay.getChildren().add(cardView); // Adds the ImageView to the HBox
		}
		// returns the HBox with all the card images ready to be displayed
		return cardDisplay;
	}
	
	// Not required, but included to ensure the program runs correctly in different setups
	public static void main(String[] args) {
		launch(args); // Launches the JavaFX application (calls the start() method)
	}

}