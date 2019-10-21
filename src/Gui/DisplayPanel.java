/**
 * @file DisplayPanel.java
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
import java.util.ArrayList;

public class DisplayPanel extends JPanel {

    public enum Components {
        YES,
        NO,
        MANAGER,
        CUSTOMER,
        PINPAD,
        KEYBOARD,
        TEXTINPUT,
        OKBUTTON
    }

    // Static
    static private int docLength = 0;
    static private int displayPanelXCoord = 200;
    static private int displayPanelYCoord = 0;
    static private JTextPane textPane;                      ///< Main Text Window
    static private JLabel textLabel;                        ///< Main Text Display
    public static int numActiveButtons = 0;
    public static int MAX_NUM_BUTTONS = 2056;

    // Members
    public ArrayList<JComponent> components;
    public YesButton yesButton;                     ///< Yes Button
    public NoButton noButton;                       ///< No Button
    public ManagerButton managerButton;             ///< Account Selection Button for Managers
    public CustomerButton customerButton;           ///< Account Selection Button for Managers
    public PinPad pinPad;                           ///< Pinpad Object
    public Keyboard keyboard;                       ///< Keyboard Object
    public StyledDocument doc;

    /**
     * @brief No Arg Constructor
     */
    public DisplayPanel(Dimension dimension, Rectangle rectangle) {

        components = new ArrayList<JComponent>(256);

        // Side Buttons
        managerButton = new ManagerButton();
        managerButton.addEventHandler();
        components.add(managerButton);
        customerButton = new CustomerButton();
        customerButton.addEventHandler();
        components.add(customerButton);
        keyboard = new Keyboard();
        keyboard.addKeyBoardListener();
        components.add(keyboard.Container);

        // Inactive at first
        pinPad = new PinPad();
        pinPad.addPinPadListener();
        yesButton = new YesButton();
        yesButton.addEventHandler();
        noButton = new NoButton();
        noButton.addEventHandler();

        // Main Text
        textPane = new JTextPane();
        textPane.setSize(dimension);
        textPane.setBounds(rectangle);
        textPane.setLocation(displayPanelXCoord, displayPanelYCoord);
        textPane.setEditable(false);
        textPane.setBackground(this.getBackground());
        doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        textPane.setVisible(true);
        add(textPane);
    }

    public DisplayPanel() {
        this(new Dimension(200, 200), new Rectangle(400, 0, 500, 200));
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
        //textPane.setText(input);
        add(textPane);
    }

    /**
     * @param input: String to be appended
     * @brief Append Text to the TextPane object
     */
    public void appendText(String input) {
        System.out.println("input: " + input);
       try
       {
            doc.insertString(doc.getLength(), input, null);
       } catch(BadLocationException exc)
       {
            exc.printStackTrace();
       }

        //textPane.setText(input);
        add(textPane);
       revalidate();
    }

    public void displayPin(String[] PIN) {
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        try {
            doc.insertString(docLength, "*", null);
        } catch (BadLocationException ble) {
            System.err.println("Bad Location Exception");
        }

        docLength = doc.getLength();
        add(textPane);
    }

    public void clearText()
    {
        textPane.setText(null);

        add(textPane);
    }

    public void CreateDisplay(Components[] comp)
    {
        for (Components Comp : comp)
        {
            switch (Comp)
            {
                case YES:
                    add(yesButton);
                    components.add(yesButton);
                    break;

                case NO:
                    add(noButton);
                    components.add(noButton);
                    break;

                case MANAGER:
                    add(managerButton);
                    components.add(managerButton);
                    break;

                case CUSTOMER:
                    add(customerButton);
                    components.add(customerButton);
                    break;

                case PINPAD:
                    add(pinPad);
                    components.add(pinPad);
                    break;

                case KEYBOARD:
                    add(keyboard.Container);
                    components.add(keyboard.Container);
                    break;
            }
        }
    }
}
