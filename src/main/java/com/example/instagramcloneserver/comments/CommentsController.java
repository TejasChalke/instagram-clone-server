package com.example.instagramcloneserver.comments;

import com.example.instagramcloneserver.requestbodystructure.CommentData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    private final CommentsRepository repo;

    public CommentsController(CommentsRepository repo) { this.repo = repo; }

    @PostMapping("/addcomment")
    int verifyLogin(@RequestParam("userId") int userId, @RequestParam("postId") int postId, @RequestParam("uname") String uname, @RequestParam("comment") String comment){
        try {
            Comments com = repo.saveAndFlush(new Comments(userId, postId, uname, comment));
            return com.getId();
        } catch (Exception e){
            System.out.println("Add Comment: " + e.getMessage());
            return -1;
        }
    }

    @GetMapping("/getcomments")
    List<Comments> getComments(@RequestParam int pid){
        try{
            return repo.findByPostid(pid);
        }catch (Exception e){
            System.out.println("Get comments: " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/deletecomment")
    int deleteComment(@RequestParam int id){
        try{
            repo.deleteById(id);
            return 1;
        }catch (Exception e){
            System.out.println("Delete comment: " + e.getMessage());
            return -1;
        }
    }
}
