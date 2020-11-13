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
    
    //TPUB
    private String disquera;
    //TPE1
    private String artista;
    //TALB
    private String album;
    //TYER
    private String año;
    //TCON
    private String genero;
    //TIT2
    private String pista;
    //url
    private String url;
    //TLEN
    private String duracion;
    //USLT
    private String letra;
    //nombreArchivo
    private String nombre;
    //WOAR
    private String pagArtista;
    //WPUB 
    private String pagDisquera;
    //WXXX
    private String pagOtras;

    public Cancion() {
        /*this.disquera = "Sin información";
        this.artista = "Sin información";
        this.album = "Sin información";
        this.año = "Sin información";
        this.genero = "Sin información";
        this.pista = "Sin información";
        this.url = "Sin información";
        this.duracion = "Sin información";
        this.letra = "Sin información";
        this.nombre = "Sin información";
        this.pagOtras = "Sin información";
        this.pagArtista = "Sin información";
        this.pagDisquera = "Sin información";
*/
    }


    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }   

    public String getDisquera() {
        return disquera;
    }
    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getPagArtista() {
        return pagArtista;
    }

    public void setPagArtista(String pagArtista) {
        this.pagArtista = pagArtista;
    }

    public String getPagDisquera() {
        return pagDisquera;
    }

    public void setPagDisquera(String pagDisquera) {
        this.pagDisquera = pagDisquera;
    }

    public String getPagOtras() {
        return pagOtras;
    }

    public void setPagOtras(String pagOtras) {
        this.pagOtras = pagOtras;
    }
    public Integer getTotalBytes(){
        int total = 0;
        /*if(disquera!=null){System.out.println(disquera.length());}
        if(artista!=null){System.out.println(artista.length());}
        if(album!=null){System.out.println(album.length());}
        if(año!=null){System.out.println(año.length());}
        if(genero!=null){System.out.println(genero.length());}
        if(pista!=null){System.out.println(pista.length());}
        if(url!=null){System.out.println(url.length());}
        if(duracion!=null){System.out.println(duracion.length());}
        if(letra!=null){System.out.println(letra.length());}
        if(pagArtista!=null){System.out.println(pagArtista.length());}
        if(pagDisquera!=null){System.out.println(pagDisquera.length());}
        if(pagOtras!=null){System.out.println(pagOtras.length());}*/
        
        if(disquera!=null){total = total + disquera.length()+5;}else{total += 5;}
        if(artista!=null){total = total + artista.length()+5;}else{total += 5;}
        if(album!=null){total = total + album.length()+5;}else{total += 5;}
        if(año!=null){total = total + año.length()+5;}else{total += 5;}
        if(genero!=null){total = total + genero.length()+5;}else{total += 5;}
        if(pista!=null){total = total + pista.length()+5;}else{total += 5;}
        if(url!=null){total = total + url.length()+5;}else{total += 5;}
        if(duracion!=null){total = total + duracion.length()+5;}else{total += 5;}
        if(letra!=null){total = total + letra.length()+6;}else{total += 6;}
        if(pagArtista!=null){total = total + pagArtista.length()+5;}else{total += 5;}
        if(pagDisquera!=null){total = total + pagDisquera.length()+5;}else{total += 5;}
        if(pagOtras!=null){total = total + pagOtras.length()+5;}else{total += 5;}
        /*System.out.println("Nombre: "+this.pista);
        System.out.println("CANCION: "+total);*/
        return total;
    }
}
