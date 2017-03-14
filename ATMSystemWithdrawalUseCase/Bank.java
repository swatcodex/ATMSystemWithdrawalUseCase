package packg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Bank {
	Account acc;
	int bankid;

	Hashtable<String,String> log = new Hashtable<>();
	Map<String,String> bankDirectory = new HashMap<>();
	{
		bankDirectory.put("A11","mypassword");
		bankDirectory.put("A12","mypassword");
		bankDirectory.put("B111","mypassword");
		bankDirectory.put("B112","mypassword");
		bankDirectory.put("B113","mypassword");
	}
	
	/**
	 * Checks whether the card number entered by the user belongs
	 * to the bank or not. 
	 * @param cardNum Card number entered by user
	 * @return True if card belongs to bank, False if it doesn't
	 */
	boolean cardAccepted(String cardNum){
		return bankDirectory.containsKey(cardNum);
	}
	
	/**
	 * Verifies the user entered password against the actual password 
	 * based on the records in the bank
	 * @param pwd user entered password
	 * @param cc card number of the user who entered the password
	 * @return
	 */
	String verifyPassword(String pwd,String cc){
		if(bankDirectory.get(cc).equals(pwd)){
			return "accept";
		}
		else{
			return "reject";
		}
	}
	
	/***
	 * Logs withdrawal transaction
	 * @param amnt Amount withdrawn by the user
	 * @param cc card number of the card which was used to withdraw the amount
	 */
	void logTxn(int amnt,String cc){
		String logTxn = cc+" "+"withdrew $"+amnt+" at "+new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
		log.put(cc, logTxn);
		if(!log.isEmpty())
			System.out.println("Transaction logged as: "+log.values());
	}
}
