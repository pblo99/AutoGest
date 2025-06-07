package com.pablo.autogest.VIEW;

import com.pablo.autogest.DAO.EmpresaDAO;
import com.pablo.autogest.DTO.EmpresaDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class telaEmpresa extends javax.swing.JFrame {

    public telaEmpresa() {
        initComponents();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        try {
            List<EmpresaDTO> listaDeEmpresas = empresaDAO.listarEmpresas();
            DefaultTableModel model = (DefaultTableModel) tblEmpresas.getModel();
            model.setRowCount(0);
            for (EmpresaDTO empresa : listaDeEmpresas) {
                model.addRow(new Object[]{empresa.getId(), empresa.getNome(), empresa.getEndereco(), empresa.getTelefone()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar empresas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Limparcampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtMessage.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpresas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEndereco = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(622, 708));
        setMinimumSize(new java.awt.Dimension(622, 708));
        setPreferredSize(new java.awt.Dimension(622, 708));
        setResizable(false);
        setSize(new java.awt.Dimension(622, 708));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Empresa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 490, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, -1, -1));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, -1, -1));

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, -1, -1));

        tblEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tblEmpresas.setShowGrid(true);
        tblEmpresas.getTableHeader().setReorderingAllowed(false);
        tblEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpresas);
        if (tblEmpresas.getColumnModel().getColumnCount() > 0) {
            tblEmpresas.getColumnModel().getColumn(0).setResizable(false);
            tblEmpresas.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblEmpresas.getColumnModel().getColumn(1).setResizable(false);
            tblEmpresas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblEmpresas.getColumnModel().getColumn(2).setResizable(false);
            tblEmpresas.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblEmpresas.getColumnModel().getColumn(3).setResizable(false);
            tblEmpresas.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 520, 240));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Telefone:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Endereço:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 30));

        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 300, 30));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 300, 30));

        txtEndereco.setColumns(20);
        txtEndereco.setRows(5);
        jScrollPane2.setViewportView(txtEndereco);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 300, 70));

        txtMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 450, 40));

        setSize(new java.awt.Dimension(596, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpresasMouseClicked
        int selectedRow = tblEmpresas.getSelectedRow();
        if (selectedRow >= 0) {
            String nome = tblEmpresas.getValueAt(selectedRow, 1).toString();
            String endereco = tblEmpresas.getValueAt(selectedRow, 2).toString();
            String telefone = tblEmpresas.getValueAt(selectedRow, 3).toString();
            txtNome.setText(nome);
            txtEndereco.setText(endereco);
            txtTelefone.setText(telefone);
            txtMessage.setText("");
        }
    }//GEN-LAST:event_tblEmpresasMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String nome = txtNome.getText().trim();
        String endereco = txtEndereco.getText().trim();
        String telefone = txtTelefone.getText().trim();
        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nome.length() > 50 || endereco.length() > 100 || telefone.length() > 50) {
            JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setNome(nome);
        empresaDTO.setEndereco(endereco);
        empresaDTO.setTelefone(telefone);
        try {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.adicionarEmpresa(empresaDTO);
            Limparcampos();
            txtMessage.setText("Empresa cadastrada com sucesso!");
            List<EmpresaDTO> listaDeEmpresas = empresaDAO.listarEmpresas();
            DefaultTableModel model = (DefaultTableModel) tblEmpresas.getModel();
            model.setRowCount(0);
            for (EmpresaDTO empresa : listaDeEmpresas) {
                model.addRow(new Object[]{empresa.getId(), empresa.getNome(), empresa.getEndereco(), empresa.getTelefone()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tblEmpresas.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta empresa?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblEmpresas.getValueAt(selectedRow, 0).toString());
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    EmpresaDTO empresaDTO = empresaDAO.buscarEmpresaPorId(id);
                    empresaDAO.excluirEmpresa(empresaDTO.getId());
                    Limparcampos();
                    txtMessage.setText("Empresa excluida com sucesso!");
                    List<EmpresaDTO> listaDeEmpresas = empresaDAO.listarEmpresas();
                    DefaultTableModel model = (DefaultTableModel) tblEmpresas.getModel();
                    model.setRowCount(0);
                    for (EmpresaDTO empresa : listaDeEmpresas) {
                        model.addRow(new Object[]{empresa.getId(), empresa.getNome(), empresa.getEndereco(), empresa.getTelefone()});
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Esta empresa não pode ser deletada", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(telaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma empresa para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblEmpresas.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar esta empresa?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String nome = txtNome.getText();
                    String endereco = txtEndereco.getText();
                    String telefone = txtTelefone.getText();
                    if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (nome.length() > 50 || endereco.length() > 100 || telefone.length() > 50) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int id = Integer.parseInt(tblEmpresas.getValueAt(selectedRow, 0).toString());
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    EmpresaDTO empresaDTO = empresaDAO.buscarEmpresaPorId(id);
                    empresaDTO.setNome(nome);
                    empresaDTO.setEndereco(endereco);
                    empresaDTO.setTelefone(telefone);
                    if (empresaDTO == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a empresa selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    empresaDAO.atualizarEmpresa(empresaDTO.getId(), empresaDTO);
                    Limparcampos();
                    txtMessage.setText("Empresa atualizada com sucesso!");
                    List<EmpresaDTO> listaDeEmpresas = empresaDAO.listarEmpresas();
                    DefaultTableModel model = (DefaultTableModel) tblEmpresas.getModel();
                    model.setRowCount(0);
                    for (EmpresaDTO empresa : listaDeEmpresas) {
                        model.addRow(new Object[]{empresa.getId(), empresa.getNome(), empresa.getEndereco(), empresa.getTelefone()});
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar a empresa.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma empresa para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaEmpresa tela = new telaEmpresa();
                tela.setTitle("Empresas");
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmpresas;
    private javax.swing.JTextArea txtEndereco;
    private javax.swing.JLabel txtMessage;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
