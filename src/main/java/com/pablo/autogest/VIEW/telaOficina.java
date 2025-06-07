package com.pablo.autogest.VIEW;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

public class telaOficina extends javax.swing.JFrame {

    public telaOficina() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPedidoCompras = new javax.swing.JButton();
        btnEstoquePecas = new javax.swing.JButton();
        btnFaturamentos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JButton();
        btnOrdemServico = new javax.swing.JButton();
        btnEmpresas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oficina");
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 597, 333));
        setMaximumSize(new java.awt.Dimension(597, 333));
        setMinimumSize(new java.awt.Dimension(597, 333));
        setPreferredSize(new java.awt.Dimension(597, 333));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPedidoCompras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPedidoCompras.setText("Pedido de Compras");
        btnPedidoCompras.setMaximumSize(new java.awt.Dimension(180, 32));
        btnPedidoCompras.setMinimumSize(new java.awt.Dimension(180, 32));
        btnPedidoCompras.setPreferredSize(new java.awt.Dimension(180, 32));
        btnPedidoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoComprasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedidoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 240, -1));

        btnEstoquePecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEstoquePecas.setText("Estoque de Peças");
        btnEstoquePecas.setMaximumSize(new java.awt.Dimension(180, 32));
        btnEstoquePecas.setMinimumSize(new java.awt.Dimension(180, 32));
        btnEstoquePecas.setPreferredSize(new java.awt.Dimension(180, 32));
        btnEstoquePecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoquePecasActionPerformed(evt);
            }
        });
        getContentPane().add(btnEstoquePecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 240, -1));

        btnFaturamentos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFaturamentos.setText("Faturamentos e Gastos");
        btnFaturamentos.setMaximumSize(new java.awt.Dimension(180, 32));
        btnFaturamentos.setMinimumSize(new java.awt.Dimension(180, 32));
        btnFaturamentos.setPreferredSize(new java.awt.Dimension(180, 32));
        btnFaturamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturamentosActionPerformed(evt);
            }
        });
        getContentPane().add(btnFaturamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 240, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento Oficina");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setMaximumSize(new java.awt.Dimension(180, 32));
        btnClientes.setMinimumSize(new java.awt.Dimension(180, 32));
        btnClientes.setPreferredSize(new java.awt.Dimension(180, 32));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, -1));

        btnOrdemServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOrdemServico.setText("Ordem de Serviço");
        btnOrdemServico.setMaximumSize(new java.awt.Dimension(180, 32));
        btnOrdemServico.setMinimumSize(new java.awt.Dimension(180, 32));
        btnOrdemServico.setPreferredSize(new java.awt.Dimension(180, 32));
        btnOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdemServicoActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrdemServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 240, -1));

        btnEmpresas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEmpresas.setText("Empresas");
        btnEmpresas.setMaximumSize(new java.awt.Dimension(180, 32));
        btnEmpresas.setMinimumSize(new java.awt.Dimension(180, 32));
        btnEmpresas.setPreferredSize(new java.awt.Dimension(180, 32));
        btnEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresasActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 240, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Registros:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 190, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Cadastros:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 190, -1));

        setSize(new java.awt.Dimension(597, 333));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoComprasActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaPedidoCompras tela = new telaPedidoCompras();
                tela.setTitle("Pedido de Compras");
                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnPedidoComprasActionPerformed

    private void btnEstoquePecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoquePecasActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaPeca tela = new telaPeca();
                tela.setTitle("Peças");
                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnEstoquePecasActionPerformed

    private void btnFaturamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturamentosActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaFaturamento tela = new telaFaturamento();
                tela.setTitle("Registro de Faturamentos e Gastos");
                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnFaturamentosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaCliente tela = new telaCliente();
                tela.setTitle("Clientes");
                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdemServicoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaOrdemServico tela = new telaOrdemServico();
                tela.setTitle("Ordem de Serviço");
                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnOrdemServicoActionPerformed

    private void btnEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresasActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaEmpresa tela = new telaEmpresa();
                tela.setTitle("Empresas");
                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnEmpresasActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaOficina tela = new telaOficina();
                tela.setTitle("Oficina");
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpresas;
    private javax.swing.JButton btnEstoquePecas;
    private javax.swing.JButton btnFaturamentos;
    private javax.swing.JButton btnOrdemServico;
    private javax.swing.JButton btnPedidoCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
