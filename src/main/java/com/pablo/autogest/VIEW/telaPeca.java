package com.pablo.autogest.VIEW;

import com.pablo.autogest.DAO.PecaDAO;
import com.pablo.autogest.DTO.PecaDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class telaPeca extends javax.swing.JFrame {

    public telaPeca() {
        initComponents();
        PecaDAO pecaDao = new PecaDAO();
        try {
            listarPecas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar peças: " + e.getMessage());
        }
    }

    private void Limparcampos() {
        txtNome.setText("");
        txtDescricao.setText("");
        txtCodigo.setText("");
        cmbValor.setValue(0);
        txtMessage.setText("");
    }

    private void listarPecas() {
        PecaDAO pecaDAO = new PecaDAO();
        List<PecaDTO> pecas = pecaDAO.listarPecas();
        DefaultTableModel model = (DefaultTableModel) tblPecas.getModel();
        model.setRowCount(0);
        for (PecaDTO peca : pecas) {
            model.addRow(new Object[]{peca.getId(), peca.getNome(), peca.getDescricao(), peca.getQuantidade(), peca.getValor(), peca.getCodigo()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cmbValor = new javax.swing.JSpinner();
        txtCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnSolicitarBaixa = new javax.swing.JButton();

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jTable1.setEnabled(false);
        jTable1.setSelectionForeground(new java.awt.Color(255, 0, 51));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque de Peças");
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 748, 858));
        setMaximumSize(new java.awt.Dimension(748, 858));
        setMinimumSize(new java.awt.Dimension(748, 858));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(748, 858));
        setResizable(false);
        setSize(new java.awt.Dimension(748, 858));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Estoque de Peças");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 400, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Produto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, 30));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 330, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Descrição:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 100, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Valor da unidade");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 90, 30));

        btnConsultar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConsultar.setText("Atualizar");
        btnConsultar.setActionCommand("");
        btnConsultar.setAlignmentX(0.5F);
        btnConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, 140, 32));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setActionCommand("");
        btnEditar.setAlignmentX(0.5F);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 710, 140, 32));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("");
        btnExcluir.setAlignmentX(0.5F);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 710, 140, 32));

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setActionCommand("");
        btnCadastrar.setAlignmentX(0.5F);
        btnCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 710, 140, 32));

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Quantidade", "Valor da unidade", "Código"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPecas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblPecas.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        tblPecas.setDragEnabled(false);
        tblPecas.setEditingColumn(0);
        tblPecas.setEditingRow(0);
        tblPecas.setFocusable(false);
        tblPecas.setShowGrid(true);
        tblPecas.setSurrendersFocusOnKeystroke(true);
        tblPecas.getTableHeader().setReorderingAllowed(false);
        tblPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPecasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPecas);
        if (tblPecas.getColumnModel().getColumnCount() > 0) {
            tblPecas.getColumnModel().getColumn(0).setResizable(false);
            tblPecas.getColumnModel().getColumn(1).setResizable(false);
            tblPecas.getColumnModel().getColumn(2).setResizable(false);
            tblPecas.getColumnModel().getColumn(3).setResizable(false);
            tblPecas.getColumnModel().getColumn(4).setResizable(false);
            tblPecas.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 740, 250));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Código");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 40, 30));

        txtMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, 340, 40));

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        txtDescricao.setSelectionColor(new java.awt.Color(255, 51, 0));
        jScrollPane3.setViewportView(txtDescricao);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 740, 80));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Nome");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 50, 30));

        cmbValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 280, 30));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 330, 30));

        jLabel11.setText("(R$)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 30, -1));

        btnSolicitarBaixa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSolicitarBaixa.setText("Solicitar Baixa");
        btnSolicitarBaixa.setActionCommand("");
        btnSolicitarBaixa.setAlignmentX(0.5F);
        btnSolicitarBaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSolicitarBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarBaixaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSolicitarBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 710, 140, 30));

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(811, 842));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            listarPecas();
            txtMessage.setText("Peças atualizadas");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar peças: " + e.getMessage());
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome = txtNome.getText();
        String descricao = txtDescricao.getText();
        String valor = cmbValor.getValue().toString();
        String codigo = txtCodigo.getText();
        if (nome.isEmpty() || descricao.isEmpty() || valor.isEmpty() || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nome.length() > 50 || descricao.length() > 100 || valor.length() > 20 || codigo.length() > 10) {
            JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo ", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PecaDTO objpeca = new PecaDTO();
        objpeca.setNome(nome);
        objpeca.setDescricao(descricao);
        objpeca.setQuantidade(0);
        try {
            objpeca.setValor(Double.parseDouble(valor));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            objpeca.setCodigo(Long.parseLong(codigo));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PecaDAO pecaDao = new PecaDAO();
        pecaDao.adicionarPeca(objpeca);
        Limparcampos();
        txtMessage.setText("Peça cadastrada com sucesso!");
        List<PecaDTO> listaDePeca = pecaDao.listarPecas();
        DefaultTableModel model = (DefaultTableModel) tblPecas.getModel();
        model.setRowCount(0);
        for (PecaDTO peca : listaDePeca) {
            model.addRow(new Object[]{peca.getId(), peca.getNome(), peca.getDescricao(), peca.getQuantidade(), peca.getValor(), peca.getCodigo()});
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblPecas.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar esta peça?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String nome = txtNome.getText();
                    String descricao = txtDescricao.getText();
                    String valor = cmbValor.getValue().toString();
                    String codigo = txtCodigo.getText();
                    if (nome.isEmpty() || descricao.isEmpty() || valor.isEmpty() || codigo.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (nome.length() > 50 || descricao.length() > 100 || valor.length() > 20 || codigo.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo ", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int id = Integer.parseInt(tblPecas.getValueAt(selectedRow, 0).toString());
                    PecaDAO pecaDAO = new PecaDAO();
                    PecaDTO objpeca = pecaDAO.buscarPecaPorId(id);
                    objpeca.setNome(nome);
                    objpeca.setDescricao(descricao);
                    objpeca.setValor(Double.parseDouble(valor));
                    long codigoLong = Long.parseLong(codigo);
                    try {
                        objpeca.setCodigo(codigoLong);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Código inválido. ", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (objpeca == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    pecaDAO.atualizarPeca(objpeca.getId(), objpeca);
                    Limparcampos();
                    txtMessage.setText("Peça atualizada com sucesso!");
                    try {
                        listarPecas();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar a peça.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma peça para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPecasMouseClicked
        int selectedRow = tblPecas.getSelectedRow();
        if (selectedRow >= 0) {
            String nome = tblPecas.getValueAt(selectedRow, 1).toString();
            String descricao = tblPecas.getValueAt(selectedRow, 2).toString();
            String valor = tblPecas.getValueAt(selectedRow, 4).toString();
            String codigo = tblPecas.getValueAt(selectedRow, 5).toString();
            txtNome.setText(nome);
            txtDescricao.setText(descricao);
            cmbValor.setValue(Double.valueOf(valor));
            txtCodigo.setText(codigo);
            txtMessage.setText("");
        }
    }//GEN-LAST:event_tblPecasMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tblPecas.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta peça?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblPecas.getValueAt(selectedRow, 0).toString());
                    PecaDAO pecaDAO = new PecaDAO();
                    PecaDTO objpeca = pecaDAO.buscarPecaPorId(id);
                    pecaDAO.excluirPeca(objpeca.getId());
                    Limparcampos();
                    txtMessage.setText("Peça excluida com sucesso!");
                    listarPecas();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Esta peça não pode ser deletada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma peça para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnSolicitarBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarBaixaActionPerformed
        int selectedRow = tblPecas.getSelectedRow();
        if (selectedRow >= 0) {
            int id = Integer.parseInt(tblPecas.getValueAt(selectedRow, 0).toString());
            String quantidadeStr = javax.swing.JOptionPane.showInputDialog("Informe a quantidade para baixar do estoque:");
            PecaDAO pecaDAO = new PecaDAO();
            PecaDTO pecaDTO = pecaDAO.buscarPecaPorId(id);
            if (pecaDTO.getQuantidade() <= 0) {
                JOptionPane.showMessageDialog(null, "Você não pode abrir uma ordem de serviço desta peça, sem unidades no estoque", "Erro", JOptionPane.ERROR_MESSAGE);
                Limparcampos();
                listarPecas();
                return;
            } else if (Double.parseDouble(String.valueOf(pecaDTO.getQuantidade())) < Double.parseDouble(quantidadeStr) || Double.parseDouble(quantidadeStr) < 0) {
                JOptionPane.showMessageDialog(null, "A quantidade de peças que você selecionou não existe em nosso estoque", "Erro", JOptionPane.ERROR_MESSAGE);
                Limparcampos();
                listarPecas();
                return;
            }
            String motivo = javax.swing.JOptionPane.showInputDialog("Informe o motivo para a baixa do estoque:");
            try {
                int quantidade = Integer.parseInt(quantidadeStr);
                pecaDAO.baixarEstoque(id, quantidade, motivo);
                txtMessage.setText("Baixa de estoque realizada com sucesso!");
                listarPecas();
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione uma peça na tabela para baixar o estoque.");
        }
    }//GEN-LAST:event_btnSolicitarBaixaActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaPeca tela = new telaPeca();
                tela.setTitle("Peças");
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSolicitarBaixa;
    private javax.swing.JSpinner cmbValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblPecas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtMessage;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
