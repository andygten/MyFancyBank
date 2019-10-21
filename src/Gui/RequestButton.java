/**
 * @file RequestButton.java
 * @brief Button designed for making requests
 */

package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestButton extends InputButton {

    public RequestButton()
    {
        setText("Request");
    }

    public void addEventHandler()
    {
        addActionListener(new requestListener());
    }

    class requestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println( "Request button clicked" );
            selected = true;
        }
    }
}
