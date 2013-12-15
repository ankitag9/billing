package billing;

public class Item {
	boolean isGroceries;
	int quantity;
	float unitPrice;
	float discountedUnitPrice;
	public Item(boolean isGroceries, int quantity, float unitPrice){
		this.isGroceries = isGroceries;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discountedUnitPrice = unitPrice;
	}
	//function to create new item from string
	// String in the format isGroceries,quantity,unitPrice
	public static Item createItem(String input){
	    String[] substrings = input.split(",");
	    int numberOfFields =  Item.class.getDeclaredFields().length;
	    if (substrings.length == (numberOfFields-1)){//not taking discountedUnitPrice as input -- calculating it dynamically
	    	boolean isGroceries = Boolean.parseBoolean(substrings[0]);
	    	int quantity = Integer.parseInt(substrings[1]);
	    	float unitPrice = Float.parseFloat(substrings[2]);
	    	//assign more fields here if new fields are added.
	    	Item tempItem = new Item(isGroceries, quantity, unitPrice);
	    	if(tempItem != null){
		    	System.out.println("New Item created - " + input);
		    	return tempItem;
	    	}
	    }
	    else
	    	System.out.println("Please enter details in correct format");
		return null;
	}
}