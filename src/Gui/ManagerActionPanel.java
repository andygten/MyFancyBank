package Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ManagerActionPanel extends JPanel {

    private JLabel accountLookupLbl;
    private JLabel dailyReportLbl;
    private JTextField accountLookupTf;
    private RequestButton requestButton;

    private ArrayList<String> textData;

    private static final int GAP = 5;
    private static final int MAX_CHARS = 32;
    private static final int GRID_COLS = 3;
    private static final int GRID_ROWS = 8;

    public ManagerActionPanel()
    {
        this(new Dimension(GRID_COLS, GRID_ROWS), new Rectangle(0, 0));
    }

    public ManagerActionPanel(Dimension dim, Rectangle rect)
    {
        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        this.setBorder(new EmptyBorder(GAP, GAP, GAP, GAP));

        textData = new ArrayList<String>(GRID_ROWS);

        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        accountLookupLbl = new JLabel("Account Lookup (ID/All): ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountLookupLbl, cs);

        accountLookupTf = new JTextField(MAX_CHARS);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 1;
        add(accountLookupTf, cs);

        dailyReportLbl = new JLabel("Daily Report: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(dailyReportLbl, cs);

        requestButton = new RequestButton();
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 1;
        add(requestButton, cs);
    }
}
