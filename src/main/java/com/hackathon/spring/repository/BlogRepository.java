package com.hackathon.spring.repository;

import com.hackathon.spring.domain.Blog;
import com.hackathon.spring.domain.Intro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT b FROM Blog b JOIN b.user u WHERE u.id=:userId")
    Optional<Blog> findByUserId(@Param("userId") Long uid);
}
