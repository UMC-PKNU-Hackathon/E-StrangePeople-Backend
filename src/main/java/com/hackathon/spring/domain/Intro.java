package com.hackathon.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "intro")
public class Intro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String introduce;

    private String thumnail;

    private String season;
    @NotNull
    private String region;
    @NotNull
    private String period;
    @NotNull
    private Integer likes;
    @CreatedDate
    private LocalDateTime createAt;
    @NotNull
    private Boolean isModify;
    @NotNull
    private Integer allExpense;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
