package com.example.aluguel.Controller;



import java.util.List;

import com.example.aluguel.Service.ContratanteService; // Importa o serviço ContratanteService
import com.example.aluguel.model.Contratante; // Importa o modelo Contratante
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/contratante")
@RestController
public class contratanteController {
    @Autowired
    private ContratanteService contratanteService;

    public contratanteController(ContratanteService contratanteService) {
        this.contratanteService = contratanteService;
    }
    @GetMapping()
    public List<Contratante> getAllContratantes() {
        return contratanteService.getAllContratantes();
    }
    @GetMapping("/id")
    public Contratante getContratanteById(@RequestParam int id) {
        return contratanteService.getContratanteById(id);
    }
    @GetMapping("/cpf")
    public List<Contratante> getContratanteByCpf(@RequestParam String cpf) {
        return contratanteService.getContratanteByCpf(cpf);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createContratante(@RequestBody Contratante contratante) {
        return contratanteService.createContratante(contratante);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateContratante(@RequestBody Contratante contratante) {
        return contratanteService.updateContratante(contratante);
    }
    
    
    
}