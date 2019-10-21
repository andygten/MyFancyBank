/**
 * @file Customer.java
 * @brief Object Representation of a Bank Customer
 * @author Andrew Gieraltowski
 * @data 10/17/19
 */
public class Customer extends Person {

    // Members
    private Account account;        ///< Account Associated With Customer

    /**
     * @brief No Arg Constructor
     */
    public Customer()
    {
        this(new Account());
    }

    /**
     * @brief Single Arg Constructor
     * @param account
     */
    public Customer(Account account)
    {
        this.account = account;
    }

}
