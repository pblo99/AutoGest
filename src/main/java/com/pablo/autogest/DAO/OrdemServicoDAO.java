package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.ClienteDTO;
import com.pablo.autogest.DTO.OrdemServicoDTO;
import com.pablo.autogest.DTO.PecaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    public void adicionarOS(boolean produto, OrdemServicoDTO os) {
        String sql = "INSERT INTO ordens_servico (cliente_id, peca_id, status, descricao, valor_peca, valor_servico, quantidade_peca, cliente_nome, peca_nome) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, os.getCliente().getId());
            if (produto) {
                stmt.setInt(2, os.getPeca().getId());
                stmt.setDouble(5, os.getValorPecas());
                stmt.setDouble(7, os.getQuantidade());
            } else {
                stmt.setInt(2, -1);
                stmt.setDouble(5, 0.0);
                stmt.setDouble(7, 0.0);
            }
            stmt.setString(3, os.getStatus());
            stmt.setString(4, os.getDescricao());
            stmt.setDouble(6, os.getValorServico());
            stmt.setString(8, os.getPeca().getNome());
            stmt.setString(9, os.getPeca().getNome());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OrdemServicoDTO> listarOS() {
        List<OrdemServicoDTO> os = new ArrayList<>();
        String sql = "SELECT * FROM ordens_servico";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemServicoDTO osDTO = new OrdemServicoDTO();
                ClienteDTO clienteDTO = new ClienteDTO();
                PecaDTO pecaDTO = new PecaDTO();
                ClienteDAO clienteDAO = new ClienteDAO();
                PecaDAO pecaDAO = new PecaDAO();
                if (rs.getInt("peca_id") == -1) {
                    pecaDTO.setCodigo(0);
                    pecaDTO.setDescricao("---");
                    pecaDTO.setNome("---");
                    pecaDTO.setQuantidade(0);
                    pecaDTO.setValor(0);
                    osDTO.setPeca(pecaDTO);
                    osDTO.getPeca().setId(-1);
                    osDTO.setQuantidade(0);
                    osDTO.setValorPecas(0);
                } else {
                    osDTO.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                    osDTO.setQuantidade(rs.getDouble("quantidade_peca"));
                    osDTO.setValorPecas(rs.getDouble("valor_peca"));
                }
                osDTO.setId(rs.getInt("id"));
                osDTO.setCliente(clienteDAO.buscarClientePorId(rs.getInt("cliente_id")));
                osDTO.setStatus(rs.getString("status"));
                osDTO.setDescricao(rs.getString("descricao"));
                osDTO.setValorServico(rs.getDouble("valor_servico"));
                if (osDTO.getCliente().getNome() == null) {
                    osDTO.setCliente(clienteDTO);
                    osDTO.getCliente().setId(rs.getInt("cliente_id"));
                    osDTO.getCliente().setNome(rs.getString("cliente_nome"));
                }
                if (osDTO.getPeca().getNome() == null) {
                    osDTO.setPeca(pecaDTO);
                    osDTO.getPeca().setId(rs.getInt("peca_id"));
                    osDTO.getPeca().setNome(rs.getString("peca_nome"));
                }
                os.add(osDTO);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return os;
    }

    public void atualizarOS(int osID, OrdemServicoDTO os) {
        String sql = "UPDATE ordens_servico SET cliente_id = ?, peca_id = ?, status = ?, descricao = ? , valor_peca = ? , valor_servico = ? , quantidade_peca = ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, os.getCliente().getId());
            stmt.setInt(2, os.getPeca().getId());
            stmt.setString(3, os.getStatus());
            stmt.setString(4, os.getDescricao());
            stmt.setDouble(5, os.getValorPecas());
            stmt.setDouble(6, os.getValorServico());
            stmt.setDouble(7, os.getQuantidade());
            stmt.setInt(8, osID);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirOS(OrdemServicoDTO os) {
        String sqlOS = "DELETE FROM ordens_servico WHERE id = ?";
        String sqlBaixa = "DELETE FROM solicitacoes_baixa WHERE id_os = ?";
        String sqlPecas = "UPDATE pecas SET quantidade = quantidade + ? WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement stmt = connection.prepareStatement(sqlOS)) {
                stmt.setInt(1, os.getId());
                stmt.execute();
                stmt.close();
            }
            try (PreparedStatement stmt2 = connection.prepareStatement(sqlBaixa)) {
                stmt2.setInt(1, os.getId());
                stmt2.execute();
                stmt2.close();
            }
            try (PreparedStatement stmt3 = connection.prepareStatement(sqlPecas)) {
                stmt3.setDouble(1, os.getQuantidade());
                stmt3.setInt(2, os.getPeca().getId());
                stmt3.execute();
                stmt3.close();
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

    public OrdemServicoDTO buscarOSPorId(int osID) {
        OrdemServicoDTO os = null;
        String sql = "SELECT * FROM ordens_servico WHERE id = ?";
        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, osID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                os = new OrdemServicoDTO();
                ClienteDAO clienteDAO = new ClienteDAO();
                PecaDAO pecaDAO = new PecaDAO();
                os.setId(rs.getInt("id"));
                os.setCliente(clienteDAO.buscarClientePorId(rs.getInt("cliente_id")));
                if (rs.getInt("peca_id") == -1) {
                    PecaDTO pecaDTO = new PecaDTO();
                    pecaDTO.setCodigo(0);
                    pecaDTO.setDescricao("---");
                    pecaDTO.setNome("---");
                    pecaDTO.setQuantidade(0);
                    pecaDTO.setValor(0);
                    os.setPeca(pecaDTO);
                    os.getPeca().setId(-1);
                    os.setQuantidade(0);
                    os.setValorPecas(0);
                } else {
                    os.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                    os.setValorPecas(rs.getLong("valor_peca"));
                    os.setQuantidade(rs.getDouble("quantidade_peca"));
                }
                os.setStatus(rs.getString("status"));
                os.setDescricao(rs.getString("descricao"));
                os.setValorServico(rs.getLong("valor_servico"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return os;
    }
}
