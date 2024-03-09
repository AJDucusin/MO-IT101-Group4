package COMPONENTS;
import com.grou4.services.TimeService;
import constructor.Time;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ViewEmpWorkedHours {
    
    public static double workedHours() throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        
        int empID = 0;
        String startDate = null;
        String endDate = null;
        
        System.out.println("*                  View Worked Hours                 *");
        
        System.out.print("Enter employee ID: \t");
        empID = scanner.nextInt();
        String pasalo = scanner.nextLine();
        System.out.println("Enter Start Date.");
        System.out.print("yyyy-MM-dd: \t");
        startDate = scanner.nextLine();
        System.out.println("Enter End Date.");
        System.out.print("yyyy-MM-dd: \t");
        endDate = scanner.nextLine();
        
        // Starting from here, puwede nyo ng i-copy tong code na ito for salary computation
        double totalWorkedHours = 0;
        double totalBreakHours = 0;
        LocalTime workStart = null;
        LocalTime workEnd = null;
        LocalTime breakStart = null;
        LocalTime breakEnd = null;
    
        List<Time> filteredTimeList = TimeService.viewTimeByRange(empID, startDate, endDate);
        
        for (int i = 0; i < filteredTimeList.size(); i++) {
            Time timeEntry = filteredTimeList.get(i);
            String status = timeEntry.getWorkStatus();
            LocalTime time = LocalTime.parse(timeEntry.getWorkTime());
            String workedDate = timeEntry.getWorkDate();
            
            // Ang part na to ay pang display lang ng status, date, and time
            System.out.println(status +"\t" +workedDate +"\t" +time);

            
            if (status.equals("IN")) {
                workStart = time;
            } else if (status.equals("B1")) {
                breakStart = time;
            } else if (status.equals("B1IN")) {
                breakEnd = time;
            } else if (status.equals("OUT")) {
                workEnd = time;
                
                if (workStart != null && workEnd != null) {
                    Duration workedHours = Duration.between(workStart, workEnd);
                    totalWorkedHours += workedHours.toMinutes();
                    workStart = null;
                    workEnd = null;
                }
                
                if (breakStart != null && breakEnd != null) {
                    Duration breakHours = Duration.between(breakStart, breakEnd);
                    totalBreakHours += breakHours.toMinutes();
                    breakStart = null;
                    breakEnd = null;
                }
                System.out.println("----------------------------------");
            }
        }
        System.out.println(" ");
        System.out.println("Employee " +empID);
        System.out.println("worked hours from: " +startDate +" to: " +endDate);
        System.out.println("--------------------------------------------");
        double totalHours = (totalWorkedHours-totalBreakHours)/60;
        System.out.println("Total Hours: "+totalHours+"Hrs");
        System.out.println("******************************************************");
        return totalHours;
    }
    
    
    
    
    public static void workedHoursDetailed(int logInUserID) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        
        int empID = 0;
        String startDate = null;
        String endDate = null;
        String line1 = "******************************************************";
        
        System.out.println("*                  View Worked Hours                 *");
        
        System.out.println("Enter Start Date.");
        System.out.print("yyyy-MM-dd: \t");
        startDate = scanner.nextLine();
        System.out.println("Enter End Date.");
        System.out.print("yyyy-MM-dd: \t");
        endDate = scanner.nextLine();
        
        // Nag declare ako ng mga variable na gagamitin ko throughout the class.
        double totalWorkedHours = 0;
        double totalBreakHours = 0;
        double totalHoursDetailed = 0;
        LocalTime workStart = null;
        LocalTime workEnd = null;
        LocalTime breakStart = null;
        LocalTime breakEnd = null;
    
        List<Time> filteredTimeList = TimeService.viewTimeByRange(logInUserID, startDate, endDate); // Ang 'viewTimeByRange' class ang responsible sa pag-kuha ng time-in time-out ni user
        
        for (int i = 0; i < filteredTimeList.size(); i++) {
            Time timeEntry = filteredTimeList.get(i);
            String status = timeEntry.getWorkStatus();
            LocalTime time = LocalTime.parse(timeEntry.getWorkTime());
            String workedDate = timeEntry.getWorkDate();
            
            // Ang part na to ay pang display lang ng status, date, and time
            System.out.println(status +"\t" +workedDate +"\t" +time);

            
            if (status.equals("IN")) {
                workStart = time;
            } else if (status.equals("B1")) {
                breakStart = time;
            } else if (status.equals("B1IN")) {
                breakEnd = time;
            } else if (status.equals("OUT")) {
                workEnd = time;
                
                if (workStart != null && workEnd != null) {
                    Duration workedHours = Duration.between(workStart, workEnd);
                    totalWorkedHours += workedHours.toMinutes();
                    workStart = null;
                    workEnd = null;
                }
                
                if (breakStart != null && breakEnd != null) {
                    Duration breakHours = Duration.between(breakStart, breakEnd);
                    totalBreakHours += breakHours.toMinutes();
                    breakStart = null;
                    breakEnd = null;
                }
                
                totalHoursDetailed = (totalWorkedHours-totalBreakHours)/60;
                String salo = "salo";
                if(totalHoursDetailed < 8) {
                    double undertime = 8-Math.round(totalHoursDetailed*100.00)/100.00;
                    double workedHoursDD = Math.round(totalHoursDetailed*100.00)/100.00;
                    int width = String.valueOf(line1).length()-((String.valueOf(undertime).length()+11)+(String.valueOf(workedHoursDD).length()+12));
                    System.out.printf("Worked Hrs: %1$-" + width +"sUndertime: %2$s", workedHoursDD, undertime);
                    System.out.println("");
                } else {
                    int width = 20;
                    double workedHoursDD = Math.round(totalHoursDetailed*100.00)/100.00;
                    System.out.println("Worked Hrs: " +workedHoursDD);
                }
                System.out.println("----------------------------------");
            }
            // Dito ko nireset ang lahat ng mga nakuhang time, para hindi mag accumulate ang time and values. para mag accumulate ulit ang time buburahin lang to.
            totalWorkedHours = 0;
            totalBreakHours = 0;
            totalHoursDetailed = 0;
        }

    }
    
    
    
    // Ang 'getOvertime' method ay kinuha ko lang sa 'workedHoursDetailed' method.
    public static double getOvertime(int logInUserID, String startDate, String endDate) throws IOException {
        
        double overtimeHours = 0.00;
        LocalTime workStart = null;
        LocalTime workEnd = null;
        LocalTime breakStart = null;
        LocalTime breakEnd = null;
        double totalWorkedHours = 0;
        double totalBreakHours = 0;
        double totalHoursDetailed = 0;
        
        
        List<Time> filteredTimeList = TimeService.viewTimeByRange(logInUserID, startDate, endDate); // Ang 'viewTimeByRange' class ang responsible sa pag-kuha ng time-in time-out ni user
        
        for (int i = 0; i < filteredTimeList.size(); i++) {
            Time timeEntry = filteredTimeList.get(i);
            String status = timeEntry.getWorkStatus();
            LocalTime time = LocalTime.parse(timeEntry.getWorkTime());
            String workedDate = timeEntry.getWorkDate();

            
            if (status.equals("IN")) {
                workStart = time;
            } else if (status.equals("B1")) {
                breakStart = time;
            } else if (status.equals("B1IN")) {
                breakEnd = time;
            } else if (status.equals("OUT")) {
                workEnd = time;
                
                if (workStart != null && workEnd != null) {
                    Duration workedHours = Duration.between(workStart, workEnd);
                    totalWorkedHours += workedHours.toMinutes();
                    workStart = null;
                    workEnd = null;
                }
                
                if (breakStart != null && breakEnd != null) {
                    Duration breakHours = Duration.between(breakStart, breakEnd);
                    totalBreakHours += breakHours.toMinutes();
                    breakStart = null;
                    breakEnd = null;
                }
                
                totalHoursDetailed = (totalWorkedHours-totalBreakHours)/60;
                
                // Ito lang ang dinagdag ko para makuha ko ang overtime.
                if(totalHoursDetailed > 8) {
                    double hoursMinusEight = totalHoursDetailed-8;
                    overtimeHours += hoursMinusEight;
                }
                
            }
            totalWorkedHours = 0;
            totalBreakHours = 0;
            totalHoursDetailed = 0;
        }
        return overtimeHours;
    }
    
}
