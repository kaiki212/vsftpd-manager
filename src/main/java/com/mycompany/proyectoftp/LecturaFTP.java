/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoftp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class LecturaFTP {
    
    
    public ArrayList<Configuracion> leerDocumento(String ruta){
        
        ArrayList<Configuracion> configuraciones= new ArrayList<>();
        String rutaArchivo = ruta;
        int nmrLinea=0;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                
                if(linea.startsWith("#")){
                    //es un comentario
                    nmrLinea++;
                }
                else{      
                    Configuracion lineaConf = leerConfig(linea);
                    lineaConf.setNmrLinea(nmrLinea);
                    configuraciones.add(lineaConf);
                    nmrLinea++;
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuraciones;
    }
    
    public Configuracion leerConfig(String linea){
        
        Configuracion conf = new Configuracion() ;
        StringBuilder lineaConf = new StringBuilder();
        int indice = 0;
        
        while(indice<linea.length()){
            char caracter = linea.charAt(indice);
            if(caracter == '='){
                String[] partes = linea.split("=");
                if(partes.length>1){
                    conf = new Configuracion(partes[0],partes[1]);
                    break;
                }
                else{
                    conf = new Configuracion(partes[0],"");
                    break;
                }
            }
            else{
                indice++;
            }    
        }
        
        return conf;
    }
}
