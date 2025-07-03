package io.github.caua_moreto.criptografia.impl;

import io.github.caua_moreto.criptografia.interfac.*;

public class CriptografiaInversaoImpl implements CriptografiaInterface {

    @Override
    public String criptografar(String textoLimpo) {
        if (textoLimpo == null) return null;
        return new StringBuilder(textoLimpo).reverse().toString();
    }

    @Override
    public String descriptografar(String textoCriptografado) {
        // A lógica de inversão é a mesma para criptografar e descriptografar.
        if (textoCriptografado == null) return null;
        return new StringBuilder(textoCriptografado).reverse().toString();
    }
}
