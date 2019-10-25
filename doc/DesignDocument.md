## Design Document
Author: Andrew Gieraltowski

###Abstract
***
The program is designed to implement an online ATM to the requirements provided for us
in the MyFancyBank project. The source code can be divided into two concurrent object oriented
design flows.

* The GUI, which incorporates a generic input panel for which other JPanels can be created with,
a generic input button class which makes use of a generic schema for creating buttons and registering
their event handlers. Specifc classes were derived from the generic subclasses and wrapped into a
container so that they could easily be applied to the screen, which is the main JFrame, responsible
for containing and maintaining the state of the gui and all of it's panels.

* The object oriented design of the online ATM, consisting of objects that would represent
an actual bank. The design allows for the creation of accounts, (savings or checking), request
a loan, deposit money, withdraw money and allows the manager to view accounts by looking them up.

* I originally spent a ton of time on very specific GUI related (The Keypad and PinPad), which I've
decided to leave in this project even though they aren't included in the execution of my code. 
My misunderstanding of what the ATM actually was had caused me to lose time, so I left them in as 
potential consideration for my efforts.


###Self Assessment
***

Retrospectively, I would have changed a few things about my program to better align with the 
misinterpreted requirements.

* I would've abstracted the idea of Account IDs to Customer IDs with associated accounts
* Had I known swift better, I could have abstracted the Panels more gracefully
* Same goes for the buttons, I might have been able to abstract a few things into the InputButton
class.

* Because of the design split between directories of the GUI and the main logic of the program, I was
not able to directly modify values in the main program from events in the GUI and therefore needed to 
include some logic in the conjoined "Main" of the program where both designs combined.

## Class Breakdown
***
### Gui
* InputPanel
    * This class is container by which all the other program specific panels and buttons can be added
    to so that they can be wrapped and dynamically applied to containers
    
* InputButton
    * The Individual buttons are specific implementations for this GUI that extend this class
    * It enforces a few custom methods for obtaining data
    
* Screen
    * The main JFrame where all the panels are loaded on and off of, it also has a method for
    which programs can use to track the state of the screen
    
* The other classes are specific implementations of the above to produce MyFancyBank GUI


###Main Program Logic
* Bank
    * An abstract class that represent the bank. Holds a Record of all the accounts as well as 
    a bank manager.
    
* Account

    * Checking Account
        * Inherits account, specific to checking in that no interest object is applied
        and fees are incurred during transactions

    * Savings Account
        * Inherits account, specific to savings in that an interest object is applied
        and fees are not incurred.

* Transaction

    * Withdraw
        * Object is initialized with the amount to be withdrawn and inherits the abstract method
        perform from transaction where it must perform the act of withdraw
        * This removes money from a specified account
    
    * Deposit
        * Object is initialized with the amount to be deposited and inherits the abstract method
        perform from transaction where it must perform the act of deposit
        * This adds money to a specified account
    
    * Loan
        * Loan object that can requested from the user
        * Will be associated with an account

* Money
    * Object representation of currency that can take 3 forms (usd, can, euro) and
    can have actions (add, sub, multiply) performed on the object

* Person
    * Manager
        * Representation of a manager, according to the requirements it is necessary to track
        how much money they made, so that is stored in this object and can be displayed
        * Ideally, the managers earned amount would be tied to the transaction class
    
    * Customer
        * Customer Object with a list of accounts and associated customer ID for logging in

* Name
    * Generic name class, first, middle, last.

* Record
    * A record of all the transactions and accounts created at the bank, held by that bank.
    * This is what is used to display the list of transactions and query for accounts

* Tax
    * The object representation of the fee that is applied to accounts with type Checking.

* Interest
    * Interest that is payed to savings accounts and also accumulated on loans.

* Teller
    * The Teller is responsible for converting money from currencies and lives within the bank.
    
