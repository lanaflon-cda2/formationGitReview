/**
 * 
 */
package com.sqli.echallenge.formation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.HabilitationScoreDao;
import com.sqli.echallenge.formation.model.HabilitationScore;

/**
 * @author Mouad
 *
 */
@Service
@Transactional
public class HabilitationScoreMetierImpl implements HabilitationScoreMetier {

	@Autowired
	private HabilitationScoreDao dao;
	
	public HabilitationScore getHabilitationScore(Long idHabilitationScore) throws Exception {
		return dao.getHabilitationScore(idHabilitationScore);
	}

	public void addHabilitationScore(HabilitationScore habilitationScore) throws Exception {
		dao.addHabilitationScore(habilitationScore);
	}

	public void removeHabililitationScore(Long idHabilitationScore)	throws Exception {
		dao.removeHabililitationScore(idHabilitationScore);
	}

	public void updateHabilitationScore(HabilitationScore habilitationScore) throws Exception {
		dao.updateHabilitationScore(habilitationScore);
	}

	public List<HabilitationScore> getAllHabilitationScores(Long idCollaborateur) throws Exception {
		return dao.getAllHabilitationScores(idCollaborateur);
	}

	public HabilitationScoreDao getDao() {
		return dao;
	}

	public void setDao(HabilitationScoreDao dao) {
		this.dao = dao;
	}

}
