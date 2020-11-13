/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomia;

import com.mycompany.proyectomia.Lista;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
        System.out.println("Reproduciendo: " + lista.actual().getCancion().getNombre());
    }

    public void Agregar() throws Exception {
        try {
            Archivos decodificador = new Archivos();
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.MP3", "mp3");
            fc.setFileFilter(filtro);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fc.showOpenDialog(null);
            File f = fc.getSelectedFile();
            String ruta = f.getAbsolutePath();

            if (ruta.endsWith(".MP3") || ruta.endsWith(".mp3")) {
                Cancion cancion = decodificador.obtenerDatosCancion(ruta, f.getName());
                lista.Insertar(cancion);
            }
            Nodo origen = lista.NodoAux(lista.frente());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void AgregarDirectorio() throws Exception {
        try {
            Archivos decodificador = new Archivos();
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fc.showOpenDialog(null);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            File f = fc.getSelectedFile();
            File[] files = f.listFiles();
            for (File fe : files) {
                String ruta = fe.getAbsolutePath();
                if (ruta.endsWith(".MP3") || ruta.endsWith(".mp3")) {
                    Cancion cancion = decodificador.obtenerDatosCancion(ruta, fe.getName());
                    lista.Insertar(cancion);
                }
                if (fe.isDirectory()) {
                    AgregarDirectorioInterno(fe.getAbsoluteFile());
                }
            }
            Nodo origen = lista.NodoAux(lista.frente());

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void AgregarDirectorioInterno(File f) throws Exception {
        try {
            Archivos decodificador = new Archivos();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.MP3", "mp3");
            File[] files = f.listFiles();
            for (File fe : files) {
                String ruta = fe.getAbsolutePath();
                if (ruta.endsWith(".MP3") || ruta.endsWith(".mp3")) {
                    Cancion cancion = decodificador.obtenerDatosCancion(ruta, fe.getName());
                    lista.Insertar(cancion);
                }
                if (fe.isDirectory()) {
                    AgregarDirectorioInterno(fe.getAbsoluteFile());
                }
            }
            Nodo origen = lista.NodoAux(lista.frente());

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void Siguiente() throws Exception {
        lista.Siguiente().getCancion().getUrl();
    }

    public void Anterior() throws Exception {
        lista.Anterior().getCancion().getUrl();
    }

    public String url() {
        return lista.frente().getCancion().getUrl();
    }

    public Integer NumLista() {
        return lista.Tama();
    }

    public Nodo Frente() {
        return lista.frente();
    }

    public Nodo Actual() {
        return lista.actual();
    }

    public void AgregarI(String ruta, File fe) {
        Cancion cancion = new Cancion();
        cancion.setUrl(ruta);
        cancion.setNombre(fe.getName());
        lista.Insertar(cancion);
    }

    void generarArchivos() throws FileNotFoundException, IOException {
        Nodo actualAux = this.lista.actual();
        Lista listaAux = this.lista;
        Lista listaActual = this.lista;
        String nombreArchivo = "C:\\Users\\luis2\\OneDrive\\Documents\\Lista de reproducción.data";

        int contadorBytes = 0;
        FileOutputStream archivo = new FileOutputStream(nombreArchivo);
        DataOutputStream escritor = new DataOutputStream(archivo);
        int tam = lista.Tama();
        int bytesCanciones = 0;
        listaAux.setRecorredor();
        for (int i = 0; i < tam; i++) {
            bytesCanciones = listaAux.actual().getCancion().getTotalBytes() + bytesCanciones;
            listaAux.Siguiente();
        }

        ArrayList<String> listaArtista = new ArrayList<String>();
        ArrayList<Integer> posicionIndices = new ArrayList<Integer>();
        listaActual.setRecorredor();
        String artista = "";
        for (int i = 0; i < listaActual.Tama(); i++) {
            if (artista == null ? listaActual.actual().getCancion().getArtista() != null : !artista.equals(listaActual.actual().getCancion().getArtista())) {
                artista = listaActual.actual().getCancion().getArtista();
                listaArtista.add(listaActual.actual().getCancion().getArtista());
            }
            listaActual.Siguiente();

        }

        System.out.println("ListaArtista: " + listaArtista);
        int noIndices = listaArtista.size();
        bytesCanciones = bytesCanciones + (noIndices * 8);
        int bytesTotales = 15 + bytesCanciones;
        System.out.println("TOTALES: " + bytesTotales);

        escritor.write("WPX".getBytes(StandardCharsets.US_ASCII)); //3B
        escritor.writeInt(tam); //Canciones totales 2B
        escritor.writeInt(bytesCanciones); //Longitud del archivo 4B
        escritor.writeInt(noIndices);
        contadorBytes = 15;
        for (int i = 0; i < noIndices; i++) {
            if (listaArtista.get(i) != null) {
                for (int j = 0; j < 4; j++) {
                    escritor.write(listaArtista.get(i).charAt(j));
                }
            } else {
                escritor.write("null".getBytes());
            }
            escritor.writeInt(0);
            contadorBytes += 8;
        }

        String artistaActual = "";
        listaAux.setRecorredor();
        for (int i = 0; i < tam; i++) {
            if (artistaActual == null ? listaAux.actual().getCancion().getArtista() != null : !artistaActual.equals(listaAux.actual().getCancion().getArtista())) {
                posicionIndices.add(contadorBytes);
                artistaActual = listaAux.actual().getCancion().getArtista();
            }

            escritor.write("DISQ".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getDisquera() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getDisquera().length());
                escritor.write(listaAux.actual().getCancion().getDisquera().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getDisquera().length() + 5;
            }

            escritor.write("ARTI".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getArtista() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getArtista().length());
                escritor.write(listaAux.actual().getCancion().getArtista().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getArtista().length() + 5;
            }

            escritor.write("ALBM".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getAlbum() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getAlbum().length());
                escritor.write(listaAux.actual().getCancion().getAlbum().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getAlbum().length() + 5;
            }

            escritor.write("FECH".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getAño() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getAño().length());
                escritor.write(listaAux.actual().getCancion().getAño().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getAño().length() + 5;
            }

            escritor.write("GENE".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getGenero() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getGenero().length());
                escritor.write(listaAux.actual().getCancion().getGenero().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getGenero().length() + 5;
            }

            escritor.write("PIST".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getPista() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getPista().length());
                escritor.write(listaAux.actual().getCancion().getPista().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getPista().length() + 5;
            }

            escritor.write("URLX".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getUrl() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getUrl().length());
                escritor.write(listaAux.actual().getCancion().getUrl().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getUrl().length() + 5;
            }

            escritor.write("DURA".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getDuracion() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getDuracion().length());
                escritor.write(listaAux.actual().getCancion().getDuracion().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getDuracion().length() + 5;
            }

            escritor.write("LETR".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getLetra() == null) {
                escritor.writeShort(0);
                contadorBytes += 6;
            } else {
                escritor.writeShort((short) listaAux.actual().getCancion().getLetra().length());
                escritor.write(listaAux.actual().getCancion().getLetra().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getLetra().length() + 6;
            }

            escritor.write("PART".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getPagArtista() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getPagArtista().length());
                escritor.write(listaAux.actual().getCancion().getPagArtista().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getPagArtista().length() + 5;
            }

            escritor.write("PDIS".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getPagDisquera() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getPagDisquera().length());
                escritor.write(listaAux.actual().getCancion().getPagDisquera().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getPagDisquera().length() + 5;
            }

            escritor.write("POTR".getBytes(StandardCharsets.US_ASCII));
            if (listaAux.actual().getCancion().getPagOtras() == null) {
                escritor.writeByte(0);
                contadorBytes += 5;
            } else {
                escritor.writeByte((byte) listaAux.actual().getCancion().getPagOtras().length());
                escritor.write(listaAux.actual().getCancion().getPagOtras().getBytes(StandardCharsets.US_ASCII));
                contadorBytes = contadorBytes + listaAux.actual().getCancion().getPagOtras().length() + 5;
            }

            listaAux.Siguiente();
        }        
        System.out.println("BYTES TOTALES: " + contadorBytes);
        
        //Creacion de indices
        File file = new File(nombreArchivo);
        byte[] fileData = new byte[(int)file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        dis.readFully(fileData);
        char frameChar[] = new char[3];
        byte[] posicionIndicesBytes = new byte [4];
        int contadorIndices = 15,division,division2,numeroActual,numeroReal;
                
        for (int i = 0; i < noIndices; i++){
            contadorIndices+=4;
            numeroActual = posicionIndices.get(i);
            int contadorInterno;
            for (int j = 8; j >= 1; j--) {
                j--;
                division = (numeroActual/((int)Math.pow(16,j)));
                if(division!=0){
                    numeroActual = numeroActual-(division*(int)Math.pow(16, j));
                }
                division2 = (numeroActual/((int)Math.pow(16,j-1)));
                if(division2!=0){
                    numeroActual = numeroActual-(division2*(int)Math.pow(16, j-1));
                }
                numeroReal = (division*16)+division2;
                fileData[contadorIndices] = (byte)numeroReal;
                contadorIndices++;
            }
        }
        archivo = new FileOutputStream("C:\\Users\\luis2\\OneDrive\\Documents\\Lista de reproducción.data");
        escritor = new DataOutputStream(archivo);
        for (int i = 0; i < bytesTotales; i++) {
            escritor.writeByte(fileData[i]);
        }
        this.lista.setActual(actualAux);
    }
    public void leerArchivo(){
        this.lista = new Lista();
        int cantCanciones = 0; 
        
        try {
            
            String ruta = "C:\\Users\\luis2\\OneDrive\\Documents\\Lista de reproducción.data";

            if (ruta.endsWith(".DATA") || ruta.endsWith(".data")) {
                Archivos decodificador = new Archivos();
                cantCanciones = decodificador.getTamañoCanciones(ruta);
                Cancion canciones[] = new Cancion[cantCanciones];
                canciones = decodificador.obtenerDatosArchivo(ruta);
                for (int i = 0; i < cantCanciones;i++) {
                    System.out.println(canciones[i].getArtista());
                    this.lista.Insertar(canciones[i]);
                }
                
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        lista.setActual(lista.frente());
    }
    public void leerArchivoAlbum(String Soy){
        this.lista = new Lista();
        int cantCanciones = 0; 
        boolean flag=false;
        try {
            String ruta = "C:\\Users\\luis2\\OneDrive\\Documents\\Lista de reproducción.data";

            if (ruta.endsWith(".DATA") || ruta.endsWith(".data")) {
                Archivos decodificador = new Archivos();
                cantCanciones = decodificador.getTamañoCanciones(ruta);
                Cancion canciones[] = new Cancion[cantCanciones];
                String seleccion[] = new String[cantCanciones];
                canciones = decodificador.obtenerDatosArchivo(ruta);
               
                        for(int i=0;i<cantCanciones;i++)
                        {

                            for(int j=0;j<seleccion.length;j++)
                            {
                                    if(Busco(canciones[i],Soy)==seleccion[j])
                                {
                                    flag=true;
                                    System.out.println("Ingresado**********************************************");
                                }
                            }
                                if(!flag)
                                {
                                    seleccion[i]=Busco(canciones[i],Soy);
                                    flag=false;
                                }
                        }   
                
               
                    String resp = (String) JOptionPane.showInputDialog(null, "Seleccione "+Soy, "Seleccion", JOptionPane.DEFAULT_OPTION, null, seleccion, seleccion[0]);
                for (int i = 0; i < cantCanciones;i++) {
                    System.out.println(canciones[i].getArtista());
                    if(resp==Busco(canciones[i],Soy))
                    {
                    this.lista.Insertar(canciones[i]);
                
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        lista.setActual(lista.frente());
    }
    private String Busco(Cancion cancion, String soy)
    {
        if(soy=="Album")
        {
            return cancion.getAlbum();
    
        }
        else if(soy=="Artista")
        {
            return cancion.getArtista();
        }
        else if(soy=="Pista")
        {
            return cancion.getPista();
        }
        else if(soy=="Año")
        {
            return cancion.getPista();
        }
        return "";
    }
}
