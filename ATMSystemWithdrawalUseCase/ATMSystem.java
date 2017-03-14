package packg;
import java.util.*;
public class ATMSystem {
	public static void main(String[] args) {
			Scanner keyboard = new Scanner(System.in);
			String atmChosen, cardNum, pwd, authorize, withdrawAmnt;
			char bankid;
			int  balance;
    		Bank bank = new Bank();
			WithdrawalTxn wt = new WithdrawalTxn();
	    	System.out.println("Enter your choice of ATM");
	    	atmChosen = keyboard.nextLine();
	    	String[] s = atmChosen.split("_");
	    	bankid = s[1].charAt(0);
	    	System.out.println("Enter your card");
	    	cardNum = keyboard.nextLine();
	    	if(!cardNum.substring(0,1).equals(bankid) && !Character.isAlphabetic(bankid)){
	    		System.out.println("This card is not supported by this ATM");
	    		System.exit(0);
	    	}
	    	if(!cardNum.substring(0,1).equals(String.valueOf(bankid))){
	    		System.out.println("This card is not supported by this ATM");
	    		cardNum = keyboard.nextLine();
	    	}
		    	if(!bank.cardAccepted(cardNum)){
		    		System.out.println("This card is not supported by this ATM");
		    		cardNum = keyboard.nextLine();
		    	}
	    	
	    	
	    	if(cardValid(cardNum)){
	    		// display error message and return card 
	    		System.out.println(" This card is expired and returned to you.");
	    	}
	    	else{
	    		// initiate authorization dialog
	    		System.out.println("The card is accepted. Please enter your password.");
	    		pwd = keyboard.nextLine();
	    		authorize = bank.verifyPassword(pwd, cardNum);
	    		if(authorize.equals("reject")){
	    			System.out.println("This is a wrong password. Enter your password.");
	    		}
	    		else{
	    			System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
	    			//initiate withdrawal dialog
	    			while(!("quit".equals(withdrawAmnt = keyboard.nextLine()))){
	    				//check limit per transaction
	    				if(Integer.parseInt(withdrawAmnt) > 50 ){
		    				System.out.println("This amount exceeds the maximum amount you can withdraw per transaction. Please enter the amount or quit.");
		    			}
	    				//verify account balance
		    			else{
		    				balance = wt.withdraw(Integer.parseInt(withdrawAmnt),cardNum);
		    				if(balance == -1){
		    					System.out.println("This amount exceeds your balance. Please enter another amount or quit.");
		    				}
		    				else if(balance==0){
		    					bank.logTxn(Integer.parseInt(withdrawAmnt), cardNum);
		    					System.out.println("You cannot withdraw anymore");
		    					System.exit(0);
		    				}
		    				else{
		    					bank.logTxn(Integer.parseInt(withdrawAmnt), cardNum);
		    					System.out.println("$"+withdrawAmnt+" is withdrawn from  your account. The remaining balance of this account is $"+balance+".  If you have more transactions, enter the amount or quit. ");
		      				}
		    			}	
	    			}
	    		}
	    	
	    	}
	
	    }

	private static boolean cardValid(String cardNum) {
		//check card validity
		CashCard c = new CashCard();
		return c.checkExpiry(cardNum);
	}

}

