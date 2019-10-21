import java.util.Date;

/**
 * @author Andrew Gieraltowski
 * @file BankCard.java
 * @brief Abstract Class that represents all the data contained in all Bank Cards
 * @data 10/17/19
 */

public abstract class BankCard {

    // Members
    private int[] cardNumber;
    private int[] csv;
    private Date date;


    public BankCard(int[] cardNumber, int[] csv, Date date) {
        this.cardNumber = cardNumber;
        this.csv = csv;
        this.date = date;
    }

    /**
     * @brief No Arg Constructor
     */
    public BankCard() {
        this(new int[16], new int[3], new Date());
    }

    /**
     * @return cardNumber
     * @brief Getter: cardNumber
     */
    private int[] getCardNum() {
        return cardNumber;
    }

    /**
     * @return csv
     * @brief Getter: csv
     */
    private int[] getCsv() {
        return csv;
    }

    /**
     * @return date
     * @brief Getter: date
     */
    private Date getDate() {
        return date;
    }

}
