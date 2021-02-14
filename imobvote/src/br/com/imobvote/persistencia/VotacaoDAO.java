package br.com.imobvote.persistencia;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.imobvote.arquitetura.base.BaseDAO;
import br.com.imobvote.modelo.vo.EmpreendimentoVO;
import br.com.imobvote.modelo.vo.VotacaoVO;

@Repository
public class VotacaoDAO extends BaseDAO {

	public VotacaoVO insere(VotacaoVO entity) {
		getEntityManager().persist(entity);
		return entity;
	}
	
	public Integer totalVotacoes() {
		StringBuilder hql = new StringBuilder();
    	hql.append(" SELECT COUNT(*) FROM ");
        hql.append(VotacaoVO.class.getSimpleName()).append(" e ");
		
		Query createQuery = getEntityManager().createQuery(hql.toString());
		try {
			return (Integer) createQuery.getSingleResult();		
		} catch (NoResultException nre) {
			return 0;
		}
	}
	
//	public List<EmpreendimentoVO> listarEmpreendimentos() {
//		StringBuilder hql = new StringBuilder();
//    	hql.append(" SELECT e FROM ");
//        hql.append(EmpreendimentoVO.class.getSimpleName()).append(" e ");
//		
//		Query createQuery = getEntityManager().createQuery(hql.toString());
//        return createQuery.getResultList();		
//	}
	
}
