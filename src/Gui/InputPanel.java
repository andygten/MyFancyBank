/**
 * @file InputPanel.java
 * @brief Class responsible for communicating and displaying text conversations to the user
 * @author Andrew Gieraltowski
 * @date 10/13/19
 */



package Gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public abstract class InputPanel extends JPanel {

    // Static Variables
    static private int docLength = 0;
    static private int displayPanelXCoord = 200;
    static private int displayPanelYCoord = 0;

    // Members
    public BackButton backButton;
    public LoginButton loginButton;                     ///< Login Button
    public CreateButton createButton;                   ///< Create Button
    public ManagerButton managerButton;             ///< Account Selection Button for Managers
    public CustomerButton customerButton;           ///< Account Selection Button for Managers
    public LookupButton lookupButton;
    public StyledDocument doc;

    // Panels
    public AccountLoginPanel accountLoginPanel;
    public AccountCreatePanel accountCreatePanel;
    public TransactionPanel transactionPanel;
    public ManagerActionPanel managerActionPanel;
    public AccountInfoPanel accountInfoPanel;
    public JTextPane textPane;                      ///< Main Text Window
    public TransactionListPanel transactionListPanel;

    /**
     * @brief No Arg Constructor
     */
    public InputPanel() {

        // Input Buttons
        managerButton = new ManagerButton();
        managerButton.addEventHandler();
        customerButton = new CustomerButton();
        customerButton.addEventHandler();
        backButton = new BackButton();
        backButton.addEventHandler();
        loginButton = new LoginButton();
        loginButton.addEventHandler();
        createButton = new CreateButton();
        createButton.addEventHandler();
        lookupButton = new LookupButton();
        lookupButton.addEventHandler();

        // Panels
        accountLoginPanel = new AccountLoginPanel();
        transactionPanel = new TransactionPanel();
        managerActionPanel = new ManagerActionPanel();
        accountCreatePanel = new AccountCreatePanel();
        accountInfoPanel = new AccountInfoPanel();
        transactionListPanel = new TransactionListPanel();

        // Layout
        setLayout(new BorderLayout());

        // These were originally part of the design to create a realistic UI
        // Please consider them for bonus points
        //keyboard = new Keyboard();
        //keyboard.addKeyBoardListener();
        //components.add(keyboard.Container);
        //pinPad = new PinPad();
        //pinPad.addPinPadListener();

        // Main Text
        textPane = new JTextPane();
        textPane.setLocation(displayPanelXCoord, displayPanelYCoord);
        textPane.setEditable(false);
        textPane.setBackground(this.getBackground());
        doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        textPane.setVisible(true);
    }

    /**
     * @param input: Text to be displayed
     * @brief Allow text to be displayed
     */
    public void displayText(String input) {

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        try {
            doc.insertString(0, input, null);
        } catch (BadLocationException ble) {
            System.err.println("Bad Location Exception");
        }

        docLength = doc.getLength();
    }

    public void clearText()
    {
        textPane.setText(null);
    }

}
