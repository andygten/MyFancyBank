/**
 * @file Deposit.java
 * @brief Object Representation of a Deposit and all of its state and data
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Deposit extends Transaction {

    // Members
    private double amount;

    public Deposit(double amount, Account account)
    {
        super(account);
        this.amount = amount;
    }

    /**
     * @brief Deposit money into a specified account
     * @param amount
     */
    public void deposit(double amount)
    {
       getTransactionAccount().addBalance(amount);
    }

    public void perform(double amount)
    {
        deposit(amount);
    }
}
