package com.grou4.motorph;

import COMPONENTS.Credits;
import COMPONENTS.ViewEmployeeDetails;
import COMPONENTS.EditEmployeeDetails;
import COMPONENTS.ViewEmpWorkedHours;
import COMPONENTS.TimeInTimeOutPage;
import COMPONENTS.CreateNewUser;
import COMPONENTS.LoginFunction;
import COMPONENTS.MenuBoard;
import constructor.User;
import constructor.Time;
import com.grou4.services.TimeService;
import com.grou4.services.AdminService;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDateTime;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MotorPH {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        ViewEmployeeDetails viewEmployeeDetails = new ViewEmployeeDetails();
        CreateNewUser createNewUser = new CreateNewUser();
        LoginFunction loginFunction = new LoginFunction();
        AdminService adminService = new AdminService();
        TimeService TimeService = new TimeService();
        Scanner userInput = new Scanner(System.in);
        MenuBoard menuBoard = new MenuBoard();
        MenuBoard myMenu = new MenuBoard();
        
        String Username;
        String Password;
        String logInUserFirstName = null;
        String logInUserLastName = null;
        String searchDate;
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
            User profileOfLogInUser = AdminService.loginUser(Username, Password);
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
            menuBoard.privilageUsers(logInUserFirstName, logInUserLastName);
        // Ang mga probataionary employee ay hindi makakapag log-in sa dashboard. Time card lang muna ang gagamitin.
        } else if ("Probationary".equals(logInUserStatus)) {
            System.out.println(" ");
            System.out.print("Unathorize access detected. ");
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
        
        
        /*
        while (logInUserAction != 6) {
            System.out.println(" ");
            System.out.println("                Choose your action:                ");
            System.out.println("1 Time In / Time Out\t\t\t4 Edit Employee's Details");
            System.out.println("2 View Employee's Time Log\t\t5 Create New Employee");
            System.out.println("3 View Employee's Personal Details\t6 Exit Portal");
            System.out.print("Action: ");
            logInUserAction = userInput.nextInt();
            System.out.println("******************************************************");
            
            if (logInUserAction == 1) {
                logInUserFirstName = logInUserFirstName.replaceAll("\\s", "");
                logInUserLastName = logInUserLastName.replaceAll("\\s", "");
                TimeInTimeOutPage.timeInTimeOutPage(logInUserFirstName, logInUserLastName);
            } else if (logInUserAction == 2) {
                ViewEmpWorkedHours.workedHours();
            } else if (logInUserAction == 3) {
                viewEmployeeDetailPage();
            } else if (logInUserAction == 4) {
                EditEmployeeDetails.editEmpByID();
            } else if (logInUserAction == 5) {
                createNewUser.addNewUser();
            } else if (logInUserAction == 99) {
                Credits.CCTO();
            }
        }
        */
        
    }
    
}
