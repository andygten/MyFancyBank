import java.util.ArrayList;

/**
 * @file Record.java
 * @brief Transaction and Account History of all the transactions taken place during the session
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */

public class Record {

    // Static Variables
    private static int MAX_NUM_OF_SUPPORTED_ACCOUNTS = 100;
    private static int MAX_NUM_OF_SUPPORTED_TRANSACTIONS = 100;
    private static String CHECKING_ACCOUNT = "Checking";
    private static String SAVINGS_ACCOUNT = "Savings";

    // Members
    private Account activeAccount;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private int numAccounts;
    private int numTransactions;

    public Record ()
    {
        accounts = new ArrayList<Account>(MAX_NUM_OF_SUPPORTED_ACCOUNTS);
        transactions = new ArrayList<Transaction>(MAX_NUM_OF_SUPPORTED_TRANSACTIONS);
        numAccounts = 0;
        numTransactions = 0;
    }

    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
        numAccounts++;
    }

    public void setActiveAccount(Account account)
    {
        activeAccount = account;
    }

    public Account getActiveAccount()
    {
        return activeAccount;
    }

    public Account getAccount(String accountID, String accountType)
    {
        String thisAccountType = accountType;
        if (thisAccountType.compareToIgnoreCase(SAVINGS_ACCOUNT) != 0) {
            // Default to Checking
            thisAccountType = CHECKING_ACCOUNT;
        }

        for (Account account : accounts)
        {
            if((account.getAccountID().compareTo(accountID) == 0) &&
               (account.getAccountType().toString().compareToIgnoreCase(thisAccountType)) == 0)
            {
                return account;
            }
        }
        return null;
    }

    /**
     * @brief Verify that an account exists by checking the list for that object
     * @param account Account object to determine if it exists
     * @return
     */
    public boolean verifyAccount(Account account)
    {
        return accounts.contains(account);
    }

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
        numTransactions++;
    }


    public int getNumAccounts()
    {
        return numAccounts;
    }

    public int getNumTransactions()
    {
        return numTransactions;
    }

}
