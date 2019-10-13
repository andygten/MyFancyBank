/**
 * @file Bank.java
 * @brief Abstract Parent Class defining all things related to bank state at a high level
 * @date 10/16/19
 * @author Andrew Gieraltowski
 */

public abstract class Bank {

    private double balance;                             ///< Amount of money in the bank


    /**
     * @brief Single Arg Constructor
     * @param deposit Initial Deposit into the Bank
     */
    public Bank(double deposit)
    {
        balance = deposit;
    }

    /**
     * @brief No Arg Constructor for the superclass
     */
    public Bank()
    {
        this(0);
    }

    /**
     * @brief Getter for bank balance
     * @return balance stored in bank
     */
    private double getBalance()
    {
        return balance;
    }

    /**
     * @brief Deposit money into the bank
     */
    private void deposit(int amount)
    {
        balance += amount;
    }

    /**
     * @brief Withdraw money from the bank
     * @return The amount withdrawn
     */
    private double withdraw(int amount)
    {
        double actualAmount = 0.00;
        if (balance < amount)
        {
            actualAmount = balance;
            balance = 0;
        }
        else
        {
            balance -= amount;
            actualAmount = amount;
        }

        return actualAmount;
    }

}
