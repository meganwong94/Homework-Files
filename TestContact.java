/**
 * Tests class Contact by creating a Contact object. 
 */

package test;
public class TestContact {
	public static void main(String[] args) {
		Contact contact1;
		contact1 = new Contact();
		
//		contact1.setFirstName("John");
//		contact1.setLastName("Schmidt");
//		contact1.setEmailAddress("johnschmidt@rainbowroad.edu");
//		contact1.setPhoneNumber("6501234567");
//		contact1.setStreetAddress("1234 Rainbow Road, Foothill, CA, 12345");
//		contact1.setNotes("Middle name is Jacobjingleheimer");
		contact1.userInputContact();
		
		System.out.println(contact1);
		System.out.println("Reached the end of main()");
	}
}

/* -------- run --------
null
null
null
null
null
null

Reached the end of main()
---------------------- */
