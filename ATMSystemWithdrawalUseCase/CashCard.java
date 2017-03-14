package packg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CashCard {
	String card_num;
	Date exp_date;
	Map<String,String> cardDetails = new HashMap<>();
	{
		cardDetails.put("A11","Mar-30-2017 08:55:28 PM");
		cardDetails.put("A12","Feb-1-2017 08:55:28 PM");
		cardDetails.put("B111","Feb-1-2017 08:55:28 PM");
		cardDetails.put("B112","Feb-1-2017 08:55:28 PM");
		cardDetails.put("B113","Feb-1-2017 08:55:28 PM");
	}
	
	/**
	 * Checks if the card entered into the ATM has not expired 
	 * @param cardNum Card number
	 * @return True if card has expired, false if not
	 */
	boolean checkExpiry(String cardNum){
		String date = cardDetails.get(cardNum);
		System.out.println("expiration for this card is"+date);
	    if(date.isEmpty() || date.trim().equals("")){
	        return false;
	    }else{
	            SimpleDateFormat sdf =  new SimpleDateFormat("MMM-dd-yyyy hh:mm:ss a"); // Jan-20-2015 1:30:55 PM
	               Date d=null;
	               Date d1=null;
	            String today=   getToday("MMM-dd-yyyy hh:mm:ss a");
	            System.out.println("today is"+today);
	            try {
	                d = sdf.parse(date);
	                d1 = sdf.parse(today);
	                if(d1.compareTo(d) <0){// not expired
	                    return false;
	                }else if(d.compareTo(d1)==0){// both date are same
	                            if(d.getTime() < d1.getTime()){// not expired
	                                return false;
	                            }else if(d.getTime() == d1.getTime()){//expired
	                                return true;
	                            }else{//expired
	                                return true;
	                            }
	                }else{//expired
	                    return true;
	                }
	            } catch (ParseException e) {
	                e.printStackTrace();                    
	                return false;
	            }
	    }
	}


	  public static String getToday(String format){
	     Date date = new Date();
	     return new SimpleDateFormat(format).format(date);
	 }
}
