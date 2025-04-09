package com.example.aluguel.Controller; 


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.aluguel.model.Aluguel; 
import com.example.aluguel.Service.AluguelService;
@RestController("/aluguel")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService; 

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }   
    @GetMapping()
    public List<Aluguel> getAllAlugueis() {
        return aluguelService.getAllAlugueis();
    }
    @GetMapping("/{id}")
    public Aluguel getAluguelById(@RequestParam int id) {
        return aluguelService.getAluguelById(id);
    }
    @GetMapping("/contratante")
    public List<Aluguel> getAlugueisByContratante(@RequestParam int idContratante) {
        return aluguelService.getAlugueisByContratante(idContratante);
    }   
    @GetMapping("/automovel")
    public List<Aluguel> getAlugueisByAutomovel(@RequestParam int idAutomovel) {
        return aluguelService.getAlugueisByAutomovel(idAutomovel);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createAluguel(@RequestBody Aluguel aluguel) {
        return aluguelService.createAluguel(aluguel);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateAluguel(@RequestBody Aluguel aluguel) {
        return aluguelService.updateAluguel(aluguel);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> deleteAluguel(@RequestParam int id) {
        return aluguelService.deleteAluguel(id);
    }
    @GetMapping("/dataInicio")
    public List<Aluguel> getAlugueisByDataInicio(@RequestParam Date dataInicio) {
        return aluguelService.getAlugueisByDataInicio(dataInicio);
    }
    @GetMapping("/dataFim")
    public List<Aluguel> getAlugueisByDataFim(@RequestParam Date dataFim) {
        return aluguelService.getAlugueisByDataFim(dataFim);
    }
    @GetMapping("/numeroRegistro")
    public List<Aluguel> getAlugueisByNumeroRegistro(@RequestParam String numeroRegistro) {
        return aluguelService.getAlugueisByNumeroRegistro(numeroRegistro);
    }


}