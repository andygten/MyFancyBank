/**
 * @file Deposit.java
 * @brief Object Representation of a Deposit and all of its state and data
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Deposit extends Transaction {

    // Members
    public Deposit(Money money, Account account)
    {
        super(account, money);
    }

    /**
     * @brief Deposit money into a specified account
     * @param amount
     */
    public void deposit(Money amount)
    {
       getTransactionAccount().addBalance(amount);
    }

    public void perform()
    {
        deposit(new Money(amount.getAmount(), getTransactionAccount().getCurrencyPreference()));

        // Apply the respective tax
        if (getTransactionAccount().getAccountType() == Account.AccountType.CHECKING) {
            getTransactionAccount().deductBalance(tax.applyTax(new Money(amount.getAmount(), getTransactionAccount().getCurrencyPreference())));
        }
    }
}
