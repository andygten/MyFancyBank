/**
 * @file Transaction.java
 * @brief Abstract Class representing a generic Transaction Object
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */


public abstract class Transaction {

    // Members
    private Account account;    ///< Account involved in the transaction
    private Tax tax;

    public Transaction(Account account) {
        this.account = account;
        this.tax = new Tax();
    }

    /**
     * No Arg Constructor
     */
    public Transaction()
    {
        this(new Account());
    }

    /**
     * @brief Getter: Account involved in transaction
     * @return account
     */
    public Account getTransactionAccount()
    {
        return account;
    }

    abstract public void perform(double amount);
}
