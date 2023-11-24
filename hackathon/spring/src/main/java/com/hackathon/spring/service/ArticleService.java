package com.hackathon.spring.service;

import com.hackathon.spring.domain.Blog;
import com.hackathon.spring.domain.Intro;
import com.hackathon.spring.domain.RoutePost;
import com.hackathon.spring.domain.User;
import com.hackathon.spring.dto.request.ArticleRequest;
import com.hackathon.spring.dto.request.IntroCreateRequest;
import com.hackathon.spring.dto.request.RouteCreateRequest;
import com.hackathon.spring.dto.request.RouteCreateRequests;
import com.hackathon.spring.repository.BlogRepository;
import com.hackathon.spring.repository.IntroRepository;
import com.hackathon.spring.repository.RoutePostRepository;
import com.hackathon.spring.repository.UserRepository;
import com.hackathon.spring.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private IntroRepository introRepository;
    @Autowired
    private RoutePostRepository routePostRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;

    public Boolean createPost(UserPrincipal userPrincipal, ArticleRequest articleRequest){
        User user = userRepository.findById(userPrincipal.getId()).get();
        IntroCreateRequest introCreateRequest = articleRequest.getIntroCreateRequest();
        Intro intro = introCreateRequest.toIntro(user);
        Intro introResult = introRepository.save(intro);

        List<RouteCreateRequest> routePosts = articleRequest.getRouteCreateRequests().getListRouteCreateRequest();
        Integer count = 1;
        Integer allExpense = 0;
        for(RouteCreateRequest routeCreateRequest : routePosts){
            RoutePost routePost = new RoutePost();
            routePost.setRouteOrder(count);
            routePost.setAddress(routeCreateRequest.getAddress());
            routePost.setContent(routeCreateRequest.getContent());
            routePost.setTransportation(routeCreateRequest.getTransposrtation());
            routePost.setExpense(routeCreateRequest.getExpense());
            routePost.setIntro(introResult);
            allExpense = allExpense + routeCreateRequest.getExpense();
            routePostRepository.save(routePost);
            count++;
        }
        introResult.setAllExpense(allExpense);
        introRepository.save(introResult);

        return true;

    }


}
