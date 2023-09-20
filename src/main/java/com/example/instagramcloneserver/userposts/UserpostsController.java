package com.example.instagramcloneserver.userposts;

import com.example.instagramcloneserver.misc.ImageUtil;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserpostsController {

    private final UserpostsRepository repo;

    public  UserpostsController(UserpostsRepository repo){
        this.repo = repo;
    }

    @PostMapping("/addpost")
    int addPost(@RequestParam("image") MultipartFile image, @RequestParam("userId") int userId, @RequestParam("description") String description){
        try{
            Userposts up = repo.saveAndFlush(new Userposts(userId, description, ImageUtil.compressImage(image.getBytes()), 0));
            return up.getId();
        }catch (Exception e){
            System.out.println("Error adding post: " + e.getMessage());
            return -1;
        }
    }

    @GetMapping("/getposts")
    List<Userposts> getPosts(@RequestParam int userId){
        try{
            List<Userposts> res = repo.findByUserid(userId);
            for(Userposts up : res){
                up.setImage(ImageUtil.decompressImage(up.getImage()));
            }

            return res;
        }catch (Exception e){
            System.out.println("Error getting posts for " + userId + ": " + e.getMessage());
            return null;
        }
    }
}
