package org.example;
import java.time.LocalDate;
import java.time.Period;

public class Main {

    public static void main(String[] args) {

        Account account1 = new Account("Ftm", 123, "Tehran", 11, 50000, "SAVING_ACC");
        System.out.println(account1.checkAccountBalance());
        System.out.println(account1.withdraw(5000));
        System.out.println(account1.deposit(1000));
        System.out.println(account1.deposit(500));
        System.out.println(account1.deposit(7000));
        System.out.println(account1.withdraw(1000));
        System.out.println(account1.deposit(11000));
        System.out.println(account1.checkAccountBalance());
        System.out.println(account1.profitCalculation());
        System.out.println(account1.loanRequest("Ftm", 124, 400));
        System.out.println(account1.loanRequest("Ftm", 123, 400));
        System.out.println(account1.loanRequest("Ftm", 123, "BUSINESS"));
        System.out.println(account1.accountBalance);
    }
}

enum accountType {
    SAVING_ACC,
    SALARY_ACC,
    NRI
}

enum loanType {

    BUSINESS(7000),
    STUDENT(2000),
    MORTGAGE(5000),
    MARRIAGE(4000);

    private int value;

    private loanType(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }
}

class Account {

    // ========= properties
    String name;
    int nationalCode;
    String cityName;
    int bankNumber;
    float accountBalance;
    accountType typeOfAccount;
    int accountScore = 0;
    LocalDate dateOfBirth = null;

    // ========= constructors
    Account(String name, int nationalCode, String cityName, int bankNumber, float accountBalance,
            String typeOfAccount, LocalDate dateOfBirth) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.cityName = cityName;
        this.bankNumber = bankNumber;
        this.accountBalance = accountBalance;
        this.typeOfAccount = accountType.valueOf(typeOfAccount);
        this.dateOfBirth = dateOfBirth;
    }

    // Default dateOfBirth {all the other ones send null for dateOfBirth}
    Account(String name, int nationalCode, String cityName, int bankNumber, float accountBalance,
            String typeOfAccount) {
        this(name, nationalCode, cityName, bankNumber, accountBalance, typeOfAccount, null);
    }

    // Default cityName & accountBalance
    Account(String name, int nationalCode, int bankNumber, String typeOfAccount) {
        this(name, nationalCode, "Esfahan", bankNumber, 2000, typeOfAccount, null);
    }

    // Default accountBalance
    Account(String name, int nationalCode, String cityName, int bankNumber, String typeOfAccount) {
        this(name, nationalCode, cityName, bankNumber, 2000, typeOfAccount, null);
    }

    // Default cityName
    Account(String name, int nationalCode, int bankNumber, float accountBalance, String typeOfAccount) {
        this(name, nationalCode, "Esfahan", bankNumber, accountBalance, typeOfAccount, null);
    }

    // ========= methods

    String setDateOfBirth(LocalDate dateOfBirth) {
        if (this.dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
            return "Date of birth successfully added";
        } else {
            this.dateOfBirth = dateOfBirth;
            return "Date of birth successfully updated";

        }
    }

    String checkAccountBalance() {

        if (this.typeOfAccount == accountType.SAVING_ACC && this.accountBalance > 1) {
            this.accountBalance--;
            this.accountScore += 10;
        } else if (this.typeOfAccount != accountType.SAVING_ACC && this.accountBalance > 2) {
            this.accountBalance -= 2;
            this.accountScore += 10;
        } else {
            return "You are Very Poor";
        }

        return "Your bank account balance : " + this.accountBalance;
    }

    String withdraw(float value) {

        // check withdraw limit
        if (value > 10000) {
            return "The Withdrawal Limit is $10000";
        }

        // check if account balance is sufficient
        if (this.accountBalance < value) {
            return "Your Account Balance is NOT Enough";
        }

        // everything is OK
        this.accountBalance -= value;
        this.accountScore += 20;
        return "Withdrawal Completed Successfully";

    }

    String deposit(float value) {

        // check deposit limit
        if (value > 1000) {
            this.accountBalance *= 0.99;
            return "The Deposit Limit is $1000\nYour balance after fine : " + this.accountBalance;
        }

        // everything is ready
        this.accountBalance += value;
        this.accountScore += 30;
        return "Deposit was Made Successfully";
    }

    float profitCalculation() {

        if (this.typeOfAccount == accountType.SAVING_ACC) {
            return this.accountBalance * 0.1f;
        }

        return this.accountBalance * 0.02f;
    }

    String loanRequest(String name, int nationalCode, int value) {

        // account validation
        if (this.name != name || this.nationalCode != nationalCode) {
            return "Account Not Found";
        }

        // check accountBalance limit based on loanRequest value
        if (this.accountBalance < (value / 2)) {
            return "Your Credit is not Enough for This Loan";
        }

        // check account score limit
        if (this.accountScore < 100) {
            return "You don't Have Enough Score";
        }

        // check loan limit for SAVING_ACC & SALARY_ACC
        if (this.typeOfAccount != accountType.NRI && value > 500) {
            return "Loan limit for your account type is 500!";
        }

        // everything is fine
        this.accountBalance += value;
        return "Loan Application Applied Successfully";
    }

    String loanRequest(String name, int nationalCode, String typeOfLoan) {

        // account validation
        if (this.name != name || this.nationalCode != nationalCode) {
            return "Account Not Found";
        }

        if (typeOfLoan == "STUDENT" || typeOfLoan == "MARRIAGE") {

            if (this.dateOfBirth == null) {
                return "To apply, you must first enter your date of birth!";
            } else {
                LocalDate now = LocalDate.now();
                Period age = Period.between(this.dateOfBirth, now);
                if (age.getYears() < 18) {
                    return "You are too young, grow up and then apply hahaha";
                }
            }
        }

        this.accountBalance += loanType.valueOf(typeOfLoan).getValue();
        return "Loan Application Applied Successfully";
    }
}