package br.com.imobvote.controle.seg;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenJWTUtil {

	private static final KeyGenerator keyGenerator = new KeyGenerator();
	
	public static String gerarToken(String usuario) {

        Key key = keyGenerator.generateKey();

        Map<String, Object> map = new HashMap<>();
        map.put("usuario", usuario);

        String jwtToken = Jwts.builder()
    		.setId(UUID.randomUUID().toString())
            .signWith(SignatureAlgorithm.HS256, key)
            .setHeaderParam("typ", "JWT")
            .setSubject("TokenSubject")
            .setIssuedAt(new Date())
            .setExpiration(toDate(LocalDateTime.now().plusHours(12L)))
            .addClaims(map)
            .compact();

        System.out.println("Token gerado: " + jwtToken);
        return jwtToken;
    }
	
	/**
     * Metodo para tratar o Date que será inserido no token
     *
     * @param localDateTime data a ser convertida
     * @return date convertida
     */
    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
