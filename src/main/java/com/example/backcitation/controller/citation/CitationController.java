package com.example.backcitation.controller.citation;

import com.example.backcitation.dto.AuthorRequest;
import com.example.backcitation.model.Citation;
import com.example.backcitation.service.citation.CitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citations")
public class CitationController {
    @Autowired
    private CitationService citationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/dujour")
    public Citation getCitationDuJour() {
        return citationService.getCitationDuJour();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/different-authors")
    public List<String> getDifferentAuthors(@RequestBody AuthorRequest authorRequest) {
        if (authorRequest == null || authorRequest.getAuthor() == null || authorRequest.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Current citation author must be provided");
        }
        return citationService.getDifferentAuthors(authorRequest.getAuthor());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/different")
    public Citation getDifferentCitation(@RequestBody Citation currentCitation) {
        return citationService.getOtherCitation(currentCitation);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public ResponseEntity<Citation> addCitation(@RequestBody Citation newCitation) {
        Citation nouvelleCitation = citationService.addCitation(newCitation);
        return new ResponseEntity<>(nouvelleCitation, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Citation> getCitationById(@PathVariable Long id) {
        Citation citation = citationService.getCitationById(id);
        return ResponseEntity.ok(citation);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Citation> updateCitation(@PathVariable Long id, @RequestBody Citation citation) {
        Citation updatedCitation = citationService.updateCitation(id, citation);
        return ResponseEntity.ok(updatedCitation);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitation(@PathVariable Long id) {
        citationService.deleteCitation(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<Citation> getAllCitations() {
        return citationService.getAllCitations();
    }
}
