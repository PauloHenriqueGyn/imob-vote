package br.com.imobvote.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import br.com.imobvote.modelo.dto.LoginDTO;
import br.com.imobvote.modelo.vo.LoginVO;
import br.com.imobvote.modelo.vo.VotacaoVO;
import br.com.imobvote.persistencia.VotacaoDAO;

@Transactional
@Service
public class VotacaoBC {

	@Autowired
	private VotacaoDAO votacaoDAO;
	
	public VotacaoVO insere(VotacaoVO votacaoVO) {
		return votacaoDAO.insere(votacaoVO);
	}
	
	public Integer totalVotacoes() {
		return votacaoDAO.totalVotacoes();
	}
}
