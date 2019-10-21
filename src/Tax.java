/**
 * @file Tax.java
 * @brief Representation of a tax, applied to all transactions
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */
public class Tax {

    // Static Variables
    static private double DEFAULT_TAX_PERCENTAGE = (2/100);

    // Members
    private double totalTaxedAmount;
    private double taxedPercentage;


    public Tax()
    {
        totalTaxedAmount = 0.00;
        taxedPercentage = DEFAULT_TAX_PERCENTAGE;
    }

    public Tax(double taxedPercentage)
    {
        totalTaxedAmount = 0.00;
        this.taxedPercentage = taxedPercentage;
    }

    private double getTaxedAmount()
    {
        return totalTaxedAmount;
    }

    private double applyTax(double amount)
    {
        return (amount * taxedPercentage);
    }
}
