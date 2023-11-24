package com.hackathon.spring.controller;

import com.hackathon.spring.dto.request.ArticleRequest;
import com.hackathon.spring.security.CurrentUser;
import com.hackathon.spring.security.UserPrincipal;
import com.hackathon.spring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    ResponseEntity<String> saveMessage(@CurrentUser UserPrincipal userPrincipal, @RequestBody ArticleRequest articleRequest){
        if (articleService.createPost(userPrincipal, articleRequest)){
            return new ResponseEntity<>("success post article", HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            return new ResponseEntity<>("fail post article", HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
