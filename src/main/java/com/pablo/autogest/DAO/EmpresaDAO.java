package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.EmpresaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    public void adicionarEmpresa(EmpresaDTO empresa) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO empresas(nome, endereco, telefone) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEndereco());
            stmt.setString(3, empresa.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EmpresaDTO> listarEmpresas() {
        List<EmpresaDTO> empresas = new ArrayList<>();
        String sql = "SELECT * FROM empresas";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    EmpresaDTO empresa = new EmpresaDTO();
                    empresa.setId(rs.getInt("id"));
                    empresa.setNome(rs.getString("nome"));
                    empresa.setEndereco(rs.getString("endereco"));
                    empresa.setTelefone(rs.getString("telefone"));
                    empresas.add(empresa);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresas;
    }

    public EmpresaDTO buscarEmpresaPorId(int id) {
        EmpresaDTO empresa = null;
        String sql = "SELECT * FROM empresas WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                empresa = new EmpresaDTO();
                empresa.setId(rs.getInt("id"));
                empresa.setNome(rs.getString("nome"));
                empresa.setEndereco(rs.getString("endereco"));
                empresa.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    public void atualizarEmpresa(int empresaId, EmpresaDTO empresa) {
        String sql = "UPDATE empresas SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEndereco());
            stmt.setString(3, empresa.getTelefone());
            stmt.setInt(4, empresaId);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirEmpresa(int id) throws ClassNotFoundException, SQLException {
        String sqlEmpresas = "DELETE FROM empresas WHERE id = ?";
        String sqlPedidos = "DELETE FROM pedido_compra WHERE empresa_id = ? AND status = ?";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmt = connection.prepareStatement(sqlEmpresas)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
            }
            try (PreparedStatement stmtPedidos = connection.prepareStatement(sqlPedidos)) {
                stmtPedidos.setInt(1, id);
                stmtPedidos.setString(2, "Em Aberto");
                stmtPedidos.execute();
                stmtPedidos.close();
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
