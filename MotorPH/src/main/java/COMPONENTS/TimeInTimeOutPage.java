package COMPONENTS;
import com.grou4.services.TimeService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class TimeInTimeOutPage {
    
    public static void timeInTimeOutPage(String searchFName, String searchLName) throws IOException {
        TimeService timeService = new TimeService();
        Scanner userTimeInInput = new Scanner(System.in);
        
        LocalDate dateNow = LocalDate.now();
        String searchDate = dateNow.toString();
        
        String fullName = searchFName +" " +searchLName;
        String workStatus = null;
        String workStatusPrint = null;
        String workStatusInput = null;

        workStatus = timeService.getTimeDataSingleDay(searchDate, searchFName, searchLName);
        
        if ("IN".equals(workStatus)) {
            workStatusInput = "B1";
            workStatusPrint = "Take a Break";
        } else if ("B1".equals(workStatus)) {
            workStatusInput = "B1IN";
            workStatusPrint = "Break time done";
        } else if ("B1IN".equals(workStatus)) {
            workStatusInput = "OUT";
            workStatusPrint = "Time out";
        } else {
            workStatusInput = "IN";
            workStatusPrint = "Time in";
        }
        
        char recordUserTime;
        System.out.println("*                  Time In / Time Out                *");
        System.out.print(workStatusPrint +"? Y/N: ");
        recordUserTime = Character.toUpperCase(userTimeInInput.next().charAt(0));

        if (recordUserTime != 'Y' && recordUserTime != 'N') {
            System.out.println("Pleamse choose between Y or N");
        } else if(recordUserTime == 'N') {
            System.out.println("Clock in abort.");
        } else {
            timeService.timeIn(workStatusInput, fullName);
            System.out.println(fullName +"'s" +" time has been recorded.");
        }
        
        System.out.println("******************************************************");
    }
    
}
