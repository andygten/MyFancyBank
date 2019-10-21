/**
 * @file Keyboard.java
 * @brief Keyboard Gui representation for user input
 * @author Andrew Gieraltowski
 */
package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Keyboard extends JPanel {

    // Static Variables
    //public static String[] keyBoardInput;     ///< Pin Pad Input
    public static boolean newInput = false;
    private static final int NUM_KEYBOARD_ROWS = 5;
    private static final int NUM_KEYBOARD_COLS = 14;
    private static final int MAX_KEYBOARD_BUTTONS = (NUM_KEYBOARD_COLS * NUM_KEYBOARD_ROWS);
    private static final int MAX_INPUT_LENGTH = 64;
    private static final int MAX_KEYBOARD_INPUT = 2048;
    private static final String[] keyboadList =
            {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "backspace",
             "tab", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "|",
             "caps", "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "enter", " ",
             "shift", "z", "x", "c", "v", "b", "n", "m", ",", ".", "/", "shift", " ", " ",
             "ctrl", "fn", "start", "alt", "space", "alt", "fn", "ctrl", " ", " ", " ", " ", " ", " "};

    private static final String[] shiftedKeyboadList =
            {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "backspace",
             "tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|",
             "caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "enter", " ",
             "shift", "Z", "X", "C", "V", "B", "N", "M", "<", ">", "?", "shift", " ", " ",
             "ctrl", "fn", "start", "alt", "space", "alt", "fn", "ctrl", " ", " ", " ", " ", " ", " "};

    public static ArrayList<String> keyBoardInput = new ArrayList<String>(MAX_KEYBOARD_INPUT);


    // Members
    protected JButton[] buttons;            ///< Collection of buttons that make up a keyboard
    protected JButton[] shiftedButtons;     ///< Collection of buttons that make up a keyboard
    private JPanel keyboardPanel;           ///< Panel Comprised of Keyboard buttons
    private JPanel shiftedkeyboardPanel;    ///< Panel Comprised of Shifted Keyboard buttons
    public  JPanel Container;           ///< Contains the Pin Pad Panel and formats it
    private int keyboardInputLen = 0;


    public Keyboard()
    {
        keyboardPanel = new JPanel();
        shiftedkeyboardPanel = new JPanel();
        Container = new JPanel(new BorderLayout());
        keyboardPanel.setLayout(new GridLayout(NUM_KEYBOARD_ROWS, NUM_KEYBOARD_COLS));
        buttons = new JButton[MAX_KEYBOARD_BUTTONS];
        shiftedButtons = new JButton[MAX_KEYBOARD_BUTTONS];

        for (int iii = 0; iii < MAX_KEYBOARD_BUTTONS ; iii++)
        {
            buttons[iii] = new JButton("" + (keyboadList[iii]));
            shiftedButtons[iii] = new JButton("" + (shiftedKeyboadList[iii]));
            keyboardPanel.add(buttons[iii]);
            shiftedkeyboardPanel.add(shiftedButtons[iii]);
        }

        Container.add(keyboardPanel, BorderLayout.CENTER);
    }

    protected void addKeyBoardListener()
    {
        for(JButton jButton : buttons)
        {
            jButton.addActionListener(new keyBoardListener());
        }
        setNewInput(true);
    }

    protected void shift()
    {
        Container.remove(keyboardPanel);
        Container.add(shiftedkeyboardPanel);
        Container.revalidate();
    }

    protected void deShift()
    {
        Container.remove(shiftedkeyboardPanel);
        Container.add(keyboardPanel);
        Container.revalidate();
    }

    class keyBoardListener extends Keyboard implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton button = (JButton)e.getSource();
            keyboardInput(button.getText());
            setNewInput(true);
            System.out.println("KeyBoard Button Pressed: " + button.getText());
        }
    }

    public void keyboardInput(String input)
    {
        System.out.println("Keyboard input added[" + keyboardInputLen + "] : " + input );
        keyBoardInput.add(input);
        keyboardInputLen++;
    }

    public ArrayList<String> getKeyBoardInput()
    {
        return keyBoardInput;
    }

    public void setNewInput(boolean newInput)
    {
        this.newInput = newInput;
    }
}
