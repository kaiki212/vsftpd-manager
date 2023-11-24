/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoftp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class ConfiguracionFTP {
    /*public static void main(String[] args) {
        // Reemplaza la ruta y el nombre del archivo con la ubicación completa de tu archivo
        String rutaArchivo = "C:\\Users\\Windows\\Documents\\NetBeansProjects\\ProyectoFTP\\src\\main\\java\\com\\mycompany\\proyectoftp\\vsftpd.txt";

        leerDocumento(rutaArchivo);
    }*/
    
    
    public ArrayList<Configuracion> leerDocumento(String ruta){
        
        ArrayList<Configuracion> configuraciones= new ArrayList<>();
        String rutaArchivo = ruta;
        int nmrLinea=0;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
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
        
        Configuracion conf = null ;
        StringBuilder lineaConf = new StringBuilder();
        int indice = 0;
        
        while(indice<linea.length()){
            char caracter = linea.charAt(indice);
            if(caracter == '='){
                String[] partes = linea.split("=");
                conf = new Configuracion(partes[0],partes[1]);
                break;
            }
            else{
                indice++;
            }    
        }
        
        return conf;
    }
}
