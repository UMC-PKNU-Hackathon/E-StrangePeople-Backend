package com.hackathon.spring.dto.request;

import com.hackathon.spring.domain.Blog;
import com.hackathon.spring.domain.Intro;
import com.hackathon.spring.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntroCreateRequest {
    private String title;
    private String introduce;
    private String thumbnail;
    private String season;
    private String region;
    private String period;

    public Intro toIntro(User user){
        Intro intro = new Intro();
        intro.setTitle(title);
        intro.setIntroduce(introduce);
        intro.setThumnail(thumbnail);
        intro.setSeason(season);
        intro.setRegion(region);
        intro.setPeriod(period);
        intro.setIsModify(false);
        intro.setAllExpense(0);
        intro.setUser(user);
        return intro;
    }
}
