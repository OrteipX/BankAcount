# OrteipX

### BankAccount Class Hierarchy - Academic Purpose

In this project, it's been designed a class hierarchy to model a real-world bank application that will create bank account objects and record transactions made in the account.

A customer can have two types of bank accounts: a personal chequing account is an account on which the user can write cheques to pay for purchases. This type of account will pay a low interest rate.

A savings account is intended to encourage customers to leave their money in the bank by not allowing cheques to be written on the account, and it also pays a higher interest rate.

This application is intended to be executed over the period of one month. The classes that will be used in this application include:

    • BankAccount, an abstract superclass which holds features that are common to it subclasses
    • PersonalChequingAccount, a concrete subclass of BankAccount
    • SavingAccount, another concrete subclass of BankAccount.
    • Transaction, an aggregate class whose objects will be instantiated in the two subclasses and stored in an ArrayList structure in order to keep track of the monthly transactions against each account object.

There is also an interface called InterestPayable, which will hold one abstract method called calcInterest(), and it will be implemented differently by each of the two subclasses.
