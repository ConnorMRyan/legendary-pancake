package com.revature.utils;

import com.revature.DAO.EmployeeDAO;
import com.revature.models.Employee;
import org.hibernate.Session;

public class Authentication {

    public static boolean verifyUser(String username, String password){
        Employee employee = EmployeeDAO.getEmployeeFromUsername(username);
        if(employee == null){
            return false;
        }
        String hashedPass = PasswordEncoder.hashPassword(password);
        return PasswordEncoder.confirmPass(employee.getPassword(),hashedPass);
    }

}
