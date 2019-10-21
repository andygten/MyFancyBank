/**
 * @file ManagerButton.java
 * @brief Specific Implementation for a logic button of type Manager
 * @date 10/18/19
 * @author Andrew Gieraltowski
 */

package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerButton extends InputButton {

    public ManagerButton()
    {
        setText("Manager");
    }

    public void addEventHandler()
    {
        addActionListener(new managerListener());
    }


    class managerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println( "Manager button clicked" );
            selected = true;
        }
    }
}
