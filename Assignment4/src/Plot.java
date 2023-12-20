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
public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p - a Plot object
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	/**
	 * Parameterized constructor
	 * @param x - horizontal coordinate of upper left corner
	 * @param y - vertical coordinate of upper left corner
	 * @param width - horizontal size
	 * @param depth - vertical size
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * @param plot - a Plot object
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		if (( x >= plot.x && x < plot.x+plot.width ) || ( x+width > plot.x && x + width <= plot.x + plot.width)) {
			if((y+depth > plot.y && y + depth <= plot.y + plot.depth) || (y >= plot.y && y < plot.y + plot.depth))
				return true;
			else if ((plot.y+plot.depth > y && plot.y + plot.depth <= y + depth) || (plot.y >= y && plot.y < y + depth))
				return true;
		}
		return false;
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * @param plot - a Plot object
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		if (plot.x >= x && plot.y >= y && plot.x + plot.width <= x + width 
				&& plot.y + plot.depth <= y + depth)
			return true;
		else
			return false;
			
	}
	
	/**
	 * Set the x value
	 * @param x - the x value to set
	 */
	
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return the x value
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Set the y value
	 * @param y - the y value to set
	 */
	
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Return the y value
	 * @return the y value
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Set the width value
	 * @param width - the width value to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Return the width value
	 * @return the width value
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Set the depth value
	 * @param depth - the depth value to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Return the depth value
	 * @return the depth value
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * @return the string representation of a Plot object in the following format: Upper left: (1,1); Width: 3 Depth: 3
	 */
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
