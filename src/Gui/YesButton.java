package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YesButton extends InputButton {

    public YesButton()
    {
        setText("Yes");
    }

    public void addEventHandler()
    {
        addActionListener(new yesListener());
    }

    class yesListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            System.out.println( "Yes button clicked" );
            selected = true;
        }
    }
}
