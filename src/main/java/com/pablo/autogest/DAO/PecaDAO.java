package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.OrdemServicoDTO;
import com.pablo.autogest.DTO.PecaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PecaDAO {

    public void adicionarPeca(PecaDTO peca) {
        String sql = "INSERT INTO pecas (nome, descricao, quantidade, valor, codigo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getDescricao());
            stmt.setDouble(3, peca.getQuantidade());
            stmt.setDouble(4, peca.getValor());
            stmt.setLong(5, peca.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PecaDTO> listarPecas() {
        List<PecaDTO> pecas = new ArrayList<>();
        String sql = "SELECT * FROM pecas";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PecaDTO peca = new PecaDTO();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getDouble("quantidade"));
                peca.setValor(rs.getDouble("valor"));
                peca.setCodigo(rs.getLong("codigo"));
                pecas.add(peca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pecas;
    }

    public void atualizarPeca(int pecaId, PecaDTO peca) {
        String sql = "UPDATE pecas SET nome = ?, descricao = ?, quantidade = ?, valor = ?, codigo = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getDescricao());
            stmt.setDouble(3, peca.getQuantidade());
            stmt.setDouble(4, peca.getValor());
            stmt.setLong(5, peca.getCodigo());
            stmt.setInt(6, pecaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPeca(int pecaId) {
        String sqlPecas = "DELETE FROM pecas WHERE id = ?";
        String sqlSolicitacoes = "DELETE FROM solicitacoes_baixa WHERE id_peca = ?";
        String sqlPedidos = "DELETE FROM pedido_compra WHERE peca_id = ? AND status = ?";
        String sqlOrdens = "DELETE FROM ordens_servico WHERE peca_id = ? AND status = ?";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmtPecas = connection.prepareStatement(sqlPecas); PreparedStatement stmtSolicitacoes = connection.prepareStatement(sqlSolicitacoes); PreparedStatement stmtPedidos = connection.prepareStatement(sqlPedidos); PreparedStatement stmtOrdens = connection.prepareStatement(sqlOrdens)) {
                stmtPecas.setInt(1, pecaId);
                stmtPecas.executeUpdate();
                stmtSolicitacoes.setInt(1, pecaId);
                stmtSolicitacoes.executeUpdate();
                stmtPedidos.setInt(1, pecaId);
                stmtPedidos.setString(2, "Em Aberto");
                stmtPedidos.executeUpdate();
                stmtOrdens.setInt(1, pecaId);
                stmtOrdens.setString(2, "Em Aberto");
                stmtOrdens.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(); 
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PecaDTO buscarPecaPorId(int id) {
        PecaDTO peca = null;
        String sql = "SELECT * FROM pecas WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    peca = new PecaDTO();
                    peca.setId(rs.getInt("id"));
                    peca.setNome(rs.getString("nome"));
                    peca.setDescricao(rs.getString("descricao"));
                    peca.setQuantidade(rs.getDouble("quantidade"));
                    peca.setValor(rs.getDouble("valor"));
                    peca.setCodigo(rs.getLong("codigo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peca;
    }

    public void baixarEstoque(OrdemServicoDTO os, String motivo) {
        String sqlBaixaEstoque = "UPDATE pecas SET quantidade = quantidade - ? WHERE id = ?";
        String sqlRegistrarBaixa = "INSERT INTO solicitacoes_baixa (id_peca, id_os, quantidade, motivo) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmtBaixaEstoque = connection.prepareStatement(sqlBaixaEstoque)) {
                stmtBaixaEstoque.setDouble(1, os.getQuantidade());
                stmtBaixaEstoque.setInt(2, os.getPeca().getId());
                stmtBaixaEstoque.execute();
            }
            try (PreparedStatement stmtRegistrarBaixa = connection.prepareStatement(sqlRegistrarBaixa)) {
                stmtRegistrarBaixa.setInt(1, os.getPeca().getId());
                stmtRegistrarBaixa.setInt(2, os.getId());
                stmtRegistrarBaixa.setDouble(3, os.getQuantidade());
                stmtRegistrarBaixa.setString(4, motivo);
                stmtRegistrarBaixa.execute();
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
    public void baixarEstoque(int pecaID, double quantidade, String motivo) {
        String sqlBaixaEstoque = "UPDATE pecas SET quantidade = quantidade - ? WHERE id = ?";
        String sqlRegistrarBaixa = "INSERT INTO solicitacoes_baixa (id_peca, quantidade, motivo) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmtBaixaEstoque = connection.prepareStatement(sqlBaixaEstoque)) {
                stmtBaixaEstoque.setDouble(1, quantidade);
                stmtBaixaEstoque.setInt(2, pecaID);
                stmtBaixaEstoque.execute();
            }
            try (PreparedStatement stmtRegistrarBaixa = connection.prepareStatement(sqlRegistrarBaixa)) {
                stmtRegistrarBaixa.setInt(1, pecaID);
                stmtRegistrarBaixa.setDouble(2, quantidade);
                stmtRegistrarBaixa.setString(3, motivo);
                stmtRegistrarBaixa.execute();
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
}
