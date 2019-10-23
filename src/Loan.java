/**
 * @file Loan.java
 * @brief An object representation of a loan
 */


public class Loan {

    // Static Variables
    private static final double INIT_AMOUNT_OWED = 0.00;
    private static final CurrencyTypes DEFAULT_CURRENCY_TYPE = CurrencyTypes.Usd;

    // Members
    private Money amountOwed;
    private Interest interest;

    public Loan()
    {
        amountOwed = new Money(INIT_AMOUNT_OWED, DEFAULT_CURRENCY_TYPE);
        interest = new Interest();
    }

    public void addToLoan(Money amount)
    {
        amountOwed.add(amount);
    }

    public void payBackLoan(Money amount)
    {
        amountOwed.subtract(amount);
    }

    public Interest getInterest()
    {
        return interest;
    }
}
