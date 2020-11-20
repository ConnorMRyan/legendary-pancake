package com.revature.utils;

public class Authentication {

    public static boolean verifyUser(String username, String password){
        String SQL = "SELECT ers_password FROM users.ers_users WHERE ers_users_id = ?";
        String hashedPass = PasswordEncoder.hashPassword("");
        return PasswordEncoder.confirmPass(password,hashedPass);
    }
}
