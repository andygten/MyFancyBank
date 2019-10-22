package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AccountInfoPanel extends JPanel {

    private JLabel accountIdLbl;
    private JLabel firstNameLbl;
    private JLabel middleNameLbl;
    private JLabel lastNameLbl;
    private JLabel balanceLbl;
    private JLabel accountTypeLbl;
    private JTextField accountIdTf;
    private JTextField firstNameTf;
    private JTextField middleNameTf;
    private JTextField lastNameTf;
    private JTextField balanceTf;
    private JTextField accountTypeTf;

    private static final int GAP = 5;
    private static final int MAX_CHARS = 32;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 8;

    public AccountInfoPanel() {
        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        this.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        accountIdLbl = new JLabel("Phone Number/Account ID: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountIdLbl, cs);

        accountIdTf = new JTextField(MAX_CHARS);
        accountIdTf.setEditable(false);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountIdTf, cs);

        firstNameLbl = new JLabel("First Name: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        add(firstNameLbl, cs);

        firstNameTf = new JTextField(MAX_CHARS);
        firstNameTf.setEditable(false);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        add(firstNameTf, cs);

        middleNameLbl = new JLabel("Middle Name: ");
        cs.gridx = 0;
        cs.gridy = 3;
        cs.gridwidth = 1;
        add(middleNameLbl, cs);

        middleNameTf = new JTextField(MAX_CHARS);
        middleNameTf.setEditable(false);
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 1;
        add(middleNameTf, cs);

        lastNameLbl = new JLabel("Last Name: ");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 1;
        add(lastNameLbl, cs);

        lastNameTf = new JTextField(MAX_CHARS);
        lastNameTf.setEditable(false);
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 1;
        add(lastNameTf, cs);

        balanceLbl = new JLabel("Balance:  ");
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        add(balanceLbl, cs);

        balanceTf = new JTextField(MAX_CHARS);
        balanceTf.setEditable(false);
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 1;
        add(balanceTf, cs);

        accountTypeLbl = new JLabel("Account Type(Checking/Savings): ");
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(accountTypeLbl, cs);

        accountTypeTf = new JTextField(MAX_CHARS);
        accountTypeTf.setEditable(false);
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(accountTypeTf, cs);
    }

    public void setData(String accountId, String firstName, String middleName, String lastName, double Balance, String accountType)
    {
        accountIdTf.setText(accountId);
        accountIdTf.setVisible(true);
        firstNameTf.setText(firstName);
        middleNameTf.setText(middleName);
        lastNameTf.setText(lastName);
        balanceTf.setText(Double.toString(Balance));
        accountTypeTf.setText(accountType);
        revalidate();
        repaint();
    }
}
