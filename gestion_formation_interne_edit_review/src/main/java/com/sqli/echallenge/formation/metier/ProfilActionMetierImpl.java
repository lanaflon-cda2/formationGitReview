/**
 * 
 */
package com.sqli.echallenge.formation.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.ProfilActionDao;

/**
 * @author Mouad
 *
 */
@Service
@Transactional
public class ProfilActionMetierImpl implements ProfilActionMetier {

	@Autowired
	private ProfilActionDao dao;
	
	public void removeAllActionsFromProfil(Long idProfil) throws Exception {
		dao.removeAllActionsFromProfil(idProfil);
	}

	public void addActionToProfil(Long idAction, Long idProfil) throws Exception {
		dao.addActionToProfil(idAction, idProfil);
	}

	public void addActionsToProfil(Long[] idActions, Long idProfil) throws Exception {
		if(idActions != null){
			for(Long idAction : idActions){
				dao.addActionToProfil(idAction, idProfil);
			}
		}
	}

	public ProfilActionDao getDao() {
		return dao;
	}

	public void setDao(ProfilActionDao dao) {
		this.dao = dao;
	}
	
}
