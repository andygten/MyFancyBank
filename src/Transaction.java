/**
 * @file Transaction.java
 * @brief Abstract Class representing a generic Transaction Object
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */


public abstract class Transaction {

    // Members
    private Account account;    ///< Account involved in the transaction
    protected Tax tax;
    protected Money amount;

    public Transaction(Account account, Money amount) {
        this.amount = amount;
        this.account = account;
        this.tax = new Tax();
    }

    /**
     * No Arg Constructor
     */
    public Transaction()
    {
        this(new Account(), new Money());
    }

    /**
     * @brief Getter: Account involved in transaction
     * @return account
     */
    public Account getTransactionAccount()
    {
        return account;
    }

    /**
     * @brief Getter: Amount in transaction
     */
    public String getTransactionAmount()
    {
        return amount.toString();
    }

    abstract public void perform();
}
