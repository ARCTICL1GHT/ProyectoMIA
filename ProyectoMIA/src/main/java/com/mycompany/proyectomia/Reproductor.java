/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import com.mycompany.proyectomia.Lista;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Reproductor {
    private Lista lista;
    public Reproductor() {
        lista = new Lista();
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) throws IOException {
        this.lista = lista;
        generarArchivos();
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

    void generarArchivos() throws FileNotFoundException, IOException {
        Lista listaAux = this.lista;  
        listaAux.setRecorredor();
        String nombreArchivo = "Lista de reproducción.data";
        String formato = "WPX";
        int ContadorBytes = 0;
        FileOutputStream archivo = new FileOutputStream(nombreArchivo);
        DataOutputStream escritor = new DataOutputStream(archivo);        
        int tam = lista.Tama();
        escritor.write(formato.getBytes(StandardCharsets.US_ASCII));
        escritor.writeShort(tam);
        for (int i = 0; i < tam; i++) {
            escritor.write("DISQ".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getDisquera()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getDisquera().length());
                escritor.write(listaAux.actual().getCancion().getDisquera().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("ARTI".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getArtista()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getArtista().length());
                escritor.write(listaAux.actual().getCancion().getArtista().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("ALBM".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getAlbum()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getAlbum().length());
                escritor.write(listaAux.actual().getCancion().getAlbum().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("FECH".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getAño()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getAño().length());
                escritor.write(listaAux.actual().getCancion().getAño().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("GENE".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getGenero()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getGenero().length());
                escritor.write(listaAux.actual().getCancion().getGenero().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("PIST".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getPista()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getPista().length());
                escritor.write(listaAux.actual().getCancion().getPista().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("URLX".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getUrl()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getUrl().length());
                escritor.write(listaAux.actual().getCancion().getUrl().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("DURA".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getDuracion()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getDuracion().length());
                escritor.write(listaAux.actual().getCancion().getDuracion().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("LETR".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getLetra()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeShort((short)listaAux.actual().getCancion().getLetra().length());
                escritor.write(listaAux.actual().getCancion().getLetra().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("PART".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getPagArtista()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getPagArtista().length());
                escritor.write(listaAux.actual().getCancion().getPagArtista().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("PDIS".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getPagDisquera()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getPagDisquera().length());
                escritor.write(listaAux.actual().getCancion().getPagDisquera().getBytes(StandardCharsets.US_ASCII));
            }
            
            escritor.write("POTR".getBytes(StandardCharsets.US_ASCII));
            if(listaAux.actual().getCancion().getPagOtras()==null){  
                escritor.writeByte(0);
            }else{
                escritor.writeByte((byte)listaAux.actual().getCancion().getPagOtras().length());
                escritor.write(listaAux.actual().getCancion().getPagOtras().getBytes(StandardCharsets.US_ASCII));
            }  
            
            listaAux.Siguiente();
        }
    }
}
