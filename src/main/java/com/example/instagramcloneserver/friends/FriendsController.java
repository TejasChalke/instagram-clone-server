package com.example.instagramcloneserver.friends;

import com.example.instagramcloneserver.requestbodystructure.FollowData;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendsController {

    private final FriendsRepository repo;

    public FriendsController(FriendsRepository repo) { this.repo = repo; }

    @GetMapping("/checkfriends")
    int checkFriends(@RequestParam int userId, @RequestParam int followerId){
        try {
            Friends friends = repo.findByUserAndFollower(userId, followerId);

            if(friends != null){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @GetMapping("/getfollowercount")
    int getFollowerCount(@RequestParam int userId){
        try{
            return repo.findByUser(userId).size();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @GetMapping("/getfollowingcount")
    int getFollowingCount(@RequestParam int userId){
        try{
            return repo.findByFollower(userId).size();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @PostMapping("/followuser")
    int followUser(@RequestBody FollowData body){
        try {
            repo.save(new Friends(Integer.parseInt(body.userId), Integer.parseInt(body.followerId)));
            return 1;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @CrossOrigin
    @DeleteMapping("/unfollowuser")
    int unfollowUser(@RequestBody FollowData body){
        try {
            repo.delete(new Friends(Integer.parseInt(body.userId), Integer.parseInt(body.followerId)));
            return 1;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
