/**
 * @file Name.java
 * @brief Name Object Representation
 * @date 10/17/19
 * @autho Andrew Gieraltowski
 */


public class Name {

    // Static Variables

    // Members
    private String firstName;
    private String middleName;
    private String lastName;

    /**
     * @No Arg Constructor
     */
    public Name()
    {
        this("","","");
    }

    public Name(String firstName, String middleName, String lastName)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    private String getFirstName()
    {
        return firstName;
    }

    private String getMiddleName()
    {
        return middleName;
    }

    private String getLastName()
    {
        return lastName;
    }

    @Override
    public String toString()
    {
        return (""+firstName+ " " + middleName + " " + lastName);
    }
}
