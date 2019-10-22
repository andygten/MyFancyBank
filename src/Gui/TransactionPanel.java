package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TransactionPanel extends JPanel {
    private JLabel withdrawLbl;
    private JLabel depositLbl;
    private JLabel loanLbl;
    private JTextField withdrawTf;
    private JTextField depositTf;
    private JTextField loanTf;
    public RequestButton withdrawRequest;
    public RequestButton depositRequest;
    public RequestButton loanRequest;

    private static final int GAP = 5;
    private static final int MAX_ACCOUNT_ID_CHARS = 20;
    private static final int MAX_PASSWORD_CHARS = 32;
    private static final int GRID_COLS = 12;
    private static final int GRID_ROWS = 12;

    public TransactionPanel() {
        this(new Dimension(1, 1), new Rectangle(0, 0));
    }

    public TransactionPanel(Dimension dim, Rectangle rect) {
        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        this.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        withdrawLbl = new JLabel("Withdraw: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(withdrawLbl, cs);

        withdrawTf = new JTextField(MAX_ACCOUNT_ID_CHARS);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(withdrawTf, cs);

        withdrawRequest = new RequestButton();
        cs.gridx = 2;
        cs.gridy = 0;
        cs.gridwidth = 1;
        withdrawRequest.addEventHandler();
        add(withdrawRequest, cs);

        depositLbl = new JLabel("Deposit: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(depositLbl, cs);

        depositTf = new JTextField(MAX_PASSWORD_CHARS);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(depositTf, cs);

        depositRequest = new RequestButton();
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        depositRequest.addEventHandler();
        add(depositRequest, cs);

        loanLbl = new JLabel("Loan: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(loanLbl, cs);

        loanTf = new JTextField(MAX_PASSWORD_CHARS);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(loanTf, cs);

        loanRequest = new RequestButton();
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 1;
        loanRequest.addEventHandler();
        add(loanRequest);
    }

    public String getWithdrawAmount()
    {
        return withdrawTf.getText();
    }

    public String getDepositAmount()
    {
        return depositTf.getText();
    }

    public String getLoanAmount()
    {
        return loanTf.getText();
    }
}
