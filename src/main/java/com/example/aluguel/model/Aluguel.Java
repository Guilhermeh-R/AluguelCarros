package com.example.aluguel.Model;
import java.util.Date;

public class Aluguel{
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private String numeroRegistro;
    private int automovelId;
    private int contratanteId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getAutomovelId() {
        return automovelId;
    }

    public void setAutomovelId(int automovelId) {
        this.automovelId = automovelId;
    }

    public int getContratanteId() {
        return contratanteId;
    }

    public void setContratanteId(int contratanteId) {
        this.contratanteId = contratanteId;
    }
}