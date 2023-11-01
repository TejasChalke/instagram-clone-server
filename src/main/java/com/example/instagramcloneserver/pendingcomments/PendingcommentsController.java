package com.example.instagramcloneserver.pendingcomments;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PendingcommentsController {
    private final PendingcommentsRepository repo;

    public PendingcommentsController(PendingcommentsRepository repo) { this.repo = repo; }

    @PostMapping("/addpendingcomment")
    int addPendingComment(@RequestParam("userId") int userId, @RequestParam("postId") int postId, @RequestParam("uname") String uname, @RequestParam("comment") String comment){
        try {
            Pendingcomments com = repo.saveAndFlush(new Pendingcomments(userId, postId, uname, comment));
            return com.getId();
        } catch (Exception e){
            System.out.println("Add Comment: " + e.getMessage());
            return -1;
        }
    }

    @PostMapping("/findpendingcomment")
    int findPendingComment(@RequestBody Map<String, Object> notifyData){
        try {
            int userid = (int) notifyData.get("userid");
            String comment = (String) notifyData.get("comment");
            System.out.println(userid + ": " + comment);

            List<Pendingcomments> comm = repo.findByUseridAndComment(userid, comment);
            return (comm != null && !comm.isEmpty()) ? comm.get(0).getId() : -1;
        }catch (Exception e){
            System.out.println("Error finding pending comment: " + e.getMessage());
            return -1;
        }
    }

    @GetMapping("/deletependingcomment")
    int deletePendingComment(@RequestParam int id){
        try{
            repo.deleteById(id);
            return 1;
        }catch (Exception e){
            System.out.println("Error deleting pending comment: " + e.getMessage());
            return -1;
        }
    }
    @GetMapping("/getpendingforreview")
    List<Pendingcomments> getPendingForReview(){
        return repo.findPendingForReview();
    }
}
