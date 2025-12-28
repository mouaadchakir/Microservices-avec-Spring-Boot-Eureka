package com.university.library.etudiant.controller;

import com.university.library.etudiant.dto.EtudiantDTO;
import com.university.library.etudiant.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService etudiantService;

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiantById(@PathVariable Long id) {
        EtudiantDTO etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiant);
    }

    @GetMapping
    public ResponseEntity<List<EtudiantDTO>> getAllEtudiants() {
        List<EtudiantDTO> etudiants = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    @PostMapping
    public ResponseEntity<EtudiantDTO> createEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        EtudiantDTO createdEtudiant = etudiantService.createEtudiant(etudiantDTO);
        return ResponseEntity.ok(createdEtudiant);
    }
}
