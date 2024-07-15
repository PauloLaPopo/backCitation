package com.example.backcitation.service;


import com.example.backcitation.model.Citation;
import com.example.backcitation.repository.CitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class CitationService {
    @Autowired
    private CitationRepository citationRepository;

    public List<Citation> getAllCitations() {
        return citationRepository.findAll();
    }

    public Citation getCitationById(long id) {
        return citationRepository.getReferenceById(id);
    }

    public List<String> getDifferentAuthors(String author) {
        List<String> allAuthors = citationRepository.findDistinctAuteurs(author);
        Collections.shuffle(allAuthors);
        return allAuthors.subList(0, Math.min(3, allAuthors.size()));
    }

    public Citation getCitationDuJour() {
        List<Citation> citations = citationRepository.findAll();
        if (citations.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(citations.size());

        return citations.get(index);
    }

    public Citation getOtherCitation(Citation currentCitation) {
        List<Citation> citations = citationRepository.findAll();
        if (citations.isEmpty()) {
            return null;
        }

        citations.removeIf(citation -> citation.getId().equals(currentCitation.getId()));

        if (citations.isEmpty()) {
            return currentCitation; // Si la seule citation était l'actuelle, retournez-la
        }

        // Obtenir une citation aléatoire parmi celles restantes
        Random random = new Random();
        Citation citation = citations.get(random.nextInt(citations.size()));
        return citation;
    }

    public Citation addCitation(Citation newCitation) {
        return citationRepository.save(newCitation);
    }

    public Citation updateCitation(Long id, Citation citationDetails) {
        Citation citation = citationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citation not found with id " + id));

        citation.setTexte(citationDetails.getTexte());
        citation.setAuteur(citationDetails.getAuteur());

        return citationRepository.save(citation);
    }

    public void deleteCitation(Long id) {
        Citation citation = citationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citation not found with id " + id));
        citationRepository.delete(citation);
    }

    public Page<Citation> getCitationsPaginated(Pageable pageable) {
        return citationRepository.findAll(pageable);
    }
}