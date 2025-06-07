package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.ClienteDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteDAOTest {

    static ClienteDAO clienteDAO;
    static int clienteId;

    @BeforeAll
    static void setup() {
        clienteDAO = new ClienteDAO();
    }

    @Test
    @Order(1)
    void testAdicionarCliente() throws Exception {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNome("João da Silva");
        cliente.setEndereco("Rua Teste, 123");
        cliente.setTelefone("99999-9999");

        clienteDAO.adicionarCliente(cliente);

        // Buscar o último cliente inserido (precisa de ID)
        List<ClienteDTO> lista = clienteDAO.listarClientes();
        ClienteDTO ultimo = lista.get(lista.size() - 1);
        clienteId = ultimo.getId();

        assertEquals("João da Silva", ultimo.getNome());
    }

    @Test
    @Order(2)
    void testListarClientes() {
        List<ClienteDTO> clientes = clienteDAO.listarClientes();
        assertNotNull(clientes);
        assertFalse(clientes.isEmpty());
    }

    @Test
    @Order(3)
    void testBuscarClientePorId() {
        ClienteDTO cliente = clienteDAO.buscarClientePorId(clienteId);
        assertNotNull(cliente);
        assertEquals("João da Silva", cliente.getNome());
    }

    @Test
    @Order(4)
    void testAtualizarCliente() {
        ClienteDTO atualizado = new ClienteDTO();
        atualizado.setNome("João Atualizado");
        atualizado.setEndereco("Rua Nova, 456");
        atualizado.setTelefone("88888-8888");

        clienteDAO.atualizarCliente(clienteId, atualizado);

        ClienteDTO resultado = clienteDAO.buscarClientePorId(clienteId);
        assertEquals("João Atualizado", resultado.getNome());
        assertEquals("Rua Nova, 456", resultado.getEndereco());
        assertEquals("88888-8888", resultado.getTelefone());
    }

    @Test
    @Order(5)
    void testExcluirCliente() throws Exception {
        clienteDAO.excluirCliente(clienteId);
        ClienteDTO cliente = clienteDAO.buscarClientePorId(clienteId);
        assertNull(cliente);
    }
}
