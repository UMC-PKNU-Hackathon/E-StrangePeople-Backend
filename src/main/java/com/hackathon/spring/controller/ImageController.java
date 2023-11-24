package com.hackathon.spring.controller;

import com.hackathon.spring.util.AwsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
    @Autowired
    private AwsUtils awsUtils;
    @PostMapping("/image")
    ResponseEntity<?> postImage(@RequestParam MultipartFile image){
        try{
            String url = awsUtils.upload(image, "saerok").getPath();
            return new ResponseEntity<>(url, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("failed", HttpStatus.FORBIDDEN);
        }


    }
}
