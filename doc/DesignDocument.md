## Design Document
Author: Andrew Gieraltowski

###Abstract
***
The program is designed to implement an online ATM to the requirements provided for us
in the MyFancyBank project. The source code can be divided into two concurrent object oriented
design flows.

1. The GUI, which incorporates a generic input panel for which other JPanels can be created with,
a generic input button class which makes use of a generic schema for creating buttons and registering
their event handlers. Specifc classes were derived from the generic subclasses and wrapped into a
container so that they could easily be applied to the screen, which is the main JFrame, responsible
for containing and maintaining the state of the gui and all of it's panels.

2. The object oriented design of the online ATM, consisting of objects that would represent
an actual bank. The design allows for the creation of accounts, (savings or checking), request
a loan, deposit money, withdraw money and allows the manager to view accounts by looking them up.

3. I originally spent a ton of time on very specific GUI related (The Keypad and PinPad), which I've
decided to leave in this project even though they aren't submitted. My misunderstanding of what the
ATM actually was had caused me to lose time, so I left them in as consideration for my efforts.

***