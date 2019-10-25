import Gui.Screen;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Andrew Gieraltowski
 * @file MyFancyBank.java
 * @brief Specific implementation of the Fancy Bank
 * @date 10/13/19
 */
public class MyFancyBank extends Bank {

    // Static Variables
    static private Screen screen;
    static private Account newAccount;
    static private Account lookupAccount;
    static private int MAX_ACCOUNTS = 20;
    static private int WINDOW_WIDTH = 1000;
    static private int WINDOW_HEIGHT = 600;
    static private int ACCOUNT_LOGIN_TYPE_IDX = 1;
    static private int ACCOUNT_ID_IDX = 0;
    static private int ACCOUNT_PSWD_IDX = 1;
    static private int ACCOUNT_TYPE_IDX = 2;
    static private int TRANSACTION_DISPLAY_SIZE = 3;
    static private String WITHDRAW = "Withdraw";
    static private String DEPOSIT = "Deposit";
    static private String LOAN = "Loan";
    static private String SAVINGS_ACCOUNT = "Savings";
    static private String CHECKING_ACCOUNT = "Checking";

    // Members
    public MyFancyBank() {
        super();
    }

    public static void main(String[] args) throws InterruptedException {

        boolean programExit = false;
        sessionRecord = new Record();
        bankManager = new Manager();
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
                if (state == Screen.ScreenState.UserActionState) {
                    screen.currentPanel.textPane.setText("User: " + sessionRecord.getActiveAccount().getAccountID());
                }
                currentState = state;
            }
            if (screen.currentPanel.backButton.isButtonSelected()) {
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
                    state = displayTransactions();
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
        if (screen.currentPanel.managerButton.isButtonSelected()) {
            return 0;
        } else if (screen.currentPanel.customerButton.isButtonSelected()) {
            return 1;
        }
        return -1;
    }

    /**
     * @brief Determine if user wants to login or create an account
     */
    private static Screen.ScreenState LoginCreateDecision() {

        if (screen.currentPanel.createButton.isButtonSelected()) {
            return Screen.ScreenState.CreateState;
        } else if (screen.currentPanel.loginButton.isButtonSelected()) {
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

        if (isLoginButtonPressed()) {
            ArrayList<String> loginData = screen.currentPanel.accountLoginPanel.getTextData();
            if (loginData.get(ACCOUNT_TYPE_IDX).compareToIgnoreCase(SAVINGS_ACCOUNT) == 0) {
                newAccount = new SavingsAccount(loginData.get(ACCOUNT_ID_IDX), loginData.get(ACCOUNT_PSWD_IDX));
            } else {
                newAccount = new CheckingAccount(loginData.get(ACCOUNT_ID_IDX), loginData.get(ACCOUNT_PSWD_IDX));
            }
            if (validateLogin(newAccount)) {
                Account activeAccount = sessionRecord.getAccount(loginData.get(ACCOUNT_ID_IDX), loginData.get(ACCOUNT_TYPE_IDX));
                if (sessionRecord.getAccount(loginData.get(ACCOUNT_ID_IDX), loginData.get(ACCOUNT_TYPE_IDX)) != null) {
                    sessionRecord.setActiveAccount(activeAccount);
                }
                return Screen.ScreenState.UserActionState;
            } else {
                screen.currentPanel.textPane.setText("Invalid Account, Please Try Again");
            }
        }

        return Screen.ScreenState.LoginState;
    }

    // Prompt the User for Account Creation Info
    private static Screen.ScreenState promptCreateInfo() {

        if (createButtonClicked()) {
            ArrayList<String> strings = screen.currentPanel.accountCreatePanel.getTextData();
            if (strings.get(Account.AccountIDX.ACCOUNT_TYPE.value).compareTo(SAVINGS_ACCOUNT) == 0) {
                SavingsAccount account = new SavingsAccount(strings.get(Account.AccountIDX.ACCOUNTID.value), strings.get(Account.AccountIDX.PASSWORD.value),
                                         new Name(strings.get(Account.AccountIDX.FIRSTNAME.value), strings.get(Account.AccountIDX.MIDDLENAME.value),
                                                  strings.get(Account.AccountIDX.LASTNAME.value)), strings.get(Account.AccountIDX.BALANCE.value));
                sessionRecord.addAccount(account);
            } else {
                CheckingAccount account = new CheckingAccount(strings.get(Account.AccountIDX.ACCOUNTID.value), strings.get(Account.AccountIDX.PASSWORD.value),
                        new Name(strings.get(Account.AccountIDX.FIRSTNAME.value), strings.get(Account.AccountIDX.MIDDLENAME.value),
                                strings.get(Account.AccountIDX.LASTNAME.value)), strings.get(Account.AccountIDX.BALANCE.value));
                System.out.println("adding account");
                sessionRecord.addAccount(account);
            }
        } else {
            return Screen.ScreenState.CreateState;
        }

        return Screen.ScreenState.LoginState;
    }

    // Decide what type of user
    private static Screen.ScreenState decideUser() {

        int ret = hasDecisionBeenMade();

        switch (ret) {
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
    private static Screen.ScreenState RequestAccountLookupInfo() {
        if (screen.currentPanel.managerActionPanel.lookupButton.isButtonSelected()) {
            ArrayList<String> strings = screen.currentPanel.managerActionPanel.getAccountRequestID();
            lookupAccount = sessionRecord.getAccount(strings.get(ACCOUNT_ID_IDX), strings.get(ACCOUNT_LOGIN_TYPE_IDX));
            if (lookupAccount == null) {
                return Screen.ScreenState.ManagerAction;
            }
            return Screen.ScreenState.AccountInfoState;
        } else if (screen.currentPanel.managerActionPanel.requestButton.isButtonSelected()) {
            return Screen.ScreenState.RequestReport;

        } else if (screen.currentPanel.managerActionPanel.earnedAmountButton.isButtonSelected()) {
            screen.currentPanel.managerActionPanel.setEarnedAmount(bankManager.getAmountCollected().toString());
        }

        return Screen.ScreenState.ManagerAction;
    }

    private static Screen.ScreenState DisplayRequestedUserInfo() {
        Money balance = lookupAccount.getBalance();
        Name name = lookupAccount.getName();
        Account.AccountType accountType = lookupAccount.getAccountType();
        screen.currentPanel.accountInfoPanel.setData(lookupAccount.getAccountID(), name.getFirstName(), name.getMiddleName(), name.getLastName(), balance.getAmount(), accountType.toString());

        return Screen.ScreenState.AccountInfoState;
    }

    private static Screen.ScreenState promptTransactions() {
        Account activeAccount = sessionRecord.getActiveAccount();
        if (screen.currentPanel.transactionPanel.depositRequest.isButtonSelected()) {
            String amount = screen.currentPanel.transactionPanel.getDepositAmount();
            Money money = new Money(Double.valueOf(amount), activeAccount.getCurrencyPreference());
            Deposit deposit = new Deposit(money, activeAccount);
            deposit.perform();
            sessionRecord.addTransaction(deposit);
            bankManager.addAmountCollected(new Money(Tax.DEFAULT_TAX_PERCENTAGE, activeAccount.getCurrencyPreference()));
        }
        if (screen.currentPanel.transactionPanel.withdrawRequest.isButtonSelected()) {
            String amount = screen.currentPanel.transactionPanel.getWithdrawAmount();
            Money money = new Money(Double.valueOf(amount), activeAccount.getCurrencyPreference());
            Withdraw withdraw = new Withdraw(money, activeAccount);
            withdraw.perform();
            sessionRecord.addTransaction(withdraw);
            bankManager.addAmountCollected(new Money(Tax.DEFAULT_TAX_PERCENTAGE, activeAccount.getCurrencyPreference()));
        }
        if (screen.currentPanel.transactionPanel.loanRequest.isButtonSelected()) {
            String amount = screen.currentPanel.transactionPanel.getLoanAmount();
            Money money = new Money(Double.valueOf(amount), activeAccount.getCurrencyPreference());
            activeAccount.addLoan(money);
        }
        if (screen.currentPanel.transactionPanel.balanceRequest.isButtonSelected()) {
            screen.currentPanel.transactionPanel.setBalanceAmout(activeAccount.getBalance().getAmount());
        }

        return Screen.ScreenState.UserActionState;
    }

    private static Screen.ScreenState displayTransactions()
    {
        int i = 0;
        String[][] strings = new String[sessionRecord.getNumTransactions()][TRANSACTION_DISPLAY_SIZE];
        for (Transaction transaction : sessionRecord.getTransactions())
        {
            int j = 0;
            strings[i][j] = transaction.getTransactionAccount().getAccountID();
            j++;
            if (transaction.getClass() == Withdraw.class) {
                strings[i][j] = WITHDRAW;
            }
            else if (transaction.getClass() == Deposit.class)
            {
                strings[i][j] = DEPOSIT;
            }

            j++;
            strings[i][j] = transaction.getTransactionAmount();
            i++;
        }
        screen.currentPanel.transactionListPanel.setTransactionsTable(strings);

        return Screen.ScreenState.RequestReport;
    }

    // Validate the User's Login Information
    private static boolean validateLogin(Account account) {
        return sessionRecord.verifyAccount(account);
    }
}
