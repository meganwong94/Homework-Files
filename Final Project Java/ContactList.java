/**
 * One object of class ContactList represents an ArrayList of Contacts.
 */
/*
 * Code written by Megan W.
 */

package test;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

public class ContactList implements Serializable {
	private ArrayList<Contact> contactList;
	
	/**
	 * Constructs a ContactList object
	 */
	public ContactList()
	{
		contactList = new ArrayList<Contact>();
	}
	
	/**
	 * Returns size of contactList
	 */
	public int contactListSize()
	{
		return contactList.size();
	}

	/**
	 * Adds a Contact to the contactList
	 */
	public void addContactToList(Contact newContact) 
	{
		if (newContact.getLastName().isEmpty())
			return;
		contactList.add(newContact);
	}
	
	/**
	 * Sorts contactList
	 */
	public void sortContactList()
	{
		Collections.sort(contactList);
	}
	
	/**
	 * Prints the contactList
	 */
	public String toString()
	{
		int arrayLength;
		String retString = "";
		this.sortContactList();
		
		for (arrayLength = 0; arrayLength < contactList.size(); arrayLength++)
		{
			retString += contactList.get(arrayLength).toString() + "\n" + "\n";
			
		}
		
		return retString;
	}
	
	/**
	 * Retrieves a Contact's information by lastName
	 */
	public ContactList returnContactByLastName(String lastName)
	{
		ContactList contactList1;
		contactList1 = new ContactList();
		int i;
		Boolean foundContact = false;
		
		for (i = 0; i < contactList.size(); i++)
		{
			if (lastName.equals(contactList.get(i).getLastName()))
			{
				contactList1.addContactToList(contactList.get(i));
				foundContact = true;
			}	
		}
		
		if (foundContact == false)
			System.out.println("Contact not found.");
		
		return contactList1;
	} 
}
