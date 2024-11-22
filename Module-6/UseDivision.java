/* Developer: Noel Miranda
 * Date of creation: November 15, 2024
 * Program objective: Create a test application named UseDivision that creates two instances of each 
 * concrete subclass of the abstract Division class (4 total instances).
*/

// Declared package
package edu.intermediatejava.module6;

public class UseDivision {

	public static void main(String[] args) {
		System.out.println("******************* Test Program *******************");
		System.out.println();
		
		// Two instances of the subclass InternationalDivison
		Division instance1 = new InternationalDivision("McDonald's", 12345, "Mexico", "Spanish");
		Division instance2 = new InternationalDivision("Burger King", 67890, "China", "Mandarin");
		
		// Two instances of the subclass of DomesticDivision
		Division instance3 = new DomesticDivision("Taco Bell", 13579, "Illinois");
		Division instance4 = new DomesticDivision("Wendy's", 24680, "California");
		
		// Test all methods for each instance
		instance1.display();
		System.out.println(instance1.getDivisionName());
		System.out.println(instance1.getAccountNumber());
		System.out.println(((InternationalDivision) instance1).getCompanyCountryLocation());
		System.out.println(((InternationalDivision) instance1).getLanguageSpoken());
		System.out.println();
		
		instance2.display();
		System.out.println(instance2.getDivisionName());
		System.out.println(instance2.getAccountNumber());
		System.out.println(((InternationalDivision) instance2).getCompanyCountryLocation());
		System.out.println(((InternationalDivision) instance2).getLanguageSpoken());
		System.out.println();
		
		instance3.display();
		System.out.println(instance3.getDivisionName());
		System.out.println(instance3.getAccountNumber());
		System.out.println(((DomesticDivision) instance3).getCompanyStateLocation());
		System.out.println();
		
		instance4.display();
		System.out.println(instance4.getDivisionName());
		System.out.println(instance4.getAccountNumber());
		System.out.println(((DomesticDivision) instance4).getCompanyStateLocation());
		System.out.println();
		
		System.out.println("Test Successful!");
	}
}
