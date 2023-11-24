package com.hackathon.spring.service;

import com.hackathon.spring.domain.Blog;
import com.hackathon.spring.domain.Intro;
import com.hackathon.spring.domain.RoutePost;
import com.hackathon.spring.domain.User;
import com.hackathon.spring.dto.request.*;
import com.hackathon.spring.repository.BlogRepository;
import com.hackathon.spring.repository.IntroRepository;
import com.hackathon.spring.repository.RoutePostRepository;
import com.hackathon.spring.repository.UserRepository;
import com.hackathon.spring.security.UserPrincipal;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Boolean createPost(RouteCreateRequests routeCreateRequests){
        RouteCreateRequest routeCreateRequest = routeCreateRequests.getListRouteCreateRequest().get(0);
        Intro intro = introRepository.findByIntroId(routeCreateRequest.getIntroId()).get();
        User user = intro.getUser();

        List<RouteCreateRequest> routePosts = routeCreateRequests.getListRouteCreateRequest();
        Integer count = 1;
        Integer allExpense = 0;
        for(RouteCreateRequest routeCreate : routePosts){
            RoutePost routePost = new RoutePost();
            routePost.setRouteOrder(count);
            routePost.setX(routeCreate.getX());
            routePost.setY(routeCreate.getY());
            routePost.setContent(routeCreate.getContent());
            routePost.setTransportation(routeCreate.getTransposrtation());
            routePost.setExpense(routeCreate.getExpense());
            routePost.setIntro(intro);
            allExpense = allExpense + routeCreate.getExpense();
            routePostRepository.save(routePost);
            count++;
        }
        intro.setAllExpense(allExpense);
        introRepository.save(intro);

        return true;

    }

    public List<ArticlePreviewDto> readArticles(String location, String season){
        List<Intro> intros = new ArrayList<>();
        if(location.equals("NULL")&&season.equals("NULL")){
            intros = introRepository.findByorder();
        }
        else if(!location.equals("NULL")&&season.equals("NULL")){
            intros = introRepository.findBylocal(location);
        }
        else if(location.equals("NULL")&&!season.equals("NULL")){
            intros = introRepository.findByseason(season);
        }
        List<ArticlePreviewDto> listArticlePreviewDto = new ArrayList<>();

        for(Intro intro : intros){
            ArticlePreviewDto articlePreviewDto = new ArticlePreviewDto();
            articlePreviewDto.setTitle(intro.getTitle());
            articlePreviewDto.setThumbnail(intro.getThumnail());
            articlePreviewDto.setLocaldate(intro.getCreateAt());
            listArticlePreviewDto.add(articlePreviewDto);
        }


        return listArticlePreviewDto;
    }


    public ArticlePreviewDtos search(String title) {
        List<Intro> allByTitle = introRepository.findAllByTitleContaining(title);
        List<ArticlePreviewDto> collect = allByTitle.stream()
                .map(ArticlePreviewDto::of)
                .collect(Collectors.toList());

        return new ArticlePreviewDtos(collect);
    }
}
