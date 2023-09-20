package com.example.instagramcloneserver.requestbodystructure;

import org.springframework.web.multipart.MultipartFile;

public class PostData {
    public String userId;
    public String description;
    public MultipartFile image;
}
