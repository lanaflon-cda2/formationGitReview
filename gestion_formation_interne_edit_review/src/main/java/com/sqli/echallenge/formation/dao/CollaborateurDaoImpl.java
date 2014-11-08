package com.sqli.echallenge.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.model.Collaborateur;

/**
 * @author Mouad
 *
 */
@Repository
@Transactional
public class CollaborateurDaoImpl implements CollaborateurDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Collaborateur getCollaborateur(Long idCollaborateur) throws Exception {
		//return entityManager.find(Collaborateur.class, idCollaborateur);
		Query query = entityManager.createQuery("from Collaborateur where idCollaborateur=:id");
		query.setParameter("id", idCollaborateur);
		return (Collaborateur) query.getSingleResult();
	}

	public void addCollaborateur(Collaborateur collaborateur) throws Exception {
		entityManager.persist(collaborateur);
	}

	public void removeCollaborateur(Long idCollaborateur) throws Exception {
		entityManager.remove(getCollaborateur(idCollaborateur));
	}

	public void updateCollaborateur(Collaborateur collaborateur) throws Exception {
		entityManager.merge(collaborateur);
	}

	@SuppressWarnings("unchecked")
	public List<Collaborateur> getAllCollaborateurs() throws Exception {
		Query query = entityManager.createQuery("from Collaborateur");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
