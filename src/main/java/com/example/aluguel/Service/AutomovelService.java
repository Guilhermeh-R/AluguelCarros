package com.example.aluguel.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.aluguel.model.Automovel; // Importa o modelo Automovel
import com.example.aluguel.Repository.AutomovelRepository; // Importa o repositório AutomovelRepository
@Service
public class AutomovelService {
    
    @Autowired
    private AutomovelRepository automovelRepository;

    public AutomovelService(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }
    public List<Automovel> getAllAutomoveis() {
        return automovelRepository.findAll();
    }
    public Automovel getAutomovelById(int id) {
        return automovelRepository.findById(id);
    }
    public List<Automovel> getAutomovelByModelo(String modelo) {
        return automovelRepository.findByModelo(modelo);
    }
    public List<Automovel> getAutomovelByAno(int ano) {
        return automovelRepository.findByAno(ano);
    }
    public List<Automovel> getAutomovelByPlaca(String placa) {
        return automovelRepository.findByPlaca(placa);
    }
    public ResponseEntity<?> createAutomovel(Automovel automovel) {
        if (automovel.getId() != 0) {
            return ResponseEntity.badRequest().body("ID deve ser zero para criar um novo automóvel.");
        }
        return automovelRepository.save(automovel);
    }
    public ResponseEntity<?> updateAutomovel(int id, Automovel automovel) {
        if (automovel.getId() != id) {
            return ResponseEntity.badRequest().body("ID do automóvel não corresponde ao ID fornecido.");
        }
        if (!automovelRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }   
        return automovelRepository.update(automovel);
    }
    public ResponseEntity<?> deleteAutomovel(int id) {
        if (!automovelRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        automovelRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
