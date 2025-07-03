package io.github.caua_moreto.criptografia.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//  Testa especificamente a implementação CriptografiaBase64Impl.

class CriptografiaBase64ImplTest {

    private CriptografiaBase64Impl criptografador;

    @BeforeEach
    void setUp() {
        criptografador = new CriptografiaBase64Impl();
    }

    @Test
    @DisplayName("Deve criptografar um texto em Base64 corretamente")
    void testCriptografar() {
        String original = "texto confidencial";
        String esperado = "dGV4dG8gY29uZmlkZW5jaWFs";
        String resultado = criptografador.criptografar(original);
        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Deve descriptografar um texto em Base64 corretamente")
    void testDescriptografar() {
        String criptografado = "dGV4dG8gY29uZmlkZW5jaWFs";
        String esperado = "texto confidencial";
        String resultado = criptografador.descriptografar(criptografado);
        assertEquals(esperado, resultado);
    }
}