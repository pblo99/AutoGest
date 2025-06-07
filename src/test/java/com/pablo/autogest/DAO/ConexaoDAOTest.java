package com.pablo.autogest.DAO;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConexaoDAOTest {

    @Test
    void testConnectaBD() {
        ConexaoDAO conexaoDAO = new ConexaoDAO(); // cria instancia da classe de conexao
        try (Connection connection = conexaoDAO.connectaBD()) { // tenta abrir conexao
            assertNotNull(connection, "A conexao nao deveria ser nula"); // verifica se conexao existe
            assertFalse(connection.isClosed(), "A conexao nao deveria estar fechada"); // verifica se esta aberta
        } catch (Exception e) {
            fail("Erro ao obter conexao: " + e.getMessage()); // falha se der erro na conexao
        }
    }
}
