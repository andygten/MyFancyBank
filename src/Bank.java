/**
 * @file Bank.java
 * @brief Abstract Parent Class defining all things related to bank state at a high level
 * @date 10/16/19
 * @author Andrew Gieraltowski
 */

public abstract class Bank {

    static protected Record sessionRecord;
    static protected Manager bankManager;
    static protected Teller teller;

    /**
     * @brief No Arg Constructor for the superclass
     */
    public Bank()
    {
        sessionRecord = new Record();
        bankManager = new Manager();
        teller = new Teller();
    }

}
