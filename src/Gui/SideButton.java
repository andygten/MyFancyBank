/**
 * @file SideButton.java
 * @brief Abstract class that represents the individual buttons meant to be displayed on the sides and
 *        used for logical choices
 * @date 10/17/19
 * @author Andrew Gieraltowski
 */

package Gui;

import javax.swing.*;

public abstract class SideButton extends JButton {

    // Members
    protected boolean selected;
    protected boolean isActive;

    public SideButton()
    {
        selected = false;
        isActive = false;
    }

    public boolean isButtonSelected()
    {
        return selected;
    }

    public void reset()
    {
        selected = false;
        isActive = false;
    }

    public void setActive()
    {
        isActive = true;
    }

    public abstract void addEventHandler();


}
