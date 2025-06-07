package com.pablo.autogest.DAO;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConexaoDAOTest {

    @Test
    void testConnectaBD() {
        ConexaoDAO conexaoDAO = new ConexaoDAO();
        try (Connection connection = conexaoDAO.connectaBD()) {
            assertNotNull(connection, "A conexão não deveria ser nula");
            assertFalse(connection.isClosed(), "A conexão não deveria estar fechada");
        } catch (Exception e) {
            fail("Erro ao obter conexão: " + e.getMessage());
        }
    }
}
