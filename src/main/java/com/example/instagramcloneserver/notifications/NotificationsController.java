package com.example.instagramcloneserver.notifications;

import com.example.instagramcloneserver.requestbodystructure.NotificationData;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class NotificationsController {

    private final NotificationsRepository repo;

    public NotificationsController(NotificationsRepository repo) { this.repo = repo; }

    @PostMapping("/addnotification")
    int addNotification(@RequestBody NotificationData body){
        try {
            java.util.Date now = new java.util.Date();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);

            Date date = Date.valueOf(formatter.format(now));
            Notifications n = repo.saveAndFlush(new Notifications(Integer.parseInt(body.user), body.type, body.message, date));
            return n.getId();
        }catch (Exception e){
            System.out.println("Add notification: " + e.getMessage());
            return -1;
        }
    }

    @GetMapping("/getnotifications")
    List<Notifications> getNotifications(@RequestParam int userId){
        try{
            return repo.findByUser(userId);
        }catch (Exception e){
            return null;
        }
    }
}
