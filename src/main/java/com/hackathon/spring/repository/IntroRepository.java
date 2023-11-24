package com.hackathon.spring.repository;

import com.hackathon.spring.domain.Blog;
import com.hackathon.spring.domain.Intro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntroRepository extends JpaRepository<Intro, Long> {
    @Query("SELECT i FROM Intro i WHERE i.id=:introId")
    Optional<Intro> findByIntroId(@Param("introId") Long introId);

    @Query("SELECT i FROM Intro i order by i.id DESC")
    List<Intro> findByorder();

    @Query("SELECT i FROM Intro i where i.season=:season order by i.id DESC")
    List<Intro> findByseason(@Param("season") String season);

    @Query("SELECT i FROM Intro i where i.region=:local order by i.id DESC")
    List<Intro> findBylocal(@Param("local") String local);

    @Query("SELECT i FROM Intro i where i.region=:local and i.season=:season order by i.id DESC")
    List<Intro> findByAll(@Param("local") String local, @Param("season") String season);

    List<Intro> findAllByTitleContaining(String title);

}
