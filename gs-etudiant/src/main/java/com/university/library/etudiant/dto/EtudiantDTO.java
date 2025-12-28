package com.university.library.etudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String cne;

}
