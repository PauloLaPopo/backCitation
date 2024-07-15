package com.example.backcitation.service;

import com.example.backcitation.model.Punchline;
import com.example.backcitation.repository.PunchlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PunchlineService {
    @Autowired
    private PunchlineRepository punchlineRepository;

    public List<Punchline> getAllPunchlines() {
        List<Punchline> allPunchlines = punchlineRepository.findAll();
        Collections.shuffle(allPunchlines);
        return allPunchlines;
    }

    public List<String> getDifferentAuthors(String author) {
        List<String> allAuthors = punchlineRepository.findDistinctAuteurs(author);
        Collections.shuffle(allAuthors);
        return allAuthors.subList(0, Math.min(3, allAuthors.size()));
    }
}
