/**
 * @file MainPanel.java
 * @brief GUI Interface Main Panel that holds all other panels and keeps track of their display order
 * @author Andrew Gieraltowski
 * @date 10/13/19
 */
package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Screen extends JFrame {

    public enum ScreenState {
        UserSelect(0),
        ManagerAction(1),
        RequestReport(2),
        LoginCreate(3),
        LoginState(4),
        CreateState(5),
        UserActionState(6),
        AccountInfoState(7),
        ProgramExit(8);

        private int value;

        private ScreenState(int value)
        {
            this.value = value;
        }
    }

    // Static Variables
    static private final int MAX_STATES = 9;

    // Members
    public ArrayList<InputPanel> inputPanels;
    public InputPanel currentPanel;                      ///< Current Display
    public Stack<ScreenState> screenStates;

    /**
     * @brief No Arg Constructor
     */
    public Screen()
    {
        inputPanels = new ArrayList<InputPanel>(MAX_STATES);
        screenStates = new Stack<>();
        inputPanels.add(new UserSelectPanel());
        inputPanels.add(new ManagerInputPanel());
        inputPanels.add(new ManagerInputPanel());
        inputPanels.add(new AccountDecisionPanel());
        inputPanels.add(new AccountLoginInputPanel());
        inputPanels.add(new AccountCreateInputPanel());
        inputPanels.add(new TransactionInputPanel());
        inputPanels.add(new AccountInfoInputPanel());

        currentPanel = inputPanels.get(0);
    }

    /**
     * @brief Move the state of the screen
     */
    public void nextScreen(ScreenState screenState)
    {
        getContentPane().remove(currentPanel);
        revalidate();
        currentPanel = inputPanels.get(screenState.value);
        screenStates.push(screenState);
        add(currentPanel);
        invalidate();
        revalidate();
        repaint();
    }

    /**
     * @brief traverse the screen stack and display
     * @return
     */
    public ScreenState previousScreen()
    {
        getContentPane().remove(currentPanel);
        revalidate();
        screenStates.pop();
        ScreenState state = screenStates.peek();
        currentPanel = inputPanels.get(state.value);
        add(currentPanel);
        invalidate();
        revalidate();
        repaint();
        return state;
    }
}
