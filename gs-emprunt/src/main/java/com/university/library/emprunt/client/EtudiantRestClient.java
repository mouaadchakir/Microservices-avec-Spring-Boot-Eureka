package com.university.library.emprunt.client;

import com.university.library.emprunt.model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GS-ETUDIANT")
public interface EtudiantRestClient {

    @GetMapping("/api/etudiants/{id}")
    Etudiant getEtudiantById(@PathVariable Long id);
}
