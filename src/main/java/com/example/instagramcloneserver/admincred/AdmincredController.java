package com.example.instagramcloneserver.admincred;

import com.example.instagramcloneserver.requestbodystructure.LoginData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdmincredController {

    private final AdmincredRepository repo;

    public AdmincredController(AdmincredRepository repo) { this.repo = repo; }

    @PostMapping("/adminsignin")
    int verifyLogin(@RequestBody LoginData data){
        try {
            Admincred userCred = repo.findByEmailAndPass(data.email, data.pass);
            return userCred.getId();
        } catch (Exception e){
            return -1;
        }
    }
}
