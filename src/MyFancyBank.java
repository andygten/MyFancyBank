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
    static public Record sessionRecord;
    static private Account lookupAccount;
    static private Manager bankManager;
    static private int MAX_ACCOUNTS = 20;
    static private int WINDOW_WIDTH = 1000;
    static private int WINDOW_HEIGHT = 600;

    // Members



    public MyFancyBank() {
        super(0);
    }

    public static void main(String[] args) throws InterruptedException {

        boolean programExit = false;
        sessionRecord = new Record();
        screen = new Screen();

        screen.setTitle("My Fancy Bank");
        screen.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        screen.setLocationRelativeTo(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);

        Screen.ScreenState state = Screen.ScreenState.UserSelect;
        Screen.ScreenState currentState = Screen.ScreenState.UserActionState;

        int ret = -1;
        while (programExit == false) {

            Thread.sleep(10);
            if (currentState != state) {
                screen.nextScreen(state);
                if (state == Screen.ScreenState.UserActionState)
                {
                    screen.currentPanel.textPane.setText("User: " + sessionRecord.getActiveAccount().getAccountID());
                }
                currentState = state;
            }
            if (screen.currentPanel.backButton.isButtonSelected())
            {
                state = screen.previousScreen();
            }
            switch (state) {
                case UserSelect:
                    state = decideUser();
                    break;

                case LoginCreate:
                    state = LoginCreateDecision();
                    break;

                case CreateState:
                    state = promptCreateInfo();
                    break;

                case LoginState:
                    state = promptLoginInfo();
                    break;

                case ManagerAction:
                    state = RequestAccountLookupInfo();
                    break;

                case UserActionState:
                    state = promptTransactions();
                    break;

                case AccountInfoState:
                    state = DisplayRequestedUserInfo();
                    break;

                case RequestReport:

                    break;


                case ProgramExit:

                    break;
            }
        }

        System.out.println("Exiting Program");
    }

    /**
     * @brief Main execution is often prompted with questions for which we need to wait for an answer
     */
    private static int hasDecisionBeenMade() {
        if (screen.currentPanel.managerButton.isButtonSelected())
        {
            return 0;
        }
        else if (screen.currentPanel.customerButton.isButtonSelected())
        {
            return 1;
        }
        return -1;
    }

    /**
     * @brief Determine if user wants to login or create an account
     */
    private static Screen.ScreenState LoginCreateDecision() {

        if (screen.currentPanel.createButton.isButtonSelected())
        {
            return Screen.ScreenState.CreateState;
        }
        else if (screen.currentPanel.loginButton.isButtonSelected()) {
            return Screen.ScreenState.LoginState;
        }

        return Screen.ScreenState.LoginCreate;
    }

    private static boolean isLoginButtonPressed() {
        return screen.currentPanel.accountLoginPanel.loginButton.isButtonSelected();
    }

    //Determine if Create Button
    private static boolean createButtonClicked() {
        return screen.currentPanel.accountCreatePanel.createBtn.isButtonSelected();
    }

    // Prompt Customer for Login Information
    private static Screen.ScreenState promptLoginInfo() {

        if (isLoginButtonPressed())
        {
            ArrayList<String> loginData = screen.currentPanel.accountLoginPanel.getTextData();
            if (loginData.get(2).compareToIgnoreCase("Savings") == 0)
            {
                account = new SavingsAccount(loginData.get(0), loginData.get(1));
            }
            else
            {
                account = new CheckingAccount(loginData.get(0), loginData.get(1));
            }
            if (validateLogin(account))
            {
                Account activeAccount = sessionRecord.getAccount(loginData.get(0), loginData.get(1));
                sessionRecord.setActiveAccount(activeAccount);
                return Screen.ScreenState.UserActionState;
            }
            else
            {
                screen.currentPanel.textPane.setText("Invalid Account, Please Try Again");
            }
        }

        return Screen.ScreenState.LoginState;
    }

    // Prompt the User for Account Creation Info
    private static Screen.ScreenState promptCreateInfo() {

        if (createButtonClicked()) {
            ArrayList<String> strings = screen.currentPanel.accountCreatePanel.getTextData();
            if (strings.get(6).compareTo("Savings") == 0) {
                SavingsAccount account = new SavingsAccount(strings.get(0), strings.get(1), new Name(strings.get(2), strings.get(3), strings.get(4)), strings.get(5));
                sessionRecord.addAccount(account);
            } else {
                CheckingAccount account = new CheckingAccount(strings.get(0), strings.get(1), new Name(strings.get(2), strings.get(3), strings.get(4)), strings.get(5));
                sessionRecord.addAccount(account);
            }
        }
        else {
            return Screen.ScreenState.CreateState;
        }

        return Screen.ScreenState.LoginState;
    }

    // Decide what type of user
    private static Screen.ScreenState decideUser()
    {

        int ret = hasDecisionBeenMade();

        switch (ret)
        {
            // Manager was chosen
            case 0:
                return Screen.ScreenState.ManagerAction;


            // Customer was chosen
            case 1:
                return Screen.ScreenState.LoginCreate;
        }

        return Screen.ScreenState.UserSelect;
    }

    // Get and Display User Data
    private static Screen.ScreenState RequestAccountLookupInfo()
    {
        if(screen.currentPanel.managerActionPanel.lookupButton.isButtonSelected()) {
            ArrayList<String> strings = screen.currentPanel.managerActionPanel.getAccountRequestID();
            lookupAccount = sessionRecord.getAccount(strings.get(0), strings.get(1));
            if (lookupAccount == null)
            {
                return Screen.ScreenState.ManagerAction;
            }
            return Screen.ScreenState.AccountInfoState;
        }
        else if(screen.currentPanel.managerActionPanel.requestButton.isButtonSelected())
        {

        }
        else if(screen.currentPanel.managerActionPanel.earnedAmountButton.isButtonSelected())
        {
            screen.currentPanel.managerActionPanel.setEarnedAmount(bankManager.getAmountCollected().toString());
        }

        return Screen.ScreenState.ManagerAction;
    }

    private static Screen.ScreenState DisplayRequestedUserInfo()
    {
        Money balance = lookupAccount.getBalance();
        Name name = lookupAccount.getName();
        Account.AccountType accountType = lookupAccount.getAccountType();
        screen.currentPanel.accountInfoPanel.setData(lookupAccount.getAccountID(), name.getFirstName(), name.getMiddleName(), name.getLastName(), balance.getAmount(), accountType.toString());

        return Screen.ScreenState.AccountInfoState;
    }

    private static Screen.ScreenState promptTransactions()
    {
        Account activeAccount = sessionRecord.getActiveAccount();
        if (screen.currentPanel.transactionPanel.depositRequest.isButtonSelected())
        {
            String amount = screen.currentPanel.transactionPanel.getDepositAmount();
            Money money = new Money(Double.valueOf(amount), activeAccount.getCurrencyPreference());
            activeAccount.deposit(money);
        }
        if (screen.currentPanel.transactionPanel.withdrawRequest.isButtonSelected())
        {
            String amount = screen.currentPanel.transactionPanel.getWithdrawAmount();
            Money money = new Money(Double.valueOf(amount), activeAccount.getCurrencyPreference());
            activeAccount.withdraw(money);
        }
        if (screen.currentPanel.transactionPanel.loanRequest.isButtonSelected())
        {
            String amount = screen.currentPanel.transactionPanel.getLoanAmount();
            Money money = new Money(Double.valueOf(amount), activeAccount.getCurrencyPreference());
            activeAccount.addLoan(money);
            activeAccount.deposit(money);
        }
        if (screen.currentPanel.transactionPanel.balanceRequest.isButtonSelected())
        {
            screen.currentPanel.transactionPanel.setBalanceAmout(activeAccount.getBalance().getAmount());
        }

        return Screen.ScreenState.UserActionState;
    }

    // Validate the User's Login Information
    private static boolean validateLogin(Account account)
    {
        return sessionRecord.verifyAccount(account);
    }
}
