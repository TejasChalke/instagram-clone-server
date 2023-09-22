package com.example.instagramcloneserver.credentials;

import com.example.instagramcloneserver.requestbodystructure.LoginData;

import org.springframework.web.bind.annotation.*;

@RestController
public class CredentialsController {

    private final CredentialsRepository repo;

    public CredentialsController(CredentialsRepository repo) { this.repo = repo; }

    @PostMapping("/signin")
    int verifyLogin(@RequestBody LoginData data){
        try {
            Credentials userCred = repo.findByEmailAndPass(data.email, data.pass);
            return userCred.getId();
        } catch (Exception e){
            return -1;
        }
    }

    @GetMapping("/getbyemail")
    int getByEmail(@RequestParam String email){
        try {
            if(repo.findByEmail(email) == null) return 1;
            return 0;
        } catch (Exception e){
            System.out.println("Error getting user by uname" + e.getMessage());
            return -1;
        }
    }

    @PostMapping("/addcredentials")
    int addCreds(@RequestParam String email, @RequestParam String pass){
        try {
            Credentials userCred = repo.saveAndFlush(new Credentials(email, pass));
            return userCred.getId();
        } catch (Exception e){
            return -1;
        }
    }

}
