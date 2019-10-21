/**
 * @file Tax.java
 * @brief Representation of a tax, applied to all transactions
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */
public class Tax {

    // Static Variables
    static private double DEFAULT_TAX_PERCENTAGE = (2/100);
    static private CurrencyTypes DEFAULT_TAX_CUR = CurrencyTypes.Usd;
    static private final double TAX_INIT = 0.00;

    // Members
    private Money totalTaxedAmount;
    private double taxedPercentage;
    private CurrencyTypes currencyType;


    public Tax()
    {
        totalTaxedAmount = new Money(TAX_INIT, DEFAULT_TAX_CUR);
        taxedPercentage = DEFAULT_TAX_PERCENTAGE;
    }

    public Tax(double taxedPercentage, CurrencyTypes currencyType)
    {
        totalTaxedAmount = new Money(TAX_INIT, currencyType);
        this.taxedPercentage = taxedPercentage;
    }

    private Money getTaxedAmount()
    {
        return totalTaxedAmount;
    }

    public Money applyTax(Money money)
    {
        // Convert to common currency and apply the tax
        Money convertedMoney = Teller.getInstance().convertToCurrency(money, currencyType);
        Money taxedAmount= new Money(convertedMoney.getAmount() * taxedPercentage, currencyType);
        totalTaxedAmount.add(taxedAmount);

        // Return the money with the applied tax, in the original currency
        Money convertedMoneyWithTaxApplied = new Money(convertedMoney.getAmount() * (1 - taxedPercentage), currencyType);
        return Teller.getInstance().convertToCurrency(convertedMoneyWithTaxApplied, money.getCurrencyType());
    }
}
