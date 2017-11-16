/**
 * Tests class ContactList by creating a ContactList object.
 */

package test;
public class TestContactList {
	public static void main(String[] args) { 
		Contact contact1;
		contact1 = new Contact();
		contact1.userInputContact();
		Contact contact2;
		contact2 = new Contact();
		contact2.userInputContact();
		ContactList contactList1;
		contactList1 = new ContactList();
		
		contactList1.addContactToList(contact1);
		contactList1.addContactToList(contact2);
		System.out.println(contactList1);
		System.out.println("Reached end of main()");
	}
}

/* ------ run ---------


Reached end of main()
--------------------- */
