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

    // Members
    private String password;
    private String accountID;
    private Name name;
    private Money balance;
    private AccountType accountType;
    private Withdraw withdraw;
    private Deposit deposit;
    private Loan loan;
    private boolean isLoggedIn;


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
        withdraw = new Withdraw(this);
        deposit = new Deposit( this);
        isLoggedIn = false;
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
    protected void deposit(Money amount)
    {
        deposit.perform(amount);
    }

    /**
     * @param amount to withdraw
     * @brief withdraw money from account
     */
    protected void withdraw(Money amount)
    {
        withdraw.perform(amount);
    }

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

    /**
     * @brief Setter: isLoggedIn
     * @return True or false
     */
    public void setLoggedIn(boolean loggedIn)
    {
        isLoggedIn = loggedIn;
    }

    public AccountType getAccountType()
    {
        return  accountType;
    }

    /**
     * @brief Getter: isLoggedIn
     * return isLoggedIn
     */
    public boolean getLoggedIn()
    {
        return isLoggedIn;
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
