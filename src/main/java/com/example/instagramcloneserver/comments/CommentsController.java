package com.example.instagramcloneserver.comments;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentsController {

    private final CommentsRepository repo;

    public CommentsController(CommentsRepository repo) { this.repo = repo; }

    @PostMapping("/addcomment")
    int addComment(@RequestParam("userId") int userId, @RequestParam("postId") int postId, @RequestParam("uname") String uname, @RequestParam("comment") String comment){
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

    @GetMapping("/deleteandgetcomment")
    Optional<Comments> deleteAndGetComment(@RequestParam int id){
        try{
            Optional<Comments> comm = repo.findById(id);
            repo.deleteById(id);
            return comm;
        }catch (Exception e){
            System.out.println("Delete comment: " + e.getMessage());
            return Optional.empty();
        }
    }
}
