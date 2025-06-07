package com.pablo.autogest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoGestTest {

    @Test
    void testMainExecutaSemErros() {
        try {
            AutoGest.main(new String[]{}); // chama o metodo main
        } catch (Exception e) {
            fail("main nao deveria lancar excecao"); // testa se roda sem erro
        }
    }
}
