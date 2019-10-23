/**
 * @file Withdraw.java
 * @brief Object Representation of a Withdrawal and all of its state and data
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Withdraw extends Transaction {

    public Withdraw()
    {
        this(new Account());
    }

    /**
     * @brief Constructor
     * @param account: Account to withdraw from
     */
    public Withdraw(Account account)
    {
        super(account);
    }

    /**
     * @brief Withdraw Money from account
     * @param amount: Amount to deduct from the balance
     */
    public void withdraw(Money amount)
    {
        getTransactionAccount().deductBalance(amount);
    }

    /**
     * @brief Perform the Withdraw Action
     * @param amount: Amount to withdraw
     */
    public void perform(Money amount)
    {
        Money convertedMoney = Teller.getInstance().convertToCurrency(amount, getTransactionAccount().getCurrencyPreference());
        if (getTransactionAccount().getBalance().getAmount() >= convertedMoney.getAmount())
        {
            withdraw(amount);
        }

        // Apply the respective tax
        getTransactionAccount().deductBalance(tax.applyTax(amount));
    }
}
