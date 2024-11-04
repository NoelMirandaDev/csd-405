/* Developer: Noel Miranda
 * Date of creation: October 31, 2024
 * Program objective: Utilizing a previous created class called Fan to create a collection
 * of instances of such class and iterate through the collection to display the contents
 * within each instance without the use of the toString() method.
*/

// Declared package
package edu.intermediatejava.module2;

// Imported packages/classes
import edu.intermediatejava.module1.Fan;
import java.util.ArrayList;
import java.util.Arrays;

public class UseFans {
	
	// Method for taking a collection (ArrayList) of Fan instances to display its contents
	public static void printCollection(ArrayList<Fan> collection) {
		// Initialize accumulator
		int accumulator = 1;
		
		// iterate through Fan objects' methods
			for (Fan fan:collection) {
				System.out.println("-----------------------------------------------------------\n");
				System.out.println("Content of Fan instance #" + accumulator + " within Fan collection\n");
				System.out.println("Fan status: " + fan.getFanStatus());
				System.out.println("Fan speed level: " + fan.getSpeed());
				System.out.println("Fan radius: " + fan.getRadius());
				System.out.println("Fan color: " + fan.getColor());
				System.out.println("-----------------------------------------------------------\n\n");
				accumulator += 1;
			}
		}
	
	// Method that takes a single instance of a Fan class to display its contents
	public static void printInstance(Fan instance) {
		System.out.println("-----------------------------------------------------------\n");
		System.out.println("Content within this Fan instance:\n");
		System.out.println("Fan status: " + instance.getFanStatus());
		System.out.println("Fan speed level: " + instance.getSpeed());
		System.out.println("Fan radius: " + instance.getRadius());
		System.out.println("Fan color: " + instance.getColor());
		System.out.println("-----------------------------------------------------------\n\n");
	}
	
	// Main method for test code
	public static void main(String[] args) {
			// Instances of the Fan class
			Fan fan1 = new Fan(5, "brown");
			Fan fan2 = new Fan(8, "yellow");
			Fan fan3 = new Fan();
			Fan fan4 = new Fan(12, "black");
			
			// ArrayList collection of Fan instances
			ArrayList<Fan> fanCollection = new ArrayList<>(Arrays.asList(fan1, fan2, fan3, fan4));
			
			System.out.println("	**** Initial Fan instances' values below ****\n");
			
			// Display initial contents of instances with single instance UseFans method
			System.out.print("	   ******** INSTANCE fan1 ********\n");
			printInstance(fan1);
			System.out.print("	   ******** INSTANCE fan2 ********\n");
			printInstance(fan2);
			System.out.print("	   ******** INSTANCE fan3 ********\n");
			printInstance(fan3);
			System.out.print("	   ******** INSTANCE fan4 ********\n");
			printInstance(fan4);
			
			System.out.println("***********************************************************");
			System.out.println("\nUtilizing instances' functionalities. Please wait...\n");
			System.out.println("***********************************************************\n");
			
			// Testing all functionalities of instances
			fan1.setFanStatus(true);
			fan2.setFanStatus(true);
			fan3.setFanStatus(true);
			fan4.setFanStatus(true);
			
			fan1.setSpeed(Fan.FAST);
			fan2.setSpeed(Fan.MEDIUM);
			fan3.setSpeed(Fan.SLOW);
			fan4.setSpeed(Fan.FAST);
			
			fan1.setRadius(20);
			fan2.setRadius(15);
			fan3.setRadius(30);
			fan4.setRadius(4);
			
			fan1.setColor("purple");
			fan2.setColor("green");
			fan3.setColor("gray");
			fan4.setColor("orange");
			
			System.out.println("	**** Fan instances' new values below ****\n");
		
			// Display contents of all instances after testing functionalities with UseFans printCollection method
			printCollection(fanCollection);	
		}
}
