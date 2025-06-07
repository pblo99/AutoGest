package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.ClienteDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // define a ordem dos testes
class ClienteDAOTest {

    static ClienteDAO clienteDAO;
    static int clienteId;

    @BeforeAll
    static void setup() {
        clienteDAO = new ClienteDAO(); // instancia o dao antes de tudo
    }

    @Test
    @Order(1)
    void testAdicionarCliente() throws Exception {
        ClienteDTO cliente = new ClienteDTO(); // cria novo cliente
        cliente.setNome("João da Silva");
        cliente.setEndereco("Rua Teste, 123");
        cliente.setTelefone("99999-9999");

        clienteDAO.adicionarCliente(cliente); // adiciona cliente ao banco

        List<ClienteDTO> lista = clienteDAO.listarClientes(); // busca todos clientes
        ClienteDTO ultimo = lista.get(lista.size() - 1); // pega o ultimo adicionado
        clienteId = ultimo.getId(); // salva o id para usar depois

        assertEquals("João da Silva", ultimo.getNome()); // verifica se o nome esta certo
    }

    @Test
    @Order(2)
    void testListarClientes() {
        List<ClienteDTO> clientes = clienteDAO.listarClientes(); // busca todos os clientes
        assertNotNull(clientes); // verifica se a lista nao eh nula
        assertFalse(clientes.isEmpty()); // verifica se nao esta vazia
    }

    @Test
    @Order(3)
    void testBuscarClientePorId() {
        ClienteDTO cliente = clienteDAO.buscarClientePorId(clienteId); // busca cliente pelo id salvo
        assertNotNull(cliente); // verifica se achou
        assertEquals("João da Silva", cliente.getNome()); // confere nome
    }

    @Test
    @Order(4)
    void testAtualizarCliente() {
        ClienteDTO atualizado = new ClienteDTO(); // cria cliente atualizado
        atualizado.setNome("João Atualizado");
        atualizado.setEndereco("Rua Nova, 456");
        atualizado.setTelefone("88888-8888");

        clienteDAO.atualizarCliente(clienteId, atualizado); // atualiza cliente no banco

        ClienteDTO resultado = clienteDAO.buscarClientePorId(clienteId); // busca cliente atualizado
        assertEquals("João Atualizado", resultado.getNome()); // confere nome novo
        assertEquals("Rua Nova, 456", resultado.getEndereco()); // confere endereco novo
        assertEquals("88888-8888", resultado.getTelefone()); // confere telefone novo
    }

    @Test
    @Order(5)
    void testExcluirCliente() throws Exception {
        clienteDAO.excluirCliente(clienteId); // exclui cliente pelo id
        ClienteDTO cliente = clienteDAO.buscarClientePorId(clienteId); // tenta buscar de novo
        assertNull(cliente); // verifica se foi realmente excluido
    }
}
