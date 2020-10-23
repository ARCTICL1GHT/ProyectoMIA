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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Interfaz extends javax.swing.JFrame {
    Reproductor Reproducir = new Reproductor();
    boolean Verificar = false, Verificar2 =false;
    private ImageIcon IconoAnterior = new ImageIcon("Anterior.png");
    private ImageIcon IconoSiguiente = new ImageIcon("Siguiente.png");
    private ImageIcon IconoAgregar = new ImageIcon("Canciones.png");
    private ImageIcon IconoAgregarD = new ImageIcon("Musica.png");
    private ImageIcon IconoVentana = new ImageIcon("Canciones.png");
    private ImageIcon IconoLimpiar = new ImageIcon("Eliminar.png");
    private ImageIcon IconoCarpeta = new ImageIcon("Carpeta.jpg");
    Lista listaActual = new Lista();
    Lista listaArtistas = new Lista();


    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        setLocationRelativeTo(null);
        File directorio = new File("Lista");
        File f = new File(directorio.getName());
        AnteriorButton.setIcon(new ImageIcon(IconoAnterior.getImage()));
        SiguienteButton.setIcon(new ImageIcon(IconoSiguiente.getImage()));
        AgregarButton.setIcon(new ImageIcon(IconoAgregarD.getImage()));
        VaciarButton.setIcon(new ImageIcon(IconoLimpiar.getImage()));
        Agregar_Button.setIcon(new ImageIcon(IconoAgregar.getImage()));
        generarArchivos.setIcon(new ImageIcon(IconoCarpeta.getImage()));
    }

    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AgregarButton = new javax.swing.JButton();
        SiguienteButton = new javax.swing.JButton();
        AnteriorButton = new javax.swing.JButton();
        cancionActual = new javax.swing.JLabel();
        MostrarLista = new java.awt.List();
        VaciarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        MostrarContenido = new java.awt.List();
        Agregar_Button = new javax.swing.JButton();
        generarArchivos = new javax.swing.JButton();
        comboArt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lector de Datos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204), 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(989, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setText("Canción Actual:");

        AgregarButton.setBackground(new java.awt.Color(204, 204, 204));
        AgregarButton.setText("Agregar Directorio");
        AgregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarButtonActionPerformed(evt);
            }
        });

        SiguienteButton.setBackground(new java.awt.Color(204, 204, 204));
        SiguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteButtonActionPerformed(evt);
            }
        });

        AnteriorButton.setBackground(new java.awt.Color(204, 204, 204));
        AnteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorButtonActionPerformed(evt);
            }
        });

        MostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarListaActionPerformed(evt);
            }
        });

        VaciarButton.setText("Vaciar Lista");
        VaciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel2.setText("Descripción:");

        MostrarContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarContenidoActionPerformed(evt);
            }
        });

        Agregar_Button.setBackground(new java.awt.Color(204, 204, 204));
        Agregar_Button.setText("Agregar Cancion");
        Agregar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_ButtonActionPerformed(evt);
            }
        });

        generarArchivos.setText("Generar Archivo");
        generarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarArchivosActionPerformed(evt);
            }
        });

        comboArt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar artista"}));
        comboArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboArtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(cancionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(AnteriorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(MostrarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AgregarButton)
                                    .addComponent(generarArchivos))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Agregar_Button)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(VaciarButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SiguienteButton))
                                    .addComponent(comboArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 24, Short.MAX_VALUE)))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MostrarContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(89, 89, 89)))
                .addGap(178, 178, 178))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(MostrarContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cancionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(MostrarLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnteriorButton)
                            .addComponent(SiguienteButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AgregarButton)
                                .addComponent(VaciarButton)
                                .addComponent(Agregar_Button)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generarArchivos)
                            .addComponent(comboArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Agregar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_ButtonActionPerformed
        // TODO add your handling code here:
        try {
            Reproducir.Agregar();
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num=0;
        Nodo Obtener= Reproducir.Frente();
        cancionActual.setText(Reproducir.Actual().getCancion().getNombre());
        try {
            ListadeDatos();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0;i<(Reproducir.NumLista()+num);i++){
            MostrarLista.add(Obtener.getCancion().getNombre());
            if(Obtener.getSiguiente()!=null)
            {
                Obtener=Obtener.getSiguiente();
            }
        }
        
        
        
    }//GEN-LAST:event_Agregar_ButtonActionPerformed

    private void MostrarContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarContenidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MostrarContenidoActionPerformed

    private void VaciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarButtonActionPerformed
        Verificar = false;
        try {
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        Reproducir = new Reproductor();
        MostrarLista.clear();
        cancionActual.setText("");
        MostrarContenido.clear();
    }//GEN-LAST:event_VaciarButtonActionPerformed

    private void MostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarListaActionPerformed

    }//GEN-LAST:event_MostrarListaActionPerformed

    private void AnteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorButtonActionPerformed
        MostrarContenido.clear();
        try {
            Reproducir.Anterior();
            cancionActual.setText(Reproducir.Actual().getCancion().getNombre());
            ListadeDatos();
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_AnteriorButtonActionPerformed

    private void SiguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteButtonActionPerformed
        MostrarContenido.clear();
        try {
            Reproducir.Siguiente();
            cancionActual.setText(Reproducir.Actual().getCancion().getNombre());
            ListadeDatos();
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SiguienteButtonActionPerformed

    private void AgregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarButtonActionPerformed
        try {
            Reproducir.AgregarDirectorio();
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num=0;
        Nodo Obtener= Reproducir.Frente();
        cancionActual.setText(Reproducir.Actual().getCancion().getNombre());
        try {
            ListadeDatos();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0;i<(Reproducir.NumLista()+num);i++){
            MostrarLista.add(Obtener.getCancion().getNombre());
            if(Obtener.getSiguiente()!=null)
            {
                Obtener=Obtener.getSiguiente();
            }
        }
        
        listaActual = Reproducir.getLista();
        listaActual.setRecorredor();
        String artista = "";
        while(listaActual.actual().getSiguiente()!=null)
        {
            if(artista == null ? listaActual.actual().getCancion().getArtista() != null : !artista.equals(listaActual.actual().getCancion().getArtista())){              
                if(listaActual.actual().getCancion().getArtista()!=null){
                    artista = listaActual.actual().getCancion().getArtista();
                    comboArt.addItem(listaActual.actual().getCancion().getArtista()); 
                }                
            }           
            listaActual.Siguiente();
        }        
    }//GEN-LAST:event_AgregarButtonActionPerformed

    private void generarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarArchivosActionPerformed
        try {       
            Reproducir.generarArchivos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generarArchivosActionPerformed

    private void comboArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboArtActionPerformed
        listaArtistas = new Lista();
        String itemSeleecionado = (String)comboArt.getSelectedItem();
        listaActual.setRecorredor();
        while(listaActual.actual().getSiguiente()!=null)
        {
            if(itemSeleecionado == null ? listaActual.actual().getCancion().getArtista() == null : itemSeleecionado.equals(listaActual.actual().getCancion().getArtista()))
            {         
                listaArtistas.Insertar(listaActual.actual().getCancion());
            }
            listaActual.Siguiente();
            
        }
        listaArtistas.Mostrar(listaArtistas.frente());
        try {
            x();
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboArtActionPerformed
    public void x() throws IOException{
        
        Reproducir = new Reproductor();
                MostrarLista.clear();
                cancionActual.setText("");
                MostrarContenido.clear();
                int num=0;
                Reproducir.setLista(listaArtistas);
                Nodo Obtener= Reproducir.Frente();
                cancionActual.setText(Reproducir.Actual().getCancion().getPista());
               try {
                    ListadeDatos();
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                for(int i = 0;i<(Reproducir.NumLista()+num);i++){
                    MostrarLista.add(Obtener.getCancion().getNombre());
                    if(Obtener.getSiguiente()!=null)
                    {
                        Obtener=Obtener.getSiguiente();
                    }
                }
    }
    
    
    private void ListadeDatos() throws FileNotFoundException, IOException
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
                
                MostrarContenido.add("Disquera: "+Reproducir.Actual().getCancion().getDisquera());
                MostrarContenido.add("Artista: "+Reproducir.Actual().getCancion().getArtista());
                MostrarContenido.add("Album: "+Reproducir.Actual().getCancion().getAlbum());   
                MostrarContenido.add("Año: "+Reproducir.Actual().getCancion().getAño());
                MostrarContenido.add("Genero: "+Reproducir.Actual().getCancion().getGenero()); 
                MostrarContenido.add("Pista: "+Reproducir.Actual().getCancion().getPista());   
                MostrarContenido.add("Direccion: "+Reproducir.Actual().getCancion().getUrl());   
                MostrarContenido.add("Duracion: "+Reproducir.Actual().getCancion().getDuracion());   
                MostrarContenido.add("Letra: "+Reproducir.Actual().getCancion().getLetra());
                MostrarContenido.add("Pagina del Artista: "+Reproducir.Actual().getCancion().getPagArtista());   
                MostrarContenido.add("Pagina de la disquera: "+Reproducir.Actual().getCancion().getPagDisquera());   
                MostrarContenido.add("Otras páginas: "+Reproducir.Actual().getCancion().getPagOtras());   
                
                
                
                
                /*
                
                
                File file = new File(Reproducir.Actual().getCancion().getUrl());
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
                MostrarContenido.add("FRAME: "+Frame);
                
                int tamañoFrame = 0;
                for (int i = contadorBytes; i < 4+contadorBytes; i++) {
                    //System.out.print((char)(fileData[i]));
                    tamañoFrame = (int)fileData[i]+tamañoFrame;                    
                }
                contadorBytes = contadorBytes+6;
                System.out.println("TAMAÑO DEL FRAME: "+tamañoFrame);
                MostrarContenido.add("TAMAÑO DEL FRAME: "+tamañoFrame);
                
                char NombreObtenido[] = new char[tamañoFrame];
                for (int i = contadorBytes; i < tamañoFrame+contadorBytes; i++) {
                    if(((int)fileData[i])>1&&(int)fileData[i]<255){
                        NombreObtenido[j] = (char)(fileData[i]);
                        j++;
                    }
                }
                String datoObtenido = new String(NombreObtenido);
                System.out.println("DATO OBTENIDO: "+datoObtenido);
                MostrarContenido.add("DATO OBTENIDO: "+datoObtenido);
                contadorBytes = contadorBytes+tamañoFrame;
                k++;
                }
                             
                
                /*
                byte fileContent[] = new byte[10];
                fin.read(fileContent);
                String s = new String(fileContent);
                System.out.println("File content: " + s);
                /*  
                System.out.println("");
                dis.close();
                */
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarButton;
    private javax.swing.JButton Agregar_Button;
    private javax.swing.JButton AnteriorButton;
    private java.awt.List MostrarContenido;
    private java.awt.List MostrarLista;
    private javax.swing.JButton SiguienteButton;
    private javax.swing.JButton VaciarButton;
    private javax.swing.JLabel cancionActual;
    private javax.swing.JComboBox<String> comboArt;
    private javax.swing.JButton generarArchivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
