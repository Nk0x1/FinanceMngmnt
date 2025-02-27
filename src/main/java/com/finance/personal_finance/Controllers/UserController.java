package com.finance.personal_finance.Controllers;

import com.finance.personal_finance.Models.UserModel;
import com.finance.personal_finance.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> userSignup(@RequestBody UserModel u){
        UserModel uob = userRepo.save(u);
        Map<String, String> response = new HashMap<>();
        if(uob.getId()!=0){
            response.put("Status", "Signup Success");
        }
        else{
            response.put("Status", "Failed to Signup");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> userLogin(@RequestBody UserModel u){
        List<UserModel> uob = userRepo.validLogin(u.getEmail(), u.getPassword());
        Map<String, String> response = new HashMap<>();
        if(uob.size()>0){
            response.put("Status", "Login Success");
            response.put("UserId", String.valueOf((uob.get(0).getId())));
            response.put("Username", String.valueOf((uob.get(0).getName())));
        }else{
            response.put("Status", "Login Failed");
        }
        return ResponseEntity.ok(response);
    }

}
