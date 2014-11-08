/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.metier.HabilitationScoreMetier;
import com.sqli.echallenge.formation.model.Habilitation;
import com.sqli.echallenge.formation.model.HabilitationScore;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class HabilitationScoreListAction extends SqliBasicAction {
	private static final long serialVersionUID = 5428985100408645071L;

	@Autowired
	public HabilitationScoreMetier habilitationScoreMetier;
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long id;//idCollaborateur
	private List<HabilitationScore> habilitationScores;
	private List<Habilitation> habilitations;
	
	@Override
	public String execute() throws Exception {
		try {
			habilitationScores = habilitationScoreMetier.getAllHabilitationScores(id);
			setHabilitations(habilitationMetier.getAllHabilitations());
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("listHabilitationScore.error.load.fail"));
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getId() {
		return id;
	}

	public void setId(Long idCollaborateur) {
		this.id = idCollaborateur;
	}

	public List<HabilitationScore> getHabilitationScores() {
		return habilitationScores;
	}

	public void setHabilitationScores(List<HabilitationScore> habilitationScores) {
		this.habilitationScores = habilitationScores;
	}

	public List<Habilitation> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(List<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}
}
