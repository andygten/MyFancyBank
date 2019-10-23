/**
 * @file Money.java
 * @brief Representation of Money
 */

public class Money {

    private double amount;
    private CurrencyTypes currencyType;

    public Money() {
        amount = 0.0;
        currencyType = CurrencyTypes.Usd;
    }

    public Money(double amt, CurrencyTypes curType) {
        amount = amt;
        currencyType = curType;
    }

    public double getAmount()
    {
        return amount;
    }

    public CurrencyTypes getCurrencyType()
    {
        return currencyType;
    }

    public void add(Money otherMoney) {
        Money convertedMoney = Teller.getInstance().convertToCurrency(otherMoney, currencyType);
        amount += convertedMoney.getAmount();
    }

    public void subtract(Money otherMoney) {
        Money convertedMoney = Teller.getInstance().convertToCurrency(otherMoney, currencyType);
        amount -= convertedMoney.getAmount();
    }

    public void multiply(Money otherMoney) {
        Money convertedMoney = Teller.getInstance().convertToCurrency(otherMoney, currencyType);
        amount *= convertedMoney.getAmount();
    }
}