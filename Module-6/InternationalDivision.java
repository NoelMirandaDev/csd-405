/* Developer: Noel Miranda
 * Date of creation: November 15, 2024
 * Program objective: Create a subclass for the abstract class Division. The InternationalDivision 
 * class includes a field for the country in which the division is located, a field for the language spoken, 
 * and a constructor that requires all fields when created.
*/

// Declared package
package edu.intermediatejava.module6;

// Subclass 1 of abstract Division class 
public class InternationalDivision extends Division {
	// Subclass specific fields
	private String companyCountryLocation;
	private String languageSpoken;
	
	// Constructor with all fields
	public InternationalDivision(String divisionName, int accountNumber, String companyCountryLocation, String languageSpoken) {
		super(divisionName, accountNumber);
		this.companyCountryLocation = companyCountryLocation;
		this.languageSpoken = languageSpoken;
	}
	
	public String getCompanyCountryLocation() {
		return companyCountryLocation;
	}
	
	public String getLanguageSpoken() {
		return languageSpoken;
	}
	
	// Inherited abstract method required, if not it makes this class an abstract
	@Override
	public void display() {
		System.out.println("Company name: " + getDivisionName());
		System.out.println("Account number: " + getAccountNumber());
		System.out.println("Country location: " + companyCountryLocation);
		System.out.println("Language spoken: " + languageSpoken);
	}
}
