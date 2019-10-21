/**
 * @file Interest.java
 * @brief Interest representation, applied to accounts with high balance
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */

public class Interest {

    // Static Variables
    private static double DEFAULT_INTEREST_RATE = (1/1000);
    private static CurrencyTypes DEFAULT_CURRENCY_TYPE = CurrencyTypes.Usd;
    private static final Money MIN_BALANCE_TO_COLLECT_INTEREST = new Money(100000, DEFAULT_CURRENCY_TYPE);
    private static final double INIT_ACCRUEL = 0.00;

    // Members
    private Money interestAccrued;
    private double interestRate;

    public Interest()
    {
        interestAccrued = new Money(INIT_ACCRUEL, DEFAULT_CURRENCY_TYPE);
        interestRate = DEFAULT_INTEREST_RATE;
    }

    private Money getInterestAcrued()
    {
        return interestAccrued;
    }

    private boolean doesAccountRequireInterest(Account account)
    {
        Money convertedMoney = MoneyConverter.getInstance().convertToCurrency(account.getBalance(), MIN_BALANCE_TO_COLLECT_INTEREST.getCurrencyType());
        return account.getBalance().getAmount() >= MIN_BALANCE_TO_COLLECT_INTEREST.getAmount();
    }

    private double calculateInterest(double amount)
    {
        return (amount * DEFAULT_INTEREST_RATE);
    }
}
