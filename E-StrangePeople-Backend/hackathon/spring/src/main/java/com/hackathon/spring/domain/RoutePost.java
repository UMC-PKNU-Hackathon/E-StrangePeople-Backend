package com.hackathon.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "routePost")
public class RoutePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer routeOrder;
    @NotNull
    private String address;
    @NotNull
    private String content;
    @NotNull
    private String image;

    private String transportation;

    private String expense;

    @ManyToOne(fetch = FetchType.LAZY)
    private Intro intro;
}
