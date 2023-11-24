/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoftp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
    
    public String leerDocumento(String ruta){
        
        String res = "";
        String rutaArchivo = ruta;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                if(linea.startsWith("#")){
                    //es un comentario
                }
                else{
                    
                    String lineaConf = leerConfig(linea);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public String leerConfig(String linea){
        
        StringBuilder lineaConf = new StringBuilder();
        int indice = 0;
        
        while(indice<linea.length()){
            char caracter = linea.charAt(indice);
            if(caracter == '='){
                
            }
            else{
                lineaConf.append(caracter);
            }
            
        }
        return lineaConf.toString();
    }
}
