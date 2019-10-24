package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class AccountCreatePanel extends JPanel {
    private JLabel accountIdLbl;
    private JLabel passwordLbl;
    private JLabel firstNameLbl;
    private JLabel middleNameLbl;
    private JLabel lastNameLbl;
    private JLabel initialDepositLbl;
    private JLabel accountTypeLbl;
    private JLabel currencyTypeLbl;
    private JTextField accountIdTf;
    private JTextField passwordTf;
    private JTextField firstNameTf;
    private JTextField middleNameTf;
    private JTextField lastNameTf;
    private JTextField initialDepositTf;
    private JTextField accountTypeTf;
    private JTextField currencyTypeTf;


    public CreateButton createBtn;

    private static final int GAP = 5;
    private static final int MAX_CHARS = 32;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 9;

    public AccountCreatePanel()
    {
        this(new Dimension(1,1), new Rectangle(0, 0));
    }

    public AccountCreatePanel(Dimension dim, Rectangle rect) {
        this.setLayout(new GridLayout(GRID_ROWS,GRID_COLS));
        this.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        accountIdLbl = new JLabel("Phone Number/Account ID: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountIdLbl, cs);

        accountIdTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountIdTf, cs);

        passwordLbl = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(passwordLbl, cs);

        passwordTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(passwordTf, cs);

        firstNameLbl = new JLabel("First Name: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        add(firstNameLbl, cs);

        firstNameTf = new JTextField(MAX_CHARS);
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
        cs.gridx = 1;
        cs.gridy = 4;
        cs.gridwidth = 1;
        add(lastNameTf, cs);

        initialDepositLbl = new JLabel("Initial Deposit: ");
        cs.gridx = 0;
        cs.gridy = 5;
        cs.gridwidth = 1;
        add(initialDepositLbl, cs);

        initialDepositTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 5;
        cs.gridwidth = 1;
        add(initialDepositTf, cs);

        accountTypeLbl = new JLabel("Account Type(Checking/Savings): ");
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(accountTypeLbl, cs);

        accountTypeTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 6;
        cs.gridwidth = 1;
        add(accountTypeTf, cs);

        currencyTypeLbl = new JLabel("Currency Type(usd,euro,can): ");
        cs.gridx = 0;
        cs.gridy = 7;
        cs.gridwidth = 1;
        add(currencyTypeLbl, cs);

        currencyTypeTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 7;
        cs.gridwidth = 1;
        add(currencyTypeTf, cs);

        createBtn = new CreateButton();
        createBtn.addEventHandler();
        add(createBtn, cs);
    }

    public ArrayList<String> getTextData()
    {

        ArrayList<String> textData = new ArrayList<String>(GRID_ROWS);

        if (accountIdTf.getText() != null) {
            textData.add(accountIdTf.getText());
        }
        else
        {
            textData.add("");
        }
        if (passwordTf.getText() != null)
        {
            textData.add(passwordTf.getText());
        }
        else
        {
            textData.add("");
        }
        if (firstNameTf.getText() != null)
        {
            textData.add(firstNameTf.getText());
        }
        else
        {
            textData.add("");
        }
        if (middleNameTf.getText() != null)
        {
            textData.add(middleNameTf.getText());
        }
        else
        {
            textData.add("");
        }
        if (lastNameTf.getText() != null)
        {
            textData.add(lastNameTf.getText());
        }
        else
        {
            textData.add("");
        }
        if (initialDepositTf.getText() != null)
        {
            textData.add(initialDepositTf.getText());
        }
        else
        {
            textData.add("0.00");
        }
        if (accountTypeTf != null)
        {
            textData.add(accountTypeTf.getText());
        }
        else
        {
            textData.add("");
        }
        if (currencyTypeTf != null)
        {
            textData.add(currencyTypeTf.getText());
        }
        else
        {
            textData.add("");
        }

        accountIdTf.setText("");
        passwordTf.setText("");
        firstNameTf.setText("");
        middleNameTf.setText("");
        lastNameTf.setText("");
        initialDepositTf.setText("");
        accountTypeTf.setText("");
        currencyTypeTf.setText("");

        return textData;
    }
}
