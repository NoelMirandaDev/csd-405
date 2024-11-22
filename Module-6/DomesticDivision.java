/* Developer: Noel Miranda
 * Date of creation: November 15, 2024
 * Program objective: Create a subclass for the abstract class Division. The DomesticDivision 
 * class includes a field for the state in which the division is located and a constructor that 
 * requires all fields when created.
*/

// Declared package
package edu.intermediatejava.module6;

//Subclass 2 of abstract Division class 
public class DomesticDivision extends Division {
	// Subclass specific fields
	private String companyStateLocation;
	
	// Constructor with all fields
	public DomesticDivision(String divisionName, int accountNumber, String companyStateLocation) {
		super(divisionName, accountNumber);
		this.companyStateLocation = companyStateLocation;
	}
	
	public String getCompanyStateLocation() {
		return companyStateLocation;
	}
	
	// Inherited abstract method required, if not it makes this class an abstract
		@Override
		public void display() {
			System.out.println("Company name: " + getDivisionName());
			System.out.println("Account number: " + getAccountNumber());
			System.out.println("State location: " + companyStateLocation);
		}
}
