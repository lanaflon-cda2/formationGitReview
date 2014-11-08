/**
 * 
 */
package com.sqli.echallenge.formation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.HabilitationDao;
import com.sqli.echallenge.formation.model.Habilitation;

/**
 * @author Mouad
 *
 */
@Service
@Transactional
public class HabilitationMetierImpl implements HabilitationMetier {
	
	@Autowired
	private HabilitationDao dao;
	
	public Habilitation getHabilitation(Long idHabilitation) throws Exception {
		return dao.getHabilitation(idHabilitation);
	}

	public void addHabilitation(Habilitation habilitation) throws Exception {
		dao.addHabilitation(habilitation);
	}

	public void removeHabilitation(Long idHabilitation) throws Exception {
		dao.removeHabilitation(idHabilitation);
	}

	public void updateHabilitation(Habilitation habilitation) throws Exception {
		dao.updateHabilitation(habilitation);
	}

	public List<Habilitation> getAllHabilitations() throws Exception {
		return dao.getAllHabilitations();
	}

	public HabilitationDao getDao() {
		return dao;
	}

	public void setDao(HabilitationDao dao) {
		this.dao = dao;
	}

}
