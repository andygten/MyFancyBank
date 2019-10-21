/**
 * @file Person.java
 * @brief Abstract Class to represent a Person Object
 * @author Andrew Gieraltoski
 * @date 10/17/19
 */

public class Person {

    // Members
    private Name name;

    public Person(Name name)
    {
        this.name = name;
    }

    public Person()
    {
        this(null);
    }

    /**
     * @brief Getter: name
     * @return name
     */
    protected Name getName()
    {
        return name;
    }

}

