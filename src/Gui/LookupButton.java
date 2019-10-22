package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookupButton extends InputButton {

    public LookupButton()
    {
        setText("Lookup");
    }

    public void addEventHandler()
    {
        addActionListener(new lookupListener());
    }


    class lookupListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println( "Lookup button clicked" );
            selected = true;
        }

    }
}
