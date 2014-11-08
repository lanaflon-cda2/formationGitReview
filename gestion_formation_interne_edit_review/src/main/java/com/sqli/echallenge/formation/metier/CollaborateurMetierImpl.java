/**
 * 
 */
package com.sqli.echallenge.formation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.CollaborateurDao;
import com.sqli.echallenge.formation.model.Collaborateur;

/**
 * @author Mouad
 *
 */
@Service
@Transactional
public class CollaborateurMetierImpl implements CollaborateurMetier {

	@Autowired
	private CollaborateurDao dao;
	
	public Collaborateur getCollaborateur(Long idCollaborateur) throws Exception {
		return dao.getCollaborateur(idCollaborateur);
	}

	public void addCollaborateur(Collaborateur collaborateur) throws Exception {
		dao.addCollaborateur(collaborateur);
	}

	public void removeCollaborateur(Long idCollaborateur) throws Exception {
		dao.removeCollaborateur(idCollaborateur);
	}

	public void updateCollaborateur(Collaborateur collaborateur) throws Exception {
		dao.updateCollaborateur(collaborateur);
	}

	public List<Collaborateur> getAllCollaborateurs() throws Exception {
		return dao.getAllCollaborateurs();
	}

	public CollaborateurDao getDao() {
		return dao;
	}

	public void setDao(CollaborateurDao dao) {
		this.dao = dao;
	}

}
