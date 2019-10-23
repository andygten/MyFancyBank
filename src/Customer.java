import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @file Customer.java
 * @brief Object Representation of a Bank Customer
 * @author Andrew Gieraltowski
 * @data 10/17/19
 */
public class Customer extends Person {

    // Static Variables
    private static final int MAX_NUM_ACCOUNTS = 5;

    // Members
    private String customerID;
    private ArrayList<Account> accounts;


    /**
     * @brief No Arg Constructor
     */
    public Customer()
    {
        this("");
    }

    /**
     * @brief Single Arg Constructor
     * @param customerID
     */
    public Customer(String customerID)
    {
        accounts = new ArrayList<Account>(MAX_NUM_ACCOUNTS);
        this.customerID = customerID;
    }

    /**
     * @brief Add account to customer in record
     */
    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Customer customer = (Customer) obj;

        return (customerID.compareTo(customer.customerID) == 0);
    }
}
