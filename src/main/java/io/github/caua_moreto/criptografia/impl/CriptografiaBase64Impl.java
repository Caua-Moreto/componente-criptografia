package io.github.caua_moreto.criptografia.impl;

import io.github.caua_moreto.criptografia.interfac.CriptografiaInterface;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

// PRINCIPIO SOLID ATENDIDO
//  3. PRINCÍPIO DA RESPONSABILIDADE ÚNICA (Single Responsibility Principle - SRP):
//   - A única responsabilidade desta classe é realizar a criptografia e descriptografia usando o algoritmo Base64.

public class CriptografiaBase64Impl implements CriptografiaInterface {

    @Override
    public String criptografar(String textoLimpo) {
        if (textoLimpo == null) return null;
        return new String(Base64.getEncoder().encode(textoLimpo.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public String descriptografar(String textoCriptografado) {
        if (textoCriptografado == null) return null;
        return new String(Base64.getDecoder().decode(textoCriptografado.getBytes(StandardCharsets.UTF_8)));
    }
}