package Gui;

import java.awt.*;

public class AccountLoginInputPanel extends InputPanel {

    public AccountLoginInputPanel()
    {
        add(accountLoginPanel);
        add(backButton, BorderLayout.SOUTH);
        add(textPane, BorderLayout.NORTH);
    }
}
