package br.com.imobvote.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.imobvote.arquitetura.base.BaseDAO;
import br.com.imobvote.modelo.vo.EmpreendimentoVO;

@Repository
public class EmpreendimentoDAO extends BaseDAO {

	public List<EmpreendimentoVO> listarEmpreendimentos() {
		StringBuilder hql = new StringBuilder();
    	hql.append(" SELECT e FROM ");
        hql.append(EmpreendimentoVO.class.getSimpleName()).append(" e ");
		
		Query createQuery = getEntityManager().createQuery(hql.toString());
        return createQuery.getResultList();		
	}
}
