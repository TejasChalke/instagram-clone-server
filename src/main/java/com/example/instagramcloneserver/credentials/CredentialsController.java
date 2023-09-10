package com.example.instagramcloneserver.credentials;

import com.example.instagramcloneserver.requestbodystructure.LoginData;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
