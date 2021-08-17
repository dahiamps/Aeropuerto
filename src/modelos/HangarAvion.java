/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;







/**
 *
 * @author dahia
 */
public class HangarAvion {
    
    private int codigoHangar;
    private String matriculaAvion;
    private Date fechaIngreso;
    private int numeroCeldas;

    public int getCodigoHangar() {
        return codigoHangar;
    }

    public void setCodigoHangar(int codigoHangar) {
        this.codigoHangar = codigoHangar;
    }

    public String getMatriculaAvion() {
        return matriculaAvion;
    }

    public void setMatriculaAvion(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getNumeroCeldas() {
        return numeroCeldas;
    }

    public void setNumeroCeldas(int numeroCeldas) {
        this.numeroCeldas = numeroCeldas;
    }

    
}
