package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ManagerActionPanel extends JPanel {

    private JLabel accountLookupLbl;
    private JLabel dailyReportLbl;
    private JLabel accountLookupTypeLbl;
    private JLabel earnedAmountLbl;
    private JTextField accountLookupTf;
    private JTextField accountLookupTypeTf;
    private JTextField earnedAmountTf;
    public LookupButton lookupButton;
    public RequestButton requestButton;
    public RequestButton earnedAmountButton;

    private static final int GAP = 5;
    private static final int MAX_CHARS = 32;
    private static final int GRID_COLS = 2;
    private static final int GRID_ROWS = 8;

    public ManagerActionPanel()
    {
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        accountLookupLbl = new JLabel("Account Lookup (ID): ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountLookupLbl, cs);

        accountLookupTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountLookupTf, cs);

        accountLookupTypeLbl = new JLabel("Account Lookup Type (Checking/Savings): ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(accountLookupTypeLbl, cs);

        accountLookupTypeTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(accountLookupTypeTf, cs);

        lookupButton = new LookupButton();
        lookupButton.addEventHandler();
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 2;
        add(lookupButton, cs);

        JLabel dummyLbl1 = new JLabel("");
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        add(dummyLbl1, cs);

        dailyReportLbl = new JLabel("Daily Report: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        add(dailyReportLbl, cs);

        requestButton = new RequestButton();
        requestButton.addEventHandler();
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 2;
        add(requestButton, cs);

        earnedAmountLbl = new JLabel("Manager Earned: ");
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(earnedAmountLbl, cs);

        earnedAmountTf = new JTextField();
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(earnedAmountTf, cs);

        earnedAmountButton = new RequestButton();
        earnedAmountButton.addEventHandler();
        cs.gridx = 2;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(earnedAmountButton, cs);
    }

    public ArrayList<String> getAccountRequestID()
    {
        ArrayList<String> strings = new ArrayList<String>(GRID_ROWS);
        strings.add(accountLookupTf.getText());
        strings.add(accountLookupTypeTf.getText());
        return strings;
    }

    public void setEarnedAmount(String amount)
    {
        earnedAmountTf.setText(amount);
    }
}
