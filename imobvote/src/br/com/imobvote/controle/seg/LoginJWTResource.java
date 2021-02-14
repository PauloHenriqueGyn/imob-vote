package br.com.imobvote.controle.seg;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobvote.modelo.dto.LoginDTO;
import br.com.imobvote.modelo.vo.LoginVO;
import br.com.imobvote.negocio.LoginBC;

@RestController
public class LoginJWTResource {

	@Autowired
	private LoginBC loginBC;
	
	@PostMapping("login")
    public ResponseEntity<LoginDTO> autenticarUsuario(@RequestBody LoginDTO loginDTO) throws Exception {
    	ResponseEntity<LoginDTO> response = null;
    	try {
    		LoginVO loginVO = loginBC.autenticaUsuario(loginDTO);
			if (loginVO != null) {
				loginDTO.setToken(TokenJWTUtil.gerarToken(loginDTO.getEmail()));
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + loginDTO.getToken());
    			response = new ResponseEntity<LoginDTO>(loginDTO, headers, HttpStatus.OK);
			} else {
				throw new Exception("Usuário não autenticado");
			}
    	}catch (NoResultException e) {
    		throw new Exception("Usuário não autenticado.");
		}
    	return response;
    }
}
