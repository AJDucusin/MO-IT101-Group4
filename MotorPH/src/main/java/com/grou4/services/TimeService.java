package com.grou4.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.FileReader; // Ito ang class sa loob ng java framework na responsible sa pag-read ng mga files.
import java.time.format.DateTimeFormatter;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import constructor.Time;
import constructor.User;
import com.grou4.services.AdminService;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class TimeService {
    // Nilagay ko sa 'private static final' ang String filePath, para dito lang magamit ang variable na to.
    private static final String filePath = "C:\\Users\\ducus\\Desktop\\MO-IT101-Group4\\MotorPH\\src\\main\\java\\TimeKeeper\\time_keeper_file.txt";
    
    public void timeIn(String workType, String fullName) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Ito ang nag didictate kung anong format ng time
        String timeFormatted = currentTime.format(timeFormatter);
        
        Path path = Paths.get(filePath);
        Files.write(path, (workType +" " +timeFormatted +" " +fullName +System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    
    public String getTimeDataSingleDay(String searchDate, String searchFName, String searchLName) throws IOException {
        String workStatus = null;
        
        // Ito ang nag reread ng txt file
        FileReader fileReader = new FileReader(filePath);
        // Ito ang responsible sa pag-convert ng read txt file into array. Dito nakuha nag readLine() method.
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        // Ito ang mag-iiterate at mag hihimayhimay sa lahat ng text line sa loob ng txt file.
        while ((line = reader.readLine()) != null) {
            String[] lineParts = line.split("\\s+");
            // Ito ang responsible sa pag-validate ng search date and name.
            if (lineParts.length != 0 && lineParts[1].equals(searchDate) && lineParts[3].equals(searchFName) && lineParts[4].equals(searchLName)) {
                workStatus = lineParts[0];
            }
        }
        return workStatus;
    }
    
    public static List<Time> readTimeEntries(String wtFirstName, String wtLastName) throws IOException {
        List<Time> timeEntries = new ArrayList<>();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] timeParts = line.split(" ");
                if (timeParts.length >= 4) {
                    String workStatus = timeParts[0];
                    String workDate = timeParts[1];
                    String workTime = timeParts[2];
                    String workFName = timeParts[3];
                    String workLName = timeParts[4];

                    Time entry = new Time(workStatus, workDate, workTime, workFName, workLName);
                    timeEntries.add(entry);
                }
            }
        }
        return timeEntries;
    }
    
    public static List<Time> viewTimeByRange(int empID, String startDate, String endDate) throws IOException {

        AdminService adminService = new AdminService();
        List<Time> timeEntries = new ArrayList<>();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Ito ang nag lolocate ng text file
        FileReader fileReader = new FileReader(filePath);
        // Ito ang nag babasa ng content ng text file ko.
        BufferedReader reader = new BufferedReader(fileReader);
        
        String FName;
        String LName;
        String FullName;

        User idToName = adminService.getUserByID(empID);
        FName = idToName.getFirstName().replaceAll("\\s+", "");
        LName = idToName.getLastName().replaceAll("\\s+", "");
        FullName = FName +" " +LName;
        
        LocalDate localStartDate = LocalDate.parse(startDate);
        LocalDate localEndDate = LocalDate.parse(endDate);
        
        LocalDateTime localStartDateTime = localStartDate.atStartOfDay();
        LocalDateTime localEndDateTime = localEndDate.atTime(23, 59);
        
        try (reader) {
            String line;
            // Kondition: hanga't hindi null/empty ang line, mag iterate sya ng mga line sa loob ng text file.
            while ((line = reader.readLine()) != null) {
                String[] timeParts = line.split(" ");
                if (timeParts.length >= 4) {
                    
                    LocalDateTime timestamp = LocalDateTime.parse(timeParts[1] + " " + timeParts[2], timeFormatter);
                    String employeeFullName = timeParts[3] +" " +timeParts[4];
                    
                    // Ito ang nag bubuo ng list/array ng mga data para magamit ko sa variables.
                    StringBuilder record = new StringBuilder();
                    for (int i = 0; i < timeParts.length; i++) {
                        record.append(timeParts[i]).append(" ");
                    }
                    Time entry = new Time(timeParts[0], timeParts[1], timeParts[2], timeParts[3], timeParts[4]);
                    //timeEntries.add(entry);
                    
                    if (timestamp.isAfter(localStartDateTime) && timestamp.isBefore(localEndDateTime) && FullName.equalsIgnoreCase(employeeFullName)) {
                        timeEntries.add(entry);
                        String salo = "";
                    }
                }
            }
            return timeEntries;
        }
    }
    
    public static List<Time> viewWorkedHours(int empID, String startDate, String endDate) throws IOException {

        AdminService adminService = new AdminService();
        List<Time> timeEntries = new ArrayList<>();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Ito ang nag lolocate ng text file
        FileReader fileReader = new FileReader(filePath);
        // Ito ang nag babasa ng content ng text file ko.
        BufferedReader reader = new BufferedReader(fileReader);
        
        String FName;
        String LName;
        String FullName;

        User idToName = adminService.getUserByID(empID);
        FName = idToName.getFirstName().replaceAll("\\s+", "");
        LName = idToName.getLastName().replaceAll("\\s+", "");
        FullName = FName +" " +LName;
        
        LocalDate localStartDate = LocalDate.parse(startDate);
        LocalDate localEndDate = LocalDate.parse(endDate);
        
        LocalDateTime localStartDateTime = localStartDate.atStartOfDay();
        // Ang .stTime() class ay para 
        LocalDateTime localEndDateTime = localEndDate.atTime(23, 59);
        
        try (reader) {
            String line;
            // Kondition: hanga't hindi null/empty ang line, mag iterate sya ng mga line sa loob ng text file.
            while ((line = reader.readLine()) != null) {
                String[] timeParts = line.split(" ");
                if (timeParts.length >= 4) {
                    
                    LocalDateTime timestamp = LocalDateTime.parse(timeParts[1] + " " + timeParts[2], timeFormatter);
                    String employeeFullName = timeParts[3] +" " +timeParts[4];
                    
                    // Ito ang nag bubuo ng list/array ng mga data para magamit ko sa variables.
                    StringBuilder record = new StringBuilder();
                    for (int i = 0; i < timeParts.length; i++) {
                        record.append(timeParts[i]).append(" ");
                    }
                    Time entry = new Time(timeParts[0], timeParts[1], timeParts[2], timeParts[3], timeParts[4]);
                    //timeEntries.add(entry);
                    
                    
                    if (timestamp.isAfter(localStartDateTime) && timestamp.isBefore(localEndDateTime) && FullName.equalsIgnoreCase(employeeFullName)) {
                        timeEntries.add(entry);
                        String salo = "";
                    }
                }
            }
            return timeEntries;
        }
    }
    
    
}
