package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.EmpresaDTO;
import com.pablo.autogest.DTO.PecaDTO;
import com.pablo.autogest.DTO.PedidoComprasDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoComprasDAO {

    public void adicionarPedido(PedidoComprasDTO pedidoDTO) {
        String sql = "INSERT INTO pedido_compra (empresa_id, peca_id, quantidade, valor, peca_nome, empresa_nome) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoDTO.getEmpresa().getId());
            stmt.setInt(2, pedidoDTO.getPeca().getId());
            stmt.setDouble(3, pedidoDTO.getQuantidade());
            stmt.setDouble(4, pedidoDTO.getValor());
            stmt.setString(5, pedidoDTO.getPeca().getNome());
            stmt.setString(6, pedidoDTO.getEmpresa().getNome());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PedidoComprasDTO> listarPedidos() {
        List<PedidoComprasDTO> pedidosList = new ArrayList<>();
        String sql = "SELECT * FROM pedido_compra";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PedidoComprasDTO pedidoDTO = new PedidoComprasDTO();
                PecaDTO pecaDTO = new PecaDTO();
                EmpresaDTO empresaDTO = new EmpresaDTO();
                EmpresaDAO empresaDAO = new EmpresaDAO();
                PecaDAO pecaDAO = new PecaDAO();
                pedidoDTO.setQuantidade(rs.getDouble("quantidade"));
                pedidoDTO.setValor(rs.getDouble("valor"));
                pedidoDTO.setId(rs.getInt("id"));
                pedidoDTO.setStatus(rs.getString("status"));
                pedidoDTO.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                pedidoDTO.setEmpresa(empresaDAO.buscarEmpresaPorId(rs.getInt("empresa_id")));
                if (pedidoDTO.getEmpresa() == null) {
                    pedidoDTO.setEmpresa(empresaDTO);
                    pedidoDTO.getEmpresa().setId(rs.getInt("empresa_id"));
                    pedidoDTO.getEmpresa().setNome(rs.getString("empresa_nome"));
                }
                if (pedidoDTO.getPeca() == null) {
                    pedidoDTO.setPeca(pecaDTO);
                    pedidoDTO.getPeca().setId(rs.getInt("peca_id"));
                    pedidoDTO.getPeca().setNome(rs.getString("peca_nome"));
                }
                pedidosList.add(pedidoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidosList;
    }

    public void concluirPedido(PedidoComprasDTO pedidoDTO) {
        String sqlPecas = "UPDATE pecas SET quantidade = quantidade + ? WHERE id = ?";
        String sqlPedidos = "UPDATE pedido_compra SET empresa_id = ?, peca_id = ?, status = ?, quantidade = ?, valor = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmt1 = connection.prepareStatement(sqlPecas)) {
                stmt1.setDouble(1, pedidoDTO.getQuantidade());
                stmt1.setInt(2, pedidoDTO.getPeca().getId());
                stmt1.execute();
            }
            try (PreparedStatement stmt2 = connection.prepareStatement(sqlPedidos)) {
                stmt2.setInt(1, pedidoDTO.getEmpresa().getId());
                stmt2.setInt(2, pedidoDTO.getPeca().getId());
                stmt2.setString(3, pedidoDTO.getStatus());
                stmt2.setDouble(4, pedidoDTO.getQuantidade());
                stmt2.setDouble(5, pedidoDTO.getValor());
                stmt2.setInt(6, pedidoDTO.getId());
                stmt2.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            try (Connection connection = ConnectionPool.getConnection()) {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void atualizarPedido(int pedidoID, PedidoComprasDTO pedidoDTO) {
        String sql = "UPDATE pedido_compra SET empresa_id = ?, peca_id = ?, status = ?, quantidade = ? , valor = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoDTO.getEmpresa().getId());
            stmt.setInt(2, pedidoDTO.getPeca().getId());
            stmt.setString(3, pedidoDTO.getStatus());
            stmt.setDouble(4, pedidoDTO.getQuantidade());
            stmt.setDouble(5, pedidoDTO.getValor());
            stmt.setInt(6, pedidoID);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPedido(PedidoComprasDTO pedidoDTO) {
        String sql = "DELETE FROM pedido_compra WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoDTO.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            try (Connection connection = ConnectionPool.getConnection()) {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public PedidoComprasDTO buscarPedidoPorId(int pedidoID) {
        PedidoComprasDTO pedidoDTO = null;
        String sql = "SELECT * FROM pedido_compra WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedidoID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pedidoDTO = new PedidoComprasDTO();
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    PecaDAO pecaDAO = new PecaDAO();
                    pedidoDTO.setId(rs.getInt("id"));
                    pedidoDTO.setEmpresa(empresaDAO.buscarEmpresaPorId(rs.getInt("empresa_id")));
                    pedidoDTO.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                    pedidoDTO.setQuantidade(rs.getDouble("quantidade"));
                    pedidoDTO.setValor(rs.getDouble("valor"));
                    pedidoDTO.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoDTO;
    }

}
