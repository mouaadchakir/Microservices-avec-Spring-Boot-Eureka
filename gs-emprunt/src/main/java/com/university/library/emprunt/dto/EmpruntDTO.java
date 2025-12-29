package com.university.library.emprunt.dto;

import com.university.library.emprunt.model.Etudiant;
import com.university.library.emprunt.model.Livre;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpruntDTO {
    private Long id;
    private Long idLivre;
    private Long idEtudiant;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private Livre livre;
    private Etudiant etudiant;
}
