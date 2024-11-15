/* Developer: Noel Miranda
 * Date of creation: November 14, 2024
 * Program objective: Write a program to create a new file titled data.file, if the file does not exist. 
 * Then write to the new file, adding 10 randomly generated numbers, or append 10 randomly generated 
 * numbers to a previous file. Each integer is to be separated by a space. Close the file, then reopen 
 * the file and read the data from the file and display it.
*/

// Declared Package
package edu.intermediatejava.module5;

// Imported Required Classes
import java.io.PrintWriter; // Writes formatted text to file
import java.io.FileWriter; // Needed for append mode
import java.io.File; // Object for file
import java.util.Random; // Generates random numbers
import java.util.Scanner; // In this text, reads from file

public class WriteReadFile {

	public static void main(String[] args) throws Exception {
		
		// Instances of required classes
		Random random = new Random();
		String fileName = "data.file";
		File file = new File(fileName);
		
		// Write or append to file
		try {
			/* Open the file in append mode, if existing file then it won't overwrite the existing file, it just appends. 
			If it does't exist then it creates a file and adds the random numbers */
			try (PrintWriter output = new PrintWriter(new FileWriter(file, true))) {
				for (int i = 0; i < 10; i++) {
					int randomNumber = random.nextInt(100);
					output.print(randomNumber + " ");
				}
			output.println(); // Added for readability in the file
			}
			
		} catch (Exception ex) {
				System.out.println("Exception occured during writing to file.");
				ex.printStackTrace();
			}
		
		// Read from file
		try {
			try (Scanner input = new Scanner(file)) {
				if (!input.hasNextInt()) {
					System.out.println("No integers in file.");
				} else {
					int accumalator = 1;
					while (input.hasNextInt()) {
						if (accumalator % 10 == 0) {
							System.out.println(input.nextInt());
						} else {
							System.out.print(input.nextInt() + " ");
						}
						accumalator++;
					}
					System.out.println();
				  }
			 }
		} catch (Exception ex) {
			System.out.println("Exception occured while reading from file.");
			ex.printStackTrace();
		}
	}
}