package com.sqli.echallenge.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.model.Action;


@Repository
@Transactional
public class ActionDaoImpl implements ActionDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Action getAction(Long idAction) throws Exception {
		return entityManager.find(Action.class, idAction);
	}

	public void addAction(Action action) throws Exception {
		entityManager.persist(action);
	}

	public void removeAction(Long idAction) throws Exception {
		entityManager.remove(getAction(idAction));
	}

	public void updateAction(Action action) throws Exception {
		entityManager.merge(action);
	}

	@SuppressWarnings("unchecked")
	public List<Action> getAllActions() throws Exception {
		Query query = entityManager.createQuery("from Action");
		return query.getResultList();
	}

}
