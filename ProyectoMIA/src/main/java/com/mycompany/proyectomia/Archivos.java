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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis2
 */
public class Archivos {

    public Cancion obtenerDatosCancion(String url, String nombre) throws FileNotFoundException, IOException {
        Cancion cancionDatos = new Cancion();
        cancionDatos.setUrl(url);
        cancionDatos.setNombre(nombre);
        String Decir = "";
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
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        dis.readFully(fileData);

        //MP3 HEADER 10 BYTES
        int tamañoHeader = 0;
        byte[] tamañoHeaderBytes = new byte[4];
        int n = 0;
        contadorBytes = 6;
        for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
            System.out.print((char) (fileData[i]));
            tamañoHeaderBytes[n] = fileData[i];
            n++;
        }
        tamañoHeader = (ByteBuffer.wrap(tamañoHeaderBytes).getInt() / 3);
        System.out.println("TAMAÑO DEL FRAME: " + tamañoHeader);
        contadorBytes = contadorBytes + 4;
        //PRIMER FRAME
        int k = 0;
        while (contadorBytes < tamañoHeader) {
            char frameChar[] = new char[4];
            int j = 0;
            for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
                //System.out.print((char)(fileData[i]));
                frameChar[j] = (char) (fileData[i]);
                j++;
            }
            contadorBytes = contadorBytes + 4;
            j = 0;
            String frame = new String(frameChar);
            System.out.println("FRAME: " + frame);

            int tamañoFrame = 0;
            byte[] tamañoFrameBytes = new byte[4];
            int b = 0;
            for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
                tamañoFrameBytes[b] = fileData[i];
                b++;
            }
            tamañoFrame = ByteBuffer.wrap(tamañoFrameBytes).getInt();
            System.out.println("TAMAÑO DEL FRAME: " + tamañoFrame);
            contadorBytes = contadorBytes + 6;
            if (tamañoFrame + contadorBytes > tamañoHeader || tamañoFrame < 0) {
                break;
            }
            char NombreObtenido[] = new char[tamañoFrame];
            for (int i = contadorBytes; i < tamañoFrame + contadorBytes; i++) {
                if (((int) fileData[i]) > 1 && (int) fileData[i] < 255) {
                    NombreObtenido[j] = (char) (fileData[i]);
                    j++;
                }
            }
            String datoObtenido = new String(NombreObtenido);
            if (tamañoFrame < 1000) {
                System.out.println("DATO OBTENIDO: " + datoObtenido);
            }
            contadorBytes = contadorBytes + tamañoFrame;
            switch (FramesEnum.getTypeFrame(frame)) {
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

    public Cancion[] obtenerDatosArchivo(String ruta) throws FileNotFoundException, IOException {
        File file = new File(ruta);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        dis.readFully(fileData);
        Cancion cancionDatos = new Cancion();
        /*Guía
        escritor.write("WPX".getBytes(StandardCharsets.US_ASCII)); //3B
        escritor.writeShort(tam); //Canciones totales 2B
        escritor.writeInt(bytesCanciones); //Longitud del archivo 4B
        escritor.writeShort(noIndices);*/
        int contadorBytes = 3,n=0,cantBytesTotales,cantCanciones,cantIndices,contadorCanciones=0;
        byte[] cantCancionesByte = new byte[4];
        for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
            cantCancionesByte[n] = fileData[i];
            n++;
        }
        
        contadorBytes +=4;
        cantCanciones = (ByteBuffer.wrap(cantCancionesByte).getInt());
        Cancion canciones[] = new Cancion[cantCanciones];
        n=0;
        byte[] cantBytesTotalesBytes = new byte[4];
        for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
            cantBytesTotalesBytes[n] = fileData[i];
            n++;
        }
        contadorBytes +=4;
        cantBytesTotales = (ByteBuffer.wrap(cantBytesTotalesBytes).getInt());
        n=0;
        
        byte[] cantIndicesBytes = new byte[4];
        for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
            cantIndicesBytes[n] = fileData[i];
            n++;
        }
        contadorBytes +=4;
        cantIndices = (ByteBuffer.wrap(cantIndicesBytes).getInt());
        contadorBytes = contadorBytes + (cantIndices*8);
        while(contadorBytes<cantBytesTotales+15){
            //Datos en orden disquera -> artista -> album -> año -> genero -> pista -> url -> duracion -> letra -> pagArtistas -> pagDisquera -> pagOtras
            
            char frameChar[] = new char[4];
            int j = 0;
            for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
                //System.out.print((char)(fileData[i]));
                frameChar[j] = (char) (fileData[i]);
                j++;
            }
            contadorBytes = contadorBytes + 4;
            j = 0;
            String frame = new String(frameChar);
            System.out.println("FRAME: " + frame);
            System.out.println("Posicion actual: " + contadorBytes);
            if(!"LETR".equals(frame)){
                byte tamañoFrame = fileData[contadorBytes];
                System.out.println("TAMAÑO: " + tamañoFrame);
                contadorBytes++;
                char NombreObtenido[] = new char[tamañoFrame];
                for (int i = contadorBytes; i < (tamañoFrame + contadorBytes); i++) {
                    if (((int) fileData[i]) > 1 && (int) fileData[i] < 255) {
                        NombreObtenido[j] = (char) (fileData[i]);
                        j++;
                    }
                }                
            String datoObtenido = new String(NombreObtenido);  
            contadorBytes = contadorBytes + tamañoFrame;
            switch (FramesEnum.getTypeFrame(frame)) {
                case disqueraX:
                    cancionDatos.setDisquera(datoObtenido);
                    break;
                case artistaX:
                    System.out.println(datoObtenido);
                    cancionDatos.setArtista(datoObtenido);
                    break;
                case albumX:
                    cancionDatos.setAlbum(datoObtenido);
                    break;
                case añoX:
                    cancionDatos.setAño(datoObtenido);
                    break;
                case generoX:
                    cancionDatos.setGenero(datoObtenido);
                    break;
                case pistaX:
                    cancionDatos.setPista(datoObtenido);
                    break;
                case urlX:
                    cancionDatos.setUrl(datoObtenido);
                    break;
                case duracionX:
                    cancionDatos.setDuracion(datoObtenido);
                    break;
                case letraX:
                    cancionDatos.setLetra(datoObtenido);
                    break;
                case pagArtistaX:
                    cancionDatos.setPagArtista(datoObtenido);
                    break;
                case pagDisqueraX:
                    cancionDatos.setPagDisquera(datoObtenido);
                    break;
                case pagOtrasX:
                    cancionDatos.setPagOtras(datoObtenido);
                    System.out.println(cancionDatos.getArtista());
                    canciones[contadorCanciones] = cancionDatos;
                    contadorCanciones++;
                    cancionDatos = new Cancion();
                    break;
                default:
                    break;
            }
        System.out.println("*************************************************************");
            }else{
                System.out.println("Posicion actual: " + contadorBytes);
                short tamañoFrame = 0;
                byte[] tamañoFrameBytes = new byte[2];
                tamañoFrameBytes[0] = fileData[contadorBytes];                
                tamañoFrameBytes[1] = fileData[contadorBytes+1];
                contadorBytes = contadorBytes +2;
                System.out.println("Posicion actual: " + contadorBytes);
                tamañoFrame = ByteBuffer.wrap(tamañoFrameBytes).getShort();                 
                System.out.println("TAMAÑO DEL LA LETRA: " + tamañoFrame);
                if(tamañoFrame !=0){
                char NombreObtenido[] = new char[tamañoFrame];
                for (int i = contadorBytes; i < (tamañoFrame + contadorBytes); i++) {
                    if (((int) fileData[i]) > 1 && (int) fileData[i] < 255) {
                        NombreObtenido[j] = (char) (fileData[i]);
                        j++;
                    }
                }
                String datoObtenido = new String(NombreObtenido);  
                contadorBytes = contadorBytes + tamañoFrame;
                cancionDatos.setLetra(datoObtenido);
                System.out.println("Posicion actual: " + contadorBytes);
                }
            }            
        }
        System.out.println("Cantidad canciones: " + cantCanciones);
        System.out.println("Cantidad bytes: " + cantBytesTotales);
        System.out.println("Cantidad indices: " + cantIndices);
        dis.close();
        return canciones;
    }

    public int getTamañoCanciones(String ruta) throws FileNotFoundException, IOException {
        File file = new File(ruta);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        dis.readFully(fileData);
        /*Guía
        escritor.write("WPX".getBytes(StandardCharsets.US_ASCII)); //3B
        escritor.writeShort(tam); //Canciones totales 2B
        escritor.writeInt(bytesCanciones); //Longitud del archivo 4B
        escritor.writeShort(noIndices);*/
        int contadorBytes = 3,n=0,cantBytesTotales,cantCanciones,cantIndices;
        byte[] cantCancionesByte = new byte[4];
        for (int i = contadorBytes; i < 4 + contadorBytes; i++) {
            cantCancionesByte[n] = fileData[i];
            n++;
        }
        cantCanciones = (ByteBuffer.wrap(cantCancionesByte).getInt());
        dis.close();
        return cantCanciones;
    }

}
