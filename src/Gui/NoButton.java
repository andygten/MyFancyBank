package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoButton extends SideButton {

    public NoButton()
    {
        setText("No");
        isActive = true;
    }

    public void addEventHandler()
    {
        addActionListener(new noListener());
    }

    class noListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("No button clicked");
            selected = true;
        }
    }

}
