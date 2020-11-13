/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

/**
 *
 * @author Tato
 */
public enum FramesEnum {
    //etiquetas del MP3 ID3
    disquera("TPUB"),
    artista("TPE1"),
    artista2("TPE2"),
    album("TALB"),
    año("TYER"),
    genero("TCON"),
    pista("TIT2"),
    duracion("TLEN"),
    letra("USLT"),
    pagArtista("WOAR"),
    pagDisquera("WPUB"),    
    pagOtras("WXXX"),
    
    //etiquetas propias
    disqueraX("DISQ"),
    artistaX("ARTI"),
    albumX("ALBM"),
    añoX("FECH"),
    generoX("GENE"),
    pistaX("PIST"),
    urlX("URLX"),
    duracionX("DURA"),
    letraX("LETR"),
    pagArtistaX("PART"),
    pagDisqueraX("PDIS"),    
    pagOtrasX("POTR"),
    
    defecto("default");

    private final String frame;

    FramesEnum(String frame) {
        this.frame = frame;
    }

    public String getValue() {
        return frame;
    }

    public static FramesEnum getTypeFrame(String frame) {
        for (FramesEnum d : FramesEnum.values()) {
            if (d.getValue().equals(frame)) {
                return d;
            }
        }
        return defecto;
    }
}
