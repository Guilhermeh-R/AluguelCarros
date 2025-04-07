package com.example.aluguel.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.aluguel.model.Aluguel;
import com.example.aluguel.Repository.AluguelRepository;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {
    
    @Autowired
    private AluguelRepository aluguelRepository; 

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }
    public List<Aluguel> getAllAlugueis() {
        return aluguelRepository.findAll();
    }
    public Aluguel getAluguelById(int id) {
        return aluguelRepository.findById(id);
    }
    public List<Aluguel> getAlugueisByContratante(int idContratante) {
        return aluguelRepository.findByContratanteId(idContratante);
    }
    public List<Aluguel> getAlugueisByAutomovel(int idAutomovel) {
        return aluguelRepository.findByAutomovelId(idAutomovel);
    }
    public ResponseEntity<?> createAluguel(Aluguel aluguel) {
        try {
            Aluguel savedAluguel = aluguelRepository.save(aluguel);
            return ResponseEntity.ok(savedAluguel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Aluguel: " + e.getMessage());
        }
    }
    public ResponseEntity<?> updateAluguel(Aluguel aluguel) {
        try {
            Aluguel updatedAluguel = aluguelRepository.save(aluguel);
            return ResponseEntity.ok(updatedAluguel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Aluguel: " + e.getMessage());
        }
    }
    public ResponseEntity<?> deleteAluguel(int id) {
        try {
            aluguelRepository.deleteById(id);
            return ResponseEntity.ok("Aluguel deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Aluguel: " + e.getMessage());
        }
    }
    public List<Aluguel> getAlugueisByDataInicio(Date dataInicio) {
        return aluguelRepository.findByDataInicio(dataInicio);
    }
    public List<Aluguel> getAlugueisByDataFim(Date dataFim) {
        return aluguelRepository.findByDataFim(dataFim);
    }
    public List<Aluguel> getAlugueisByNumeroRegistro(String numeroRegistro) {
        return aluguelRepository.findByNumeroRegistro(numeroRegistro);
    }
    public List<Aluguel> getAlugueisByDataInicioAndDataFim(Date dataInicio, Date dataFim) {
        return aluguelRepository.findByDataInicioAndDataFim(dataInicio, dataFim);
    }
    
}
