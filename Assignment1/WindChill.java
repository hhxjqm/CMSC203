/*
 * Class: CMSC203 
 * Program: Assignment 1
 * Instructor: Grigoriy A. Grinberg
 * Description: (Develop a Java application that prompts for and reads two double 
 * numeric amounts that represent the Fahrenheit temperature and the wind speed.  
 * The temperature must be between -45 and 40 inclusively. The wind speed must be between 
 * 5 and 60 inclusively. Use these two amounts in the formula below to calculate the wind
 *  chill temperature in degrees Fahrenheit.)

 * Due: 6/19/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Huan Shiuan Huang
*/

import  java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double temp,speed,windChill;
		
		System.out.println("Wind Chill Calculator\n");
		
		System.out.print("Enter the temperature in Fahrenheit "
				+"(must be >= -45 and <= 40): ");		
		temp = sc.nextDouble();
		
		System.out.print("Enter the wind speed (must be >= 5 and <= 60): ");
		speed = sc.nextDouble();
		
		windChill = 35.74 + 0.6215*temp-35.75*Math.pow(speed,0.16)+
				0.4275*temp*Math.pow(speed, 0.16);
		System.out.println("\nWind chill temperature: "+windChill
				+" degrees Fahrenheit\n");
		
		System.out.println("Programmer: Huan Shiuan Huang");
		sc.close();
	}

}
