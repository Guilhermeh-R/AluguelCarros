package com.example.aluguel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.aluguel.Service.AutomovelService; // Importa o serviço AutomovelService
import com.example.aluguel.model.Automovel; // Importa o modelo Automovel

@RestController("/automovel")
public class AutomovelController {
    @Autowired
    private AutomovelService automovelService;

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }
    @GetMapping("/id")
    public Automovel getAutomovelById(@RequestParam int id) {
        return automovelService.getAutomovelById(id);
    }
    @GetMapping("/modelo")
    public List<Automovel> getAutomovelByModelo(@RequestParam String modelo) {
        return automovelService.getAutomovelByModelo(modelo);
    }
    @GetMapping("/ano")
    public List<Automovel> getAutomovelByAno(@RequestParam int ano) {
        return automovelService.getAutomovelByAno(ano);
    }
    @GetMapping("/placa")
    public List<Automovel> getAutomovelByPlaca(@RequestParam String placa) {
        return automovelService.getAutomovelByPlaca(placa);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createAutomovel(@RequestBody Automovel automovel) {
        return automovelService.createAutomovel(automovel);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateAutomovel(@RequestBody Automovel automovel, @RequestParam int id) {
        if (automovel.getId() != id) {
            return ResponseEntity.badRequest().body("ID do automóvel não corresponde ao ID fornecido.");
        }
        return automovelService.updateAutomovel(id,automovel);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> deleteAutomovel(@RequestParam int id) {
        return automovelService.deleteAutomovel(id);
    }
}
