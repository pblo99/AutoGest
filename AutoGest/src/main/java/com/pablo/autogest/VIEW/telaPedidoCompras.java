package com.pablo.autogest.VIEW;

import com.pablo.autogest.DAO.EmpresaDAO;
import com.pablo.autogest.DAO.PecaDAO;
import com.pablo.autogest.DAO.PedidoComprasDAO;
import com.pablo.autogest.DAO.RegistrosDAO;
import com.pablo.autogest.DTO.EmpresaDTO;
import com.pablo.autogest.DTO.PecaDTO;
import com.pablo.autogest.DTO.PedidoComprasDTO;
import com.pablo.autogest.DTO.RegistrosDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class telaPedidoCompras extends javax.swing.JFrame {

    public telaPedidoCompras() {
        initComponents();
        PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        PecaDAO pecaDAO = new PecaDAO();
        try {
            List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
            cmbEmpresaNome.addItem("Nenhuma");
            cmbEmpresaID.addItem("---");
            cmbPecaNome.addItem("Nenhuma");
            cmbPecaID.addItem("---");
            DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
            DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
            pedidosFinalizados.setRowCount(0);
            pedidosPendentes.setRowCount(0);
            for (PedidoComprasDTO objPedido : listaPedidos) {
                try {
                    if ("Finalizado".equals(objPedido.getStatus())) {
                        pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                    } else {
                        pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                    }
                } catch (Exception e) {
                }
            }
            List<EmpresaDTO> empresas = new ArrayList<>();
            empresas = empresaDAO.listarEmpresas();
            List<PecaDTO> pecas = new ArrayList<>();
            pecas = pecaDAO.listarPecas();
            int i = 1;
            for (EmpresaDTO empresa : empresas) {
                cmbEmpresaNome.addItem(i + " - " + empresa.getNome());
                cmbEmpresaID.addItem(String.valueOf(empresa.getId()));
                i++;
            }
            i = 1;
            for (PecaDTO peca : pecas) {
                cmbPecaNome.addItem(i + " - " + peca.getNome());
                cmbPecaID.addItem(String.valueOf(peca.getId()));
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar os pedidos de compra [#1]: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Limparcampos() {
        cmbEmpresaNome.setSelectedIndex(0);
        cmbEmpresaID.setSelectedIndex(0);
        cmbPecaNome.setSelectedIndex(0);
        cmbPecaID.setSelectedIndex(0);
        cmbQuantidadePeca.setValue(0);
        txtMessage.setText("");
    }

    private void Atualizarcampos() {
        PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        PecaDAO pecaDAO = new PecaDAO();
        try {
            List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
            DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
            DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
            pedidosFinalizados.setRowCount(0);
            pedidosPendentes.setRowCount(0);
            for (PedidoComprasDTO objPedido : listaPedidos) {
                try {
                    if ("Finalizado".equals(objPedido.getStatus())) {
                        pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                    } else {
                        pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                    }
                } catch (Exception e) {
                }
            }
            List<EmpresaDTO> empresas = new ArrayList<>();
            empresas = empresaDAO.listarEmpresas();
            List<PecaDTO> pecas = new ArrayList<>();
            pecas = pecaDAO.listarPecas();
            cmbEmpresaNome.removeAllItems();
            cmbEmpresaID.removeAllItems();
            cmbPecaNome.removeAllItems();
            cmbPecaID.removeAllItems();
            cmbEmpresaNome.addItem("Nenhuma");
            cmbEmpresaID.addItem("---");
            cmbPecaNome.addItem("Nenhuma");
            cmbPecaID.addItem("---");
            int i = 1;
            for (EmpresaDTO empresa : empresas) {
                cmbEmpresaNome.addItem(i + " - " + empresa.getNome());
                cmbEmpresaID.addItem(String.valueOf(empresa.getId()));
                i++;
            }
            i = 1;
            for (PecaDTO peca : pecas) {
                cmbPecaNome.addItem(i + " - " + peca.getNome());
                cmbPecaID.addItem(String.valueOf(peca.getId()));
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os pedidos de compra [#2]: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        jLabel6 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        cmbEmpresaNome = new javax.swing.JComboBox<>();
        cmbEmpresaID = new javax.swing.JComboBox<>();
        cmbPecaID = new javax.swing.JComboBox<>();
        cmbPecaNome = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        cmbQuantidadePeca = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidosPendentes = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPedidosFinalizados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbValor = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Pedido de Compras");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Pendentes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 220, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Informações da Peça:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 200, 30));

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Detalhes do Pedido:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 180, 30));

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

        cmbEmpresaNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbEmpresaNome.setToolTipText("");
        cmbEmpresaNome.setName("Selecione um Cliente"); // NOI18N
        cmbEmpresaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpresaNomeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEmpresaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 210, 30));

        cmbEmpresaID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbEmpresaID.setToolTipText("");
        cmbEmpresaID.setName("Selecione um Cliente"); // NOI18N
        cmbEmpresaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpresaIDActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEmpresaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 210, 30));

        cmbPecaID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPecaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPecaIDActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPecaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 210, 30));

        cmbPecaNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPecaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPecaNomeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPecaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 210, 30));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel8.setText("Nome");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel9.setText("ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        jLabel10.setText("Nome");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        jLabel12.setText("Quantidade");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 70, 20));

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

        cmbQuantidadePeca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbQuantidadePeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 210, 30));

        tblPedidosPendentes.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Empresa", "Peça", "Quantia de Peças", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
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
        tblPedidosPendentes.setShowGrid(true);
        tblPedidosPendentes.getTableHeader().setReorderingAllowed(false);
        tblPedidosPendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosPendentesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPedidosPendentes);
        if (tblPedidosPendentes.getColumnModel().getColumnCount() > 0) {
            tblPedidosPendentes.getColumnModel().getColumn(0).setResizable(false);
            tblPedidosPendentes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPedidosPendentes.getColumnModel().getColumn(1).setResizable(false);
            tblPedidosPendentes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblPedidosPendentes.getColumnModel().getColumn(2).setResizable(false);
            tblPedidosPendentes.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblPedidosPendentes.getColumnModel().getColumn(3).setResizable(false);
            tblPedidosPendentes.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblPedidosPendentes.getColumnModel().getColumn(4).setResizable(false);
            tblPedidosPendentes.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 460, 280));

        tblPedidosFinalizados.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Empresa", "Peça", "Quantia de Peças", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
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
        tblPedidosFinalizados.setShowGrid(true);
        tblPedidosFinalizados.getTableHeader().setReorderingAllowed(false);
        tblPedidosFinalizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosFinalizadosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPedidosFinalizados);
        if (tblPedidosFinalizados.getColumnModel().getColumnCount() > 0) {
            tblPedidosFinalizados.getColumnModel().getColumn(0).setResizable(false);
            tblPedidosFinalizados.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPedidosFinalizados.getColumnModel().getColumn(1).setResizable(false);
            tblPedidosFinalizados.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblPedidosFinalizados.getColumnModel().getColumn(2).setResizable(false);
            tblPedidosFinalizados.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblPedidosFinalizados.getColumnModel().getColumn(3).setResizable(false);
            tblPedidosFinalizados.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblPedidosFinalizados.getColumnModel().getColumn(4).setResizable(false);
            tblPedidosFinalizados.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 460, 280));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Informações da Empresa:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 220, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Finalizados:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, 30));

        jLabel13.setText("Valor da Unidade");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 100, 20));

        cmbValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 210, 30));

        jLabel11.setText("(R$)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 30, -1));

        setSize(new java.awt.Dimension(1016, 708));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow1 = tblPedidosFinalizados.getSelectedRow();
        int selectedRow2 = tblPedidosPendentes.getSelectedRow();
        if (selectedRow1 >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar este pedido?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String empresa = cmbEmpresaID.getSelectedItem().toString();
                    String peca = cmbPecaID.getSelectedItem().toString();
                    String quantidade = cmbQuantidadePeca.getValue().toString().replace(".", "");
                    if (empresa.isEmpty() || peca.isEmpty() || quantidade.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (quantidade.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int id = Integer.parseInt(tblPedidosFinalizados.getValueAt(selectedRow1, 0).toString());
                    PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
                    PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(id);
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    PecaDAO pecaDAO = new PecaDAO();
                    pedidoDTO.setEmpresa(empresaDAO.buscarEmpresaPorId(Integer.parseInt(empresa)));
                    pedidoDTO.setPeca(pecaDAO.buscarPecaPorId(Integer.parseInt(peca)));
                    pedidoDTO.setQuantidade(Double.parseDouble(quantidade));
                    if (pedidoDTO.getEmpresa() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a empresa selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    if (pedidoDTO.getPeca() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    pedidoDAO.atualizarPedido(pedidoDTO.getId(), pedidoDTO);
                    Limparcampos();
                    txtMessage.setText("Pedido de compras atualizado com sucesso!");
                    List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
                    DefaultTableModel model = (DefaultTableModel) tblPedidosFinalizados.getModel();
                    model.setRowCount(0);
                    for (PedidoComprasDTO objPedido : listaPedidos) {
                        try {
                            model.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (selectedRow2 >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar este pedido?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String empresa = cmbEmpresaID.getSelectedItem().toString();
                    String peca = cmbPecaID.getSelectedItem().toString();
                    String quantidade = cmbQuantidadePeca.getValue().toString().replace(".", "");
                    if (empresa.isEmpty() || peca.isEmpty() || quantidade.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (quantidade.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int id = Integer.parseInt(tblPedidosPendentes.getValueAt(selectedRow2, 0).toString());
                    PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
                    PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(id);
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    PecaDAO pecaDAO = new PecaDAO();
                    pedidoDTO.setEmpresa(empresaDAO.buscarEmpresaPorId(Integer.parseInt(empresa)));
                    pedidoDTO.setPeca(pecaDAO.buscarPecaPorId(Integer.parseInt(peca)));
                    pedidoDTO.setQuantidade(Double.parseDouble(quantidade));
                    if (pedidoDTO.getEmpresa() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a empresa selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    if (pedidoDTO.getPeca() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode editar isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    pedidoDAO.atualizarPedido(pedidoDTO.getId(), pedidoDTO);
                    Limparcampos();
                    txtMessage.setText("Pedido de compras atualizado com sucesso!");
                    List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
                    DefaultTableModel model = (DefaultTableModel) tblPedidosPendentes.getModel();
                    model.setRowCount(0);
                    for (PedidoComprasDTO objPedido : listaPedidos) {
                        try {
                            model.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um pedido para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow1 = tblPedidosFinalizados.getSelectedRow();
        int selectedRow2 = tblPedidosPendentes.getSelectedRow();
        if (selectedRow1 >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este pedido?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblPedidosFinalizados.getValueAt(selectedRow1, 0).toString());
                    PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
                    PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(id);
                    pedidoDAO.excluirPedido(pedidoDTO);
                    Limparcampos();
                    txtMessage.setText("Pedido de compras excluido com sucesso!");
                    List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
                    DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
                    DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
                    pedidosFinalizados.setRowCount(0);
                    pedidosPendentes.setRowCount(0);
                    for (PedidoComprasDTO objPedido : listaPedidos) {
                        try {
                            if ("Finalizado".equals(objPedido.getStatus())) {
                                pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            } else {
                                pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Este pedido não pode ser deletado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (selectedRow2 >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este pedido?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tblPedidosPendentes.getValueAt(selectedRow2, 0).toString());
                    PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
                    PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(id);
                    pedidoDAO.excluirPedido(pedidoDTO);
                    Limparcampos();
                    txtMessage.setText("Pedido de compras excluido com sucesso!");
                    List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
                    DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
                    DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
                    pedidosFinalizados.setRowCount(0);
                    pedidosPendentes.setRowCount(0);
                    for (PedidoComprasDTO objPedido : listaPedidos) {
                        try {
                            if ("Finalizado".equals(objPedido.getStatus())) {
                                pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            } else {
                                pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Este pedido não pode ser deletado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um pedido para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
        int selectedRow1 = tblPedidosFinalizados.getSelectedRow();
        int selectedRow2 = tblPedidosPendentes.getSelectedRow();
        if (selectedRow1 >= 0) {
            int id = Integer.parseInt(tblPedidosFinalizados.getValueAt(selectedRow1, 0).toString());
            PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(id);
            if ("Finalizado".equals(pedidoDTO.getStatus())) {
                JOptionPane.showMessageDialog(null, "Este pedido já foi finalizado.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente concluir este pedido?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    pedidoDTO.setStatus("Finalizado");
                    RegistrosDAO registroDAO = new RegistrosDAO();
                    RegistrosDTO registro = new RegistrosDTO();
                    if (pedidoDTO.getEmpresa() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode concluir isso, a empresa selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    if (pedidoDTO.getPeca() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode concluir isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    pedidoDAO.concluirPedido(pedidoDTO);
                    registro.setPeca(pedidoDTO.getPeca());
                    registro.setEmpresa(pedidoDTO.getEmpresa());
                    registro.setQuantidade(pedidoDTO.getQuantidade());
                    registro.setValor(pedidoDTO.getValor());
                    registroDAO.adicionarRegistro(false, registro);
                    Limparcampos();
                    txtMessage.setText("Pedido de compras finalizado com sucesso!");
                    List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
                    DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
                    DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
                    pedidosFinalizados.setRowCount(0);
                    pedidosPendentes.setRowCount(0);
                    for (PedidoComprasDTO objPedido : listaPedidos) {
                        try {
                            if ("Finalizado".equals(objPedido.getStatus())) {
                                pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            } else {
                                pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao finalizar essa OS: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (selectedRow2 >= 0) {
            int id = Integer.parseInt(tblPedidosPendentes.getValueAt(selectedRow2, 0).toString());
            PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(id);
            if ("Finalizado".equals(pedidoDTO.getStatus())) {
                JOptionPane.showMessageDialog(null, "Este pedido já foi finalizado.");
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente concluir este pedido?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    pedidoDTO.setStatus("Finalizado");
                    RegistrosDAO registroDAO = new RegistrosDAO();
                    RegistrosDTO registro = new RegistrosDTO();
                    if (pedidoDTO.getEmpresa() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode concluir isso, a empresa selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    if (pedidoDTO.getPeca() == null) {
                        JOptionPane.showMessageDialog(null, "Você não pode concluir isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                        Atualizarcampos();
                        return;
                    }
                    pedidoDAO.concluirPedido(pedidoDTO);
                    registro.setPeca(pedidoDTO.getPeca());
                    registro.setEmpresa(pedidoDTO.getEmpresa());
                    registro.setQuantidade(pedidoDTO.getQuantidade());
                    registro.setValor(pedidoDTO.getValor());
                    registroDAO.adicionarRegistro(false, registro);
                    Limparcampos();
                    txtMessage.setText("Pedido de compras finalizado com sucesso!");
                    List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
                    DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
                    DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
                    pedidosFinalizados.setRowCount(0);
                    pedidosPendentes.setRowCount(0);
                    for (PedidoComprasDTO objPedido : listaPedidos) {
                        try {
                            if ("Finalizado".equals(objPedido.getStatus())) {
                                pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            } else {
                                pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao finalizar essa OS: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um pedido para concluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String empresa = cmbEmpresaID.getSelectedItem().toString();
        String peca = cmbPecaID.getSelectedItem().toString();
        String quantidade = cmbQuantidadePeca.getValue().toString();
        double valorTotal = Double.parseDouble(cmbValor.getValue().toString()) * Double.parseDouble(quantidade);
        if (empresa.isEmpty() || peca.isEmpty() || quantidade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantidade.length() > 20) {
            JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cmbPecaID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para adicionar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cmbEmpresaID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para adicionar isto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Double.parseDouble(quantidade) < 1.0) {
            JOptionPane.showMessageDialog(null, "A quantidade de peças que você selecionou não é válida", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PedidoComprasDTO pedido = new PedidoComprasDTO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        PecaDAO pecaDAO = new PecaDAO();
        pedido.setEmpresa(empresaDAO.buscarEmpresaPorId(Integer.parseInt(empresa)));
        pedido.setPeca(pecaDAO.buscarPecaPorId(Integer.parseInt(peca)));
        pedido.setQuantidade(Double.parseDouble(quantidade));
        pedido.setValor(valorTotal);
        pedido.setStatus("Em Aberto");
        if (pedido.getEmpresa() == null) {
            JOptionPane.showMessageDialog(null, "Você não pode adicionar isso, a empresa selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            Atualizarcampos();
            return;
        }
        if (pedido.getPeca() == null) {
            JOptionPane.showMessageDialog(null, "Você não pode adicionar isso, a peça selecionada não existe em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            Atualizarcampos();
            return;
        }
        PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
        pedidoDAO.adicionarPedido(pedido);
        Limparcampos();
        txtMessage.setText("Pedido de compras criado com sucesso!");
        List<PedidoComprasDTO> listaPedidos = pedidoDAO.listarPedidos();
        DefaultTableModel pedidosFinalizados = (DefaultTableModel) tblPedidosFinalizados.getModel();
        DefaultTableModel pedidosPendentes = (DefaultTableModel) tblPedidosPendentes.getModel();
        pedidosFinalizados.setRowCount(0);
        pedidosPendentes.setRowCount(0);
        for (PedidoComprasDTO objPedido : listaPedidos) {
            try {
                if ("Finalizado".equals(objPedido.getStatus())) {
                    pedidosFinalizados.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                } else {
                    pedidosPendentes.addRow(new Object[]{objPedido.getId(), objPedido.getEmpresa().getNome(), objPedido.getPeca().getNome(), round(objPedido.getQuantidade()), objPedido.getValor()});
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cmbEmpresaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpresaNomeActionPerformed
        try {
            int index = cmbEmpresaNome.getSelectedIndex();
            cmbEmpresaID.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbEmpresaNomeActionPerformed

    private void cmbEmpresaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpresaIDActionPerformed
        try {
            int index = cmbEmpresaID.getSelectedIndex();
            cmbEmpresaNome.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbEmpresaIDActionPerformed

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
        txtMessage.setText("Pedidos de compra atualizados");
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblPedidosPendentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosPendentesMouseClicked
        int selectedRow = tblPedidosPendentes.getSelectedRow();
        if (selectedRow >= 0) {
            tblPedidosFinalizados.clearSelection();
            String ID = tblPedidosPendentes.getValueAt(selectedRow, 0).toString();
            PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
            PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(Integer.parseInt(ID));
            if (pedidoDTO == null || pedidoDTO.getEmpresa() == null || pedidoDTO.getPeca() == null) {
                JOptionPane.showMessageDialog(null, "Você não pode editar isso, o pedido possui \ninformaçoes inexistentes em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                Atualizarcampos();
                return;
            }
            String quantidade = tblPedidosPendentes.getValueAt(selectedRow, 3).toString();
            cmbEmpresaID.setSelectedItem(String.valueOf(pedidoDTO.getEmpresa().getId()));
            cmbPecaID.setSelectedItem(String.valueOf(pedidoDTO.getPeca().getId()));
            cmbQuantidadePeca.setValue(Double.valueOf(quantidade));
        }
    }//GEN-LAST:event_tblPedidosPendentesMouseClicked

    private void tblPedidosFinalizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosFinalizadosMouseClicked
        int selectedRow = tblPedidosFinalizados.getSelectedRow();
        if (selectedRow >= 0) {
            tblPedidosPendentes.clearSelection();
            String ID = tblPedidosFinalizados.getValueAt(selectedRow, 0).toString();
            PedidoComprasDAO pedidoDAO = new PedidoComprasDAO();
            PedidoComprasDTO pedidoDTO = pedidoDAO.buscarPedidoPorId(Integer.parseInt(ID));
            if (pedidoDTO == null || pedidoDTO.getEmpresa() == null || pedidoDTO.getPeca() == null) {
                JOptionPane.showMessageDialog(null, "Você não pode editar isso, o pedido possui \ninformaçoes inexistentes em nosso banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
                Atualizarcampos();
                return;
            }
            String quantidade = tblPedidosFinalizados.getValueAt(selectedRow, 3).toString();
            cmbEmpresaID.setSelectedItem(String.valueOf(pedidoDTO.getEmpresa().getId()));
            cmbPecaID.setSelectedItem(String.valueOf(pedidoDTO.getPeca().getId()));
            cmbQuantidadePeca.setValue(Double.valueOf(quantidade));
        }
    }//GEN-LAST:event_tblPedidosFinalizadosMouseClicked

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaPedidoCompras tela = new telaPedidoCompras();
                tela.setTitle("Pedido de Compras");
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
    private javax.swing.JComboBox<String> cmbEmpresaID;
    private javax.swing.JComboBox<String> cmbEmpresaNome;
    private javax.swing.JComboBox<String> cmbPecaID;
    private javax.swing.JComboBox<String> cmbPecaNome;
    private javax.swing.JSpinner cmbQuantidadePeca;
    private javax.swing.JSpinner cmbValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblPedidosFinalizados;
    private javax.swing.JTable tblPedidosPendentes;
    private javax.swing.JLabel txtMessage;
    // End of variables declaration//GEN-END:variables
}
