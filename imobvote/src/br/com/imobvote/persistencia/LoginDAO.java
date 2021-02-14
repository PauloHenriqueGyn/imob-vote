package br.com.imobvote.persistencia;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.imobvote.arquitetura.base.BaseDAO;
import br.com.imobvote.modelo.vo.LoginVO;

@Repository
public class LoginDAO extends BaseDAO {

	public LoginVO buscaUsuarioPorSenhaMd5(String email, String senhaMd5) {
		StringBuilder hql = new StringBuilder();
    	hql.append(" SELECT login FROM ");
        hql.append(LoginVO.class.getSimpleName()).append(" login ");
        hql.append(" WHERE ");
        hql.append("  login.email = :email");
		hql.append("  AND login.senha = :senha");
		
		Query createQuery = getEntityManager().createQuery(hql.toString());
        createQuery.setParameter("email", email);
        createQuery.setParameter("senha", senhaMd5);
        return (LoginVO) createQuery.getSingleResult();
	}
}
