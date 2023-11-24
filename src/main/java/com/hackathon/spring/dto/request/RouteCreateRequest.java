package com.hackathon.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RouteCreateRequest {
    private Long introId;
    private String x;
    private String y;
    private String content;
    private String transposrtation;
    private Integer expense;

}
