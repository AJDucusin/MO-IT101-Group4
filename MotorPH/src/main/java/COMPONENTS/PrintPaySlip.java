package COMPONENTS;
import java.util.Scanner;
import constructor.User;
import com.grou4.services.AdminService;
import java.io.IOException;

public class PrintPaySlip {
    
    public static void employeePaySlip(String Username, String Password) throws InterruptedException, IOException {
        
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();
        
        User getEmpDetails = adminService.loginUser(Username, Password);
        
        String fullName = getEmpDetails.getFirstName() +" " +getEmpDetails.getLastName();
        String empStatus = getEmpDetails.getStatus();
        int empID = getEmpDetails.getUserId();
        String empPosition = getEmpDetails.getDesignation();
        double empMonthlySalary = getEmpDetails.getBasicSalary();
        
        
        //char singleAll;
        int period = 0;
        String startDate = null;
        String endDate = null;
        double empTotalAllowance = 0;
        double empTotalOvertimePay = 0;
        double empGrossPay = 0;
        double empTotalDeduction = 0;
        double empNetPay = 0;
        double empTotalBasicPay = 0;
        
        // >>>  mag lagay ng option: print current period? <<<
        
        // Ang reason kung bakit puwedeng mamili ng salary period ay;
        // Kapag ang mga employee ay mag rerequest ng copy of payslip, madali nalang mag print.
        System.out.println("******************************************************");
        System.out.println("               Choose a salary period:                ");
        periodMenu();
        period = scanner.nextInt();
        while (period != 3 && period != 4) {
            System.out.println(" ");
            System.out.println("Period out of range. . .");
            System.out.println(" ");
            Thread.sleep(2000);
            periodMenu();
            System.out.print("Please choose a salary period: ");
            period = scanner.nextInt();
            Thread.sleep(2000);
            System.out.println(" ");
        }
        
        if (period == 3) {
            startDate = "2024-02-01";
            endDate = "2024-02-15";
        } else if (period == 4) {
            startDate = "2024-02-16";
            endDate = "2024-02-29";
        }
        
        
        
        int line10Width = 70;  //<<< ito ay para lang sa with, "print with function".
        double overtimeWorkedHours = ViewEmpWorkedHours.getOvertime(empID, startDate, endDate);
        double totalWorkedHours = ViewEmpWorkedHours.returnWorkedHours(empID, startDate, endDate);
        double totalUndertimeHours = ViewEmpWorkedHours.returnUndertimeHours(empID, startDate, endDate);
        double halfPay = empMonthlySalary/2;
        double hourlyRate = getEmpDetails.getHourlyRate();
        double overtimeHourlyRate = hourlyRate * 2;
        empTotalOvertimePay = overtimeWorkedHours * overtimeHourlyRate;
        
        double riceSubsidy = getEmpDetails.getRiceSubsidy();
        double phoneSubsidy = getEmpDetails.getPhoneAllowance();
        double clothSubsidy = getEmpDetails.getClothingAllowance();
        empTotalAllowance = riceSubsidy + phoneSubsidy + clothSubsidy;
        empTotalBasicPay = totalWorkedHours * hourlyRate;
        
        double sssDeduction = empTotalBasicPay * 0.04;
        double philhealthDeduction = empTotalBasicPay * 0.04;
        double pagibigDeduction = empTotalBasicPay * 0.04;
        double taxDeduction = empTotalBasicPay * 0.12;
        double undertimeDeduction = totalUndertimeHours * hourlyRate;
        
        empGrossPay = empTotalBasicPay + empTotalOvertimePay + empTotalAllowance;
        empTotalDeduction = sssDeduction + philhealthDeduction + pagibigDeduction + taxDeduction + undertimeDeduction;
        empNetPay = empGrossPay - empTotalDeduction;
        
        
/*1*/   System.out.println("*****************************************************************************************************************");
/*2*/   System.out.println("*                                               Employee Pay Slip                                               *");
/*3*/   System.out.println("|                                                                                 |\t\t\t\t|");
/*4*/   System.out.println("| MotorPH Corporation  Group 4                                                    |\t\t\t\t|");
/*5*/   System.out.println("| " +fullName +"\t\t\tPERIOD: " +startDate +" to " +endDate +"\t  |\t\t\t\t|");
/*6*/   System.out.printf("|                                                                                 | Basic Pay:\t%1$.2f\t|", empTotalBasicPay);
        System.out.println("");
/*7*/   System.out.println("|===============================================================================================================|");
/*8*/   System.out.printf("| Employer: MotorPH\t\t\t\tStatus: " +empStatus +"\t\t\t  | Overtime:\t%1$.2f\t\t|", empTotalOvertimePay);
        System.out.println("");
/*9*/   System.out.println("|---------------------------------------------------------------------------------| 13th Month:\t0.00\t\t|");
/*10*/  System.out.printf("| Position: %1$-" +line10Width +"s| Allowance:\t%2$s\t\t|", empPosition, empTotalAllowance);
        System.out.println("");
/*11*/  System.out.println("|---------------------------------------------------------------------------------|\t\t\t\t|");
/*12*/  System.out.printf("|\t\t\t\t|\t\t\t|\t\t\t  | Gross Pay:\t%1$.2f\t|", empGrossPay);
        System.out.println("");
/*13*/  System.out.printf("|  Work     Hrs\t\tPay\t| Adjustments   Amount\t| Deduction     Amount    | Deduction:\t%1$.2f\t\t|", empTotalDeduction);
        System.out.println("");
/*14*/  System.out.println("|---------------------------------------------------------------------------------|\t\t\t\t|");
/*15*/  System.out.printf("|  Regular  %1$.2f\t%2$.2f\t| 13Month       0.00\t| Tax\t\t%3$.2f\t  |\t\t\t\t|", totalWorkedHours, hourlyRate, taxDeduction);
        System.out.println("");
/*16*/  System.out.printf("|  Overtime %1$.2f\t%2$.2f\t| Rice Subsidy  %3$.2f\t| SSS\t\t%4$.2f\t  | Net Pay:\t%5$.2f\t|", overtimeWorkedHours, overtimeHourlyRate, riceSubsidy, sssDeduction, empNetPay);
        System.out.println("");
/*17*/  System.out.printf("|\t\t\t\t| Phone Subsidy %1$.2f\t| Philhealth\t%2$.2f\t  |\t\t\t\t|", phoneSubsidy, philhealthDeduction);
        System.out.println("");
/*18*/  System.out.printf("|\t\t\t\t| Cloth Subsidy %1$.2f\t| Pag-Ibig\t%2$.2f\t  |\t\t\t\t|", clothSubsidy, pagibigDeduction);
        System.out.println("");
/*19*/  System.out.printf("|\t\t\t\t| Others\t0.00\t| Tirediness\t%1$.2f\t  |\t\t\t\t|", undertimeDeduction);
        System.out.println("");
/*20*/  System.out.println("|\t\t\t\t|\t\t\t| Loan\t\t0.00\t  |\t\t\t\t|");
/*21*/  System.out.println("|\t\t\t\t|\t\t\t| Others\t0.00\t  |\t\t\t\t|");
/*22*/  System.out.println("|\t\t\t\t|\t\t\t|\t\t\t  |\t\t\t\t|");
/*23*/  System.out.println("|\t\t\t\t|\t\t\t|\t\t\t  |\t\t\t\t|");
/*24*/  System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        
    }
    
    public static void periodMenu() {
        System.out.println("1: 2024 Jan 01-15\t\t\t13: 2024 Jul 01-15");
        System.out.println("2: 2024 Jan 16-31\t\t\t14: 2024 Jul 16-31");
        System.out.println("3: 2024 Feb 01-15\t\t\t15: 2024 Aug 01-15");
        System.out.println("4: 2024 Feb 16-29\t\t\t16: 2024 Aug 16-31");
        System.out.println("5: 2024 Mar 01-15\t\t\t17: 2024 Sep 01-15");
        System.out.println("6: 2024 Mar 16-31\t\t\t18: 2024 Sep 16-30");
        System.out.println("7: 2024 Apr 01-15\t\t\t19: 2024 Oct 01-15");
        System.out.println("8: 2024 Apr 16-30\t\t\t20: 2024 Oct 16-31");
        System.out.println("9: 2024 May 01-15\t\t\t21: 2024 Nov 01-15");
        System.out.println("10: 2024 May 16-31\t\t\t22: 2024 Nov 16-30");
        System.out.println("11: 2024 Jun 01-15\t\t\t23: 2024 Dec 01-15");
        System.out.println("12: 2024 Jun 16-30\t\t\t24: 2024 Dec 16-31");
    }
    
}
