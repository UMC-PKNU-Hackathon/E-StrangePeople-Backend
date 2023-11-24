package com.hackathon.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDetailResponse {
    private Author author;
    private Long articleId;
    private String introduce;
    private String thumbnail;
    private String season;
    private String region;
    private String period;
    private Integer allExpense;
    private LocalDateTime createdAt;

    private RouteAddressResponse routeAddressResponse;

    private RouteDtos routeDtos;
}
