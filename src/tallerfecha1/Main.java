/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerfecha1;

import java.awt.BorderLayout;

/**
 *
 * @author johan
 */
public class Main extends javax.swing.JFrame {
     public static void main(String[] args) {
        // TODO code application logic here
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    /**
     * Creates new form main
     */
    public Main() {
        initComponents();
         configComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        agregaru = new javax.swing.JMenu();
        agregare = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));

        panelPrincipal.setBackground(new java.awt.Color(255, 204, 153));
        panelPrincipal.setForeground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("BIENVENIDOS A ");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("EVENTOS");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("CULTURALES UDEC");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel3)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(182, 182, 182))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jMenuBar2.setBackground(new java.awt.Color(102, 0, 0));
        jMenuBar2.setForeground(new java.awt.Color(255, 255, 255));

        agregaru.setForeground(new java.awt.Color(255, 255, 255));
        agregaru.setText("AGREGAR USUARIOS");
        agregaru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregaruMouseClicked(evt);
            }
        });
        jMenuBar2.add(agregaru);

        agregare.setForeground(new java.awt.Color(255, 255, 255));
        agregare.setText("AGREGAR EVENTOS");
        agregare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregareMouseClicked(evt);
            }
        });
        jMenuBar2.add(agregare);

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("MOSTRAR");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregaruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregaruMouseClicked
        System.out.println("AUI ESTOY");
        Panel1 panel1=new Panel1();
        panel1.setSize(400, 300);
        panel1.setLocation(5, 5);
        
        panelPrincipal.removeAll();
        panelPrincipal.add(panel1,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }//GEN-LAST:event_agregaruMouseClicked

    private void agregareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregareMouseClicked
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        panelPrincipal.removeAll();
        System.out.println("AUI ESTOY");
        Panel2 panel2=new Panel2();
        panel2.setSize(500, 380);
        panel2.setLocation(5, 5);
        
      
        panelPrincipal.add(panel2,BorderLayout.CENTER);
     
    }//GEN-LAST:event_agregareMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
System.out.println("AUI ESTOY");
        Mostrar panel3=new Mostrar();
        panel3.setSize(500, 300);
        panel3.setLocation(5, 5);
        
        panelPrincipal.removeAll();
        panelPrincipal.add(panel3,BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu agregare;
    private javax.swing.JMenu agregaru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private void configComponents() {
       
    }
}
