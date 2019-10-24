/**
 * @file AccountPanel.java
 * @brief Panel for logging in and creating accounts
 */
package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class AccountLoginPanel extends JPanel {
    private JLabel accountIdLbl;
    private JLabel passwordLbl;
    private JLabel accountTypeLbl;
    private JTextField accountIdTf;
    private JTextField passwordTf;
    private JTextField accountTypeTf;
    public LoginButton loginButton;

    private static final int MAX_ACCOUNT_ID_CHARS = 20;
    private static final int MAX_PASSWORD_CHARS = 32;
    private static final int MAX_ACCOUNT_TYPE_CHARS = 20;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 4;

    public AccountLoginPanel() {

        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        accountIdLbl = new JLabel("Account ID: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountIdLbl, cs);

        accountIdTf = new JTextField(MAX_ACCOUNT_ID_CHARS);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountIdTf, cs);

        passwordLbl = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(passwordLbl, cs);

        passwordTf = new JTextField(MAX_PASSWORD_CHARS);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(passwordTf, cs);

        accountTypeLbl = new JLabel("Account Type (Checking/Savings):");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        add(accountTypeLbl);

        accountTypeTf = new JTextField(MAX_ACCOUNT_TYPE_CHARS);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        add(accountTypeTf);

        loginButton = new LoginButton();
        loginButton.addEventHandler();
        add(loginButton);
    }

    public ArrayList<String> getTextData() {
        ArrayList<String> strings = new ArrayList<String>(GRID_ROWS);
        strings.add(accountIdTf.getText());
        strings.add(passwordTf.getText());
        strings.add(accountTypeTf.getText());

        accountIdTf.setText("");
        passwordTf.setText("");
        accountTypeTf.setText("");

        return strings;
    }
}
