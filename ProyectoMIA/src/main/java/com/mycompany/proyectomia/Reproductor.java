/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import com.mycompany.proyectomia.Lista;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Reproductor {
    private Lista lista;
    public Reproductor() {
        lista = new Lista();
    }

    public void Play() throws Exception {
        System.out.println("Reproduciendo: "+lista.actual().getCancion().getNombre());
    }
    
  
    
    public void Agregar() throws Exception{
        try {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.MP3","mp3");
        fc.setFileFilter(filtro);
        int result = fc.showOpenDialog(null);
        File f = fc.getCurrentDirectory();
        File[] files = f.listFiles();
        for(File fe: files)
        {            
            String ruta = fe.getAbsolutePath();      
            if(ruta.endsWith(".MP3") || ruta.endsWith(".mp3"))
            {
            Cancion cancion = new Cancion();
            cancion.setUrl(ruta);
            cancion.setNombre(fe.getName());            
            lista.Insertar(cancion);
            }
        }
        Nodo origen=lista.NodoAux(lista.frente());
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void Siguiente()throws Exception {
       lista.Siguiente().getCancion().getUrl();
    }
    
    public void Anterior()throws Exception {
        lista.Anterior().getCancion().getUrl();
    }   
    
    public String url()
    {
        return lista.frente().getCancion().getUrl();
    }
    public Integer NumLista()
    {
        return lista.Tama();
    }
    public Nodo Frente()
    {
        return lista.frente();
    }
    public Nodo Actual()
    {
        return lista.actual();
    }
    public void AgregarI(String ruta, File fe)
    {            
            Cancion cancion = new Cancion();
            cancion.setUrl(ruta);
            cancion.setNombre(fe.getName());            
            lista.Insertar(cancion);            
    }
    public void Aleatorio()
    {        
        Lista listaAux1 = new Lista();
        Lista listaAux2 = new Lista();
        while(lista.Tama()!=0)
        {
            System.out.println("Sirve");
            int dado = (int) (Math.random() * 2) + 1;    
            if(dado==1)
            {
                listaAux1.Insertar(lista.pop(lista.frente()).getCancion());
                
            }
            else 
            {
                listaAux2.Insertar(lista.pop(lista.frente()).getCancion());
            }
        }
        lista = new Lista();
        while(listaAux1.Tama()!=0)
        {
            lista.Insertar(listaAux1.pop(listaAux1.frente()).getCancion());
            System.out.println(lista.frente().getCancion().getNombre());            
        }
        while(listaAux2.Tama()!=0)
        {
            lista.Insertar(listaAux2.pop(listaAux2.frente()).getCancion());
            System.out.println(lista.frente().getCancion().getNombre());
        }
        Nodo origen=lista.NodoAux(lista.frente());
    }
}
