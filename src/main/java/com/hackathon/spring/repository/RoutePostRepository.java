package com.hackathon.spring.repository;

import com.hackathon.spring.domain.Intro;
import com.hackathon.spring.domain.RoutePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutePostRepository extends JpaRepository<RoutePost, Long> {
    @Query("SELECT rp FROM RoutePost rp WHERE rp.id=:introId")
    List<RoutePost> findByIntroId(@Param("introId") Long introId);

}
