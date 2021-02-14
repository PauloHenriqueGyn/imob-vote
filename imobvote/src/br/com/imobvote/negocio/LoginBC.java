package br.com.imobvote.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import br.com.imobvote.modelo.dto.LoginDTO;
import br.com.imobvote.modelo.vo.LoginVO;
import br.com.imobvote.persistencia.LoginDAO;

@Transactional
@Service
public class LoginBC {

	@Autowired
	private LoginDAO loginDAO;
	
	public LoginVO autenticaUsuario(LoginDTO loginDTO) {
		String senhaMd5Hex = DigestUtils.md5DigestAsHex(loginDTO.getSenha().getBytes()).toUpperCase();
		return loginDAO.buscaUsuarioPorSenhaMd5(loginDTO.getEmail(), senhaMd5Hex);
	}
	
}