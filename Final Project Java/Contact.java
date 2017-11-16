/**
 * One object of class Contact represents the first name, last name, street address, 
 * email address, phone number, and notes of a Contact.
 */
/*
 * Code written by Xiaoyu Z.
 */

package test;
import java.io.*;
import java.util.Scanner;

public class Contact implements Serializable, Comparable <Contact> {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String streetAddress;
	private String notes;
	
	/**
	 * Sets firstName to newFirstName
	 */
	public void setFirstName(String newFirstName) 
	{
		firstName = newFirstName;
	}
	
	/**
	 * Sets lastName to newLastName
	 */
	public void setLastName(String newLastName) 
	{
		lastName = newLastName;
	}
	
	/**
	 * Sets phoneNumber to newPhoneNumber
	 */
	public void setPhoneNumber(String newPhoneNumber) 
	{
		phoneNumber = newPhoneNumber;
	}
	
	/**
	 * Sets emailAddress to newEmailAddress
	 */
	public void setEmailAddress(String newEmailAddress) 
	{
		emailAddress = newEmailAddress;
	}
	
	/**
	 * Sets streetAddress to newAddress
	 */
	public void setStreetAddress(String newAddress) 
	{
		streetAddress = newAddress;
	}
	
	/**
	 * Sets notes to newNotes
	 */
	public void setNotes(String newNotes) 
	{
		notes = newNotes;
	}
	
	/**
	 * Returns the value of firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}
	
	/**
	 * Returns the value of lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}
	
	/**
	 * Returns the value of phoneNumber
	 */
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	/**
	 * Returns the value of emailAddress
	 */
	public String getEmailAddress() 
	{
		return emailAddress;
	}

    /**
	 * Returns the value of streetAddress
	 */
	public String getStreetAddress() 
	{
		return streetAddress;
	}
	
	/**
	 * Returns the value of notes
	 */
	public String getNotes() 
	{
		return notes;
	}
	
	/**
	 * Sets Contact member variables to user input
	 */
	public void userInputContact()
	{
		Scanner console;
		console = new Scanner (System.in);
		
		System.out.print("Contact's first name: ");
		setFirstName(console.nextLine().trim());
		
		System.out.print("Contact's last name (required): ");
		setLastName(console.nextLine().trim());
		
		if (lastName.isEmpty())
		{
			System.out.println("Contact not stored in contact list because no last name has been entered.\n");
			return;
		}
		
		System.out.print("Contact's phone number: ");
		setPhoneNumber(console.nextLine().trim());
		
		System.out.print("Contact's email address: ");
		setEmailAddress(console.nextLine().trim());
		
		System.out.print("Contact's street address: ");
		setStreetAddress(console.nextLine().trim());
		
		System.out.print("Contact's notes: ");
		setNotes(console.nextLine().trim());	
		
		System.out.println("Contact has been stored in contact list.");
		System.out.println();
	}
	
	/**
	 * Returns a string consisting of all Contact information
	 */
	public String toString()
	{
		return "Name: " + getFirstName() + " " + getLastName() + "\n"
		+ "Street Address: " + getStreetAddress() + "\n" + 
		"Email Address: " + getEmailAddress() + "\n" + 
		"Phone Number: " + getPhoneNumber() + "\n" + 
		"Notes: " + getNotes();
	}
	
	/**
	 * Returns an int based on whether calling object and parameter's last names are 
	 * equal or not. If last names are equal then tests first names
	 */
	public int compareTo(Contact other) 
	{
		if (this.getLastName().equals(other.getLastName()))
		{
			if (this.getFirstName().equals(other.getFirstName()))
				return 0;
			
			else if (this.getFirstName().compareTo(other.getFirstName()) < 0)
				return -1;
			
			else 
				return 1;
		}
		
		else if (this.getLastName().compareTo(other.getLastName()) < 1)
			return -1;
		
		else
			return 1;
	}
}
