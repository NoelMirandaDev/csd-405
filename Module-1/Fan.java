/* Developer: Noel Miranda 
 * Date of Creation: October 25, 2024
 * Program Objective: Create a specified Fan class to do specified behaviors. Include test code for 
 * two instances of the Fan class to demonstrate functionality.
*/

package edu.intermediatejava.module1;

public class Fan {
	// Fan constants for speed level
	public static final int STOPPED = 0;
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	
	// Default values for mutable fields
	private int speed = STOPPED;
	private boolean on = false;
	private int radius = 6;
	private String color = "white";
	
	// No-argument constructor
	public Fan() {
	}
	
	// Constructor taking arguments and setting values
	public Fan(int radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	// Speed attribute setter and getter methods
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int speedLevel) {
		if (speedLevel >= STOPPED && speedLevel <= FAST) {
			this.speed = speedLevel;
		} else {
			System.out.print("Invalid Speed Level.");
		}
	}
	
	// On attribute setter and getter methods
	public boolean getFanStatus() {
		return this.on;
	}
	public void setFanStatus(boolean status) {
			this.on = status;
	}
	
	// Radius attribute setter and getter methods
	public int getRadius() {
		return this.radius;
	}
	public void setRadius(int newRadius) {
		if (newRadius >= 0) {
			this.radius = newRadius;
		} else {
			System.out.print("Invalid Radius Measurement.");
		}
	}
	
	// Color attribute setter and getter methods
	public String getColor() {
		return this.color;
	}
	public void setColor(String newColor) {
		this.color = newColor;
	}
	
	// Customized toString method overriding default object toString 
	@Override
	public String toString() {
		return "speed= " + this.speed + "\n" +
			   "on= " + this.on + "\n" +
			   "radius= " + this.radius + "\n" +
			   "color= " + this.color;  
	}
	
	// Main method to test code by creating two instances and testing methods functionality
	public static void main(String[] args) {
		
		System.out.println("--------------------------------------------------------");
		System.out.println("********* Testing Fan Class for Functionality *********");
		System.out.println("--------------------------------------------------------");
		System.out.println("\n    ********* Two Instances of Fan Class *********\n");
		
		// Fan instance with default constructor
		System.out.println("Name of Fan class object (default constructor): fan1");
		System.out.println("Initial data attributes of fan1 found below:");
		Fan fan1 = new Fan();
		System.out.println(fan1);
		
		// Fan instance with argument constructor 
		System.out.println("\nName of Fan class object (argument constructor): fan2");
		System.out.println("Initial data attributes of fan2 found below:");
		Fan fan2 = new Fan(10, "brown");
		System.out.println(fan2 + "\n");
		
		System.out.println("--------------------------------------------------------");
		System.out.println("\n   **** Testing Fan Class Methods for fan1 Object ****");
		
		// Testing Class methods for functionality through fan1 instance of the Fan class
		System.out.println("\nInitial speed level: " + fan1.getSpeed());
		fan1.setSpeed(FAST);
		System.out.println("After setter method, speed level: " + fan1.getSpeed());
		
		System.out.println("\nInitial fan Status: " + fan1.getFanStatus());
		fan1.setFanStatus(true);
		System.out.println("After setter method, fan Status: " + fan1.getFanStatus());
		
		System.out.println("\nInitial radius length: " + fan1.getRadius() + " feet");
		fan1.setRadius(8);
		System.out.println("After settermethod, radius length: " + fan1.getRadius() + " feet");
		
		System.out.println("\nInitial fan color: " + fan1.getColor());
		fan1.setColor("Red");
		System.out.println("After setter method, fan color: " + fan1.getColor() + "\n");
		System.out.println("--------------------------------------------------------");
		
		System.out.println("\n   **** All of fan1's New Data Attributes  ****\n");
		System.out.println(fan1.toString());
		System.out.println("\n--------------------------------------------------------");	
	}
}