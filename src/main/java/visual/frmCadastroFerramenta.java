
package visual;
import model.Ferramenta;
public class frmCadastroFerramenta extends javax.swing.JFrame {

  
    public frmCadastroFerramenta() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFFerramenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFCusto = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCadastrar);
        JBCadastrar.setBounds(30, 70, 100, 23);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Cadastro Ferramenta");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, -10, 330, 80);

        jLabel2.setText("Ferramenta");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 140, 16);
        getContentPane().add(JTFFerramenta);
        JTFFerramenta.setBounds(30, 140, 530, 22);

        jLabel4.setText("Marca");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 180, 37, 16);
        getContentPane().add(JTFMarca);
        JTFMarca.setBounds(30, 200, 530, 22);

        jLabel5.setText("Custo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 240, 31, 16);
        getContentPane().add(JTFCusto);
        JTFCusto.setBounds(30, 260, 530, 22);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(30, 310, 76, 23);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/cdferramenta.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -40, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
       Ferramenta novaFerramenta = new Ferramenta ();
       
       novaFerramenta.setNome(JTFFerramenta.getText());
       novaFerramenta.setMarca(JTFMarca.getText());
       novaFerramenta.setCusto(Double.parseDouble(JTFCusto.getText()));
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        //Libera todos os recurso da interface gráfica
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

  
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
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadastroFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    private static class cadastrar {

        public cadastrar() {
        }
    }
}
