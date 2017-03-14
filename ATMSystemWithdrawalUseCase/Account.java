package packg;
import java.util.HashMap;
import java.util.Map;

public class Account {
	
	int acc_num;
	/***
	 * Parameterized constructor for Account class
	 * It takes card number as input and sets the private instance variable balance to the current balance value
	 * @param cardNum
	 */
	public Account(String cardNum) {
		this.balance = accBal.get(cardNum);
	}
	
	/** 
	 * Static data structure that stores card number to account balance association
	 * whose changes across the project will keep the values persistent
	 */
	static Map<String,Integer> accBal = new HashMap<>();
	static{
		accBal.put("A11",40);
		accBal.put("A12",40);
		accBal.put("B111",40);
		accBal.put("B122",40);
		accBal.put("B133",40);
	}
	
	private int balance;
	
	public int getBalance(String cardNum) {
		balance = accBal.get(cardNum);
		return accBal.get(cardNum);
	}
	
	//gets the account balance based on card number
	public void setBalance(int balance,String cardNum) {
		accBal.put(cardNum, balance);
	}
	
	//gets the account number
	public int getAcc_num() {
		return acc_num;
	}
	
	//sets the account number
	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}
	
	/** Checks balance in the account before serving withdrawal request
	 * 
	 * @param amnt Amount to be withdrawn
	 * @param cc card number from which amount has to be withdrawn
	 * @return -1 if balance is not sufficient and new balance if balance is sufficient
	 */
	int checkBalance(int amnt,String cc){
		if(amnt > balance){
			return -1;
		}
		else if(amnt <= balance){
			return balance-amnt;
		}
		return 0;
	}
}
