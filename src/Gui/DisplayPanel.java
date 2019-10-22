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

    // Static
    static private int docLength = 0;
    static private int displayPanelXCoord = 200;
    static private int displayPanelYCoord = 0;
    static private JTextPane textPane;                      ///< Main Text Window
    static private JLabel textLabel;                        ///< Main Text Display
    public static int numActiveButtons = 0;
    public static int MAX_NUM_BUTTONS = 48;
    static private int COMPONENT_MAX = 10;

    // Members

    /**
     * @brief No Arg Constructor
     */
    public DisplayPanel(Dimension dimension, Rectangle rectangle) {

    }

    public DisplayPanel() {
        this(new Dimension(200, 200), new Rectangle(400, 0, 500, 200));
    }

    /**
     * @param input: Text to be displayed
     * @brief Allow text to be displayed
     */
    public void displayText(String input) {

    }

    /**
     * @param input: String to be appended
     * @brief Append Text to the TextPane object
     */
    public void appendText(String input) {
    }

    public void clearText()
    {
        textPane.setText(null);

        //add(textPane);
    }

}
