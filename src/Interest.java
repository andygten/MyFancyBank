/**
 * @file Interest.java
 * @brief Interest representation, applied to accounts with high balance
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */

public class Interest {

    // Static Variables
    static double MIN_BALANCE_TO_COLLECT_INTEREST = 100000;
    static double DEFAULT_INTEREST_RATE = (1/1000);

    // Members
    private double interestAccrued;
    private double interestRate;

    public Interest()
    {
        interestAccrued = 0.00;
        interestRate = DEFAULT_INTEREST_RATE;
    }

    private double getInterestAcrued()
    {
        return interestAccrued;
    }

    private boolean doesAccountRequireInterest(Account account)
    {
        return account.getBalance() >= MIN_BALANCE_TO_COLLECT_INTEREST;
    }

    private double calculateInterest(double amount)
    {
        return (amount * DEFAULT_INTEREST_RATE);
    }

}
