/**
 * @file CheckingAccount.java
 * @brief Inherits Account, is a specific Checking Type of Account
 * @author Andrew Gieraltowski
 * @date 10/19/19
 */


public class CheckingAccount extends Account {

    public CheckingAccount(String accountID, String password, Name name, String balance) {
        super(accountID, password, name, balance, AccountType.CHECKING);
    }

    public CheckingAccount(String accountID, String password)
    {
        super(accountID, password, AccountType.CHECKING);
    }

    /**
     * @brief No Arg Constructor
     */
    public CheckingAccount() {
        this("", "", new Name("", "", ""), "0.00");
    }
}
