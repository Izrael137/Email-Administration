package emailapp;

import java.util.Scanner;

public class Email {

    // The private keyword is an access modifier used for attributes,
    // methods and constructors, making them only accessible within the
    // declared class.

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultpasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultpasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate an email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    // Ask for the department
    private String setDepartment() {

        Scanner sc = new Scanner(System.in);

        System.out.print("NEW WORKER: " + firstName +  "\nDEPARTMENTS CODES:\n1. for Sales\n2. for Development\n3. for Accounting\n0. for none\nEnter department code: ");
        int departmentChoice = sc.nextInt();

        if (departmentChoice == 1) {
            return "sales";
        }
        else if (departmentChoice == 2) {
            return "development";
        }
        else if (departmentChoice == 3) {
            return "accounting";
        }
        else {
            return "";
        }

    }

    // Generate a random password
    private String randomPassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }

        return new String(password);

    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";

    }

}
