package br.com.imobvote.controle;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobvote.modelo.vo.VotacaoVO;
import br.com.imobvote.negocio.VotacaoBC;

@RestController
@RequestMapping("votacoes")
public class VotacaoWS implements Serializable {

	private final VotacaoBC votacaoBC;
	
	@Autowired
	public VotacaoWS(VotacaoBC votacaoBC) {
		this.votacaoBC = votacaoBC;
	}
	
	@PostMapping("insereSim")
	public ResponseEntity<VotacaoVO> insereSim(@RequestBody VotacaoVO votacaoVO) throws Exception {
		votacaoVO.setVoto(true);
		return ResponseEntity.ok(votacaoBC.insere(votacaoVO));
	}

	@PostMapping("insereNao")
	public ResponseEntity<VotacaoVO> insereNao(@RequestBody VotacaoVO votacaoVO) throws Exception {
		votacaoVO.setVoto(false);
		return ResponseEntity.ok(votacaoBC.insere(votacaoVO));
	}

	@GetMapping("totalVotacoes")
	public ResponseEntity<Integer> totalVotacoes() throws Exception {
		return ResponseEntity.ok(votacaoBC.totalVotacoes());
	}
	
}
