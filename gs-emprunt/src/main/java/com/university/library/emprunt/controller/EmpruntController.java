package com.university.library.emprunt.controller;

import com.university.library.emprunt.dto.EmpruntDTO;
import com.university.library.emprunt.service.EmpruntService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emprunts")
@RequiredArgsConstructor
public class EmpruntController {

    private final EmpruntService empruntService;

    @GetMapping("/{id}")
    public ResponseEntity<EmpruntDTO> getEmpruntById(@PathVariable Long id) {
        EmpruntDTO emprunt = empruntService.getEmpruntById(id);
        return ResponseEntity.ok(emprunt);
    }

    @PostMapping
    public ResponseEntity<EmpruntDTO> createEmprunt(@RequestBody EmpruntDTO empruntDTO) {
        EmpruntDTO createdEmprunt = empruntService.createEmprunt(empruntDTO);
        return ResponseEntity.ok(createdEmprunt);
    }
}
