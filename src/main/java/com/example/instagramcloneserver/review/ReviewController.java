package com.example.instagramcloneserver.review;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    private final ReviewRepository repo;

    public ReviewController(ReviewRepository repo) { this.repo = repo; }

    @GetMapping("/addreview")
    int addReview(@RequestParam int pendingid){
        try{
            repo.save(new Review(pendingid));
            return 1;
        }catch (Exception e){
            System.out.println("Adding review: " + e.getMessage());
            return -1;
        }
    }

    @Transactional
    @GetMapping("/deletereview")
    int deleteReview(@RequestParam int pendingid){
        try{
            repo.deleteByPendingid(pendingid);
            return 1;
        }catch (Exception e){
            System.out.println("Deleting review: " + e.getMessage());
            return -1;
        }
    }
}
