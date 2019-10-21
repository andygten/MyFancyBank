/**
 * @file Account.java
 * @brief Represents the Account of a Customer or Manager
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public abstract class Account {

    enum AccountType {
        CHECKING,
        SAVINGS
    }

    // Members
    private String password;
    private String accountID;
    private Name name;
    private Money balance;
    private AccountType accountType;


    public Account(String accountID, String password, Name name, String balance, AccountType accountType) {
        this.accountID = accountID;
        this.name = name;
        this.password = password;
        this.balance = new Money(Double.parseDouble(balance), CurrencyTypes.Usd);
        this.accountType = accountType;
    }

    /**
     * @brief No Arg Constructor
     */
    public Account() {
        this("", "", new Name("", "", ""), "0.00", AccountType.CHECKING);
    }

    /**
     * @brief 2 Arg Constructor for determining if Accounts exist in Record
     */
    public Account(String accountID, String password)
    {
        this(accountID, password, new Name("", "", ""), "0.00", AccountType.CHECKING);
    }

    /**
     * @param amount: Amount to add
     * @brief Add to Balance of account
     */
    protected void addBalance(Money amount) {
        balance.add(amount);
    }

    /**
     * @param amount: Amount to deduct
     * @brief Deduct Balance from account
     */
    protected void deductBalance(Money amount) {
        balance.add(amount);
    }

    /**
     * @return double balance
     * @brief Get Balance of Account
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * @return String
     * @brief Get the ID of the Account
     */
    private String getAccountID() {
        return accountID;
    }

    /**
     * @return String : Password
     * @brief Get the Password of an Account
     */
    private String getPassword() {
        return password;
    }

    public CurrencyTypes getCurrencyPreference()
    {
        return balance.getCurrencyType();
    }


    /**
     * @brief An Account will be determined as equal if there Account ID and Password Are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Account account = (Account) obj;

        return ((account.accountID.compareTo(accountID) == 0) &&
                (account.password.compareTo(password) == 0));
    }
}
