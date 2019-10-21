/**
 * @file PinPad.java
 * @brief Gui representation of a Pin Pad which is a collection of buttons 0-9
 * @author Andrew Gieraltowski
 * @date 10/13/19
 */
package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinPad extends JPanel {

    // Static Variables
    static private int PIN_PAD_NUMS = 9;
    static private int MAX_PIN_NUMS = 4;
    static private int PIN_PAD_GRID_ROWS = 4;
    static private int PIN_PAD_GRID_COLS = 4;
    static private int pinPadInputLen = 0;
    static private int pinPadNumsDiplayed = 0;

    // Members
    protected JButton[] buttons;            ///< Collection of buttons that make up a pin pad
    private JPanel PinPadPanel;             ///< Panel Comprised of Pin Pad Buttons
    private String[] pinPadInput;           ///< Pin Pad Input
    private pinPadListener pinPadListener;  ///< Pin Pad Event Listener
    public  JPanel Container;               ///< Contains the Pin Pad Panel and formats it

    /**
     * @brief No Arg Constructor
     */
    public PinPad()
    {
        PinPadPanel = new JPanel();
        Container = new JPanel(new BorderLayout());
        Container.add(new JTextField("Pin Pad"));
        PinPadPanel.setLayout(new GridLayout(PIN_PAD_GRID_ROWS, PIN_PAD_GRID_COLS));
        buttons = new JButton[PIN_PAD_NUMS+3];
        pinPadInput = new String[MAX_PIN_NUMS];

        for (int iii = 0; iii < PIN_PAD_NUMS; iii++)
        {
            buttons[iii] = new JButton("" + (iii+1));
            PinPadPanel.add(buttons[iii]);
        }

        buttons[PIN_PAD_NUMS] = new JButton("0");
        buttons[PIN_PAD_NUMS+1] = new JButton("Clear");
        buttons[PIN_PAD_NUMS+2] = new JButton("Enter");

        PinPadPanel.add(buttons[PIN_PAD_NUMS+1]);
        PinPadPanel.add(buttons[PIN_PAD_NUMS]);
        PinPadPanel.add(buttons[PIN_PAD_NUMS+2]);

        Container.add(PinPadPanel, BorderLayout.CENTER);
    }

    /**
     * @brief Returns the buttons collectively used to create the PinPad
     * @return Buttons array
     */
    protected JButton[] getButtons()
    {
        return buttons;
    }

    protected void addPinPadListener()
    {
        for(JButton jButton : buttons)
        {
            jButton.addActionListener(new pinPadListener());
        }
    }

    /**
     * @brief Keep Track of Input to the PinPad
     */
    protected void pinPadInput(String input)
    {
        if (pinPadInputLen >= MAX_PIN_NUMS && input.compareTo("Clear") != 0)
        {
            System.err.println("MAXIMUM INPUT REACHED");
            return;
        }

        switch (input)
        {
            case "Clear":
                for (int iii = 0; iii < pinPadInputLen; iii++)
                {
                    pinPadInput[iii] = "";
                }
                pinPadInputLen = 0;
                break;
            case "Enter":
                // Call enter function here
                pinPadInputLen = 0;
                break;

            default:
                if (pinPadInputLen < MAX_PIN_NUMS)
                {
                    pinPadInput[pinPadInputLen] = input;
                    pinPadInputLen++;
                }
                break;
        }
    }

    class pinPadListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton button = (JButton)e.getSource();
            pinPadInput(button.getText());
            if (pinPadInputLen > 0 && pinPadNumsDiplayed < MAX_PIN_NUMS) {
                pinPadInput[pinPadInputLen - 1] = button.getText();
                StringBuilder b = new StringBuilder();
                for (int iii = 0; iii < pinPadInputLen; iii++)
                {
                    b.append(String.valueOf(pinPadInput[iii]));
                }
                System.out.println("builder: "+b.toString());

                //appendText(b.toString());
                pinPadNumsDiplayed++;
            }
            else if (pinPadInputLen == 0)
            {
               //DisplayPanel.clearText();
            }

            System.out.println("Num Pad Clicked: " + button.getText());
        }
    }

    public String[] getPin()
    {
        return pinPadInput;
    }

    public static int getPinLength()
    {
        return pinPadInputLen;
    }
}
