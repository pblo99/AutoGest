package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.ClienteDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void adicionarCliente(ClienteDTO cliente) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO clientes(nome, endereco, telefone) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public ClienteDTO buscarClientePorId(int id) {
        ClienteDTO cliente = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new ClienteDTO();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void atualizarCliente(int clienteId, ClienteDTO cliente) {
        String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, clienteId);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(int id) throws ClassNotFoundException, SQLException {
        String sqlClientes = "DELETE FROM clientes WHERE id = ?";
        String sqlOrdens = "DELETE FROM ordens_servico WHERE cliente_id = ? AND status = ?";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmt = connection.prepareStatement(sqlClientes)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
            try (PreparedStatement stmtOrdens = connection.prepareStatement(sqlOrdens)) {
                stmtOrdens.setInt(1, id);
                stmtOrdens.setString(2, "Em Aberto");
                stmtOrdens.execute();
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
