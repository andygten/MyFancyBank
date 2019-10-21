/**
 * @file MainPanel.java
 * @brief GUI Interface Main Panel that holds all other panels
 * @author Andrew Gieraltowski
 * @date 10/13/19
 */
package Gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JFrame {

    // Static Variables
    private static int MAX_FRAME_NUM = 128;
    private static int STARTING_FRAME_NUM = 0;
    private static boolean firstButtonSetDisplayed = true;
    private static int frameTracker = 0;                    ///< Keeps Track of the Execution Frame to Allow BackTracking

    // Members
    //public  DisplayPanel[] displayPanels;                    ///< Collection of displays to filter through
    public DisplayPanel[] displayPanels;
    public DisplayPanel currentPanel;                      ///< Current Display

    /**
     * @brief No Arg Constructor
     */
    public Screen()
    {
        displayPanels = new DisplayPanel[MAX_FRAME_NUM];
        for (int iii = 0; iii < MAX_FRAME_NUM; iii++)
        {
            displayPanels[iii] = new DisplayPanel();
        }
        currentPanel = displayPanels[0];

        add(currentPanel, BorderLayout.CENTER);
        add(currentPanel.customerButton, BorderLayout.EAST);
        add(currentPanel.managerButton, BorderLayout.WEST);
        add(currentPanel.backButton, BorderLayout.SOUTH);
        //add(currentPanel.keyboard.Container, BorderLayout.SOUTH);
    }

    public void nextScreen()
    {
        for (JComponent component : currentPanel.components)
        {
            remove(component);
        }
        remove(currentPanel);
        revalidate();
        frameTracker++;
        currentPanel = displayPanels[frameTracker];
        add(currentPanel, BorderLayout.CENTER);
        for (JComponent component : currentPanel.components)
        {
            if (component.getClass() == CustomerButton.class)
            {
                add(currentPanel.customerButton, BorderLayout.EAST);
            }
            else if (component.getClass() == ManagerButton.class)
            {
                add(currentPanel.managerButton, BorderLayout.WEST);
            }
            else if (component.getClass() == YesButton.class)
            {
                add(currentPanel.yesButton, BorderLayout.EAST);
            }
            else if (component.getClass() == NoButton.class)
            {
                add(currentPanel.noButton, BorderLayout.WEST);
            }
            else if (component.getClass() == PinPad.class)
            {
                add(currentPanel.pinPad, BorderLayout.SOUTH);
            }
            else if (component.getClass() == Keyboard.class)
            {
                //add(currentPanel.keyboard.Container, BorderLayout.SOUTH);
            }
            else if (component.getClass() == BackButton.class)
            {
                add(currentPanel.backButton, BorderLayout.SOUTH);
            }
            else
            {
                //add(currentPanel.keyboard.Container, BorderLayout.SOUTH);
            }
        }
        revalidate();
    }

    public void previousScreen()
    {
        if (frameTracker > 0)
        {
            frameTracker--;
        }
        currentPanel = displayPanels[frameTracker];
        revalidate();
    }

    public static int getFrame()
    {
        return frameTracker;
    }
}
