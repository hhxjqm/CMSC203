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
public class ManagementCompany {
	/**
	 * Maximum number of properties that this management company handles is set to 5
	 */
    private final int MAX_PROPERTY = 5;
    /**
     * management fee percentage
     */
    private double mgmFeePer;
    /**
     * Name of the management company
     */
    private java.lang.String name;
    /**
     *  tax ID of the management Company
     */
    private java.lang.String taxID;
    /**
     *  initialized to 10
     */
    private final int MAX_WIDTH = 10;
    /**
     *  initialized to 10
     */
    private final int MAX_DEPTH = 10;
    /**
     * An array of Property objects
     */
    private Property[] properties;
    /**
     *  Plot of the ManagemntCompany
     */
    private Plot plot;

    /** 
     * No-Arg Constructor that creates a ManagementCompany object using empty strings and a default Plot. "properties" array is initialized here as well.
     */
    public ManagementCompany() {
        name = "";
        taxID = "";
        mgmFeePer = 0;
        plot = new Plot();
        properties = new Property[MAX_PROPERTY];
    }

    /**
     * Constructor Creates a ManagementCompany object using the passed information. Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well.
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - management fee
	 */
    public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(0,0,MAX_WIDTH, MAX_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    /**
     * Constructor Creates a ManagementCompany object using the passed information. "properties" array is initialized here as well.
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - management fee
	 */
    public ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x,y,width,depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    /**
     * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. "properties" array is initialized here as well.
	 * @param otherCompany - another management company
	 */
    public ManagementCompany(ManagementCompany otherCompany) {
        name = otherCompany.name;
	    taxID = otherCompany.taxID;
	    mgmFeePer = otherCompany.mgmFeePer;
	    plot = otherCompany.plot;
	    properties = new Property[MAX_PROPERTY];
    }
    
    /**
     * Return the MAX_PROPERTY constant that represent the size of the "properties" array.
     * @return the MAX_PROPERTY
     */
    public int getMAX_PROPERTY() {
	    return MAX_PROPERTY;
    }
    
    /**
     * Adds the property object to the "properties" array.
	 * @return Returns either -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
    public int addProperty(Property property) {
        if (property == null)
            return -2;
      
        else if (!plot.encompasses(property.getPlot()))
            return -3;
    
        for (int i = 0;i < MAX_PROPERTY;i++) {
            if (properties[i] != null) {
                if (properties[i].getPlot().overlaps(property.getPlot()))
                    return -4;
            } 
            else{
                properties[i] = property;
                return i;
            } 
        }
        return -1;
    }
  
    /**
     * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name - property name
	 * @param city - location of the property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @return Returns either -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
    public int addProperty(String name,String city,double rent,String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }
  
    /**
     * Creates a property object and adds it to the "properties" array.
   	 * @param name - property name
   	 * @param city - location of the property
   	 * @param rent - monthly rent
   	 * @param owner - owner of the property
   	 * @param x - x location of upper left corner of property's plot
   	 * @param y - y location of upper left corner of property's plot
   	 * @param width - width of the property's plot
   	 * @param depth - depth of the property's plot
   	 * @return Returns either -1 if the array is full, 
   	 * -2 if property is null, 
   	 * -3 if the plot is not contained by the MgmtCo plot, 
   	 * -4 of the plot overlaps any other property, 
   	 * or the index in the array where the property was added successfully.
   	 */
    public int addProperty( String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }
  
    /**
     * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
     * @return total rent
     */
    public double totalRent() {
	    double total = 0;
	    for (int i=0;i<MAX_PROPERTY;i++) {
	        if (properties[i]==null)
	            break;
	        total += properties[i].getRentAmount();
	    }
	    return total;
    }
  
    /**
     * This method finds the property with the maximum rent amount and returns its toString result. NOTE: For simplicity assume that each "Property" object's rent amount is different.
     * @return double, the maximum rent amount
     */
    public double maxRentProp() {
	    return properties[maxRentPropertyIndex()].getRentAmount();
    }
 
    /**
     * This method finds the index of the property with the maximum rent amount. NOTE: For simplicity assume that each "Property" object's rent amount is different.
     * @return int , the index of the property with the maximum rent amount
     */
    private int maxRentPropertyIndex() {
        int index = 0;
        double max = 0;
        for (int i = 0;i<MAX_PROPERTY;i++) {
            if (properties[i] == null)  
                break;
            if (max < properties[i].getRentAmount()) {
                max = properties[i].getRentAmount();
                index = i;
            }
        }
        return index;
    }

    /**
     * Displays the information of the property at index i
     * @param i - The index of the property within the array "properties"
     * @return information of the property at index i
     */
    public java.lang.String displayPropertyAtIndex(int i){
	    return properties[i].toString();
    }
    
    /**
     * Displays the information of all the properties in the "properties" array.
     * @return information of ALL the properties within this management 
     * company by accessing the "Properties" array.
     */
    public java.lang.String toString() {
        String str = "";
        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i]==null)
                break; 
            str += properties[i] + "\n"; 
        }
        return "List of the properties for " + name + ", taxID: " + taxID
        + "\n______________________________________________________\n" + str 
        +  "______________________________________________________\n"
        + "total management Fee: " + (totalRent() * mgmFeePer / 100);
    }
    
    /**
     * return the name
     * @return the name
     */
    public String getName() {
    	return name;
    }
    
    /**
     * return the plot
     * @return the plot
     */
    public Plot getPlot() {
    	return plot;
    }
}

