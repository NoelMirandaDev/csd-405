/* Developer: Noel Miranda
*  Date of Creation: December 11, 2024
*  Program Objective: Write a program that displays various figures such as a Circle, a Rectangle, 
*  or an Ellipse. Include radio buttons selections for changing the display figure to the one 
*  selected. Include a check box for filling and clearing the displayed figure with a random color.
*/

// Declared Package 
package edu.intermediatejava.module11;

// Imported JavaFX classes
import javafx.application.Application; // Required for JavaFX applications
import javafx.geometry.Pos; // Used to align elements within a layout
import javafx.stage.Stage; // Represents the main application window
import javafx.scene.Scene; // Represents the UI scene
import javafx.scene.control.RadioButton; // Represents a clickable radio button in the UI
import javafx.scene.control.ToggleGroup; // Groups multiple buttons together
import javafx.scene.control.CheckBox; // Represents a checkable button in the UI
import javafx.scene.layout.BorderPane; // Layout with predefined regions
import javafx.scene.layout.StackPane; // Layout which centers and stacks nodes
import javafx.scene.layout.HBox; // Horizontal layout for nodes 
import javafx.scene.layout.VBox; // Vertical layout for nodes
import javafx.scene.control.Label; // Represents labels for titles, etc.
import javafx.geometry.Insets; // Utilized for setting padding to UI elements
import javafx.scene.shape.Circle; // Utilized to create a circle shape
import javafx.scene.shape.Rectangle; // Utilized to create a rectangle shape
import javafx.scene.shape.Ellipse; // Utilized to create an ellipse shape
import javafx.scene.paint.Color; // Utilized to assign colors
import javafx.scene.shape.Shape; // Utilized as a type to create a variable for holding shapes
import javafx.scene.layout.BorderStroke; // Represents an outline for a border in a JavaFX layout
import javafx.scene.layout.BorderStrokeStyle; // Defines styles for border stroke
import javafx.scene.layout.BorderWidths; // Specifies the thickness of the border in pixels
import javafx.scene.layout.CornerRadii; // Defines the radius of the corners for rounded borders
import javafx.scene.layout.Border; // Represents the overall border object (strokes, widths, etc.)
import javafx.scene.text.Font; // Defines and applies fonts and font size to text

// Imported Java Classes 
import java.util.List; // Represents a collection interface that can hold ordered elements
import java.util.ArrayList; // A resizable array to store dynamic elements
import java.util.Random; // Provides methods to generate random numbers or elements


public class DisplayDifferentShapes extends Application{
	
	// Default Fill Color
	private Color fillColor = Color.WHITE; 
	
	// Variable to identify current Shape, it is also initialized with a default Shape
	Shape currentShape = getRectangleShape(fillColor);
	
	// Adds default Shape to StackPane (viewing pane for shape)
	private StackPane paneWithShape = new StackPane(currentShape);
	
	// List of Random Colors
	private List<Color> listOfRandomColors = new ArrayList<>(List.of(
			Color.AQUA, Color.BLUE, Color.YELLOW,
			Color.CHOCOLATE, Color.DARKRED, Color.GOLD,
			Color.GREEN, Color.GREY, Color.PINK,
			Color.VIOLET));
	
	// Main entry point for the JavaFX application
	@Override
	public void start(Stage primaryStage) {
		// The overall layout of the application
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10));
		
		// BorderStroke and Border objects to set with VBox
		BorderStroke borderStroke = new BorderStroke(
				Color.BLACK,
				BorderStrokeStyle.SOLID,
				new CornerRadii(5),
				new BorderWidths(2)
		);
		Border border = new Border(borderStroke);
		
		// The radio buttons' layout
		VBox radioBtnContainer = new VBox(10);
		radioBtnContainer.setPadding(new Insets(10));
		radioBtnContainer.setAlignment(Pos.CENTER_LEFT);
		radioBtnContainer.setMaxHeight(100);
		BorderPane.setAlignment(radioBtnContainer, Pos.CENTER);
		radioBtnContainer.setBorder(border);
		
		// The check box layout
		VBox checkBoxContainer = new VBox(10);
		checkBoxContainer.setPadding(new Insets(10));
		checkBoxContainer.setAlignment(Pos.CENTER_LEFT);
		checkBoxContainer.setMaxHeight(50);
		BorderPane.setAlignment(checkBoxContainer, Pos.CENTER);
		checkBoxContainer.setBorder(border);
		
		// Title Label layout
		HBox programTitleHBox = new HBox();
		programTitleHBox.setPadding(new Insets(10));
		programTitleHBox.setAlignment(Pos.BASELINE_CENTER);
		
		// Radio Button SubTitle layout
		HBox rbTitle = new HBox();
		rbTitle.setPadding(new Insets(1));
		rbTitle.setAlignment(Pos.BASELINE_CENTER);
		
		// Check Box SubTitle layout
		HBox cbTitle = new HBox();
		cbTitle.setPadding(new Insets(1));
		cbTitle.setAlignment(Pos.BASELINE_CENTER);
		
		// Title Label
		Label titleLable = new Label("Shape & Color Manipulation GUI");
		titleLable.setFont(new Font(20));
		
		// Add program title lable to HBox
		programTitleHBox.getChildren().add(titleLable);
		
		// Radio Button SubTitle Label
		Label rbSubTitleLable = new Label("Choose a Shape");
		rbSubTitleLable.setFont(new Font(15));
				
		// Add radio button subtitle lable to HBox
		rbTitle.getChildren().add(rbSubTitleLable);
		
		// Check box SubTitle Label
		Label cbSubTitleLable = new Label("Choose to Fill");
		cbSubTitleLable.setFont(new Font(15));
				
		// Add check box subtitle lable to HBox
		cbTitle.getChildren().add(cbSubTitleLable);
		
		// Radio Buttons
		RadioButton rectangleButton = new RadioButton("Rectangle"); 
		rectangleButton.setSelected(true); // Default selection
		RadioButton circleButton = new RadioButton("Circle");
		RadioButton ellipseButton = new RadioButton("Ellipse");
		
		// Groups radio buttons
		ToggleGroup toggleGroup = new ToggleGroup();
		rectangleButton.setToggleGroup(toggleGroup);
		circleButton.setToggleGroup(toggleGroup);
		ellipseButton.setToggleGroup(toggleGroup);
		
		// Adds subTitle and radio buttons to VBox
		radioBtnContainer.getChildren().addAll(rbTitle, rectangleButton, circleButton, ellipseButton);
		
		// Handles radioButtons' Action Events
		rectangleButton.setOnAction(e -> {
			if (rectangleButton.isSelected()) {
				paneWithShape.getChildren().clear();
				currentShape = getRectangleShape(fillColor);
				paneWithShape.getChildren().add(currentShape);
			}
		});
		circleButton.setOnAction(e -> {
			if (circleButton.isSelected()) {
				paneWithShape.getChildren().clear();
				currentShape = getCircleShape(fillColor);
				paneWithShape.getChildren().add(currentShape);
			}
		});
		ellipseButton.setOnAction(e -> {
			if (ellipseButton.isSelected()) {
				paneWithShape.getChildren().clear();
				currentShape = getEllipseShape(fillColor);
				paneWithShape.getChildren().add(currentShape);
			}
		});
		
		// Check Box 
		CheckBox checkBox = new CheckBox("Random Color");
		
		// Adds subtitle and check box to VBox
		checkBoxContainer.getChildren().addAll(cbTitle, checkBox);
		
		// Handles check box's action events
		checkBox.setOnAction(e -> {
			if (checkBox.isSelected()) {
				fillColor = getRandomFillColor();
				currentShape.setFill(fillColor);
			} else {
				fillColor = Color.WHITE;
				currentShape.setFill(fillColor);
			}
		});
		
		// adds all elements to main layout
		borderPane.setCenter(paneWithShape);
		borderPane.setRight(radioBtnContainer);
		borderPane.setLeft(checkBoxContainer);
		borderPane.setTop(programTitleHBox);
		
		// Creation of scene, adding of scene to stage, setting stage title, and showing stage
		Scene scene = new Scene(borderPane, 700, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Intermediate Java: Module 11 Assignment");
		primaryStage.show();
	}
	
	// Method to create Rectangle shape
	public Rectangle getRectangleShape(Color fillColor) {
		Rectangle rectangle = new Rectangle(100, 150);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(fillColor);
		
		return rectangle;
	}
	
	// Method to create Circle shape
	public Circle getCircleShape(Color fillColor) {
		Circle circle = new Circle(75);
		circle.setStroke(Color.BLACK);
		circle.setFill(fillColor);
		
		return circle;
	}
	
	// Method to create Ellipse Shape
	public Ellipse getEllipseShape(Color fillColor) {
		Ellipse ellipse = new Ellipse(50,75);
		ellipse.setStroke(Color.BLACK);
		ellipse.setFill(fillColor);
		
		return ellipse;
	}
	
	// Method to get random fill color 
	private Color getRandomFillColor() {
		int randomInt = new Random().nextInt(10);
		Color randomColor = listOfRandomColors.get(randomInt);
		
		return randomColor;
	}
	
	// Not required, but included to ensure the program runs correctly in different setups
	public static void main(String[] args) {
		launch(args); // Launches the JavaFX application (calls the start() method)
	}

}
