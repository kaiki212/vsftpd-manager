/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoftp;

/**
 *
 * @author Windows
 */
public class Configuracion {

    String conf="";
    String estado="";
    int linea;
    
    public Configuracion(){
        
    }
    
    public Configuracion(String conf, String estado){
        this.conf = conf;
        this.estado = estado;
    }
    
    public Configuracion(String conf, String estado, int nmrLinea){
        this.conf = conf;
        this.estado = estado;
        this.linea = nmrLinea;
    }
    
    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getNmrLinea() {
        return linea;
    }

    public void setNmrLinea(int nmr) {
        this.linea = nmr;
    }
    
}
