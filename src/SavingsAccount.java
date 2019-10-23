/**
 * @file SavingsAccount.java
 * @brief Savings Implementation of the Abstract Class Account
 * @data 10/19/19
 * @author Andrew Gieraltowski
 */


public class SavingsAccount extends Account {

    // Members
    private Interest interest;          ///< Interest is only payed to Savings Accounts


    public SavingsAccount(String accountID, String password, Name name, String balance)
    {
        super(accountID, password, name, balance, AccountType.SAVINGS);
        interest = new Interest();
    }

    public SavingsAccount(String accountID, String password)
    {
        super(accountID, password, AccountType.SAVINGS);
    }

    /**
     * @brief No Arg Constructor
     */
    public SavingsAccount() {
        this("", "", new Name("", "", ""), "0.00");
    }


}
