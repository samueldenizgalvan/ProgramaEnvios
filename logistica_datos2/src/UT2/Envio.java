package UT2;

import java.io.Serializable;
import java.util.Date;

public class Envio implements Serializable {
    private String numeroSeguimiento;
    private String destino;
    private double peso;
    private Date fechaEnvio;
    private Date fechaEstimadaEntrega;

    public Envio(String numeroSeguimiento, String destino, double peso, Date fechaEnvio, Date fechaEstimadaEntrega) {
        this.numeroSeguimiento = numeroSeguimiento;
        this.destino = destino;
        this.peso = peso;
        this.fechaEnvio = fechaEnvio;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }
}
