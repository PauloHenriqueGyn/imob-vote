package br.com.imobvote.controle;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imobvote.modelo.vo.EmpreendimentoVO;
import br.com.imobvote.negocio.EmpreendimentoBC;

@RestController
@RequestMapping("empreendimentos")
public class EmpreendimentoWS implements Serializable {

	private static final long serialVersionUID = 2253090608033855039L;
	
	private final EmpreendimentoBC empreendimentoBC;
	
	@Autowired
	public EmpreendimentoWS(EmpreendimentoBC empreendimentoBC) {
		this.empreendimentoBC = empreendimentoBC;
	}
	
//	@PostMapping("buscaPorId")
//	public ResponseEntity<ProdutoVO> buscaPorId(@Valid @RequestBody ProdutoVO produtoVO) throws Exception {
//		if (produtoVO != null) {
//            produtoVO = produtoBC.buscaPorId(produtoVO.getId(), false, false);
//            return ResponseEntity.ok(produtoVO);
//        }
//		return ResponseEntity.badRequest().body(produtoVO);
//	}
	
	@GetMapping("listarEmpreendimentos")
    public ResponseEntity<List<EmpreendimentoVO>> listarEmpreedimentos() throws Exception {
		List<EmpreendimentoVO> lista = empreendimentoBC.listarEmpreedimentos();
		return ResponseEntity.ok(lista);
    }

}
