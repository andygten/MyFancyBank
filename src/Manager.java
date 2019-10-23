/**
 * @file Manager.java
 * @brief Object Representation of a Manager of Fancy Bank
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */


public class Manager extends Person {

    // Static Variables

    // Members
    private Money amountCollected;
    private Money loansOwed;

    public Manager()
    {
        amountCollected = new Money();
        loansOwed = new Money();
    }

    public void addAmountCollected(Money money)
    {
       amountCollected.add(money);
    }

    public Money getAmountCollected()
    {
        return amountCollected;
    }

    public void addLoanAmount(Money money)
    {
        loansOwed.add(money);
    }

    public Money getLoansOwed()
    {
        return loansOwed;
    }

}
