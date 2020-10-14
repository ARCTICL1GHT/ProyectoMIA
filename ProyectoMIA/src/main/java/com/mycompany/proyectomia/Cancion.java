/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tato
 */
public class Cancion {
    private String url;
    private String nombre;
     private Archivos desc;

    public Cancion() {
       desc=new Archivos();
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
        try {
            desc.SetExtencion(url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cancion.class.getName()).log(Level.SEVERE, null, ex);
        }
;
    }
    public String getDesc()
    {
        try {
            return desc.Mostrar();
        } catch (IOException ex) {
            Logger.getLogger(Cancion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No Encontrado";
    }
    
    
}
