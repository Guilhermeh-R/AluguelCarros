package com.example.aluguel.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.aluguel.model.Aluguel;

public class AluguelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AluguelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Aluguel> findAll(){
        String sql = "SELECT * FROM aluguel";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public Aluguel findById(int id) {
        String sql = "SELECT * FROM aluguel WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public List<Aluguel> findByContratanteId(int idContratante) {
        String sql = "SELECT * FROM aluguel WHERE contratante_id = ?";
        return jdbcTemplate.query(sql, new Object[]{idContratante}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public List<Aluguel> findByAutomovelId(int idAutomovel) {
        String sql = "SELECT * FROM aluguel WHERE automovel_id = ?";
        return jdbcTemplate.query(sql, new Object[]{idAutomovel}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public List<Aluguel> findByDataInicio(java.sql.Date dataInicio) {
        String sql = "SELECT * FROM aluguel WHERE data_inicio = ?";
        return jdbcTemplate.query(sql, new Object[]{dataInicio}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public List<Aluguel> findByDataFim(java.sql.Date dataFim) {
        String sql = "SELECT * FROM aluguel WHERE data_fim = ?";
        return jdbcTemplate.query(sql, new Object[]{dataFim}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public List<Aluguel> findByNumeroRegistro(String numeroRegistro) {
        String sql = "SELECT * FROM aluguel WHERE numero_registro = ?";
        return jdbcTemplate.query(sql, new Object[]{numeroRegistro}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public List<Aluguel> findByDataInicioAndDataFim(java.sql.Date dataInicio, java.sql.Date dataFim) {
        String sql = "SELECT * FROM aluguel WHERE data_inicio = ? AND data_fim = ?";
        return jdbcTemplate.query(sql, new Object[]{dataInicio, dataFim}, (rs, rowNum) -> {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(rs.getInt("id"));
            aluguel.setDataInicio(rs.getDate("data_inicio"));
            aluguel.setDataFim(rs.getDate("data_fim"));
            aluguel.setNumeroRegistro(rs.getString("numero_registro"));
            aluguel.setAutomovelId(rs.getInt("automovel_id"));
            aluguel.setContratanteId(rs.getInt("contratante_id"));
            return aluguel;
        });
    }
    public Aluguel save(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel (data_inicio, data_fim, numero_registro, automovel_id, contratante_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, aluguel.getDataInicio(), aluguel.getDataFim(), aluguel.getNumeroRegistro(), aluguel.getAutomovelId(), aluguel.getContratanteId());
        return aluguel;
    }
    public Aluguel update(Aluguel aluguel) {
        String sql = "UPDATE aluguel SET data_inicio = ?, data_fim = ?, numero_registro = ?, automovel_id = ?, contratante_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, aluguel.getDataInicio(), aluguel.getDataFim(), aluguel.getNumeroRegistro(), aluguel.getAutomovelId(), aluguel.getContratanteId(), aluguel.getId());
        return aluguel;
    }
    public void deleteById(int id) {
        String sql = "DELETE FROM aluguel WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
