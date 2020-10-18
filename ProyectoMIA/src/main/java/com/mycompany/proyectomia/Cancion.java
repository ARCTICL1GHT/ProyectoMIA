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
    
    
}
