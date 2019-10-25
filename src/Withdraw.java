/**
 * @file Withdraw.java
 * @brief Object Representation of a Withdrawal and all of its state and data
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Withdraw extends Transaction {

    // Static Variables
    private static final double WITHDRAW_INIT = 0.00;

    // Members

    public Withdraw()
    {
        this(new Money(WITHDRAW_INIT, new CheckingAccount().getCurrencyPreference()), new CheckingAccount());
    }

    /**
     * @brief Constructor
     * @param amount: Amount to prompt withdrawal with
     * @param account: Account to withdraw from
     */
    public Withdraw(Money amount, Account account)
    {
        super(account, amount);
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
     * @brief Perfor the Withdraw Action
     */
    public void perform()
    {
        Money convertedMoney = Teller.getInstance().convertToCurrency(amount, getTransactionAccount().getCurrencyPreference());
        if (getTransactionAccount().getBalance().getAmount() >= convertedMoney.getAmount())
        {
            withdraw(amount);
        }

        // Apply the respective tax
        if (getTransactionAccount().getAccountType() == Account.AccountType.CHECKING) {
            getTransactionAccount().deductBalance(tax.applyTax(amount));
        }
    }
}
