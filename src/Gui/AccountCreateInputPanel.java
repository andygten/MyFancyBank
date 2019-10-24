package Gui;

import java.awt.*;

public class AccountCreateInputPanel extends InputPanel {

    public AccountCreateInputPanel()
    {
        add(accountCreatePanel);
        add(backButton, BorderLayout.SOUTH);
        add(textPane, BorderLayout.NORTH);
    }
}
