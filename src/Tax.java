/**
 * @file Tax.java
 * @brief Representation of a tax, applied to all transactions
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */
public class Tax {

    // Static Variables
    static private double DEFAULT_TAX_PERCENTAGE = 5;
    static private CurrencyTypes DEFAULT_TAX_CUR = CurrencyTypes.Usd;
    static private final double TAX_INIT = 0.00;

    // Members
    private Money totalTaxedAmount;
    private double taxedAmount;
    private CurrencyTypes currencyType;


    public Tax()
    {
        totalTaxedAmount = new Money(TAX_INIT, DEFAULT_TAX_CUR);
        taxedAmount = DEFAULT_TAX_PERCENTAGE;
        currencyType = DEFAULT_TAX_CUR;
    }

    public Tax(double taxedAmount, CurrencyTypes currencyType)
    {
        totalTaxedAmount = new Money(TAX_INIT, currencyType);
        this.taxedAmount = taxedAmount;
    }

    private Money getTaxedAmount()
    {
        return totalTaxedAmount;
    }

    public Money applyTax(Money money)
    {
        return new Money((taxedAmount), currencyType);
    }
}
