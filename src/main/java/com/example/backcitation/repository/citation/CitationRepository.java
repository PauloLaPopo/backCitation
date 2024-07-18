package com.example.backcitation.repository.citation;

import com.example.backcitation.model.Citation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitationRepository extends JpaRepository<Citation, Long> {
    @Query("SELECT DISTINCT c.auteur FROM Citation c WHERE LOWER(c.auteur) <> LOWER(:author)")
    List<String> findDistinctAuteurs(@Param("author") String author);
}
