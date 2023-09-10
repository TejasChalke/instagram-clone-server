package com.example.instagramcloneserver.user;

import com.example.instagramcloneserver.requestbodystructure.FollowData;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    private final UsersRepository repo;

    public UsersController(UsersRepository repo){
        this.repo = repo;
    }

    @RequestMapping("/getall")
    List<Users> hello(){
        return repo.findAll();
    }

    @GetMapping("/getuser/{id}")
    Optional<Users> getUserData(@PathVariable("id") int id){
        try {
            return repo.findById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/getrandomusers/{id}")
    List<Users> getRandomUsers(@PathVariable("id") int id){
        return repo.findRandomUsers(id);
    }

    @GetMapping("/getfollowers/{id}")
    List<Users> getFollowers(@PathVariable("id") int id){
        return repo.findFollowers(id);
    }

    @GetMapping("/getfollowings/{id}")
    List<Users> getFollowings(@PathVariable("id") int id){
        return repo.findFollowings(id);
    }

    @GetMapping("/getusersbypattern/{pattern}")
    List<Users> getUsersByPattern(@PathVariable("pattern") String pattern){
        return repo.findByPattern(pattern);
    }
}
