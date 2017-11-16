/**
 * Tests classes Contact and ContactList by creating and adding two contacts
 * to a contactList.
 */

package test;

public class TestUseCase1 {
	public static void main(String[] args) { 
		ContactList contactList1;
		contactList1 = new ContactList();

		Contact contact1;
		contact1 = new Contact();
		contact1.userInputContact();

		contactList1.addContactToList(contact1);

		System.out.println(contactList1);
		
		Contact contact2;
		contact2 = new Contact();
		contact2.userInputContact();

		contactList1.addContactToList(contact2);

		System.out.println(contactList1);
		
		contactList1.sortContactList();
		
		System.out.println(contactList1.returnContactByLastName("Wong"));
	}
}

/* ------------------------- run ---------------------------
Contact's first name: John
Contact's last name (required): Schmidt
Contact's phone number: 6501234567
Contact's email address: johnschmidt@rainbowroad.edu
Contact's street address: 1234 Rainbow Road, Foothill, CA 12345
Contact's notes: Middle name is Jacobjingleheimer

Name: John Schmidt
Street Address: 1234 Rainbow Road, Foothill, CA 12345
Email Address: johnschmidt@rainbowroad.edu
Phone Number: 6501234567
Notes: Middle name is Jacobjingleheimer


Contact's first name: Megan
Contact's last name (required): Wong
Contact's phone number: 6505678910
Contact's email address: meganwong@sunnyvale.edu
Contact's street address: 5678 Black Street, Sunnyvale, CA 56789
Contact's notes: Has a cat named Snicklefritz

Name: John Schmidt
Street Address: 1234 Rainbow Road, Foothill, CA 12345
Email Address: johnschmidt@rainbowroad.edu
Phone Number: 6501234567
Notes: Middle name is Jacobjingleheimer

Name: Megan Wong
Street Address: 5678 Black Street, Sunnyvale, CA 56789
Email Address: meganwong@sunnyvale.edu
Phone Number: 6505678910
Notes: Has a cat named Snicklefritz

--------------------------------------------------------------- */
