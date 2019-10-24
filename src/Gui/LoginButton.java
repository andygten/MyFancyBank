/**
 * @File LoginButton.java
 * @brief button that prompts a login
 */
package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButton extends InputButton {

    public LoginButton()
    {
        setText("Login");
    }

    public void addEventHandler()
    {
        addActionListener(new LoginButtonListener());
    }

    class LoginButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            selected = true;
        }
    }
}
