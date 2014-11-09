package com.sqli.echallenge.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.model.Profil;


@Repository
@Transactional
public class ProfilDaoImpl implements ProfilDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Profil getProfil(Long idProfil) throws Exception {
		return entityManager.find(Profil.class, idProfil);
	}
	
	public Profil getProfil(String nomProfil) throws Exception {
		Query query = entityManager.createNamedQuery("from Profil where nomProfil=:nomProfil");
		query.setParameter("nomProfil", nomProfil);
		return (Profil) query.getSingleResult();
	}

	public void addProfil(Profil profil) throws Exception {
		entityManager.persist(profil);
	}

	public void removeProfil(Long idProfil) throws Exception {
		entityManager.remove(getProfil(idProfil));
	}

	public void updateProfil(Profil profil) throws Exception {
		entityManager.merge(profil);
	}

	@SuppressWarnings("unchecked")
	public List<Profil> getAllProfils() throws Exception {
		Query query = entityManager.createQuery("from Profil");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
