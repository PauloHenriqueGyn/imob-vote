package br.com.imobvote.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.imobvote.modelo.vo.EmpreendimentoVO;
import br.com.imobvote.persistencia.EmpreendimentoDAO;

@Transactional
@Service
public class EmpreendimentoBC {

	@Autowired
	private EmpreendimentoDAO empreendimentoDAO;
	
	public List<EmpreendimentoVO> listarEmpreedimentos() {
		return empreendimentoDAO.listarEmpreendimentos();
	}
}
