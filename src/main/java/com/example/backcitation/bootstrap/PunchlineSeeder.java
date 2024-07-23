package com.example.backcitation.bootstrap;

import com.example.backcitation.model.Punchline;
import com.example.backcitation.repository.punchline.PunchlineRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PunchlineSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final PunchlineRepository punchlineRepository;

    public PunchlineSeeder(PunchlineRepository punchlineRepository) {
        this.punchlineRepository = punchlineRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {this.createDataPunchlines();}

    private void createDataPunchlines() {
        Punchline punchline1 = new Punchline(
                "Le temps du cours j'inversais le cours du temps",
                "Nekfeu",
                "Nekketsu"
        );
        Punchline punchline2 = new Punchline(
                "Roland Garros ou l'casino, j'touche le jackpot en trois sets",
                "Dinos",
                "Namek"
        );
        Punchline punchline3 = new Punchline(
                "J’ai des souvenirs marqués sur la peau, j’m'en souviendrai jusqu’à tout en haut",
                "Josman",
                "V&V"
        );
        Punchline punchline4 = new Punchline(
                "Hier et demain sont la même journée, la boucle est bouclée",
                "Orelsan",
                "J'essaye, j'essaye"
        );

        Optional<Punchline> optionalPunch1 = punchlineRepository.findByPunchline(punchline1.getPunchline());
        if (optionalPunch1.isEmpty()) punchlineRepository.save(punchline1);
        Optional<Punchline> optionalPunch2 = punchlineRepository.findByPunchline(punchline2.getPunchline());
        if (optionalPunch2.isEmpty()) punchlineRepository.save(punchline2);
        Optional<Punchline> optionalPunch3 = punchlineRepository.findByPunchline(punchline3.getPunchline());
        if (optionalPunch3.isEmpty()) punchlineRepository.save(punchline3);
        Optional<Punchline> optionalPunch4 = punchlineRepository.findByPunchline(punchline4.getPunchline());
        if (optionalPunch4.isEmpty()) punchlineRepository.save(punchline4);
    }
}
