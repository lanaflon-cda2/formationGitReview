package com.sqli.echallenge.formation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.UtilisateurDao;
import com.sqli.echallenge.formation.model.Utilisateur;

@Service
@Transactional
public class UtilisateurMetierImpl implements UtilisateurMetier {

	@Autowired
	private UtilisateurDao dao;
	
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception {
		return dao.getUtilisateur(idUtilisateur);
	}
	
	public Utilisateur getUtilisateur(String email, String password) throws Exception {
		return dao.getUtilisateur(email, password);
	}


	public void addUtilisateur(Utilisateur utilisateur) throws Exception {
		dao.addUtilisateur(utilisateur);
	}

	public void removeUtilisateur(Long idUtilisateur) throws Exception {
		dao.removeUtilisateur(idUtilisateur);
	}

	public void updateUtilisateur(Utilisateur utilisateur) throws Exception {
		dao.updateUtilisateur(utilisateur);
	}

	public List<Utilisateur> getAllUtilisateurs() throws Exception {
		return dao.getAllUtilisateurs();
	}

	public UtilisateurDao getDao() {
		return dao;
	}

	public void setDao(UtilisateurDao dao) {
		this.dao = dao;
	}

}
