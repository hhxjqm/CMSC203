/*
 * Class: CMSC203 
 * Program: Assignment 4
 *  Instructor: Grigoriy A. Grinberg
 * Description: (A property management company manages individual properties they will build to rent, 
 * and charges them a management fee as the percentages of the monthly rental amount. 
 * The properties cannot overlap each other, and each property must be within the limits of the management company¡¯s plot.  
 * Write an application that lets the user create a management company and add the properties managed by the company to its list. 
 * Assume the maximum number of properties handled by the company is 5.  )
 *
 * Due: 7/26/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Huan Shiuan Huang
*/

/**
 * @author Huan Shiuan Huang
 */
public class Property {

	private java.lang.String city;
	private java.lang.String owner;
	private java.lang.String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 *  No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot (sets the x, y values to zero, depth and width to 1)
	 */
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	/**
	 *  Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p - a Property object
	 */
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = new Plot(p.plot);
	}
	
	/**
	 * Parameterized Constructor, no Plot information provided
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 */
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner) {
	   this.propertyName = propertyName;
	   this.city = city;
	   this.owner = owner;
	   this.rentAmount = rentAmount;
	   plot = new Plot();
	}
	
	/**
	 * Constructor, Parameterized constructor
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 */
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner, int x, int y, int width, int depth ) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Return the property Name
	 * @return the propertyName
	 */
	public java.lang.String getPropertyName(){
		return propertyName;
	}	
	
	/**
	 * Set the property name
	 * @param propertyName - the propertyName to set
	 */
	public void setPropertyName(java.lang.String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * return the city
	 * @return the city
	 */
	public java.lang.String getCity(){
		return city;
	}
	
	/**
	 * set the Plot values
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x,y,width,depth);
		return plot;
	}
	/**
	 * set the city
	 * @param city - the city to set
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	
	/**
	 * return the owner name
	 * @return the owner
	 */
	public java.lang.String getOwner(){
		return owner;
	}
	
	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * set the owner name
	 * @param owner - the owner to set
	 */
	public void setOwner(java.lang.String owner) {
		this.owner = owner;
	}
	
	/**
	 * return the rent amount
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * set the rent amount
	 * @param rentAmount - the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * @return return information
	 */
	public java.lang.String toString(){
		return (" Property Name: " + propertyName + "\n  Located in " +
         city + "\n  Belonging to: " + owner + "\n  Rent Amount: " + rentAmount);
	}
}
