# ATMSystemWithdrawalUseCase
States of two Banks  

Assume all accounts have $40 preloaded.  
BankofA (two customers)
Customer with Cash Card (bankid: A, account number : 11), expires on MM/DD/YY, password ... 
Customer with Cash Card (bankid: A, account number : 12), expires on MM/DD/YY, password ... 

BankofB (three customers)
Customer - Cash Card (bankid: B, account number : 111), expires on MM/DD/YY, password... 
Customer - Cash Card (bankid: B, account number : 122), expires on MM/DD/YY, password... 
Customer - Cash Card (bankid: B, account number : 133), expires on MM/DD/YY, password... 


States of four ATMs (2 for each Bank)
ATM1_A: (ATM1 from BankofA)
  The maximum amount of cash a card can widthraw per day: $50

ATM2_A: (ATM1 from BankofA)
  The maximum amount of cash a card can widthraw per day: $50
  
ATM1_B: (ATM1 from BankofA)
  The maximum amount of cash a card can widthraw per day: $50
  
ATM2_B: (ATM1 from BankofA)
  The maximum amount of cash a card can widthraw per day: $50
------------------------------------------------------------------------------
Now, your program is in an interactive mode. % means the prompt on your cmd (shell).


% Enter your choice of ATM
% ATM_A1
% Enter your card
% A11 
% This card is expired and returned to you.  
% Enter your card
% B 111
% This card is not supported by this ATM
% A 12
% The card is accepted. Please enter your password.  (ATM takes this password and sends it to the bank) 
% &*(*&)
% This is a wrong password. Enter your password.
% mypassword
% Authorization is accepted. Start your transaction by entering the amount to withdraw.  
% 100
% This amount exceeds the maximum amount you can withdraw per transaction. Please enter the amount or quit.
% 25 (ATM passes $25 to the bank to determine the current balance can afford this money.)
% $25 is withdrawn from  your account. The remaining balance of this account is $.  If you have more transactions, enter the amount or quit. 
$ 25  
% The amount exceeds the current balance. Enter another amount or quit.   
% 15 
% $15 is withdrawn from  your account. The remaining balance of this account is $0.  If you have more transactions, enter the amount or quit. 
%quit
------------------------------------------------------------------------------------
Sample output:


% Enter your choice of ATM
% ATM_2
% Enter your card
% A11 
% This card is not supported by this ATM
-------------------------------------------------------------------------------------

% Enter your choice of ATM
% ATM_B
% Enter your card
% B112
% The card is accepted. Please enter your password.  
% mypassword
% Authorization is accepted. Start your transaction by entering the amount to withdraw.  
% 10
% $10 is withdrawn from  your account. The remaining balance of this account is $30.  If you have more transactions, enter the amount or quit. 
% 30  
% $10 is withdrawn from  your account. The remaining balance of this account is $0.  If you have more transactions, enter the amount or quit.
% You cannot withdraw anymore   
----------------------------------------------------------------------------------------





