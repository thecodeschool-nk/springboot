package main.java.com.thecodeschool.springweb.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("niraj")
                && password.equalsIgnoreCase("pass1234");
    }

}