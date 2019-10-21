/**
 * @file Deposit.java
 * @brief Object Representation of a Deposit and all of its state and data
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Deposit extends Transaction {

    // Members
    private Money amount;

    public Deposit(Money amount, Account account)
    {
        super(account);
        this.amount = amount;
    }

    /**
     * @brief Deposit money into a specified account
     * @param amount
     */
    public void deposit(Money amount)
    {
       getTransactionAccount().addBalance(amount);
    }

    public void perform(Money amount)
    {
        deposit(amount);
        getTransactionAccount().deductBalance(tax.applyTax(amount));
    }
}
