package com.pablo.autogest.DAO;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class ConnectionPoolTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    void testConnectionNotNull() {
        try (Connection conn = ConnectionPool.getConnection()) {
            assertNotNull(conn, "A conexão não deve ser nula");
            assertFalse(conn.isClosed(), "A conexão deve estar aberta");
        } catch (Exception e) {
            fail("Erro ao obter conexão: " + e.getMessage());
        }
    }

    @Test
    public void testGetConnection() throws Exception {
        try (Connection result = ConnectionPool.getConnection()) {
            assertNotNull(result, "A conexão não deve ser nula");
            assertFalse(result.isClosed(), "A conexão deve estar aberta");
        } catch (Exception e) {
            fail("Erro ao obter conexão: " + e.getMessage());
        }
    }

}
