/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
/**
 *
 * @author luis2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        InputStream is = null;
        Scanner S=new Scanner(System.in);
        byte[] buffer = new byte[5];
        char c;
        String p;
        Archivos mp3=new Archivos();
        int a;
        mp3.extencion="agenda.dat";
        while(true)
        {
            System.out.println("1. Ingresar Cancion");
            System.out.println("2. Mostrar datos de cancion");
            System.out.println("3.Salir");
            a=S.nextInt();
            if(1==a)
            {         
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
                
                File file = new File("C:\\Users\\Tato\\Desktop\\Temp\\01 Perfect World.mp3");
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
                System.out.println("FRAME: "+Frame);
                
                int tamañoFrame = 0;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    //System.out.print((char)(fileData[i]));
                    tamañoFrame = (int)fileData[i]+tamañoFrame;                    
                }
                contadorBytes = contadorBytes+6;
                System.out.println("TAMAÑO DEL FRAME: "+tamañoFrame);
                
                char NombreObtenido[] = new char[tamañoFrame];
                for (int i = contadorBytes; i < tamañoFrame+contadorBytes; i++) {
                    if(((int)fileData[i])>1&&(int)fileData[i]<255){
                        NombreObtenido[j] = (char)(fileData[i]);
                        j++;
                    }
                }
                String datoObtenido = new String(NombreObtenido);
                System.out.println("DATO OBTENIDO: "+datoObtenido);
                contadorBytes = contadorBytes+tamañoFrame;
                k++;
                }
                             
                
                /*
                byte fileContent[] = new byte[10];
                fin.read(fileContent);
                String s = new String(fileContent);
                System.out.println("File content: " + s);
                */   
                System.out.println("");
                dis.close();
            }
            else if(2==a)
            {
                try {
                    mp3.MostrarA(mp3.extencion);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(3==a)
            {
                System.exit(0);
            }
            
        }
    }
    
}
