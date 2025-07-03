package io.github.caua_moreto.criptografia.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Testa a funcionalidade de Inversão

class CriptografiaInversaoImplTest {

    private CriptografiaInversaoImpl criptografador;

    @BeforeEach
    void setUp() {
        criptografador = new CriptografiaInversaoImpl();
    }

    @Test
    @DisplayName("Deve criptografar um texto invertendo os caracteres")
    void testCriptografar() {
        String original = "C.A.U.A";
        String esperado = "A.U.A.C"; // O reverso de "C.A.U.A"
        String resultado = criptografador.criptografar(original);
        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Deve descriptografar um texto revertendo a inversao")
    void testDescriptografar() {
        String criptografado = "A.U.A.C";
        String esperado = "C.A.U.A";
        String resultado = criptografador.descriptografar(criptografado);
        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("A criptografia e descriptografia devem ser reversiveis")
    void testReversibilidade() {
        String original = "teste de reversibilidade";
        String criptografado = criptografador.criptografar(original);
        String revertido = criptografador.descriptografar(criptografado);
        assertEquals(original, revertido);
    }
}