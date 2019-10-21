/**
 * @file Record.java
 * @brief Transaction and Account History of all the transactions taken place during the session
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */

public class Record {

    // Static Variables
    private static int MAX_NUM_OF_SUPPORTED_ACCOUNTS = 8192;
    private static int MAX_NUM_OF_SUPPORTED_TRANSACTIONS = 65536;

    // Members
    private Account[] accounts;
    private Transaction[] transactions;
    private int numAccounts;
    private int numTransactions;

    public Record ()
    {
        accounts = new Account[MAX_NUM_OF_SUPPORTED_ACCOUNTS];
        transactions = new Transaction[MAX_NUM_OF_SUPPORTED_TRANSACTIONS];

        numAccounts = 0;
        numTransactions = 0;
    }

    private Account[] getAccounts()
    {
        return accounts;
    }

    private Transaction[] getTransactions()
    {
        return transactions;
    }

    private void addAccount(Account account)
    {
        accounts[numAccounts] = account;
        numAccounts++;
    }

    private void addTransaction(Transaction transaction)
    {
        transactions[numTransactions] = transaction;
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
