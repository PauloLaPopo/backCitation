package com.example.backcitation.controller.punchline;

import com.example.backcitation.dto.AuthorRequest;
import com.example.backcitation.model.Punchline;
import com.example.backcitation.service.punchline.PunchlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punchlines")
public class PunchlineController {
    @Autowired
    private PunchlineService punchlineService;

    @GetMapping("/all")
    public List<Punchline> getAllPunchlines() {
        return punchlineService.getAllPunchlines();
    }

    @PostMapping("/different-authors")
    public List<String> getDifferentAuthors(@RequestBody AuthorRequest authorRequest) {
        if (authorRequest == null || authorRequest.getAuthor() == null || authorRequest.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Current citation author must be provided");
        }
        return punchlineService.getDifferentAuthors(authorRequest.getAuthor());
    }

    @GetMapping("/authors")
    public List<String> getAllAuthors() {
        return punchlineService.getAllAuthors();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Punchline> addPunchline(@RequestBody Punchline newPunchline) {
        Punchline punchline = punchlineService.addPunchline(newPunchline);
        return new ResponseEntity<>(punchline, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Punchline> updatePunchline(@PathVariable Long id, @RequestBody Punchline punchline) {
        Punchline updatedPunchline = punchlineService.updatePunchline(id, punchline);
        return ResponseEntity.ok(updatedPunchline);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> deletePunchline(@PathVariable Long id) {
        punchlineService.deletePunchline(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Punchline> getPunchlineById(@PathVariable Long id) {
        Punchline punchline = punchlineService.getPunchlineById(id);
        return ResponseEntity.ok(punchline);
    }

}
