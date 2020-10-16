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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis2
 */
public class Archivos {
    private String extension;
    public void SetExtencion(String Archivo) throws FileNotFoundException
    {
        extension=Archivo;
    }
    public String Mostrar() throws FileNotFoundException, IOException
    {
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
                
                File file = new File(extension);
                FileInputStream fin = null;
                fin = new FileInputStream(file);
                byte[] fileData = new byte[(int)file.length()];
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                dis.readFully(fileData);
                
                //MP3 HEADER 10 BYTES
                for (int i = contadorBytes; i < 10+contadorBytes; i++) {
                    //System.out.print((char)(fileData[i]));
                }
                contadorBytes = contadorBytes+10;
                //PRIMER FRAME
                int k = 0;
                while(k!=10){
                char FrameChar[] = new char[4];
                int j=0;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    //System.out.print((char)(fileData[i]));
                    FrameChar[j] = (char)(fileData[i]);
                    j++;
                }
                contadorBytes = contadorBytes+4;
                j=0;
                String Frame = new String(FrameChar);
                Decir=Decir+"FRAME: "+Frame+"\n";
                
                int tamañoFrame = 0;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    //System.out.print((char)(fileData[i]));
                    tamañoFrame = (int)fileData[i]+tamañoFrame;                    
                }
                contadorBytes = contadorBytes+6;
                Decir=Decir+"TAMAÑO DEL FRAME: "+tamañoFrame+"\n";
                
                char NombreObtenido[] = new char[tamañoFrame];
                for (int i = contadorBytes; i < tamañoFrame+contadorBytes; i++) {
                    if(((int)fileData[i])>1&&(int)fileData[i]<255){
                        NombreObtenido[j] = (char)(fileData[i]);
                        j++;
                    }
                }
                String datoObtenido = new String(NombreObtenido);
                Decir=Decir+"DATO OBTENIDO: "+datoObtenido+"vez "+k+"\n";
                contadorBytes = contadorBytes+tamañoFrame;
                k++;
                }
                             
                
                /*
                byte fileContent[] = new byte[10];
                fin.read(fileContent);
                String s = new String(fileContent);
                System.out.println("File content: " + s);
                */   
                dis.close();
                return Decir;
    }
}
