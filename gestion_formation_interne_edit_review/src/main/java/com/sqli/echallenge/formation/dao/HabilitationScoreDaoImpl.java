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

import com.sqli.echallenge.formation.model.HabilitationScore;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class HabilitationScoreDaoImpl implements HabilitationScoreDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public HabilitationScore getHabilitationScore(Long idHabilitationScore) throws Exception {
		Query query = entityManager.createQuery("from HabilitationScore where idHabilitationScore=:id");
		query.setParameter("id", idHabilitationScore);
		return (HabilitationScore) query.getSingleResult();
	}
	
	public void addHabilitationScore(HabilitationScore habilitationScore) throws Exception {
		entityManager.persist(habilitationScore);
	}

	public void removeHabililitationScore(Long idHabilitationScore) throws Exception {
		entityManager.remove(getHabilitationScore(idHabilitationScore));
	}
	
	//Update = update score
	public void updateHabilitationScore(HabilitationScore habilitationScore) throws Exception {
		entityManager.merge(habilitationScore);
	}

	@SuppressWarnings("unchecked")
	public List<HabilitationScore> getAllHabilitationScores(Long idCollaborateur) throws Exception {
		Query query = entityManager.createQuery("from HabilitationScore where collaborateur.idCollaborateur=:id");
		query.setParameter("id", idCollaborateur);
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
