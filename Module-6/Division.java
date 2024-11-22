/* Developer: Noel Miranda
 * Date of creation: November 15, 2024
 * Program objective: Create an abstract Division class with fields for a company's division 
 * name and account number, and an abstract display() method that will be defined in the subclasses.
*/

// Declared Package
package edu.intermediatejava.module6;

// Abstract Division Class (Superclass)
public abstract class Division {
	// Fields for a company's division name and account number
	private String divisionName;
	private int accountNumber;
	
	// Constructor to initialize company's fields
	public Division(String divisionName, int accountNumber) {
		this.divisionName = divisionName;
		this.accountNumber = accountNumber;
	}
	
	public String getDivisionName() {
		return divisionName;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public abstract void display(); 
}
