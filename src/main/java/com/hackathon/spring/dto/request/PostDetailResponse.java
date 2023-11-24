package com.hackathon.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDetailResponse {
    private String nickName;
    private Long articleId;
    private String title;
    private String introduce;
    private String thumbnail;
    private String season;
    private String region;
    private String period;
    private Integer allExpense;
    private LocalDateTime createdAt;

    private List<RouteAddressResponse> routeAddressResponse;

    private RouteDtos routeDtos;
}
