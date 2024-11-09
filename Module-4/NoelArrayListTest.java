/* Developer: Noel Miranda
 * Date of creation: November 8, 2024
 * Program objective: To create a class that holds:
 * 1) a method that receives an ArrayList populated with an Integer data type holding the integers 
 * received from user input. 
 * 2) The user input is to accept Integers that are then assigned to the ArrayList until a value 
 * of 0 is entered, which is also assigned to the ArrayList. 
 * 3) The ArrayList is then to be sent to the method. 
 * 4) The method is then to return the largest value in the ArrayList. 
 * 5) If the ArrayList is sent in empty, the method will then return 0. 
 * 6) The method signature is to be: public static Integer max (ArrayList list). 
 * 7) Write additional code for testing your method. 
 * 8) The method will return the largest value that is displayed to the user.
*/

// Declared package
package edu.intermediatejava.module4;

// imported classes
import java.util.ArrayList;
import java.util.Scanner;

public class NoelArrayListTest {
	// Specified max method
	public static Integer max(ArrayList<Integer> list) {
		// Check whether ArrayList is empty
		if (list.isEmpty()) {
			return 0;
		} else {
			int maxValue = (int) list.get(0);
			
			// Iteration to find largest value
			for (int i = 1; i < list.size(); i++) {
				if (maxValue < (int)list.get(i)) {
					maxValue = (int)list.get(i);
				}
			}
			return maxValue; //Return max integer in ArrayList
		}
	}
	
	// Main method 
	public static void main(String[] args) {
		// ArrayList creation for holding Integers from user input
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		Scanner input = new Scanner(System.in); 
		
		System.out.println("* You will be creating a list of integers. \n" +
				"* Please type in as many integers as you desire. \n" +
				"* Press enter after each integer OR seperate each integer with spaces.\n" +
				"* After you are done, input the integer zero and click enter. \n" + 
				"----------------------------------------------------------------------------------------\n" +
				"List your integers: ");
		
		// Variable for holding integers from input
		int userInput;
		
		// do-while statement to add input integers into ArrayList until the integer 0 is inputed
		do {
			userInput = input.nextInt();
			arrayList.add(userInput);
		} while (userInput != 0);
		
		// close Scanner
		input.close();
		
		System.out.println("\nThe highest value of the inputed integers is: " + max(arrayList) +
				"\n----------------------------------------------------------------------------------------\n"); 	
		
		System.out.println("	******************** ADDITIONAL TEST CODE ********************\n");
		
		// Additional test code method for max method utilizing try-catch block 
		try {
			// Test 1
			ArrayList<Integer> test1 = new ArrayList<>();
			test1.add(45);
			test1.add(50);
			test1.add(1000000);
			test1.add(1);
			test1.add(5);
			test1.add(9);
			System.out.println("ArrayList TEST1: " + test1);
			System.out.println("Max value in TEST1: " + max(test1));
			
			// Test 2
			ArrayList<Integer> test2 = new ArrayList<>();
			test2.add(-4);
			test2.add(-7);
			test2.add(-1);
			test2.add(-10);
			test2.add(-1000);
			test2.add(-50);
			System.out.println("\nArrayList TEST2: " + test2);
			System.out.println("Max value in TEST2: " + max(test2));
			
			// Test 3
			ArrayList<Integer> test3 = new ArrayList<>();
			System.out.println("\nArrayList TEST3: " + test3);
			System.out.println("Max value in TEST3: " + max(test3));
			
			// Test 4
			ArrayList<Integer> test4 = new ArrayList<>();
			test4.add(4);
			test4.add(7);
			test4.add(10);
			test4.add(11);
			test4.add(14);
			test4.add(0);
			System.out.println("\nArrayList TEST4: " + test4);
			System.out.println("Max value in TEST4: " + max(test4));
				
		} catch (Exception e) {
			System.out.println("Test Failed! " + e.getMessage());
		}
		
		System.out.println("\nTEST PASSED!\n----------------------------------------------------------------------------------------");
	}
}