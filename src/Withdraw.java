/**
 * @file Withdraw.java
 * @brief Object Representation of a Withdrawal and all of its state and data
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Withdraw extends Transaction {

    // Static Variables

    // Members
    private double amount;

    public Withdraw()
    {
        this(0, new Account());
    }

    /**
     * @brief Constructor
     * @param amount: Amount to prompt withdrawal with
     * @param account: Account to withdraw from
     */
    public Withdraw(double amount, Account account)
    {
        super(account);
        this.amount = amount;
    }

    /**
     * @brief Withdraw Money from account
     * @param amount: Amount to deduct from the balance
     */
    public void withdraw(double amount)
    {
        getTransactionAccount().deductBalance(amount);
    }

    /**
     * @brief Perfor the Withdraw Action
     * @param amount: Amount to withdraw
     */
    public void perform(double amount)
    {
        if (getTransactionAccount().getBalance() < amount)
        {
            withdraw(amount);
        }
        else
        {
            withdraw(getTransactionAccount().getBalance());
        }
    }
}
