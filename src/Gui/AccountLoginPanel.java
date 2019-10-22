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
    private JTextField accountIdTf;
    private JTextField passwordTf;
    public LoginButton loginButton;
    public BackButton backButton;

    private static final int GAP = 5;
    private static final int MAX_ACCOUNT_ID_CHARS = 20;
    private static final int MAX_PASSWORD_CHARS = 32;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 3;

    public AccountLoginPanel() {

        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        this.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));

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

        loginButton = new LoginButton();
        loginButton.addEventHandler();
        add(loginButton);
    }

    public ArrayList<String> getTextData() {
        ArrayList<String> strings = new ArrayList<String>(GRID_ROWS);
        strings.add(accountIdTf.getText());
        strings.add(passwordTf.getText());

        accountIdTf.setText("");
        passwordTf.setText("");

        return strings;
    }
}
