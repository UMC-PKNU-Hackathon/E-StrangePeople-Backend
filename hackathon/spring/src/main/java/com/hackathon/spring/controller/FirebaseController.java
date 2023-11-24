package com.hackathon.spring.controller;


import com.hackathon.spring.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FirebaseController {

    @Autowired
    private FirebaseService firebaseService;

    /**
     * this method is used to post/upload files into the google cloud firebase
     * @param file variable shall contain multipart file to be uploaded
     * @return success message on uploading the file
     * @throws Exception
     */
    @PostMapping("/Image")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        return firebaseService.uploadFile(file);
    }

}