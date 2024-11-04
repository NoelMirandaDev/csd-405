/* Developer: Noel Miranda
 * Date of creation: November 2, 2024
 * Program objective: To create a class specifically for integer values. This class has
 * specified methods and fields from the requirements of the assignment. Also, it includes
 * test code to ensure everything is functioning accordingly.
*/

// Declared package
package edu.intermediatejava.module3;

public class NoelInteger {
	// Data field
	private int noel;
	
	// No argument constructor
	public  NoelInteger() {
		this(25); // Default value
	}
	
	// Constructor with one parameter for setting initial value
	public NoelInteger(int noel) {
		this.noel = noel;
	}
	
	// Getter method
	public int getInt() {
		return noel;
	}
	
	// Setter method
	public void setInt(int noel) {
		this.noel = noel;
	}
	
	// Required specified non-static methods
	public boolean isEven() {
		return (noel % 2 == 0);
	}
	
	public boolean isOdd() {
		return (noel % 2 != 0);
	}
	
	public boolean isPrime() {
		// Any numbers below 2 are not considered prime
		if (noel < 2) {
			return false;
		}
		// Checks for divisors from 2 up to the square root of the noel variable
		for (int i = 2; i <= Math.sqrt(noel); i++) {
			if (noel % i == 0) {
			return false;
			}
		}
		// If no divisors were found, the value of noel	is prime
		return true;
	}
	
	// Required specified equals methods
	public boolean equals(int noel) {
		return this.noel == noel;
	}
		
	public boolean equals(Integer noel) {
		return noel != null && this.noel == noel;
	}
	
	//Required specified static methods
	static boolean isEven(int noel) {
		return (noel % 2 == 0);
	}
	
	static boolean isOdd(int noel) {
		return (noel % 2 != 0);
	}
	
	static boolean isPrime(int noel) {
		// Any numbers below 2 are not considered prime
		if (noel < 2) {
			return false;
		}
		// Checks for divisors from 2 up to the square root of the noel variable
		for (int i = 2; i <= Math.sqrt(noel); i++) {
			if (noel % i == 0) {
			return false;
			}
		}
		// If no divisors were found, the value of noel	is prime
		return true;
	}
	
	// Main method for test code
	public static void main(String[] args) {
		// Program intro
		System.out.println("		******** Test Code for NoelInteger Class ********");
		System.out.println("------------------------------------------------------------------------------------------\n");
		
		// Test code for three instances, two with the same value, and one with a different value
		System.out.println("Creating three instances of the NoelInteger class...");
		NoelInteger obj1 = new NoelInteger(); // Default value of 25
		NoelInteger obj2 = new NoelInteger(39); // Specified value of 39
		NoelInteger obj3 = new NoelInteger(39); // Specified value of 39
		System.out.println("-First instance named obj1 with a value of " + obj1.getInt());
		System.out.println("-Second instance named obj2 with a value of " + obj2.getInt());
		System.out.println("-Third instance named obj3 with a value of " + obj3.getInt());
		
		// Test code for getter and setter method
		System.out.println("\n\nTesting NoelInteger class getter method for obj3...");
		System.out.println("-Getter method for obj3 returns an integer value of " + obj3.getInt());
		System.out.println("\n\nTesting NoelInteger class setter method with a value of 25 for obj3...");
		obj3.setInt(25);
		System.out.println("-obj3 data field value after executing setter method: " + obj3.getInt());
		
		// Test code for non-static methods
		System.out.println("\n\nTesting NoelInteger class non-static methods for obj3 with a value of 25...");
		System.out.println("-After executing the isEven() method for object3, the result is: " + obj3.isEven());
		System.out.println("-After executing the isOdd() method for object3, the result is: " + obj3.isOdd());
		System.out.println("-After executing the isPrime() method for object3, the result is: " + obj3.isPrime());
		System.out.println("-After executing the equals(30) method for object3, the result is: " + obj3.equals(30));
		System.out.println("-After executing the equals(25) method for object3, the result is: " + obj3.equals(25));
		System.out.println("-After executing the equals(Integer.valueOf(2) method for object3, the result is: " + obj3.equals(Integer.valueOf(2)));
		System.out.println("-After executing the equals(Integer.valueOf(25) method for object3, the result is: " + obj3.equals(Integer.valueOf(25)));
		
		// Test code for static methods 
		System.out.println("\n\nTesting NoelInteger class static methods with varying paramter values...");
		System.out.println("-After executing the NoelInteger.isEven(4) method, the result is: " + NoelInteger.isEven(4));
		System.out.println("-After executing the NoelInteger.isEven(5) method, the result is: " + NoelInteger.isEven(5));
		System.out.println("-After executing the NoelInteger.isOdd(6) method, the result is: " + NoelInteger.isOdd(6));
		System.out.println("-After executing the NoelInteger.isOdd(7) method, the result is: " + NoelInteger.isOdd(7));
		System.out.println("-After executing the NoelInteger.isPrime(1) method, the result is: " + NoelInteger.isPrime(1));
		System.out.println("-After executing the NoelInteger.isPrime(3) method, the result is: " + NoelInteger.isPrime(3));
		System.out.println("\n------------------------------------------------------------------------------------------\n");
	}
}
