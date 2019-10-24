/**
 * @file Account.java
 * @brief Represents the Account of a Customer or Manager
 * @author Andrew Gieraltowski
 * @date 10/17/19
 */

public class Account {

    // Static Variables
    private static final double ACCOUNT_OPENING_BONUS = 50;

    enum AccountType {
        CHECKING,
        SAVINGS
    }

    public enum AccountIDX {
        ACCOUNTID(0),
        PASSWORD(1),
        FIRSTNAME(2),
        MIDDLENAME(3),
        LASTNAME(4),
        ACCOUNT_TYPE(5),
        BALANCE(6);

        public int value;

        private AccountIDX(int value)
        {
            this.value = value;
        }
    }

    // Members
    private String password;
    private String accountID;
    private Name name;
    private Money balance;
    private AccountType accountType;
    private Loan loan;


    public Account(String accountID, String password, Name name, String balance, AccountType accountType) {
        this.accountID = accountID;
        this.name = name;
        this.password = password;
        if (balance.compareTo("") != 0) {
            this.balance = new Money(Double.parseDouble(balance), CurrencyTypes.Usd);
        }
        else
        {
            this.balance = new Money(ACCOUNT_OPENING_BONUS, CurrencyTypes.Usd);
        }
        this.accountType = accountType;
        loan = new Loan();
    }

    /**
     * @brief No Arg Constructor
     */
    public Account() {
        this("", "", new Name("", "", ""), "0.00", AccountType.SAVINGS);
    }

    /**
     * @brief 2 Arg Constructor for determining if Accounts exist in Record
     */
    public Account(String accountID, String password, AccountType accountType)
    {
        this(accountID, password, new Name("", "", ""), "0.00", accountType);
    }

    /**
     * @param amount: Amount to add
     * @brief Add to Balance of account
     */
    protected void addBalance(Money amount) {
        balance.add(amount);
    }

    /**
     * @param amount to Deposit
     * @brief deposit money into the account
     */

    /**
     * @param amount: Amount to deduct
     * @brief Deduct Balance from account
     */
    protected void deductBalance(Money amount) {
        balance.subtract(amount);
    }


    /**
     * @param amount: Amount to add to loan
     * @brief add loan
     */
    protected void addLoan(Money amount)
    {
        loan.addToLoan(amount);
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
    public String getAccountID() {
        return accountID;
    }

    public AccountType getAccountType()
    {
        return  accountType;
    }

    public Name getName()
    {
        return name;
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
                (account.password.compareTo(password) == 0) &&
                (account.accountType.toString().compareToIgnoreCase(accountType.toString()) == 0));
    }
}
