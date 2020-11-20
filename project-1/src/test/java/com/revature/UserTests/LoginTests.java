package com.revature.UserTests;

import com.revature.utils.Authentication;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTests {

    @Test
    public void correctLogin(){
        String username = "test";
        String password = "test";
        boolean authenticated = Authentication.verifyUser(username,password);
        assertTrue(authenticated);
    }
}
