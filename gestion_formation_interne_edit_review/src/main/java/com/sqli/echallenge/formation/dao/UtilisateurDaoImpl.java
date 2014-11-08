package com.sqli.echallenge.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.model.Utilisateur;

@Repository
@Transactional
public class UtilisateurDaoImpl implements UtilisateurDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception {
		return entityManager.find(Utilisateur.class, idUtilisateur);
	}

	public Utilisateur getUtilisateur(String email, String password) throws Exception {
		Query query = entityManager.createQuery("from Utilisateur where emailUtilisateur=:email and passwordUtilisateur=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		
		return (Utilisateur) query.getSingleResult();
	}
	
	public void addUtilisateur(Utilisateur utilisateur) throws Exception {
		entityManager.persist(utilisateur);
	}

	public void removeUtilisateur(Long idUtilisateur) throws Exception {
		entityManager.remove(getUtilisateur(idUtilisateur));
	}

	public void updateUtilisateur(Utilisateur utilisateur) throws Exception {
		entityManager.merge(utilisateur);
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getAllUtilisateurs() throws Exception {
		Query query = entityManager.createQuery("from Utilisateur");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
