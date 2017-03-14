package packg;	

public class WithdrawalTxn {
	Account acnt;
	String cardNum;
	int balance, newBalance;
	
	/**
	 * Returns an integer value that -1 if balance has
	 * exceeded the account balance and the new balance if 
	 * its has not.
	 * Takes the amnt and cardNum arguments must specify the amount
	 * to be withdrawn and card from which it should be withdrawn respectively
	 *
	 * @param  amnt  amount to be withdrawn 
	 * @param  cardNum card from which amount should be withdrawn - indicates bankid and account of customer
	 * @return      new balance
	 */
	public int withdraw(int amnt, String cardNum){
		acnt = new Account(cardNum);
		newBalance = acnt.checkBalance(amnt, cardNum);
		if(newBalance != -1){
			acnt.setBalance(newBalance,cardNum);
		}
		return newBalance;
	}
}
