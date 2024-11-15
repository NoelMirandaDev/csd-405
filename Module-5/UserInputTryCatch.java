/* Developer: Noel Miranda
 * Date of creation: November 14, 2024
 * Program objective: Write a program that uses an ArrayList filled with a minimum of 10 Strings. 
 * Use a ‘for-each’ loop to print the ArrayList collection. Then ask a user which element they would 
 * like to see again. Then, attempt printing the element in a try/catch format which will result in 
 * the element being displayed. If the element value received is invalid, display a message that an 
 * Exception has been thrown displaying “Out of Bounds”. In this program, include the use of 
 * Auto-boxing/Auto-Unboxing, working with a user String input.
*/

// Declared package
package edu.intermediatejava.module5;

// import required classes for this program
import java.util.ArrayList;
import java.util.Scanner;

// Program 1
public class UserInputTryCatch {

	public static void main(String[] args) {
		// Create ArrayList to hold 10 String elements
		ArrayList<String> stringList = new ArrayList<>();
		
		// Add 10 string number elements
		stringList.add("0");
		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		stringList.add("4");
		stringList.add("5");
		stringList.add("6");
		stringList.add("7");
		stringList.add("8");
		stringList.add("9");
		
		// Display Arraylist collection to user
		System.out.println("Welcome user, I will be displaying a collection of String numbers for you to view.\n");
		System.out.print("Collection: ");
		for (String element : stringList) {
			System.out.print(element + " ");
		}
		
		// Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt user for an element to repeat
		System.out.println("\n\nNow that you have seen the collection, what element would you like to see again?\n" +
				"Please type the element you would like to view again followed by pressing the enter key.\n");
		
		// Assign user input to a String variable
		String userRequest = input.next();
		
		try {	
			// (Auto-boxing requirement); turns String userRequest value to int, then Auto-boxing from int to Integer
			Integer index = Integer.parseInt(userRequest);
			String requestedElement = getUserRequest(index, stringList);
			System.out.println("\nYour requested element: " + requestedElement);
		} catch (NumberFormatException ex) { // during Integer.parseInt
			System.out.println("\nException thrown: Invalid element.");
		} catch (IndexOutOfBoundsException ex) { // during retrieval of element from ArrayList
			System.out.println("\nException thrown: Out of Bounds.");
		} catch (Exception ex) { // Anything else
			System.out.println("Error.");
		} finally {
			input.close();
		}
	}
		// Method for retrieving element from ArrayList (auto-unboxing requirement)
		public static String getUserRequest(Integer index, ArrayList<String> stringList) {
			return stringList.get(index); // auto-unboxing Integer index into int for index 
	}
}
