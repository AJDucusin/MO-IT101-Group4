package COMPONENTS;

import com.grou4.services.AdminService;
import constructor.User;

public class LoginFunction {
    
    public boolean login(String enteredUsername, String enteredPassword) {
        User loggedInUser = AdminService.loginUser(enteredUsername, enteredPassword);
        
        if (loggedInUser == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public String getLoginInfo(String enteredUsername, String enteredPassword) {
        User getFullname = AdminService.loginUser(enteredUsername, enteredPassword);
        
        return getFullname.getFirstName() +" " +getFullname.getLastName();
    }
    
}
