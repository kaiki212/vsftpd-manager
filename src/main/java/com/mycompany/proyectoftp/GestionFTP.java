/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoftp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Windows
 */
public class GestionFTP {
    
    // Método para instalar vsftpd
    private static void instalarVSFTP() {
        String inst = ejecutarComando("zypper --non-interactive install vsftpd");
        
    }
    
    //Metodo para verificar existencia de vsftpd
    private static String verificarVsftp(){
        String existencia = ejecutarComando("zypper search \"vsftp\" | grep vsftpd");
        String res;
        if(existencia.equals("")){
            res = "No se tiene instalado el servicio vsftpd";
        }
        else{
            res = "El servicio vsftpd esta instalado";
        }
        return res;
    }
  
    //metodo para iniciar el servicio
    private static String iniciarServicio(String servicio) {
        String estado = verificarEstadoServicio("vsftpd");
        String res = "";
        
        if (estado.equals("inactive")) {
            ejecutarComando("systemctl start " + servicio);
            res = "El servicio fue iniciado correctamente";
        }
        else{
            res = "El servicio ya estaba activo"; 
        }
        return res;
    }

    // Método para detener el servicio
    private static String detenerServicio(String servicio) {
        String estado = verificarEstadoServicio("vsftpd");
        String res = "";
        
        if(estado.equals("active")){
            ejecutarComando("systemctl stop " + servicio);
            res = "El servicio se detuvo correctamente";
        }
        else{
            res = "El servicio no esta activo";
        }
        
        return res;
    }

    // Método para reiniciar el servicio
    private static String reiniciarServicio(String servicio) {
        ejecutarComando("systemctl restart " + servicio);
        return "Servicio Reiniciado";
    }

      
    private static String verificarEstadoServicio(String servicio) {
        String comando = "systemctl is-active " + servicio;
        return ejecutarComando(comando).trim();
    }
    
    
    private static String ejecutarComando(String comando) {
        StringBuilder salida = new StringBuilder();
        
        try {
            Process proceso = Runtime.getRuntime().exec(comando);
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;
            while ((linea = lector.readLine()) != null) {
                salida.append(linea).append("\n");
            }

            lector.close();
            proceso.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return salida.toString();
    }
}
