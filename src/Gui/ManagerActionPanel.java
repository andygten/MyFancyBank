package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ManagerActionPanel extends JPanel {

    private JLabel accountIdLbl;
    private JLabel passwordLbl;
    private JLabel firstNameLbl;
    private JLabel middleNameLbl;
    private JLabel lastNameLbl;
    private JLabel initialDepositLbl;
    private JLabel accountTypeLbl;
    private JTextField accountIdTf;
    private JTextField passwordTf;
    private JTextField firstNameTf;
    private JTextField middleNameTf;
    private JTextField lastNameTf;
    private JTextField initialDepositTf;
    private JTextField accountTypeTf;

    private ArrayList<String> textData;

    public CreateButton createBtn;

    private static final int GAP = 5;
    private static final int MAX_CHARS = 32;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 8;

    public ManagerActionPanel()
    {
        this(new Dimension(1,1), new Rectangle(0, 0));
    }

    public ManagerActionPanel(Dimension dim, Rectangle rect) {
        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        this.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));

        textData = new ArrayList<String>(GRID_ROWS);

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

        createBtn = new CreateButton();
        createBtn.addEventHandler();
        add(createBtn);
    }

}
