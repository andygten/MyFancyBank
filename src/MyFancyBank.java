import Gui.DisplayPanel;
import Gui.Screen;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @file MyFancyBank.java
 * @brief Specific implementation of the Fancy Bank
 * @date 10/13/19
 * @author Andrew Gieraltowski
 */
public class MyFancyBank extends Bank {

    // Static Variables
    static private Screen screen;
    static private Account account;
    static private Transaction transaction;
    static public Record sessionRecord;
    static private int MAX_ACCOUNTS = 20;

    // Members



    public MyFancyBank() {
        super(0);
    }

    public static void main(String[] args) throws InterruptedException {

        sessionRecord = new Record();
        screen = new Screen();

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
        if (ret == 1)
        {
            promptCreateInfo();
            boolean createClicked = false;
            while (createClicked == false)
            {
                createClicked = createButtonClicked();

            }
            ArrayList<String> strings = screen.currentPanel.accountCreatePanel.getTextData();
            if (strings.get(6).compareTo("Checking") == 0)
            {
                CheckingAccount account = new CheckingAccount(strings.get(0), strings.get(1), new Name(strings.get(2), strings.get(3), strings.get(4)), strings.get(5));
            }
            sessionRecord.addAccount(account);
        }

        promptLoginInfo();

        boolean valid = false;
        while (valid == false)
        {
            ret = -1;
            while (ret == -1)
            {
                ret = isLoginButtonPressed();
            }
            String[] loginData = screen.currentPanel.accountLoginPanel.getTextData();
            System.out.println("Attempting to Validate with [ " + loginData[0] + " : " + loginData[1] + " ]");
            account = new CheckingAccount(loginData[0], loginData[1]);
            valid = validateLogin(account);
            screen.currentPanel.accountLoginPanel.loginButton.reset();
        }

        promptTransaction();


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

    private static int isLoginButtonPressed()
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            System.err.println(e);
        }
        if (screen.currentPanel.accountLoginPanel.loginButton.isButtonSelected())
        {
            return 0;
        }

        return -1;
    }

    // Determine if Back Button is pressed
    private static void isBackPressed(String capture)
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            System.err.println(e);
        }
        if (screen.currentPanel.backButton.isButtonSelected())
        {
            screen.previousScreen();
        }
    }

    //Determine if Create Button
    private static boolean createButtonClicked()
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            System.err.println(e);
        }

        return screen.currentPanel.accountCreatePanel.createBtn.isButtonSelected();
    }

    // Prompt Customer for Login Information
    private static void promptLoginInfo()
    {
            screen.currentPanel.clearText();
            screen.currentPanel.displayText("OK! Enter your Login Information!");
            DisplayPanel.Components[] Logincomponents = {DisplayPanel.Components.ACCOUNT_LOGIN_PANEL};
            screen.displayPanels[Screen.getFrame() + 1].CreateDisplay(Logincomponents);
            screen.nextScreen();
    }

    // Prompt the User for Account Creation Info
    private static void promptCreateInfo()
    {
        screen.currentPanel.clearText();
        screen.currentPanel.displayText("OK! Enter the prompted information to create an account!");
        DisplayPanel.Components[] Createcomponents = {DisplayPanel.Components.ACCOUNT_CREATE_PANEL};
        screen.displayPanels[Screen.getFrame()+1].CreateDisplay(Createcomponents);
        screen.nextScreen();
    }

    // Decide what type of user
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
                DisplayPanel.Components[] components = {DisplayPanel.Components.YES, DisplayPanel.Components.NO};
                screen.displayPanels[Screen.getFrame()+1].CreateDisplay(components);
                screen.nextScreen();
                screen.currentPanel.clearText();
                screen.currentPanel.displayText("Hello Manager! Do you already have an account?");
                break;

            // Customer was chosen
            case 1:
                System.out.println("Customer was chosen");
                DisplayPanel.Components[] Custcomponents = {DisplayPanel.Components.YES, DisplayPanel.Components.NO, DisplayPanel.Components.BACK};
                screen.displayPanels[Screen.getFrame()+1].CreateDisplay(Custcomponents);
                screen.nextScreen();
                screen.currentPanel.clearText();
                screen.currentPanel.displayText("Hello Customer! Do you already have an account?");
                break;
        }
    }

    // Prompt the User for a transaction
    private static void promptTransaction()
    {
        DisplayPanel.Components[] Acctcomponents = {DisplayPanel.Components.ACCOUNT_TRANSACTION_PANEL};
        screen.displayPanels[Screen.getFrame()+1].CreateDisplay(Acctcomponents);
        screen.nextScreen();
    }

    // Validate the User's Login Information
    private static boolean validateLogin(Account account)
    {
        return sessionRecord.verifyAccount(account);
    }
}
