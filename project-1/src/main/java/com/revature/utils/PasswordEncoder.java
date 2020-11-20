package com.revature.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordEncoder {
    static Argon2 encoder =  Argon2Factory.create();

    PasswordEncoder(){}

    public static String hashPassword(String pass) {
        char[] passToEncode = pass.toCharArray();
        // Using low memory and iterations for speed, if using for actual security remember to up these.
        String hashPass = encoder.hash(10, 2048, 10, passToEncode);
        encoder.wipeArray(passToEncode);
        return hashPass;
    }

    public static  Boolean confirmPass(String passToConfirm, String hashedPass) {
        char[] passToCheck = passToConfirm.toCharArray();
        boolean confirm = encoder.verify(hashedPass, passToCheck);
        encoder.wipeArray(passToCheck);
        return confirm;

    }
}
