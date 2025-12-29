package com.university.library.emprunt.service;

import com.university.library.emprunt.client.EtudiantRestClient;
import com.university.library.emprunt.client.LivreRestClient;
import com.university.library.emprunt.dto.EmpruntDTO;
import com.university.library.emprunt.model.Emprunt;
import com.university.library.emprunt.model.Etudiant;
import com.university.library.emprunt.model.Livre;
import com.university.library.emprunt.repository.EmpruntRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final LivreRestClient livreRestClient;
    private final EtudiantRestClient etudiantRestClient;
    private final ModelMapper modelMapper;

    public EmpruntDTO getEmpruntById(Long id) {
        Emprunt emprunt = empruntRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprunt not found"));

        // Fetch book and student details from other microservices
        Livre livre = livreRestClient.getBookById(emprunt.getIdLivre());
        Etudiant etudiant = etudiantRestClient.getEtudiantById(emprunt.getIdEtudiant());

        // Map to DTO and set the fetched objects
        EmpruntDTO empruntDTO = modelMapper.map(emprunt, EmpruntDTO.class);
        empruntDTO.setLivre(livre);
        empruntDTO.setEtudiant(etudiant);

        return empruntDTO;
    }

    public EmpruntDTO createEmprunt(EmpruntDTO empruntDTO) {
        // Check if book and student exist by calling their services
        Livre livre = livreRestClient.getBookById(empruntDTO.getIdLivre());
        if (livre == null) {
            throw new RuntimeException("Book not found");
        }

        Etudiant etudiant = etudiantRestClient.getEtudiantById(empruntDTO.getIdEtudiant());
        if (etudiant == null) {
            throw new RuntimeException("Etudiant not found");
        }

        // Create and save the loan
        Emprunt emprunt = new Emprunt();
        emprunt.setIdLivre(empruntDTO.getIdLivre());
        emprunt.setIdEtudiant(empruntDTO.getIdEtudiant());
        emprunt.setDateEmprunt(LocalDate.now());
        emprunt.setDateRetour(null); // The book has not been returned yet

        Emprunt savedEmprunt = empruntRepository.save(emprunt);

        // Return the full DTO
        return getEmpruntById(savedEmprunt.getId());
    }
}
