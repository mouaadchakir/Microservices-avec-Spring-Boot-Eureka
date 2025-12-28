package com.university.library.etudiant.service;

import com.university.library.etudiant.dto.EtudiantDTO;
import com.university.library.etudiant.model.Etudiant;
import com.university.library.etudiant.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final ModelMapper modelMapper;

    public EtudiantDTO getEtudiantById(Long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));
        return modelMapper.map(etudiant, EtudiantDTO.class);
    }

    public List<EtudiantDTO> getAllEtudiants() {
        return etudiantRepository.findAll().stream()
                .map(etudiant -> modelMapper.map(etudiant, EtudiantDTO.class))
                .collect(Collectors.toList());
    }

    public EtudiantDTO createEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = modelMapper.map(etudiantDTO, Etudiant.class);
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return modelMapper.map(savedEtudiant, EtudiantDTO.class);
    }
}
