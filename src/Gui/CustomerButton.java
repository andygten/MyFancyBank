/**
 * @file CustomerButton.java
 * @brief Specific Implementation for the logic button Customer
 * @date 10/18/19
 * @author Andrew Gieraltowski
 */
package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerButton extends InputButton {

    public CustomerButton()
    {
        setText("Customer");
    }

    public void addEventHandler()
    {
        addActionListener(new customerListener());
    }

    class customerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            selected = true;
        }
    }
}
