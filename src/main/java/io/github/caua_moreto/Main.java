package io.github.caua_moreto;

import io.github.caua_moreto.criptografia.interfac.CriptografiaInterface;
import io.github.caua_moreto.criptografia.impl.CriptografiaBase64Impl;
import io.github.caua_moreto.criptografia.impl.CriptografiaInversaoImpl;

public class Main {

    public static void main(String[] args) {
        // PRINCIPIO DA INVERSÃO DE DEPENDÊNCIA (DIP):
        // Criamos instâncias das classes concretas (baixo nível)...
        CriptografiaInterface criptoBase64 = new CriptografiaBase64Impl();
        CriptografiaInterface criptoInversao = new CriptografiaInversaoImpl();

        String texto = "Teste de Criptografia - Caua";

        System.out.println("--- Implementacao Base64 ---");
        demonstrarCriptografia(criptoBase64, texto);

        System.out.println("\n--- Implementacao por Inversao ---");
        demonstrarCriptografia(criptoInversao, texto);
    }

    public static void demonstrarCriptografia(CriptografiaInterface criptografador, String textoOriginal) {
        System.out.println("Texto Original: " + textoOriginal);

        String textoCriptografado = criptografador.criptografar(textoOriginal);
        System.out.println("Texto Criptografado: " + textoCriptografado);

        String textoDescriptografado = criptografador.descriptografar(textoCriptografado);
        System.out.println("Texto Descriptografado: " + textoDescriptografado);

        if (textoOriginal.equals(textoDescriptografado)) {
            System.out.println("Status: SUCESSO - O texto foi revertido corretamente.");
        } else {
            System.out.println("Status: FALHA - O texto nao foi revertido.");
        }
    }
}