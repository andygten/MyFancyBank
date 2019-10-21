package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButton extends InputButton {

    public BackButton()
    {
        setText("Back");
    }

    public void addEventHandler()
    {
        addActionListener(new backListener());
    }


    class backListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println( "Back button clicked" );
            selected = true;
        }
    }
}
