/**
 * 
 */
package com.sqli.echallenge.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class ProfilActionDaoImpl implements ProfilActionDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void removeAllActionsFromProfil(Long idProfil) throws Exception {
		Query query = entityManager.createNativeQuery("DELETE FROM PROFIL_ACTION WHERE ID_PROFIL=:idProfil");
		query.setParameter("idProfil", idProfil);
		
		query.executeUpdate();
	}

	public void addActionToProfil(Long idAction, Long idProfil) throws Exception {
		Query query = entityManager.createNativeQuery("INSERT INTO PROFIL_ACTION (ID_PROFIL, ID_ACTION) VALUES (:idProfil, :idAction)");
		query.setParameter("idProfil", idProfil);
		query.setParameter("idAction", idAction);
		
		query.executeUpdate();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
