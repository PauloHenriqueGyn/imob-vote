package br.com.imobvote.controle.seg;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

public class KeyGenerator {

	/**
     * Metodo responsavel por gerar a secret key que sera utilizado no token
     *
     * @return key criptografada para o token
     */
    public Key generateKey() {
        String keyString = "GyhHEYyLLJUKJeABcqo0YO+QUd6ERarphT2go9S2i94=";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HmacSHA256");
    }
}
