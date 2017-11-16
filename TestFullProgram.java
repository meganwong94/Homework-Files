/**
 * Tests all 5 use cases of QualitySoft Project.
 */
/*
 * Code written by Megan W.
 */

package test;
import java.io.*;
import java.util.Scanner;

public class TestFullProgram {
	public static void main(String[] args) {
		printMenu(ReadContacts());
	}
	
	/**
	 * Prints the user menu and, based on input from the user,
	 * calls appropriate methods from class Contact and ContactList
	 */
	public static void printMenu(ContactList contactListToUse)
	{
		String userInput = "";
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		while (userInput != "Q")
		{
			System.out.println("Would you like to: ");
			System.out.println("E ---- Enter a new person into the contact list?");
		    System.out.println("P ---- Print the contact list?");
		    System.out.println("R ---- Retrieve a contact from the list by last name?");
			System.out.println("Q ---- Quit the program and save to disk?");
			userInput = scanner.nextLine();
			
			switch (userInput.charAt(0)) {
			    case 'E': {
			    	caseE(contactListToUse);
					break;
			    }
			    case 'P': {
			    	System.out.println(contactListToUse);
			    	break;
			    }
			    case 'R': {
			    	caseR(contactListToUse);
			    	break;
			    }
			    case 'Q': {
			    	StoreContacts(contactListToUse);
					System.exit(0);
			    }
			    default: {
			    	System.out.println("Please enter a valid option.\n");
			    	break;
			    }
			}
		}
	}
	
	/**
	 * Enters a new Contact into a ContactList
	 */
	public static void caseE(ContactList addList)
	{
		Contact contact1;
		contact1 = new Contact();
		
		contact1.userInputContact();
		addList.addContactToList(contact1);	
	}
	
	/**
	 * Retrieves a Contact by last name
	 */
	public static void caseR(ContactList retrieveContact)
	{
		String findLastName;

		Scanner scanner;
		scanner = new Scanner(System.in);
		
		System.out.print("Please enter the last name of the contact you would like to access: ");
    	findLastName = scanner.nextLine();
    	System.out.println(retrieveContact.returnContactByLastName(findLastName));
	}
	
	/**
	 * Takes a ContactList as a parameter and saves this
	 * ContactList to disk
	 */
	public static void StoreContacts(ContactList contactListToStore) 
    {
	    FileOutputStream outFile;
	    ObjectOutputStream outObject;
	
	    try 
	    {
		    outFile = new FileOutputStream("saveThisContactList");
		    outObject = new ObjectOutputStream(outFile);
		
		    outObject.writeObject(contactListToStore);
		
		    outFile.close();
		    outObject.close();	
		    System.out.println("Contact list saved to disk.");
	    }
	
	    catch(IOException ioe)
	    {
		    System.out.println("Error saving contactList to the file: " + ioe.getMessage());
	    }
	    
	    contactListToStore = null;
    }
	
	/**
	 * Returns the saved ContactList 
	 */
	public static ContactList ReadContacts()
	{
		FileInputStream inFile;
		ObjectInputStream inObject;
		
		ContactList savedList;
		savedList = new ContactList();
		
		try 
		{
			inFile = new FileInputStream("saveThisContactList");
			inObject = new ObjectInputStream(inFile);
			
			savedList = (ContactList)inObject.readObject();
			
			inFile.close();
			inObject.close();
			
			System.out.println(savedList.contactListSize() + " contact(s) saved in contact list.");
		}
		
		catch(IOException ioe)
		{
			System.out.println("No contacts in contact list.");
		}
		
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error in casting to ContactList: " + cnfe);
		}
		
		return savedList;
	}
}

/* ------------------------- run #1 --------------------------
No contacts in contact list.
Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
Z
Please enter a valid option.

Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
E
Contact's first name: John
Contact's last name (required): Schmidt
Contact's phone number: 6501234567
Contact's email address: johnsmith@rainbowroad.edu
Contact's street address: 1234 Rainbow Road, Foothill, CA, 12345
Contact's notes: Middle name is Jacobjingleheimer
Contact has been stored in contact list.

Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
P
Name: John Schmidt
Street Address: 1234 Rainbow Road, Foothill, CA, 12345
Email Address: johnsmith@rainbowroad.edu
Phone Number: 6501234567
Notes: Middle name is Jacobjingleheimer


Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
R
Please enter the last name of the contact you would like to access: Scott
Contact not found.

Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
R
Please enter the last name of the contact you would like to access: Schmidt
Name: John Schmidt
Street Address: 1234 Rainbow Road, Foothill, CA, 12345
Email Address: johnsmith@rainbowroad.edu
Phone Number: 6501234567
Notes: Middle name is Jacobjingleheimer


Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
Q
Contact list saved to disk.
-------------------------------------------------------------------------- */
/* ---------------------------- run #2 ------------------------------------
1 contact(s) saved in contact list.
Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
E
Contact's first name: Megan
Contact's last name (required): Wong
Contact's phone number: 6505678910
Contact's email address: meganwong@sunnyvale.edu
Contact's street address: 5678 Black Street, Sunnyvale, CA 56789
Contact's notes: Has a cat named Snicklefritz
Contact has been stored in contact list.

Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
P
Name: John Schmidt
Street Address: 1234 Rainbow Road, Foothill, CA, 12345
Email Address: johnsmith@rainbowroad.edu
Phone Number: 6501234567
Notes: Middle name is Jacobjingleheimer

Name: Megan Wong
Street Address: 5678 Black Street, Sunnyvale, CA 56789
Email Address: meganwong@sunnyvale.edu
Phone Number: 6505678910
Notes: Has a cat named Snicklefritz


Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
Q
Contact list saved to disk.
------------------------------------------------------------------------- */
/* -------------------------- run #3 --------------------------------------
2 contact(s) saved in contact list.
Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
E
Contact's first name: Claire
Contact's last name (required): Zhang
Contact's phone number: 6509876543
Contact's email address: clairezhang@sunnyvale.edu
Contact's street address: 9876 Hufflepuff Lane, Milpitas, CA, 98765
Contact's notes: Favorite color is pink.
Contact has been stored in contact list.

Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
P
Name: John Schmidt
Street Address: 1234 Rainbow Road, Foothill, CA, 12345
Email Address: johnsmith@rainbowroad.edu
Phone Number: 6501234567
Notes: Middle name is Jacobjingleheimer

Name: Megan Wong
Street Address: 5678 Black Street, Sunnyvale, CA 56789
Email Address: meganwong@sunnyvale.edu
Phone Number: 6505678910
Notes: Has a cat named Snicklefritz

Name: Claire Zhang
Street Address: 9876 Hufflepuff Lane, Milpitas, CA, 98765
Email Address: clairezhang@sunnyvale.edu
Phone Number: 6509876543
Notes: Favorite color is pink.


Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
Q
Contact list saved to disk.
------------------------------------------------------------------------- */
/* ----------------------------- run #4 -----------------------------------
3 contact(s) saved in contact list.
Would you like to: 
E ---- Enter a new person into the contact list?
P ---- Print the contact list?
R ---- Retrieve a contact from the list by last name?
Q ---- Quit the program and save to disk?
Q
Contact list saved to disk.
------------------------------------------------------------------------- */


