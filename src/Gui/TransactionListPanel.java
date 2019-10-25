package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TransactionListPanel extends JPanel {

    private JLabel transactionsLbl;
    private JTable transactionsTable;
    private JScrollPane transactionScrollPane;

    private static String[][] data = {{" ", " ", " "}};

    private static final int GAP = 5;
    private static final int MAX_CHARS = 32;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 8;

    public TransactionListPanel() {
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        transactionsLbl = new JLabel("List of Transactions: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(transactionsLbl, cs);


        String[] cols = {"Account ID", "Transction Type", "Amount"};
        transactionsTable = new JTable(data, cols);
        transactionScrollPane = new JScrollPane(transactionsTable);
        cs.gridx = 0;
        cs.gridy = 1;
        add(transactionScrollPane, cs);
    }


    public void setTransactionsTable(String[][] data)
    {
        // Account ID - Transaction Type - Amount
        GridBagConstraints cs = new GridBagConstraints();
        remove(transactionScrollPane);
        String[] cols = {"Account ID", "Transction Type", "Amount"};
        transactionsTable = new JTable(data, cols);
        transactionScrollPane = new JScrollPane(transactionsTable);
        cs.gridx = 0;
        cs.gridy = 1;
        add(transactionScrollPane, cs);
        add(transactionScrollPane);
        revalidate();
        repaint();
    }
}
