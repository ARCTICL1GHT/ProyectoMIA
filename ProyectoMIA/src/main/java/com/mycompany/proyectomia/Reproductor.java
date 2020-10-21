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
        Archivos decodificador = new Archivos();
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.MP3","mp3");
        fc.setFileFilter(filtro);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int result = fc.showOpenDialog(null);
        File f = fc.getSelectedFile();
        String ruta = f.getAbsolutePath();
       
            if(ruta.endsWith(".MP3") || ruta.endsWith(".mp3"))
            {
            Cancion cancion = decodificador.obtenerDatosCancion(ruta, f.getName());
            System.out.println("ALBUM: "+cancion.getAlbum());
            lista.Insertar(cancion);
            }
        Nodo origen=lista.NodoAux(lista.frente());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void AgregarDirectorio() throws Exception{
        try {
        Archivos decodificador = new Archivos();
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fc.showOpenDialog(null);
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        File f = fc.getSelectedFile();
        File[] files = f.listFiles();
        for(File fe: files)
        {            
            String ruta = fe.getAbsolutePath();      
            if(ruta.endsWith(".MP3") || ruta.endsWith(".mp3"))
            {
            Cancion cancion = decodificador.obtenerDatosCancion(ruta, fe.getName());
            System.out.println("ALBUM: "+cancion.getAlbum());
            lista.Insertar(cancion);
            }
            if(fe.isDirectory())
            {
                AgregarDirectorioInterno(fe.getAbsoluteFile());
            }
        }
        Nodo origen=lista.NodoAux(lista.frente());
        
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void AgregarDirectorioInterno(File f) throws Exception{
        try {
        Archivos decodificador = new Archivos();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.MP3","mp3");
        File[] files = f.listFiles();
        for(File fe: files)
        {            
            String ruta = fe.getAbsolutePath();      
            if(ruta.endsWith(".MP3") || ruta.endsWith(".mp3"))
            {
            Cancion cancion = decodificador.obtenerDatosCancion(ruta, fe.getName());
            System.out.println("ALBUM: "+cancion.getAlbum());
            lista.Insertar(cancion);
            }
            if(fe.isDirectory())
            {
                AgregarDirectorioInterno(fe.getAbsoluteFile());
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
}
