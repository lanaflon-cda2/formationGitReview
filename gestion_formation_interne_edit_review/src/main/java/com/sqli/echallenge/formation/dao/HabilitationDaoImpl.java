/**
 * 
 */
package com.sqli.echallenge.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.model.Habilitation;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class HabilitationDaoImpl implements HabilitationDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Habilitation getHabilitation(Long idHabilitation) throws Exception {
		//return entityManager.find(Habilitation.class, idHabilitation);
		Query query = entityManager.createQuery("from Habilitation where idHabilitation=:id");
		query.setParameter("id", idHabilitation);
		return (Habilitation) query.getSingleResult();
	}

	public void addHabilitation(Habilitation habilitation) throws Exception {
		entityManager.persist(habilitation);
	}

	public void removeHabilitation(Long idHabilitation) throws Exception {
		entityManager.remove(getHabilitation(idHabilitation));
	}

	public void updateHabilitation(Habilitation habilitation) throws Exception {
		entityManager.merge(habilitation);
	}

	@SuppressWarnings("unchecked")
	public List<Habilitation> getAllHabilitations() throws Exception {
		Query query = entityManager.createQuery("from Habilitation");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
