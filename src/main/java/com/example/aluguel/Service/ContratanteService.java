package com.example.aluguel.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.aluguel.model.Contratante;
import com.example.aluguel.Repository.ContratanteRepository;

@Service
public class ContratanteService {
    @Autowired
    private ContratanteRepository contratanteRepository;

    public ContratanteService(ContratanteRepository contratanteRepository) {
        this.contratanteRepository = contratanteRepository;
    }
    public List<Contratante> getAllContratantes() {
        return contratanteRepository.findAll();
    }
    public Contratante getContratanteById(int id) {
        return contratanteRepository.findById(id);
    }
    public List<Contratante> getContratanteByCpf(String cpf) {
        return contratanteRepository.findByCpf(cpf);
    }
    public ResponseEntity<?> createContratante(Contratante contratante) {
        if (contratante.getId() != 0) {
            return ResponseEntity.badRequest().body("ID deve ser zero para criar um novo contratante.");
        }
        Contratante savedContratante = contratanteRepository.save(contratante);
        return ResponseEntity.ok(savedContratante);
    }
    public ResponseEntity<?> updateContratante(int id, Contratante contratante) {
        if (contratante.getId() != id) {
            return ResponseEntity.badRequest().body("ID do contratante não corresponde ao ID fornecido.");
        }
        Contratante updatedContratante = contratanteRepository.save(contratante);
        return ResponseEntity.ok(updatedContratante);
    }
    public ResponseEntity<?> deleteContratante(int id) {
        if (!contratanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contratanteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<?> updateContratante(Contratante contratante) {
        if (contratante.getId() == 0) {
            return ResponseEntity.badRequest().body("ID deve ser fornecido para atualizar um contratante.");
        }
        Contratante updatedContratante = contratanteRepository.save(contratante);
        return ResponseEntity.ok(updatedContratante);
    }
}
