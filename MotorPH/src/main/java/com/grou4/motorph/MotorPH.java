package com.grou4.motorph;

import COMPONENTS.LoginFunction;
import COMPONENTS.MenuBoard;
import constructor.User;
import com.grou4.services.AdminService;
import java.util.Scanner;
import COMPONENTS.ViewEmpWorkedHours;
import java.io.IOException;


public class MotorPH {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        LoginFunction loginFunction = new LoginFunction(); // Nag instanciate ako ng 'LoginFunction' para magamit sa MotorPH.java class (main) ko yung mga functions and code sa loob ng class
        Scanner userInput = new Scanner(System.in);
        MenuBoard menuBoard = new MenuBoard(); // Nag instanciate ako ng 'MenuBoard' para magamit sa MotorPH.java class (main) ko yung mga functions and code sa loob ng class
        
        // nag declare ako ng mga variable na magagamit ko throughout this class
        // Ang ibang String variable ay inasign ko sa 'null' just in case walang ma retrive ang program, meron paring mai-babatong value.
        // Ang mga int variable ay inasign ko sa '0' just in case walang ma retrive ang program, meron aring mai-babatong value.
        String Username;
        String Password;
        String logInUserFirstName = null;
        String logInUserLastName = null;
        String logInUserPosition = null;
        String logInUserStatus = null;
        int logInUserID = 0;
        String fullName;
        int logInUserAction = 0;
        
        System.out.println("******************************************************");
        System.out.println("*             Welcome to MotorPH Portal              *");
        System.out.println("*                 powered by Group 4                 *");
        System.out.println("******************************************************");
        
        System.out.println("Please log-in to continue... ");
        System.out.print("Username: ");
        Username = userInput.nextLine();
        System.out.print("Password: ");
        Password = userInput.nextLine();
        System.out.println(" ");
        
        // Ginamit ko yung loginFunction.login para ipag-banga kung merong username at password na kapareho sa input ni user.
        // Diniclare ko sya sa boolean, mag rereturn sya ng true or false.
        boolean loginStatus = loginFunction.login(Username, Password);
        
        // Kapag true ang nireturn ni loginStatus variable, mag poproceed sya sa pag-login ni user.
        if (loginStatus) {
            System.out.println("******************************************************");
            System.out.println("Login successful!");
            User profileOfLogInUser = AdminService.loginUser(Username, Password); // Ginamit ko ang loginUser class sa loob ng AdminService para ma retrive ang mga information ni user
            logInUserFirstName = profileOfLogInUser.getFirstName();
            logInUserLastName = profileOfLogInUser.getLastName();
            logInUserID = profileOfLogInUser.getUserId();
            logInUserPosition = profileOfLogInUser.getDesignation();
            logInUserStatus = profileOfLogInUser.getStatus();
            
            System.out.println("Hi " +logInUserFirstName +" " +logInUserLastName +", Welcome to MotorPH Portal.");
        
        // Kapag false ang nireturn ni loginStatus variable, iteterminate nya ang application
        } else {
            System.out.println("Login failed. Invalid username or password.");
            System.exit(0);
        }
        
        // After mag log-in ni user, ivavalidate naman nya ang position ng user sa company.
        // Ang CEO, HR Manager, Accounting Head, lang ang may privilage sa mga sensitive data at pages.
        if ("Chief Executive Officer".equals(logInUserPosition) || "HR Manager".equals(logInUserPosition) || "Accounting Head".equals(logInUserPosition)) {
            menuBoard.privilageUsers(logInUserFirstName, logInUserLastName, Username, Password);
        // Ang mga probataionary employee ay hindi makakapag log-in sa dashboard. Time card lang muna ang gagamitin.
        } else if ("Probationary".equals(logInUserStatus)) {
            System.out.println(" ");
            System.out.print("Unathorize access detected. ");
            // Ang 'Thread.sleep();' class ay para i-slow down lang ang pag-read ng program. Ang number sa loob ay miliseconds
            Thread.sleep(1000);
            System.out.print(". ");
            Thread.sleep(1000);
            System.out.print(". ");
            Thread.sleep(1000);
            System.out.println(". ");
            Thread.sleep(1000);
            System.out.println(" ");
            System.out.print("Closing application. ");
            Thread.sleep(1000);
            System.out.print(". ");
            Thread.sleep(1000);
            System.out.print(". ");
            Thread.sleep(1000);
            System.out.println(". ");
            Thread.sleep(1000);
            System.exit(0);
            
        // Ang mga normal user, ang privilage lang nila ay time-in time-out, view their own details.
        } else if (!("Chief Executive Officer".equals(logInUserPosition) || "HR Manager".equals(logInUserPosition) || "Accounting Head".equals(logInUserPosition))) {
            menuBoard.regularUser(logInUserFirstName, logInUserLastName, Username, Password);
        }


    }
    
}
