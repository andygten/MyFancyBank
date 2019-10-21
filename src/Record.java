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

    // Members
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

    private ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    private ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
        numAccounts++;
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

    private void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
        numTransactions++;
    }

    private int getNumAccounts()
    {
        return numAccounts;
    }

    private int getNumTransactions()
    {
        return numTransactions;
    }

}
