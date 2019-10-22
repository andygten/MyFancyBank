package Gui;

import java.awt.*;

public class TransactionInputPanel extends InputPanel {

    public TransactionInputPanel()
    {
        add(transactionPanel, BorderLayout.CENTER);
        add(textPane, BorderLayout.NORTH);
        add(backButton, BorderLayout.SOUTH);
    }
}
