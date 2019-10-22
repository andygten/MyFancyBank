package Gui;

import java.awt.*;

public class ManagerInputPanel extends InputPanel {

    // Static Variables

    public ManagerInputPanel()
    {
        add(managerActionPanel);
        add(backButton, BorderLayout.SOUTH);
    }
}
