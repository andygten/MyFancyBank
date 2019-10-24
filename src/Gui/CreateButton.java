package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButton extends InputButton {

    public CreateButton()
    {
        setText("Create");
    }

    public void addEventHandler()
    {
        addActionListener(new CreateButtonListener());
    }

    class CreateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            selected = true;
        }
    }
}
