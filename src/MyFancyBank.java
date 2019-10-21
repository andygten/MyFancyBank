import Gui.DisplayPanel;
import Gui.Screen;

import javax.swing.*;

/**
 * @file MyFancyBank.java
 * @brief Specific implementation of the Fancy Bank
 * @date 10/13/19
 * @author Andrew Gieraltowski
 */
public class MyFancyBank extends Bank {

    // Static Variables
    static public Record sessionRecord;
    static public Screen screen;
    static public Account[] accounts;               ///< List of Accounts associated with users
    static public String inputFirstName;            ///< First Name of User
    static public String inputMiddleName;           ///< Middle Name of User
    static public String inputLastName;             ///< Last Name of User
    static public String inputId;
    static public String inputBalance;
    static public String inputPIN;

    public MyFancyBank() {
        super(0);
    }

    public static void main(String[] args) throws InterruptedException {

        sessionRecord = new Record();
        screen = new Screen();

        inputId = new String();
        screen = new Screen();
        screen.setTitle("My Fancy Bank");
        screen.setSize(1000, 600);
        screen.setLocationRelativeTo(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
        screen.currentPanel.displayText("Hello and Welcome to My Fancy Bank! Are you a Manager or a Customer?");

        decideUser();

        int ret = -1;

        while (ret == -1)
        {
            Thread.sleep(100);
            ret = YesorNo();
        }
        if (ret == 0)
        {
            promptLoginInfo();
        }
        else
        {
            promptCreateInfo();
        }


        System.out.println("Exiting Program");
    }

    /**
     * @brief Main execution is often prompted with questions for which we need to wait for an answer
     */
    private static int hasDecisionBeenMade()
    {
        if (screen.currentPanel.managerButton.isButtonSelected() == true)
        {
            // Return 0 for Manager Selection
            return 0;
        }
        else if (screen.currentPanel.customerButton.isButtonSelected() == true)
        {
            // Return 1 for Customer Selection
            return 1;
        }

        return -1;
    }

    /**
     * @brief Determine if Yes or No Button has been pressed
     */
    private static int YesorNo()
    {
       if (screen.currentPanel.yesButton.isButtonSelected() == true)
       {
           return 0;
       }
       else if (screen.currentPanel.noButton.isButtonSelected() == true)
       {
           return 1;
       }

       return -1;
    }

    private static void isBackPressed(String capture)
    {
        if (screen.currentPanel.backButton.isButtonSelected())
        {
            screen.previousScreen();
        }
    }

    private static void promptLoginInfo()
    {
        screen.currentPanel.clearText();
        screen.currentPanel.displayText("OK! Enter your Login Information!");
        DisplayPanel.Components[] Custcomponents = {DisplayPanel.Components.ACCOUNT_LOGIN_PANEL};
        screen.displayPanels[Screen.getFrame()+1].CreateDisplay(Custcomponents);
        screen.nextScreen();
    }

    private static void promptCreateInfo()
    {
        screen.currentPanel.clearText();
        screen.currentPanel.displayText("OK! Enter the prompted information to create an account!");
        DisplayPanel.Components[] Custcomponents = {DisplayPanel.Components.ACCOUNT_CREATE_PANEL};
        screen.displayPanels[Screen.getFrame()+1].CreateDisplay(Custcomponents);
        screen.nextScreen();
    }

    private static void decideUser()
    {
        int ret = -1;
        while (ret == -1)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                System.err.println(e);
            }
            ret = hasDecisionBeenMade();
        }

        switch (ret)
        {
            // Manager was chosen
            case 0:
                System.out.println("Manager was chosen");
                DisplayPanel.Components[] components = {DisplayPanel.Components.YES, DisplayPanel.Components.NO, DisplayPanel.Components.KEYBOARD};
                screen.displayPanels[Screen.getFrame()+1].CreateDisplay(components);
                screen.nextScreen();
                screen.currentPanel.clearText();
                screen.currentPanel.displayText("Hello Manager! Do you already have an account?");
                break;

            // Customer was chosen
            case 1:
                System.out.println("Customer was chosen");
                DisplayPanel.Components[] Custcomponents = {DisplayPanel.Components.YES, DisplayPanel.Components.NO, DisplayPanel.Components.KEYBOARD};
                screen.displayPanels[Screen.getFrame()+1].CreateDisplay(Custcomponents);
                screen.nextScreen();
                screen.currentPanel.clearText();
                screen.currentPanel.displayText("Hello Customer! Do you already have an account?");
                break;
        }
    }

    private static void determineAccountOwner()
    {

    }
}
