package com.hackathon.spring.repository;

import com.hackathon.spring.domain.Intro;
import com.hackathon.spring.domain.RoutePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePostRepository extends JpaRepository<RoutePost, Long> {
}
