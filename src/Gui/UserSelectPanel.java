package Gui;

import javax.swing.border.Border;
import java.awt.*;

public class UserSelectPanel extends InputPanel {

    // Static Variables
    static private final String USER_SELECT_TEXT = "Hello, Welcome to MyFancyBank! Are you a Customer or Manager?";

    public UserSelectPanel()
    {
        add(managerButton, BorderLayout.WEST);
        add(customerButton, BorderLayout.EAST);
        add(textPane, BorderLayout.NORTH);
        displayText(USER_SELECT_TEXT);
    }
}
