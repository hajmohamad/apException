package org.example;

import org.example.exceptions.InvalidInput.AccountNotFound;
import org.example.exceptions.InvalidInput.AmountIsNegative;
import org.example.exceptions.InvalidInput.InvalidPersonalInformation;
import org.example.exceptions.Invalidrequests.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

            try {
                Account WrongId =  new Account("Ftm", "123", "Tehran", 11, 50000, "SAVING_ACC",LocalDate.now(),"09191234566");

            } catch (InvalidPersonalInformation e) {
                System.out.println(e.getMessage());

            }
            try {
                Account WrongPhoneNumberAccount =  new Account("Ftm", "0820124597", "Tehran", 11, 50000, "SAVING_ACC",LocalDate.now(),"09134566");

            } catch (InvalidPersonalInformation e) {
                System.out.println(e.getMessage());

            }

            Account leseAccountBalance=null;
            try {
                leseAccountBalance =  new Account("Ftm", "0820124597", "Tehran", 11, 0, "SAVING_ACC",LocalDate.now(),"09391234566");

            } catch (InvalidPersonalInformation  e) {
                System.out.println(e.getMessage());

            }
            try {
                System.out.println(leseAccountBalance.checkAccountBalance());
            } catch (YouAreVeryPoor e) {
                System.out.println(e.getMessage());
            }

            Account account = null;
            try {
                account = new Account("Ftm", "0820467529", "Tehran", 11, 1000, "SAVING_ACC",LocalDate.now(),"09391234566");
            } catch (InvalidPersonalInformation  e) {
                System.out.println(e.getMessage());
            }

            try {
                System.out.println(account.withdraw(100010));
            } catch (AmountIsNegative | NotEnoughCredit | WithdrawalLimit  e){
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.withdraw(-2));
            } catch (AmountIsNegative  | NotEnoughCredit | WithdrawalLimit  e){
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.withdraw(1500));
            } catch (AmountIsNegative  | NotEnoughCredit | WithdrawalLimit  e){
                System.out.println(e.getMessage());
            }

            try {
                System.out.println(account.withdraw(1000));
            } catch (AmountIsNegative  | NotEnoughCredit | WithdrawalLimit  e){
                System.out.println(e.getMessage());
            }

            try {
                System.out.println(account.deposit(-2));
            } catch (AmountIsNegative   | DepositLimit  |IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.deposit(1001));
            } catch (AmountIsNegative   | DepositLimit  |IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.deposit(100));
            } catch (AmountIsNegative | DepositLimit  |IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.deposit(200));
            } catch (AmountIsNegative | DepositLimit  |IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.deposit(300));
            } catch (AmountIsNegative | DepositLimit  |IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.deposit(100));
            } catch (AmountIsNegative | DepositLimit  |IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.checkAccountBalance());
            } catch (YouAreVeryPoor e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.loanRequest("Ftm", "124", 400));
            } catch (AccountNotFound | AmountIsNegative |LoanLimit | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.loanRequest("ali", "124", 400));
            } catch (AccountNotFound | AmountIsNegative|LoanLimit  | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.loanRequest("Ftm", "0820467529", 600));
            } catch (AccountNotFound | AmountIsNegative|LoanLimit  | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.loanRequest("Ftm", "0820467529", 1200));
            } catch (AccountNotFound | AmountIsNegative|LoanLimit  | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.loanRequest("Ftm", "0820467529", 100));
            } catch (AccountNotFound | AmountIsNegative|LoanLimit | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }
            account.setAccountScore(account.getAccountScore()-30);
            try {
                System.out.println(account.loanRequest("Ftm", "0820467529", 200));
            } catch (AccountNotFound | AmountIsNegative |LoanLimit | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(account.loanRequest("Ftm", "0820467529", -200));
            } catch (AccountNotFound | AmountIsNegative|LoanLimit  | NotEnoughCredit | NotEnoughScore  e) {
                System.out.println(e.getMessage());
            }

        finally {
            System.out.println("Trust Bank");
        }
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
    private String name;
    private String nationalCode;
    private String cityName;
    private int bankNumber;
    private String phoneNumber;
    private int depositCounter;
    private double accountBalance;
    private accountType typeOfAccount;
    private int accountScore = 0;
    private LocalDate dateOfBirth = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(int bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDepositCounter() {
        return depositCounter;
    }

    public void setDepositCounter(int depositCounter) {
        this.depositCounter = depositCounter;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public accountType getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(accountType typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public int getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(int accountScore) {
        this.accountScore = accountScore;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // ========= constructors
    Account(String name, String nationalCode, String cityName, int bankNumber, float accountBalance,
            String typeOfAccount, LocalDate dateOfBirth , String phoneNumber) throws InvalidPersonalInformation {
        String regexPattern = "^(\\+98|0)?9\\d{9}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new InvalidPersonalInformation("Incorrect phone number");
        }
       if(String.valueOf(nationalCode).length()<10) {
            throw new InvalidPersonalInformation("Incorrect id");
        }
        this.name = name;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
        this.cityName = cityName;
        this.bankNumber = bankNumber;
        this.accountBalance = accountBalance;
        this.typeOfAccount = accountType.valueOf(typeOfAccount);
        this.dateOfBirth = dateOfBirth;
        this.depositCounter=0;

    }

    // Default dateOfBirth {all the other ones send null for dateOfBirth}
    Account(String name, String nationalCode, String cityName, int bankNumber, float accountBalance,
            String typeOfAccount) throws InvalidPersonalInformation {
        this(name, nationalCode, cityName, bankNumber, accountBalance, typeOfAccount, null, "09395327229");
    }

    // Default cityName & accountBalance
    Account(String name, String nationalCode, int bankNumber, String typeOfAccount) throws InvalidPersonalInformation {
        this(name, nationalCode, "Esfahan", bankNumber, 2000, typeOfAccount, null, "09395327229");
    }

    // Default accountBalance
    Account(String name, String nationalCode, String cityName, int bankNumber, String typeOfAccount) throws InvalidPersonalInformation {
        this(name, nationalCode, cityName, bankNumber, 2000, typeOfAccount, null, "09395327229");
    }

    // Default cityName
    Account(String name, String nationalCode, int bankNumber, float accountBalance, String typeOfAccount) throws InvalidPersonalInformation {
        this(name, nationalCode, "Esfahan", bankNumber, accountBalance, typeOfAccount, null, "09395327229");
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

    String checkAccountBalance() throws YouAreVeryPoor {

        if (this.typeOfAccount == accountType.SAVING_ACC && this.accountBalance > 1) {
            this.accountBalance--;
            this.accountScore += 10;
        } else if (this.typeOfAccount != accountType.SAVING_ACC && this.accountBalance > 2) {
            this.accountBalance -= 2;
            this.accountScore += 10;
        } else {
            throw new YouAreVeryPoor();
          //  return "You are Very Poor";
        }
        return "Your bank account balance : " + this.accountBalance;
    }

    String withdraw(float value) throws AmountIsNegative, WithdrawalLimit , NotEnoughCredit {
        if(value<0){
            throw new AmountIsNegative();
        }

        // check withdraw limit
        if (value > 10000) {
            throw new WithdrawalLimit ();
           // return "The Withdrawal Limit is $10000";
        }

        // check if account balance is sufficient
        if (this.accountBalance < value) {
            throw new NotEnoughCredit();
            //return "Your Account Balance is NOT Enough";
        }

        // everything is OK
        this.accountBalance -= value;
        this.accountScore += 20;
        return "Withdrawal Completed Successfully";

    }

    String deposit(float value) throws AmountIsNegative, DepositLimit ,IndexOutOfBoundsException {
        if(depositCounter>=3){
            throw new IndexOutOfBoundsException("You can deposit only 3 times");
        }


        if(value<0){
            throw new AmountIsNegative();
        }
        // check deposit limit
        if (value > 1000) {
            this.accountBalance = this.accountBalance*0.99;
            throw new DepositLimit ();
        }

        // everything is ready
        this.accountBalance += value;
        this.accountScore += 30;
        this.depositCounter++;
        return "Deposit was Made Successfully";
    }

    double profitCalculation() {

        if (this.typeOfAccount == accountType.SAVING_ACC) {
            return this.accountBalance * 0.1;
        }

        return this.accountBalance * 0.02f;
    }

    String loanRequest(String name, String nationalCode, int value) throws LoanLimit,AccountNotFound , AmountIsNegative, NotEnoughCredit, NotEnoughScore  {
        if(value>this.accountBalance*2){
            throw new NotEnoughCredit();
        }
        if(value<0){
            throw new AmountIsNegative();
        }
        // account validation
        if (this.name != name || this.nationalCode != nationalCode) {
            throw new AccountNotFound ();
        }



        // check account score limit
        if (this.accountScore < 100) {
            throw new NotEnoughScore ();
            //return "You don't Have Enough Score";
        }

        // check loan limit for SAVING_ACC & SALARY_ACC
        if (this.typeOfAccount != accountType.NRI && value > 500) {
          throw new LoanLimit();
        }

        // everything is fine
        this.accountBalance += value;
        return "Loan Application Applied Successfully";
    }

    String loanRequest(String name, String nationalCode, String typeOfLoan) throws AccountNotFound  {

        // account validation
        if (!Objects.equals(this.name, name) || !Objects.equals(this.nationalCode, nationalCode)) {
            throw new AccountNotFound ();
        }

        if (Objects.equals(typeOfLoan, "STUDENT") || Objects.equals(typeOfLoan, "MARRIAGE")) {

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