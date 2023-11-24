package com.hackathon.spring.controller;

import com.amazonaws.Response;
import com.hackathon.spring.dto.request.ArticlePreviewDtos;
import com.hackathon.spring.dto.request.ArticleRequest;
import com.hackathon.spring.dto.request.PostDetailResponse;
import com.hackathon.spring.dto.request.RouteCreateRequests;
import com.hackathon.spring.security.CurrentUser;
import com.hackathon.spring.security.UserPrincipal;
import com.hackathon.spring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    ResponseEntity<String> saveMessage(@RequestBody RouteCreateRequests routeCreateRequests){
        if (articleService.createPost(routeCreateRequests)){
            return new ResponseEntity<>("success post article", HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            return new ResponseEntity<>("fail post article", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/articles")
    ResponseEntity<List> save(@RequestParam(defaultValue = "NULL") String location, @RequestParam(defaultValue = "NULL") String season){

        return new ResponseEntity<>(articleService.readArticles(location, season), HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/search/{title}")
    ResponseEntity<?> search(@PathVariable String title){
        ArticlePreviewDtos articlePreviewDtos = articleService.search(title);
        return new ResponseEntity<>(articlePreviewDtos, HttpStatus.OK);
    }
    @GetMapping("/article/detail")
    ResponseEntity<PostDetailResponse> get(@RequestParam Long introId){



        return new ResponseEntity<>(articleService.getdetail(introId), HttpStatus.NOT_ACCEPTABLE);
    }



}
