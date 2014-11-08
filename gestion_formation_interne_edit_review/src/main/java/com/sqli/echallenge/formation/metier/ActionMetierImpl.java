package com.sqli.echallenge.formation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.ActionDao;
import com.sqli.echallenge.formation.model.Action;


@Service
@Transactional
public class ActionMetierImpl implements ActionMetier {

	
	@Autowired
	private ActionDao dao;
	
	public Action getAction(Long idAction) throws Exception {
		return dao.getAction(idAction);
	}

	public void addAction(Action action) throws Exception {
		dao.addAction(action);
	}

	public void removeAction(Long idAction) throws Exception {
		dao.removeAction(idAction);
	}

	public void updateAction(Action action) throws Exception {
		dao.updateAction(action);
	}

	public List<Action> getAllActions() throws Exception {
		return dao.getAllActions();
	}

	public ActionDao getDao() {
		return dao;
	}

	public void setDao(ActionDao dao) {
		this.dao = dao;
	}

}
