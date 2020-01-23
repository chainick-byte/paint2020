/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import codigo.figuras.Circulo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author xp
 */
public class VentanaPaint extends javax.swing.JFrame {

    //acelera la lectura de una informacion de disco duro a la memoria
    BufferedImage buffer = null;
    //libreria de java que permite dibujar cuadrados y circulos, figuras convencionales

    Graphics2D bufferGraphics, jpanelGraphics = null;
    //creamos dos variables para ver el circulo relleno y no tanto

  
    Circulo miCirculo = null;

    /**
     * Creates new form VentanaPaint
     */
    public VentanaPaint() {

        initComponents();
        inicializaBuffers();
    }

    //enlaza variables buffers con jpanel del interfaz
    private void inicializaBuffers() {
        //creo una imagen del mismo ancho y alto que el jPanel
        //hay que castear lo , ya que son diferentes tipos de variables
        //variable que almacena la imagen , todo lo que dibujo se guarda en el buffer!!!!!
        buffer = (BufferedImage) jPanel1.createImage(jPanel1.getWidth(), jPanel1.getHeight());
        //creo una imagen modificable, bufferGraphics dibuja figuras rectangulares (en teoria 
        //todas las figuras y funciones del paint rectangulares se situan aqui)
        bufferGraphics = buffer.createGraphics();
        //inicializo el buufer para que se pinte en blanco entero ,tambien se puede utilizar pa borrar todo!!!
        bufferGraphics.setColor(Color.white);
        //el rectangulo
        bufferGraphics.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        //enlazamos el jpanel1 con el jPanelGaphics, cada vez que queremos escribir algo en jPanel1 , va a salir en 
        //jpanelGraphics
        jpanelGraphics = (Graphics2D) jPanel1.getGraphics();
    }

    //hace falta enlazar el componente jpanel con la zona de memoria donde esta guardado el rectangulo blanco
    //sobreescribimos un metodo ;significa que algo que estan haciendo el codigo propio de java ,no nos vale y algo extenderlo
    //en nuestro caso solo queremos extender un metodo y no una clase entera 
    //modificamos el metodo paint de la libreria jFrame
    @Override
    public void paint(Graphics g) {
        //super llama a jFrame donde esta el paint original y lo haga todo lo que estaba haciendo antes pero ademas algo mas
        super.paint(g);
        //aqui añadimos ya nuestra funciones!!!!
        //pinto el buffer sobre el jPANELel1
        //drawImage sirve para almacenar la imagen en la memoria , si en vez de null ponemos otra cosa aparace la imagen de la memoria
        jpanelGraphics.drawImage(buffer, 0, 0, null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colores1 = new codigo.Colores();
        jPanel1 = new javax.swing.JPanel();
        colores2 = new codigo.Colores();
        herramientas1 = new codigo.Herramientas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(herramientas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(colores2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(herramientas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colores2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // aqui dibujamos un punto pa eso necesitamos coordenadas y color 
        //coordinadas proporciona evt
        //aqui el colo hay que pasar con un metodo y podremos dibujar de diferentes colores
        switch (herramientas1.formElegida) {
            case 0:
                bufferGraphics.setColor(colores2.colorSeleccionado);
                bufferGraphics.fillOval(evt.getX(), evt.getY(), 5, 5);
                break;
            case 1: 
                miCirculo.dibujaTe(bufferGraphics, evt.getX());break;
                
          
        }
        repaint(0, 0, 1, 1);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       switch (herramientas1.formElegida) {
            case 0:
                break;
            case 1:
                miCirculo=new Circulo(evt.getX(), evt.getY(), 1, colores2.colorSeleccionado, false);
                miCirculo.dibujaTe(bufferGraphics, evt.getX());
                break;
          
        }
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPaint().setVisible(true);
            }
        });
    }
    // 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private codigo.Colores colores1;
    private codigo.Colores colores2;
    private codigo.Herramientas herramientas1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
