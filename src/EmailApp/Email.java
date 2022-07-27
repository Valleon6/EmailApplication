package EmailApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Email extends Thread {
    private final String firstName;
    private final String lastName;
    private String department;
    private final String companySuffix = "@decagon.hq.com";
    private String password;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private final String email;

    public Email(String firstName, String lastName) throws InterruptedException {
        System.out.println("Processing ...");
        Thread.sleep(500);

        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email created for " + this.firstName + " " + this.lastName);
        System.out.println("Processing ...");
        Thread.sleep(500);

        // Call a method asking for the department. Return the department.

        setDepartment();
        Thread.sleep(500);

        //Combine elements to generate email
        if(!department.isBlank()){
            email = this.firstName + "." + this.lastName + "." + department + companySuffix;

        }else{
            email = this.firstName + "." + this.lastName + companySuffix;
        }
        System.out.println("Processing ...");
        Thread.sleep(500);
        System.out.println("Your new email Address is: " + email);

        Thread.sleep(500);
        setPassword();

        setAlternateEmail();
        System.out.println("Processing ...");
        Thread.sleep(500);
        System.out.println("Your Email setup has been completed.");
    }

    //Ask for the department
    private void setDepartment() throws InterruptedException {
        System.out.println("Choose your department: \n 1. Sales \n 2. Development \n 3. Accounting \n 0. None");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice;
        do {
            departmentChoice = scanner.nextInt();
            switch (departmentChoice) {
                case 1 -> department = "Sales";
                case 2 -> department = "Development";
                case 3 -> department = "Accounting";
                case 0 -> department = "";
                default -> System.out.println("""
                        Please choose your department:\s
                         1. Sales\s
                         2. Development\s
                         3. Accounting\s
                         0. None""");
            }
        } while (department == null);
        System.out.println("Processing ...");
        Thread.sleep(500);
        System.out.println("Chosen department: " + department);
    }

    //Generate a random password.
    private String randomPassword() throws InterruptedException {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";

        System.out.println("Processing ...");
        Thread.sleep(500);
        System.out.println("Please type desired random password length in the range of 8-12)");

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        while (!(length >= 8 && length <= 12)) {
            System.out.println("Please type a password length in the range of 8-12");
            length = scanner.nextInt();
        }

        char[] password = new char[length];
        char[] passwordChar = passwordSet.toCharArray();
        for (int i = 0; i < length; i++) {
            password[i] = passwordChar[(int) (Math.random() * passwordSet.length())];
        }
        System.out.println("Processing ...");
        Thread.sleep(500);
        System.out.println("Your new password is: " + new String(password));
        return (new String(password));
    }

    //Set an alternate email.
    public void setAlternateEmail() throws InputMismatchException, InterruptedException {
        System.out.println("Processing ...");
        Thread.sleep(500);
        System.out.println("Do you want to set an Alternate Email: Yes / No ? \n" +
                "Type 'Y' for YES and any other character for NO.");
        Scanner scanner = new Scanner(System.in);
        String makeAlternateEmail = scanner.next();
        if (makeAlternateEmail.equalsIgnoreCase("Y")) {
            Thread.sleep(500);
            System.out.println("Please type in Alternate Email: ");
            this.alternateEmail = scanner.next();
            Thread.sleep(500);
            System.out.println("Your alternate email is: " + this.alternateEmail);
        } else {
            this.alternateEmail = null;
            System.out.println("Please proceed.");
        }
    }

    // Change the password.
    public void setPassword() throws InterruptedException {
        this.password = randomPassword();
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }
    public String getEmailAddress() {
        return email;
    }

    //Get the mailbox capacity;
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }


}
