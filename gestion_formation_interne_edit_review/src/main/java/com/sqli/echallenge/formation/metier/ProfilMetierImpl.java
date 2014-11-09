package com.sqli.echallenge.formation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.dao.ProfilDao;
import com.sqli.echallenge.formation.model.Profil;


@Service
@Transactional
public class ProfilMetierImpl implements ProfilMetier {

	@Autowired
	private ProfilDao dao;
	
	public Profil getProfil(Long idProfil) throws Exception {
		return dao.getProfil(idProfil);
	}
	
	public Profil getProfil(String nomProfil) throws Exception {
		return dao.getProfil(nomProfil);
	}
	

	public void addProfil(Profil profil) throws Exception {
		dao.addProfil(profil);
	}

	public void removeProfil(Long idProfil) throws Exception {
		dao.removeProfil(idProfil);
	}

	public void updateProfil(Profil profil) throws Exception {
		dao.updateProfil(profil);
	}

	public List<Profil> getAllProfils() throws Exception {
		return dao.getAllProfils();
	}

	public ProfilDao getDao() {
		return dao;
	}

	public void setDao(ProfilDao dao) {
		this.dao = dao;
	}

}
