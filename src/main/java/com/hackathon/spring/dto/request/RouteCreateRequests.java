package com.hackathon.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteCreateRequests {
    private List<RouteCreateRequest> listRouteCreateRequest;
}
