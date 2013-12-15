package billing;

import java.util.ArrayList;

public class Cart {
	ArrayList<Item> itemList;
	float amount = 0;
	float discountedAmount =0;
	public Cart(ArrayList<Item> list){
		this.itemList = list;
		for(int i=0; i<list.size(); i++)
			this.amount += list.get(i).quantity*list.get(i).unitPrice;
		this.discountedAmount = this.amount;
	}
	public void applyPercentageDiscount(int percentage){
		this.discountedAmount = 0;
		for(int i=0; i<itemList.size(); i++){
			if(!itemList.get(i).isGroceries) // percentage discount not applicable on groceries
				itemList.get(i).discountedUnitPrice = itemList.get(i).unitPrice*(100 - percentage)/100;
			this.discountedAmount += itemList.get(i).quantity*itemList.get(i).discountedUnitPrice;
		}
	}
	public void applyFixDiscount(int discount){
		this.discountedAmount -= discount;
	}
}