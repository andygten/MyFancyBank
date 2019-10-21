import javax.naming.Name;

/**
 * @file Account.java
 * @brief Represents the Account of a Customer or Manager
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Account {

    // Members
    private int[] PIN;
    private String AccountID;
    private Name name;
    private double balance;
    private Interest interest;


    public Account(String AccountID, Name name, int[] PIN, double balance)
    {
        this.AccountID = AccountID;
        this.name = name;
        this.PIN = PIN;
        this.balance = balance;
        interest = new Interest();
    }

    /**
     * @brief No Arg Constructor
     */
    public Account()
    {
        this("EMPTY", null, new int[4], 0.00);
    }

    /**
     * @brief Add to Balance of account
     * @param amount: Amount to add
     */
    protected void addBalance(double amount)
    {
        balance += amount;
    }

    /**
     * @brief Deduct Balance from account
     * @param amount: Amount to deduct
     */
    protected void deductBalance(double amount)
    {
        balance -= amount;
    }

    /**
     * @brief Get Balance of Account
     * @return double balance
     */
    public double getBalance()
    {
        return balance;
    }
}
