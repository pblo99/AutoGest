package com.pablo.autogest.VIEW;

import com.pablo.autogest.DAO.RegistrosDAO;
import com.pablo.autogest.DTO.RegistrosDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class telaFaturamento extends javax.swing.JFrame {

    public telaFaturamento() {
        initComponents();
        Atualizarcampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGastos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFaturamentos = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        txtMessage = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1000, 700));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Faturamentos e Gastos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Gastos (Pedidos de Compras):");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 260, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Faturamentos (Serviços):");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 220, 30));

        tblGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Empresa", "Peca", "Quantia", "Valor Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGastos.setShowGrid(true);
        tblGastos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblGastos);
        if (tblGastos.getColumnModel().getColumnCount() > 0) {
            tblGastos.getColumnModel().getColumn(0).setResizable(false);
            tblGastos.getColumnModel().getColumn(1).setResizable(false);
            tblGastos.getColumnModel().getColumn(2).setResizable(false);
            tblGastos.getColumnModel().getColumn(3).setResizable(false);
            tblGastos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 940, 220));

        tblFaturamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Peca", "Descrição", "Valor Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFaturamentos.setShowGrid(true);
        tblFaturamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblFaturamentos);
        if (tblFaturamentos.getColumnModel().getColumnCount() > 0) {
            tblFaturamentos.getColumnModel().getColumn(0).setResizable(false);
            tblFaturamentos.getColumnModel().getColumn(1).setResizable(false);
            tblFaturamentos.getColumnModel().getColumn(2).setResizable(false);
            tblFaturamentos.getColumnModel().getColumn(3).setResizable(false);
            tblFaturamentos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 940, 220));

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setMaximumSize(new java.awt.Dimension(105, 32));
        btnAtualizar.setMinimumSize(new java.awt.Dimension(105, 32));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(105, 32));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 610, 110, 32));

        txtMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 420, 40));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setMaximumSize(new java.awt.Dimension(105, 32));
        btnExcluir.setMinimumSize(new java.awt.Dimension(105, 32));
        btnExcluir.setPreferredSize(new java.awt.Dimension(105, 32));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 610, 110, 32));

        setSize(new java.awt.Dimension(1000, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        Atualizarcampos();
        txtMessage.setText("Ordens de serviço atualizadas");
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow1 = tblGastos.getSelectedRow();
        int selectedRow2 = tblFaturamentos.getSelectedRow();
        if (selectedRow1 >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta ordem de serviço?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblGastos.getValueAt(selectedRow1, 0).toString());
                    RegistrosDAO registroDAO = new RegistrosDAO();
                    RegistrosDTO registro = registroDAO.buscarRegistroPorId(id);
                    registroDAO.excluirRegistro(registro);
                    Limparcampos();
                    Atualizarcampos();
                    txtMessage.setText("Registro de gasto excluido com sucesso!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Este registro não pode ser deletado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (selectedRow2 >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta ordem de serviço?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblFaturamentos.getValueAt(selectedRow2, 0).toString());
                    RegistrosDAO registroDAO = new RegistrosDAO();
                    RegistrosDTO registro = registroDAO.buscarRegistroPorId(id);
                    registroDAO.excluirRegistro(registro);
                    Limparcampos();
                    Atualizarcampos();
                    txtMessage.setText("Registro de faturamento excluido com sucesso!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Este registro não pode ser deletado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um registro para excluir", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void Limparcampos() {
        txtMessage.setText("");
    }

    private void Atualizarcampos() {
        RegistrosDAO registrosDAO = new RegistrosDAO();
        Limparcampos();
        try {
            List<RegistrosDTO> listaDeRegistros = registrosDAO.listarRegistros();
            DefaultTableModel faturamentos = (DefaultTableModel) tblFaturamentos.getModel();
            faturamentos.setRowCount(0);
            DefaultTableModel gastos = (DefaultTableModel) tblGastos.getModel();
            gastos.setRowCount(0);
            for (RegistrosDTO registro : listaDeRegistros) {
                try {
                    if (registro.getCliente().getId() == -1) {
                        gastos.addRow(new Object[]{registro.getId(), registro.getEmpresa().getNome(), registro.getPeca().getNome(), registro.getQuantidade(), registro.getValor()});
                    } else {
                        faturamentos.addRow(new Object[]{registro.getId(), registro.getCliente().getNome(), registro.getPeca().getNome(), registro.getDescricao(), registro.getValor()});
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os registros [#2]: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaFaturamento tela = new telaFaturamento();
                tela.setTitle("Faturamentos");
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblFaturamentos;
    private javax.swing.JTable tblGastos;
    private javax.swing.JLabel txtMessage;
    // End of variables declaration//GEN-END:variables
}
