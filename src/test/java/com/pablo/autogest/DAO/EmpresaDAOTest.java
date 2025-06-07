package com.pablo.autogest.DAO;

import com.pablo.autogest.DTO.EmpresaDTO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpresaDAOTest {

    private static EmpresaDAO empresaDAO;
    private static int empresaCriadaId;

    @BeforeAll
    static void setup() {
        empresaDAO = new EmpresaDAO();
    }

    @Test
    @Order(1)
    void testAdicionarEmpresa() throws SQLException, ClassNotFoundException {
        EmpresaDTO empresa = new EmpresaDTO();
        empresa.setNome("Empresa Teste");
        empresa.setEndereco("Rua Teste, 123");
        empresa.setTelefone("123456789");

        empresaDAO.adicionarEmpresa(empresa);

        List<EmpresaDTO> empresas = empresaDAO.listarEmpresas();
        EmpresaDTO ultima = empresas.get(empresas.size() - 1);
        empresaCriadaId = ultima.getId();

        assertEquals("Empresa Teste", ultima.getNome());
    }

    @Test
    @Order(2)
    void testListarEmpresas() {
        List<EmpresaDTO> empresas = empresaDAO.listarEmpresas();
        assertNotNull(empresas);
        assertTrue(empresas.size() > 0);
    }

    @Test
    @Order(3)
    void testBuscarEmpresaPorId() {
        EmpresaDTO empresa = empresaDAO.buscarEmpresaPorId(empresaCriadaId);
        assertNotNull(empresa);
        assertEquals("Empresa Teste", empresa.getNome());
    }

    @Test
    @Order(4)
    void testAtualizarEmpresa() {
        EmpresaDTO nova = new EmpresaDTO();
        nova.setNome("Empresa Atualizada");
        nova.setEndereco("Rua Nova, 456");
        nova.setTelefone("987654321");

        empresaDAO.atualizarEmpresa(empresaCriadaId, nova);

        EmpresaDTO atualizada = empresaDAO.buscarEmpresaPorId(empresaCriadaId);
        assertEquals("Empresa Atualizada", atualizada.getNome());
    }

    @Test
    @Order(5)
    void testExcluirEmpresa() throws SQLException, ClassNotFoundException {
        empresaDAO.excluirEmpresa(empresaCriadaId);
        EmpresaDTO excluida = empresaDAO.buscarEmpresaPorId(empresaCriadaId);
        assertNull(excluida);
    }
}
