package com.example.backcitation.controller;

import com.example.backcitation.dto.AuthorRequest;
import com.example.backcitation.model.Punchline;
import com.example.backcitation.service.PunchlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punchlines")
public class PunchlineController {
    @Autowired
    private PunchlineService punchlineService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<Punchline> getAllPunchlines() {
        return punchlineService.getAllPunchlines();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/different-authors")
    public List<String> getDifferentAuthors(@RequestBody AuthorRequest authorRequest) {
        if (authorRequest == null || authorRequest.getAuthor() == null || authorRequest.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Current citation author must be provided");
        }
        return punchlineService.getDifferentAuthors(authorRequest.getAuthor());
    }

}
