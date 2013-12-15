package billing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Rules {
	Cart cart;
	User user;
	public Rules(Cart cart, User user){
		this.cart = cart;
		this.user = user;
	}
	//function to calculate percentage discount
	//the rules are checked here and returns are arranged in decreasing order to give the user maximum discount
	public int checkApplicablePercentageDiscount(){
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);
		Date twoYearAgoDate = cal.getTime();
		if(this.user.isEmployee)
			return 30;
		else if(this.user.isAffiliate)
			return 10;
		else if(this.user.joiningDate.before(twoYearAgoDate))
			return 5;
		else
			return 0;
	}
	public int checkApplicableFixDiscount(){
		int discount = (int)this.cart.discountedAmount / 100;
		return discount*5;
	}
}