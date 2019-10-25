package Gui;

import java.awt.*;

public class TransactionListInputPanel extends InputPanel {


    TransactionListInputPanel() {
        add(transactionListPanel);
        add(backButton, BorderLayout.SOUTH);
    }
}
