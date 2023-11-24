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
public class RouteDto {
    private Long routeId;
    private Integer routeOrder;
    private String x;
    private String y;
    private String content;
    private Integer expense;
    private String transportation;
    private LocalDateTime createdAt;
    private Boolean isAuthor;
}
