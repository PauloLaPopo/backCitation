package com.example.backcitation.service.punchline;

import com.example.backcitation.model.Punchline;
import com.example.backcitation.repository.punchline.PunchlineRepository;
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

    public List<String> getAllAuthors() {
        return punchlineRepository.findAllAuthors();
    }

    public Punchline addPunchline(Punchline newPunchline) {
        return punchlineRepository.save(newPunchline);
    }

    public Punchline updatePunchline(Long id, Punchline punchlineDetails) {
        Punchline punchline = punchlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Punchline not found with id " + id));

        punchline.setPunchline(punchlineDetails.getPunchline());
        punchline.setAuteur(punchlineDetails.getAuteur());
        punchline.setTitre(punchlineDetails.getTitre());

        return punchlineRepository.save(punchline);
    }

    public void deletePunchline(Long id) {
        Punchline punchline = punchlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Punchline not found with id " + id));
        punchlineRepository.delete(punchline);
    }

    public Punchline getPunchlineById(long id) {
        return punchlineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Punchline not found with id " + id));
    }
}
