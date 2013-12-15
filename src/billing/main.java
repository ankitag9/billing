package billing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		System.out.println("Welcome to Billing System");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader;
		int count = 0;
		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) { //read till the file ends
					count++;
					System.out.println("---Case " + String.valueOf(count) +"----");
				    User user = User.createUser(line); // first line contains user details
					if(user == null){
						System.out.println("Please enter User details in correct format");
						break;
					}
					line = reader.readLine();
					int itemInCart = Integer.parseInt(line); // second line contains number of items in cart
					ArrayList<Item> itemList = new ArrayList<Item>();
					for(int i=0; i< itemInCart; i++){
						line = reader.readLine();
						Item item = Item.createItem(line); // next few lines contain item details present in the cart
						if(item != null)
							itemList.add(item);
					}
					Cart cart = null;
					if(itemList.size() != 0)
						cart = new Cart(itemList);
					else{
						System.out.println("Please enter Cart details in correct format");
						break;
					}
					Rules rule = new Rules(cart, user);
					System.out.println("Bill amount before discount:$" + Float.toString(rule.cart.amount));
					int discountPercentage = rule.checkApplicablePercentageDiscount();
					System.out.println("Applicable percentage discount = " + String.valueOf(discountPercentage) + "%");
					rule.cart.applyPercentageDiscount(discountPercentage);
					int fixDiscount = rule.checkApplicableFixDiscount();
					System.out.println("Applicable fix discount = $" + String.valueOf(fixDiscount));
					rule.cart.applyFixDiscount(fixDiscount);
					System.out.println("Bill amount after discount:$" + Float.toString(rule.cart.discountedAmount));
					System.out.println("");
					System.out.println("Please press enter to continue...");
					br.readLine();
					}
				} catch (IOException e) {
					System.out.println("Error in reading line");
				}
		} catch (FileNotFoundException e) {
			System.out.println("Error in reading file");
		}
		System.out.println("Thank you for using this billing system.....Program terminated");
	}
}