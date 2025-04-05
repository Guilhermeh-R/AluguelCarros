package com.example.aluguel.Repository;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.aluguel.model.Automovel;

@Repository
public class AutomovelRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AutomovelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public ResponseEntity<?> save(Automovel automovel) {
        String sql = "INSERT INTO automovel (modelo, ano, placa) VALUES (?, ?, ?)"; // Consulta SQL para inserir um novo automóvel
        jdbcTemplate.update(sql, automovel.getModelo(), automovel.getAno(), automovel.getPlaca());
        return ResponseEntity.ok(automovel); // Retorna o automóvel inserido
    }

    public ResponseEntity<?> update(Automovel automovel) {
        String sql = "UPDATE automovel SET modelo = ?, ano = ?, placa = ? WHERE id = ?"; // Consulta SQL para atualizar um automóvel existente
        jdbcTemplate.update(sql, automovel.getModelo(), automovel.getAno(), automovel.getPlaca(), automovel.getId());
        return ResponseEntity.ok(automovel); // Retorna o automóvel atualizado
    }

    public ResponseEntity<?> deleteById(int id) {
        String sql = "DELETE FROM automovel WHERE id = ?"; // Consulta SQL para excluir um automóvel pelo ID
        jdbcTemplate.update(sql, id);
        return ResponseEntity.ok().build(); // Retorna uma resposta vazia após a exclusão
    }
    public Automovel findById(int id) {
        String sql = "SELECT * FROM automovel WHERE id = ?"; // Consulta SQL para selecionar um automóvel pelo ID
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Automovel automovel = new Automovel();
            automovel.setId(rs.getInt("id"));
            automovel.setModelo(rs.getString("modelo"));
            automovel.setAno(rs.getInt("ano"));
            automovel.setPlaca(rs.getString("placa"));
            return automovel;
        });
    }
    public List<Automovel> findAll() {
        String sql = "SELECT * FROM automovel"; // Consulta SQL para selecionar todos os automóveis
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Automovel automovel = new Automovel();
            automovel.setId(rs.getInt("id"));
            automovel.setModelo(rs.getString("modelo"));
            automovel.setAno(rs.getInt("ano"));
            automovel.setPlaca(rs.getString("placa"));
            return automovel;
        });
    }
    public List<Automovel> findByModelo(String modelo) {
        String sql = "SELECT * FROM automovel WHERE modelo = ?"; // Consulta SQL para selecionar automóveis pelo modelo
        return jdbcTemplate.query(sql, new Object[]{modelo}, (rs, rowNum) -> {
            Automovel automovel = new Automovel();
            automovel.setId(rs.getInt("id"));
            automovel.setModelo(rs.getString("modelo"));
            automovel.setAno(rs.getInt("ano"));
            automovel.setPlaca(rs.getString("placa"));
            return automovel;
        });
    }
    public List<Automovel> findByAno(int ano) {
        String sql = "SELECT * FROM automovel WHERE ano = ?"; // Consulta SQL para selecionar automóveis pelo ano
        return jdbcTemplate.query(sql, new Object[]{ano}, (rs, rowNum) -> {
            Automovel automovel = new Automovel();
            automovel.setId(rs.getInt("id"));
            automovel.setModelo(rs.getString("modelo"));
            automovel.setAno(rs.getInt("ano"));
            automovel.setPlaca(rs.getString("placa"));
            return automovel;
        });
    }
    public List<Automovel> findByPlaca(String placa) {
        String sql = "SELECT * FROM automovel WHERE placa = ?"; // Consulta SQL para selecionar automóveis pela placa
        return jdbcTemplate.query(sql, new Object[]{placa}, (rs, rowNum) -> {
            Automovel automovel = new Automovel();
            automovel.setId(rs.getInt("id"));
            automovel.setModelo(rs.getString("modelo"));
            automovel.setAno(rs.getInt("ano"));
            automovel.setPlaca(rs.getString("placa"));
            return automovel;
        });
    }
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(*) FROM automovel WHERE id = ?"; // Consulta SQL para verificar se um automóvel existe pelo ID
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        return count != null && count > 0; // Retorna verdadeiro se o automóvel existir
    }
    
}
