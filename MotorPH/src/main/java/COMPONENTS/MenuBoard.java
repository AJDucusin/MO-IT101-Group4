package COMPONENTS;

import java.util.Scanner;
import COMPONENTS.TimeInTimeOutPage;
import COMPONENTS.CreateNewUser;
import COMPONENTS.ViewEmployeeDetails;
import com.grou4.services.AdminService;
import constructor.User;
import java.io.IOException;


public class MenuBoard {
    
    public void privilageUsers(String logInUserFirstName, String logInUserLastName) throws IOException {
        
        Scanner userInput = new Scanner(System.in);

        CreateNewUser createNewUser = new CreateNewUser();
        int logInUserAction = 0;
        
        while (logInUserAction != 6) {
            System.out.println(" ");
            System.out.println("                   Choose your action:                   ");
            System.out.println("1 Time In / Time Out\t\t\t4 Edit Employee's Details");
            System.out.println("2 View Employee's Time Log\t\t5 Create New Employee");
            System.out.println("3 View Employee's Personal Details\t6 Exit Portal");
            System.out.print("Action: ");
            logInUserAction = userInput.nextInt();
            System.out.println("************************************************************");
            
            if (logInUserAction == 1) {
                logInUserFirstName = logInUserFirstName.replaceAll("\\s", "");
                logInUserLastName = logInUserLastName.replaceAll("\\s", "");
                TimeInTimeOutPage.timeInTimeOutPage(logInUserFirstName, logInUserLastName);
            } else if (logInUserAction == 2) {
                ViewEmpWorkedHours.workedHours();
            } else if (logInUserAction == 3) {
                ViewEmployeeDetails.getEmployeePersonalDetail();
            } else if (logInUserAction == 4) {
                EditEmployeeDetails.editEmpByID();
            } else if (logInUserAction == 5) {
                createNewUser.addNewUser();
            } else if (logInUserAction == 99) {
                Credits.CCTO();
            }
        }
    }
    
    public void regularUser(String logInUserFirstName, String logInUserLastName, String Username, String Password) throws IOException {
        
        User profileOfLogInUser = AdminService.loginUser(Username, Password);
        CreateNewUser createNewUser = new CreateNewUser();
        Scanner userInput = new Scanner(System.in);
        
        int logInUserID = profileOfLogInUser.getUserId();
        int logInUserAction = 0;
        
        while (logInUserAction != 5) {
        
            System.out.println(" ");
            System.out.println("                   Choose your action:                   ");
            System.out.println("1 Time In / Time Out\t\t\t4 Print Payslip");
            System.out.println("2 View My Time Log\t\t\t5 Exit Portal");
            System.out.println("3 View My Personal Details");
            System.out.print("Action: ");
            logInUserAction = userInput.nextInt();
            System.out.println("******************************************************");
            
            if (logInUserAction == 1) {
                logInUserFirstName = logInUserFirstName.replaceAll("\\s", "");
                logInUserLastName = logInUserLastName.replaceAll("\\s", "");
                TimeInTimeOutPage.timeInTimeOutPage(logInUserFirstName, logInUserLastName);
            } else if (logInUserAction == 2) {
                ViewEmpWorkedHours.workedHoursDetailed(logInUserID);
            } else if (logInUserAction == 3) {
                //ViewEmployeeDetails.getEmployeePersonalDetail();
                ViewEmployeeDetails.getMyPersonalDetail(logInUserID);
            } else if (logInUserAction == 99) {
                Credits.CCTO();
            } else if (logInUserAction == 4) {
                PrintPaySlip.employeePaySlip();
            }
        }
    }
    
}
