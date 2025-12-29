package com.university.library.emprunt.model;

import lombok.Data;

@Data
public class Etudiant {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String cne;
}
