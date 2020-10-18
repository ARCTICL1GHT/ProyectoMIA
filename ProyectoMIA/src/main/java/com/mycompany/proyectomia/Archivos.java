/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis2
 */
public class Archivos {
    
    public Cancion obtenerDatosCancion(String url,String nombre) throws FileNotFoundException, IOException
    {
        Cancion cancionDatos = new Cancion();
        cancionDatos.setUrl(url);
        cancionDatos.setNombre(nombre);
        String Decir="";
        int contadorBytes = 0;
        
                /*               
                Guía de estructura inicial
                0-2 ID3
                3-4 Versión
                5 flags
                6-9 tamaño
                
                Frames
                0-3 tipo de frame  - 4B
                4-7 tamaño - 4B
                8-9 flags - 2B
                Contenido variable
                */
                
                File file = new File(url);

                byte[] fileData = new byte[(int)file.length()];
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                dis.readFully(fileData);
                
                //MP3 HEADER 10 BYTES
                int tamañoHeader = 0;
                byte [] tamañoHeaderBytes = new byte[4];       
                int n = 0;
                contadorBytes = 6;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    System.out.print((char)(fileData[i]));
                    tamañoHeaderBytes[n] = fileData[i];      
                    n++;
                }
                tamañoHeader = (ByteBuffer.wrap(tamañoHeaderBytes).getInt()/3);
                System.out.println("TAMAÑO DEL FRAME: " + tamañoHeader);
                contadorBytes = contadorBytes+4;
                //PRIMER FRAME
                int k = 0;
                while(contadorBytes<tamañoHeader){
                char frameChar[] = new char[4];
                int j=0;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    //System.out.print((char)(fileData[i]));
                    frameChar[j] = (char)(fileData[i]);
                    j++;
                }
                contadorBytes = contadorBytes+4;
                j=0;
                String frame = new String(frameChar);
                System.out.println("FRAME: "+frame);
                
                int tamañoFrame = 0;
                byte [] tamañoFrameBytes = new byte[4];       
                int b = 0;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    tamañoFrameBytes[b] = fileData[i];      
                    b++;
                }
                tamañoFrame = ByteBuffer.wrap(tamañoFrameBytes).getInt();
                System.out.println("TAMAÑO DEL FRAME: " + tamañoFrame);
                contadorBytes = contadorBytes+6;
                if(tamañoFrame+contadorBytes>tamañoHeader||tamañoFrame<0)
                {
                    break;
                }
                char NombreObtenido[] = new char[tamañoFrame];
                for (int i = contadorBytes; i < tamañoFrame+contadorBytes; i++) {
                    if(((int)fileData[i])>1&&(int)fileData[i]<255){
                        NombreObtenido[j] = (char)(fileData[i]);
                        j++;
                    }
                }
                String datoObtenido = new String(NombreObtenido);
                if(tamañoFrame<1000){
                    System.out.println("DATO OBTENIDO: "+datoObtenido);                    
                }
                contadorBytes = contadorBytes+tamañoFrame;
                switch(FramesEnum.getTypeFrame(frame)){
                    case disquera:
                        cancionDatos.setDisquera(datoObtenido);
                        break;
                    case artista:
                        cancionDatos.setArtista(datoObtenido);
                        break;
                    case artista2:
                        cancionDatos.setArtista(datoObtenido);
                        break;
                    case album:
                        cancionDatos.setAlbum(datoObtenido);
                        break;
                    case año:
                        cancionDatos.setAño(datoObtenido);
                        break;
                    case genero:
                        cancionDatos.setGenero(datoObtenido);
                        break;
                    case pista:
                        cancionDatos.setPista(datoObtenido);
                        break;
                    case duracion:
                        cancionDatos.setDuracion(datoObtenido);
                        break;
                    case letra:
                        cancionDatos.setLetra(datoObtenido);
                        break;
                    case pagArtista:
                        cancionDatos.setPagArtista(datoObtenido);
                        break;
                    case pagDisquera:
                        cancionDatos.setPagDisquera(datoObtenido);
                        break;
                    case pagOtras:
                        cancionDatos.setPagOtras(datoObtenido);
                        break;
                    default:                        
                        break;
                }     
                
                }                           
                dis.close();
                return cancionDatos;
    }
}
