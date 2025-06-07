package com.pablo.autogest.VIEW;

import com.pablo.autogest.DAO.ClienteDAO;
import com.pablo.autogest.DAO.OrdemServicoDAO;
import com.pablo.autogest.DAO.PecaDAO;
import com.pablo.autogest.DAO.RegistrosDAO;
import com.pablo.autogest.DTO.ClienteDTO;
import com.pablo.autogest.DTO.OrdemServicoDTO;
import com.pablo.autogest.DTO.PecaDTO;
import com.pablo.autogest.DTO.RegistrosDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class telaOrdemServico extends javax.swing.JFrame {

    public telaOrdemServico() {
        initComponents();
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PecaDAO pecaDAO = new PecaDAO();
        try {
            List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
            DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
            model.setRowCount(0);
            cmbClienteNome.addItem("Nenhum");
            cmbClienteID.addItem("---");
            cmbPecaNome.addItem("Nenhuma");
            cmbPecaID.addItem("---");
            for (OrdemServicoDTO os : listaDeOS) {
                try {
                    if (os.getPeca().getId() == -1) {
                        model.addRow(new Object[]{os.getId(), os.getCliente().getNome(), -1, os.getStatus(), 0, 0, os.getValorServico(), os.getDescricao()});
                    } else {
                        model.addRow(new Object[]{os.getId(), os.getCliente().getNome(), os.getPeca().getNome(), os.getStatus(), round(os.getQuantidade()), os.getValorPecas(), os.getValorServico(), os.getDescricao()});
                    }
                } catch (Exception e) {
                }
            }
            List<ClienteDTO> clientes = new ArrayList<>();
            clientes = clienteDAO.listarClientes();
            List<PecaDTO> pecas = new ArrayList<>();
            pecas = pecaDAO.listarPecas();
            int i = 1;
            for (ClienteDTO cliente : clientes) {
                cmbClienteNome.addItem(i + " - " + cliente.getNome());
                cmbClienteID.addItem(String.valueOf(cliente.getId()));
                i++;
            }
            i = 1;
            for (PecaDTO peca : pecas) {
                cmbPecaNome.addItem(i + " - " + peca.getNome());
                cmbPecaID.addItem(String.valueOf(peca.getId()));
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar as ordens de serviço [#1]: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Limparcampos() {
        cmbClienteNome.setSelectedIndex(0);
        cmbClienteID.setSelectedIndex(0);
        cmbPecaNome.setSelectedIndex(0);
        cmbPecaID.setSelectedIndex(0);
        cmbQuantidadePeca.setValue(0);
        cmbValorServico.setValue(0);
        txtDescricao.setText("");
        txtMessage.setText("");
    }

    private void Atualizarcampos() {
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PecaDAO pecaDAO = new PecaDAO();
        Limparcampos();
        try {
            List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
            DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
            model.setRowCount(0);
            for (OrdemServicoDTO os : listaDeOS) {
                try {
                    if (os.getPeca().getId() == -1) {
                        model.addRow(new Object[]{os.getId(), os.getCliente().getNome(), -1, os.getStatus(), 0, 0, os.getValorServico(), os.getDescricao()});
                    } else {
                        model.addRow(new Object[]{os.getId(), os.getCliente().getNome(), os.getPeca().getNome(), os.getStatus(), round(os.getQuantidade()), os.getValorPecas(), os.getValorServico(), os.getDescricao()});
                    }
                } catch (Exception e) {
                }
            }
            List<ClienteDTO> clientes = new ArrayList<>();
            clientes = clienteDAO.listarClientes();
            List<PecaDTO> pecas = new ArrayList<>();
            pecas = pecaDAO.listarPecas();
            cmbClienteNome.removeAllItems();
            cmbClienteID.removeAllItems();
            cmbPecaNome.removeAllItems();
            cmbPecaID.removeAllItems();
            cmbClienteNome.addItem("Nenhum");
            cmbClienteID.addItem("---");
            cmbPecaNome.addItem("Nenhuma");
            cmbPecaID.addItem("---");
            int i = 0;
            for (ClienteDTO cliente : clientes) {
                cmbClienteNome.addItem(i + 1 + " - " + cliente.getNome());
                cmbClienteID.addItem(String.valueOf(cliente.getId()));
                i++;
            }
            i = 0;
            for (PecaDTO peca : pecas) {
                cmbPecaNome.addItem(i + 1 + " - " + peca.getNome());
                cmbPecaID.addItem(String.valueOf(peca.getId()));
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar as ordens de serviço [#2]: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdemServico = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        cmbClienteNome = new javax.swing.JComboBox<>();
        cmbClienteID = new javax.swing.JComboBox<>();
        cmbPecaID = new javax.swing.JComboBox<>();
        cmbPecaNome = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        cmbValorServico = new javax.swing.JSpinner();
        cmbQuantidadePeca = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        checkProduto = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Ordem de Serviço");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Informações do Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Informações da Peça:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 200, 30));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, 110, 32));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 110, 32));

        btnConcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 110, 32));

        tblOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Peça", "Status", "Quantia de Peças", "Valor das Peças", "Valor do Serviço", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdemServico.setShowGrid(true);
        tblOrdemServico.getTableHeader().setReorderingAllowed(false);
        tblOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdemServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrdemServico);
        if (tblOrdemServico.getColumnModel().getColumnCount() > 0) {
            tblOrdemServico.getColumnModel().getColumn(0).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(1).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(2).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(3).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(4).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(5).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(6).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 940, 230));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Detalhes do Serviço:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 180, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descricao do Serviço:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, -1));

        txtMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 420, 40));

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, 110, 32));

        cmbClienteNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbClienteNome.setToolTipText("");
        cmbClienteNome.setName("Selecione um Cliente"); // NOI18N
        cmbClienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteNomeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbClienteNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 210, 30));

        cmbClienteID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbClienteID.setToolTipText("");
        cmbClienteID.setName("Selecione um Cliente"); // NOI18N
        cmbClienteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteIDActionPerformed(evt);
            }
        });
        getContentPane().add(cmbClienteID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 210, 30));

        cmbPecaID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPecaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPecaIDActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPecaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 210, 30));

        cmbPecaNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPecaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPecaNomeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPecaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 210, 30));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel8.setText("Nome");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel9.setText("ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jLabel10.setText("Nome");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 940, 60));

        jLabel11.setText("(R$)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 30, -1));

        jLabel12.setText("Quantia da Peça");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 90, 20));

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
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 110, 32));

        cmbValorServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbValorServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 210, 30));

        cmbQuantidadePeca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbQuantidadePeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 210, 30));

        jLabel13.setText("Valor do Serviço");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 100, -1));

        checkProduto.setSelected(true);
        checkProduto.setText("Venda de Produto");
        checkProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(checkProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        setSize(new java.awt.Dimension(1016, 708));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = tblOrdemServico.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar esta ordem de serviço?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String cliente = cmbClienteID.getSelectedItem().toString();
                    String peca = cmbPecaID.getSelectedItem().toString();
                    String valorServico = cmbValorServico.getValue().toString();
                    String quantidadePeca = cmbQuantidadePeca.getValue().toString();
                    String descricao = txtDescricao.getText();
                    if (cliente.isEmpty() || peca.isEmpty() || quantidadePeca.isEmpty() || valorServico.isEmpty() || descricao.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (quantidadePeca.length() > 11 || valorServico.length() > 20 || descricao.length() > 100) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int id = Integer.parseInt(tblOrdemServico.getValueAt(selectedRow, 0).toString());
                    OrdemServicoDAO osDAO = new OrdemServicoDAO();
                    OrdemServicoDTO os = osDAO.buscarOSPorId(id);
                    ClienteDAO clienteDAO = new ClienteDAO();
                    PecaDAO pecaDAO = new PecaDAO();
                    os.setCliente(clienteDAO.buscarClientePorId(Integer.parseInt(cliente)));
                    os.setPeca(pecaDAO.buscarPecaPorId(Integer.parseInt(peca)));
                    os.setValorServico(Double.parseDouble(valorServico));
                    os.setValorPecas(os.getPeca().getValor() * Double.parseDouble(quantidadePeca));
                    os.setQuantidade(Integer.parseInt(quantidadePeca));
                    os.setDescricao(descricao);
                    if (os.getCliente() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, o cliente selecionado não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    if (os.getPeca() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    osDAO.atualizarOS(os.getId(), os);
                    Limparcampos();
                    txtMessage.setText("Ordem de serviço atualizada com sucesso!");
                    List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
                    DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
                    model.setRowCount(0);
                    for (OrdemServicoDTO objOS : listaDeOS) {
                        try {
                            if (objOS.getPeca().getId() == -1) {
                                model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), -1, objOS.getStatus(), 0, 0, objOS.getValorServico(), objOS.getDescricao()});
                            } else {
                                model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), objOS.getPeca().getNome(), objOS.getStatus(), round(objOS.getQuantidade()), objOS.getValorPecas(), objOS.getValorServico(), objOS.getDescricao()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma ordem de serviço para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tblOrdemServico.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta ordem de serviço?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblOrdemServico.getValueAt(selectedRow, 0).toString());
                    OrdemServicoDAO osDAO = new OrdemServicoDAO();
                    OrdemServicoDTO os = osDAO.buscarOSPorId(id);
                    osDAO.excluirOS(os);
                    Limparcampos();
                    txtMessage.setText("Ordem de serviço excluida com sucesso!");
                    List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
                    DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
                    model.setRowCount(0);
                    for (OrdemServicoDTO objOS : listaDeOS) {
                        try {
                            if (objOS.getPeca().getId() == -1) {
                                model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), -1, objOS.getStatus(), 0, 0, objOS.getValorServico(), objOS.getDescricao()});
                            } else {
                                model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), objOS.getPeca().getNome(), objOS.getStatus(), round(objOS.getQuantidade()), objOS.getValorPecas(), objOS.getValorServico(), objOS.getDescricao()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Esta ordem de serviço não pode ser deletada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma ordem de serviço para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        int selectedRow = tblOrdemServico.getSelectedRow();
        if (selectedRow >= 0) {
            if ("Finalizada".equals(tblOrdemServico.getValueAt(selectedRow, 3).toString())) {
                JOptionPane.showMessageDialog(null, "Esta Ordem de Serviço já foi finalizada.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente concluir esta ordem de serviço?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblOrdemServico.getValueAt(selectedRow, 0).toString());
                    OrdemServicoDAO osDAO = new OrdemServicoDAO();
                    OrdemServicoDTO os = osDAO.buscarOSPorId(id);
                    RegistrosDAO registroDAO = new RegistrosDAO();
                    RegistrosDTO registro = new RegistrosDTO();
                    if (os.getPeca() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode concluir isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    os.setStatus("Finalizada");
                    osDAO.atualizarOS(os.getId(), os);
                    registro.setPeca(os.getPeca());
                    registro.setCliente(os.getCliente());
                    registro.setDescricao(os.getDescricao());
                    registro.setValor(os.getValorPecas() + os.getValorServico());
                    registroDAO.adicionarRegistro(true, registro);
                    Limparcampos();
                    txtMessage.setText("Ordem de serviço finalizada com sucesso!");
                    List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
                    DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
                    model.setRowCount(0);
                    for (OrdemServicoDTO objOS : listaDeOS) {
                        try {
                            if (objOS.getPeca().getId() == -1) {
                                model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), -1, objOS.getStatus(), 0, 0, objOS.getValorServico(), objOS.getDescricao()});
                            } else {
                                model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), objOS.getPeca().getNome(), objOS.getStatus(), round(objOS.getQuantidade()), objOS.getValorPecas(), objOS.getValorServico(), objOS.getDescricao()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao finalizar essa OS: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma ordem de serviço para concluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void tblOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdemServicoMouseClicked
        int selectedRow = tblOrdemServico.getSelectedRow();
        if (selectedRow >= 0) {
            String ID = tblOrdemServico.getValueAt(selectedRow, 0).toString();
            OrdemServicoDAO osDAO = new OrdemServicoDAO();
            OrdemServicoDTO os = osDAO.buscarOSPorId(Integer.parseInt(ID));
            if (os == null || os.getCliente() == null || os.getPeca() == null) {
                Atualizarcampos();
                return;
            }
            String quantidadePeca = tblOrdemServico.getValueAt(selectedRow, 4).toString();
            String valorServico = tblOrdemServico.getValueAt(selectedRow, 6).toString();
            String descricao = tblOrdemServico.getValueAt(selectedRow, 7).toString();
            cmbClienteID.setSelectedItem(String.valueOf(os.getCliente().getId()));
            cmbValorServico.setValue(Double.valueOf(valorServico));
            txtDescricao.setText(descricao);
            boolean check = os.getPeca().getId() != -1;
            if (!check) {
                checkProduto.setSelected(false);
                cmbPecaNome.setSelectedIndex(0);
                cmbPecaID.setSelectedIndex(0);
                cmbQuantidadePeca.setValue(0);
                cmbQuantidadePeca.setEnabled(false);
                cmbPecaNome.setEnabled(false);
                cmbPecaID.setEnabled(false);
            } else {
                checkProduto.setSelected(true);
                cmbQuantidadePeca.setEnabled(true);
                cmbPecaNome.setEnabled(true);
                cmbPecaID.setEnabled(true);
                cmbPecaID.setSelectedItem(String.valueOf(os.getPeca().getId()));
                cmbQuantidadePeca.setValue(Double.valueOf(quantidadePeca));
            }
        }
    }//GEN-LAST:event_tblOrdemServicoMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String cliente = cmbClienteID.getSelectedItem().toString();
        String peca = cmbPecaID.getSelectedItem().toString();
        String quantidadePeca = cmbQuantidadePeca.getValue().toString();
        String valorServico = cmbValorServico.getValue().toString();
        String descricao = txtDescricao.getText();
        if (cliente.isEmpty() || peca.isEmpty() || quantidadePeca.isEmpty() || valorServico.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantidadePeca.length() > 20 || valorServico.length() > 20 || descricao.length() > 100) {
            JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (checkProduto.isSelected()) {
            if (cmbPecaID.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para adicionar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (cmbClienteID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para adicionar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        OrdemServicoDTO os = new OrdemServicoDTO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PecaDAO pecaDAO = new PecaDAO();
        os.setCliente(clienteDAO.buscarClientePorId(Integer.parseInt(cliente)));
        if (checkProduto.isSelected()) {
            PecaDTO pecaDTO = pecaDAO.buscarPecaPorId(Integer.parseInt(peca));
            if (pecaDTO == null) {
                JOptionPane.showMessageDialog(null, "Você não pode abrir uma ordem de serviço desta peça, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                Atualizarcampos();
                return;
            }
            if (pecaDTO.getQuantidade() <= 0) {
                JOptionPane.showMessageDialog(null, "Você não pode abrir uma ordem de serviço desta peça, sem unidades no estoque", "Erro", JOptionPane.ERROR_MESSAGE);
                Atualizarcampos();
                return;
            } else if (Double.parseDouble(String.valueOf(pecaDTO.getQuantidade())) < Double.parseDouble(quantidadePeca) || Double.parseDouble(quantidadePeca) < 0) {
                JOptionPane.showMessageDialog(null, "A quantidade de peças que você selecionou não existe em nosso estoque", "Erro", JOptionPane.ERROR_MESSAGE);
                Atualizarcampos();
                return;
            }
            os.setPeca(pecaDTO);
            os.setValorPecas(os.getPeca().getValor() * Double.parseDouble(quantidadePeca));
            os.setQuantidade(Double.parseDouble(String.valueOf(quantidadePeca)));
        } else {
            PecaDTO pecaDTO = new PecaDTO();
            pecaDTO.setCodigo(0);
            pecaDTO.setDescricao("---");
            pecaDTO.setNome("---");
            pecaDTO.setQuantidade(0);
            pecaDTO.setValor(0);
            os.setPeca(pecaDTO);
            os.getPeca().setId(-1);
            os.setValorPecas(0);
            os.setQuantidade(0);
        }
        os.setStatus("Em Aberto");
        os.setValorServico(Double.parseDouble(valorServico));
        os.setDescricao(descricao);
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        if (os.getCliente() == null) {
            JOptionPane.showMessageDialog(null, "Você não pode editar isso, o cliente selecionado não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            Atualizarcampos();
            return;
        }
        osDAO.adicionarOS(checkProduto.isSelected(), os);
        Limparcampos();
        txtMessage.setText("Ordem de serviço criada com sucesso!");
        List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
        DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
        model.setRowCount(0);
        for (OrdemServicoDTO objOS : listaDeOS) {
            try {
                if (os.getCliente().getId() == objOS.getCliente().getId() && os.getPeca().getId() == objOS.getPeca().getId() && os.getStatus().equals(objOS.getStatus()) && os.getValorPecas() == objOS.getValorPecas() && os.getValorServico() == objOS.getValorServico() && os.getDescricao().equals(objOS.getDescricao()) && round(os.getQuantidade()) == round(objOS.getQuantidade())) {
                    pecaDAO.baixarEstoque(objOS, descricao);
                    break;
                }
            } catch (Exception e) {
            }
        }
        for (OrdemServicoDTO objOS : listaDeOS) {
            try {
                if (objOS.getPeca().getId() == -1) {
                    model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), -1, objOS.getStatus(), 0, 0, objOS.getValorServico(), objOS.getDescricao()});
                } else {
                    model.addRow(new Object[]{objOS.getId(), objOS.getCliente().getNome(), objOS.getPeca().getNome(), objOS.getStatus(), round(objOS.getQuantidade()), objOS.getValorPecas(), objOS.getValorServico(), objOS.getDescricao()});
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cmbClienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteNomeActionPerformed
        try {
            int index = cmbClienteNome.getSelectedIndex();
            cmbClienteID.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbClienteNomeActionPerformed

    private void cmbClienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteIDActionPerformed
        try {
            int index = cmbClienteID.getSelectedIndex();
            cmbClienteNome.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbClienteIDActionPerformed

    private void cmbPecaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPecaNomeActionPerformed
        try {
            int index = cmbPecaNome.getSelectedIndex();
            cmbPecaID.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbPecaNomeActionPerformed

    private void cmbPecaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPecaIDActionPerformed
        try {
            int index = cmbPecaID.getSelectedIndex();
            cmbPecaNome.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbPecaIDActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        Atualizarcampos();
        txtMessage.setText("Ordens de serviço atualizadas");
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void checkProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProdutoActionPerformed
        cmbQuantidadePeca.setEnabled(checkProduto.isSelected());
        cmbPecaNome.setEnabled(checkProduto.isSelected());
        cmbPecaID.setEnabled(checkProduto.isSelected());
    }//GEN-LAST:event_checkProdutoActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaOrdemServico tela = new telaOrdemServico();
                tela.setTitle("Ordem de Serviço");
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JCheckBox checkProduto;
    private javax.swing.JComboBox<String> cmbClienteID;
    private javax.swing.JComboBox<String> cmbClienteNome;
    private javax.swing.JComboBox<String> cmbPecaID;
    private javax.swing.JComboBox<String> cmbPecaNome;
    private javax.swing.JSpinner cmbQuantidadePeca;
    private javax.swing.JSpinner cmbValorServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOrdemServico;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtMessage;
    // End of variables declaration//GEN-END:variables
}
