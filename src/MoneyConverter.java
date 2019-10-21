/**
 * @file Teller.java
 * @brief The Teller is reponsible for converting and processing money transactions within the bank
 */

public final class MoneyConverter {

    private static final CurrencyTypes DEFAULT_CURRENCY_TYPE = CurrencyTypes.Usd;

    private static MoneyConverter moneyConverter = null;

    public static MoneyConverter getInstance() {
        if (moneyConverter == null) {
            moneyConverter = new MoneyConverter();
        }
        return moneyConverter;
    }

    public MoneyConverter() {}

    public Money convertToCurrency(Money money, CurrencyTypes currencyType) {
        // If we're already converted, return
        if (money.getCurrencyType() == currencyType) {
            return money;
        }

        // Convert to common, default currency
        Money defaultMoney = convertToDefaultCurrency(money);

        // If the default type is the desired currency, return
        if (defaultMoney.getCurrencyType() == DEFAULT_CURRENCY_TYPE) {
            return defaultMoney;
        }

        double startingAmt = money.getAmount();
        double targetAmt = 0.0;

        // Convert to from the default currency to the desired
        switch (currencyType) {
            case Euro:
                targetAmt = startingAmt * 0.90;
                break;

            case Cad:
                targetAmt = startingAmt * 1.13;
                break;

            default:
                targetAmt = startingAmt;
                break;
        }

        return new Money(targetAmt, currencyType);
    }

    private Money convertToDefaultCurrency(Money money) {
        if (money.getCurrencyType() == DEFAULT_CURRENCY_TYPE) {
            return money;
        }

        double startingAmt = money.getAmount();
        double targetAmt = 0.0;

        switch (money.getCurrencyType()) {
            case Euro:
                targetAmt = startingAmt * 1.12;
                break;

            case Cad:
                targetAmt = startingAmt * 0.76;
                break;

            default:
                targetAmt = startingAmt;
                break;
        }

        return new Money(targetAmt, DEFAULT_CURRENCY_TYPE);
    }
}