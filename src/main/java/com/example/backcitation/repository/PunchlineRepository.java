package com.example.backcitation.repository;

import com.example.backcitation.model.Punchline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PunchlineRepository extends JpaRepository<Punchline, Long> {
    @Query("SELECT DISTINCT p.auteur FROM Punchline p WHERE LOWER(p.auteur) <> LOWER(:author)")
    List<String> findDistinctAuteurs(@Param("author") String author);

    @Query("SELECT DISTINCT p.auteur FROM Punchline p")
    List<String> findAllAuthors();
}
