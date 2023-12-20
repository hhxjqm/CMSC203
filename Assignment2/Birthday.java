/*
 * Class: CMSC203 
 * Program: Assignment 2
 *  Instructor: Grigoriy A. Grinberg
 * Description: (You have decided to use a specialized toy company to purchase birthday 
 * 				gifts for the young children of your friends and relatives. The toys you can choose 
 * 				are divided into three categories: plushies, blocks, and books.  You can add a card 
 * 				and/or a balloon with each gift. Your program must print a title and a list of all 
 * 				the gifts to the console, with a total for each gift, and the total amount of the order. 
 * 				Your program must generate a random five-digit number to serve as the order number, 
 * 				followed by your name as programmer.  The Toy class provided, will keep a total cost 
 * 				for one toy and determine if the toy is age-appropriate for the child.  You should 
 * 				not make any changes to the Toy class.  Assume that the user enters the name and age 
 * 				of the child correctly.)
 *
 * Due: MM/DD/YYYY (7/5/2020)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Huan Shiuan Huang
*/

import javax.swing.JOptionPane;
import java.util.Random;

public class Birthday {
	public static void main(String[] args) {
		String name = null, toyName = null, ifAnother;
		int age = 0;
		double totalCost = 0;
		Toy toy1 = new Toy();
		Random rand = new Random();                
		
		//display the welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the "+
	"Toy Company to choose gifts for young children");
		System.out.println("BIRTHDAY GIFTS\n");
		do {
			String ifCancel = "Yes";
			while (ifCancel.equalsIgnoreCase("Yes")) {
				//Ask for the name of the child
				name = JOptionPane.showInputDialog("Enter the name of the child");
				//Ask for the age of the child
				age = Integer.parseInt(JOptionPane.showInputDialog("How old is the child?"));    
				toy1.setAge(age);
				//Ask for the toy choice and set cost
				toyName = JOptionPane.showInputDialog("Choose a toy: a plushie,blocks,or a book");
				toy1.setToy(toyName);
				toy1.setCost(toyName);
				//validate the input toy choice
				if (!toy1.ageOK()) {
					//Print out a error message and ask if the user wants to cancel that toy request.
					ifCancel = JOptionPane.showInputDialog("Toy is not age appropriate. " + 
				"Do you want to cancel the toy request: Yes or No");
				}
				else {
					ifCancel = "No";
				}
			}
			//Ask if a card or balloon should be added to the gift.
			toy1.addCard(JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No"));
			toy1.addBalloon(JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No"));
			//Calculate the total coast by add the current cost on it.
		    totalCost += toy1.getCost();
		    //Display the name, age and the total for gift.
			System.out.printf("The gift for " + name + " " + age + " years old is "+ toyName + " $%.2f\n", toy1.getCost());
			//Ask if another gift is desired
			ifAnother = JOptionPane.showInputDialog("Do you want another toy? Yes or No");
			}while(ifAnother.equalsIgnoreCase("Yes")) ;
		
		//Display the total amount of the order and a random five-digit order number
		System.out.printf("The total cost of your oeder is $%.2f Order number is " + (rand.nextInt(90000)+10000), totalCost);
		//Display programmer name
		System.out.println("\nProgrammer: Huan Shiuan Huang");
	}
}