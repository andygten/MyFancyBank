package Gui;

import java.awt.*;

public class AccountDecisionPanel extends InputPanel {

    // Static Variables
    static private final String USER_SELECT_TEXT = "Would you like to Login with and Existing Account, Or Create a new one?";

    public AccountDecisionPanel()
    {
        add(loginButton, BorderLayout.WEST);
        add(createButton, BorderLayout.EAST);
        add(backButton, BorderLayout.SOUTH);
        add(textPane, BorderLayout.NORTH);
        displayText(USER_SELECT_TEXT);
    }

}
