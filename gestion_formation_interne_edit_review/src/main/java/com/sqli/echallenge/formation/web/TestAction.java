/**
 * 
 */
package com.sqli.echallenge.formation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.model.Profil;

/**
 * @author Mouad
 *
 */
@Controller
public class TestAction extends SqliBasicAction {
	private static final long serialVersionUID = 1704543259641668411L;

	@Autowired
	public ProfilMetier profilMetier;
	
	@Override
	public String execute() throws Exception {
		try {
			Profil p = profilMetier.getProfil("Administrateur");
			
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
