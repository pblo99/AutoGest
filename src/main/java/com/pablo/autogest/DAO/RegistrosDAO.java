package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.ClienteDTO;
import com.pablo.autogest.DTO.EmpresaDTO;
import com.pablo.autogest.DTO.PecaDTO;
import com.pablo.autogest.DTO.RegistrosDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrosDAO {

    public void adicionarRegistro(boolean reg, RegistrosDTO registro) {
        String sqlFaturamentos = "INSERT INTO registros (cliente_id, peca_id, descricao, valor) VALUES (?, ?, ?, ?)";
        String sqlGastos = "INSERT INTO registros (empresa_id, peca_id, quantidade, valor) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            if (reg) {
                try (PreparedStatement stmt1 = connection.prepareStatement(sqlFaturamentos)) {
                    stmt1.setInt(1, registro.getCliente().getId());
                    stmt1.setInt(2, registro.getPeca().getId());
                    stmt1.setString(3, registro.getDescricao());
                    stmt1.setDouble(4, registro.getValor());
                    stmt1.execute();
                }
            } else {
                try (PreparedStatement stmt2 = connection.prepareStatement(sqlGastos)) {
                    stmt2.setInt(1, registro.getEmpresa().getId());
                    stmt2.setInt(2, registro.getPeca().getId());
                    stmt2.setDouble(3, registro.getQuantidade());
                    stmt2.setDouble(4, registro.getValor());
                    stmt2.execute();
                }
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

    public List<RegistrosDTO> listarRegistros() {
        List<RegistrosDTO> registros = new ArrayList<>();
        String sql = "SELECT * FROM registros";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RegistrosDTO registro = new RegistrosDTO();
                ClienteDAO clienteDAO = new ClienteDAO();
                ClienteDTO clienteDTO = new ClienteDTO();
                PecaDAO pecaDAO = new PecaDAO();
                PecaDTO pecaDTO = new PecaDTO();
                EmpresaDAO empresaDAO = new EmpresaDAO();
                EmpresaDTO empresaDTO = new EmpresaDTO();
                registro.setId(rs.getInt("id"));
                if (rs.getInt("cliente_id") == -1) {
                    registro.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                    registro.setEmpresa(empresaDAO.buscarEmpresaPorId(rs.getInt("empresa_id")));
                    registro.setCliente(clienteDTO);
                    registro.getCliente().setId(rs.getInt("cliente_id"));
                    registro.getCliente().setNome(rs.getString("cliente_nome"));
                    registro.setQuantidade(rs.getDouble("quantidade"));
                    registro.setValor(rs.getDouble("valor"));
                } else {
                    registro.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                    registro.setEmpresa(empresaDTO);
                    registro.getEmpresa().setId(rs.getInt("empresa_id"));
                    registro.getEmpresa().setNome(rs.getString("empresa_nome"));
                    registro.setCliente(clienteDAO.buscarClientePorId(rs.getInt("cliente_id")));
                    registro.setDescricao(rs.getString("descricao"));
                    registro.setValor(rs.getDouble("valor"));
                }
                if (registro.getPeca() == null) {
                    registro.setPeca(pecaDTO);
                    registro.getPeca().setId(rs.getInt("peca_id"));
                    registro.getPeca().setNome(rs.getString("peca_nome"));
                }
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public void excluirRegistro(RegistrosDTO registro) {
        String sql = "DELETE FROM registros WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, registro.getId());
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

    public RegistrosDTO buscarRegistroPorId(int regID) {
        RegistrosDTO registro = null;
        String sql = "SELECT * FROM registros WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, regID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    registro = new RegistrosDTO();
                    ClienteDAO clienteDAO = new ClienteDAO();
                    PecaDAO pecaDAO = new PecaDAO();
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    registro.setId(rs.getInt("id"));
                    if (rs.getInt("cliente_id") == -1) {
                        registro.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                        registro.setEmpresa(empresaDAO.buscarEmpresaPorId(rs.getInt("empresa_id")));
                        registro.setCliente(new ClienteDTO());
                        registro.getCliente().setId(rs.getInt("cliente_id"));
                        registro.setQuantidade(rs.getDouble("quantidade"));
                        registro.setValor(rs.getDouble("valor"));
                    } else {
                        registro.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                        registro.setEmpresa(new EmpresaDTO());
                        registro.getEmpresa().setId(rs.getInt("empresa_id"));
                        registro.setCliente(clienteDAO.buscarClientePorId(rs.getInt("cliente_id")));
                        registro.setDescricao(rs.getString("descricao"));
                        registro.setValor(rs.getDouble("valor"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }
}
