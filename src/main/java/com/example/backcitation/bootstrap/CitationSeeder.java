package com.example.backcitation.bootstrap;

import com.example.backcitation.model.Citation;
import com.example.backcitation.repository.citation.CitationRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CitationSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final CitationRepository citationRepository;

    public CitationSeeder(
            CitationRepository citationRepository
    ) {
        this.citationRepository = citationRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {this.createCitationData();}

    private void createCitationData() {
        Citation citation1 = new Citation(
                "Evitez les gens négatifs, ils ont toujours un problème à chaque solution",
                "Albert Einstein"
        );
        Citation citation2 = new Citation(
                "Notre vie est ce que nos pensées en font",
                "Marc Aurèle"
        );
        Citation citation3 = new Citation(
                "On finit toujours par regretter ce que l'on a pas tenté",
                "Abraham Maslow"
        );
        Citation citation4 = new Citation(
                "Nous sommes plus souvent effrayés que blessés; et nous souffrons de l'imagination plus que de la réalité",
                "Sénèque"
        );

        Optional<Citation> optionalCitation1 = citationRepository.findByTexte(citation1.getTexte());
        if (optionalCitation1.isEmpty()) citationRepository.save(citation1);

        Optional<Citation> optionalCitation2 = citationRepository.findByTexte(citation2.getTexte());
        if (optionalCitation2.isEmpty()) citationRepository.save(citation2);

        Optional<Citation> optionalCitation3 = citationRepository.findByTexte(citation3.getTexte());
        if (optionalCitation3.isEmpty()) citationRepository.save(citation3);

        Optional<Citation> optionalCitation4 = citationRepository.findByTexte(citation4.getTexte());
        if (optionalCitation4.isEmpty()) citationRepository.save(citation4);
    }
}

