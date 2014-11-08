/**
 * 
 */
package com.sqli.echallenge.formation.web.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.metier.HabilitationScoreMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.model.Habilitation;
import com.sqli.echallenge.formation.model.HabilitationScore;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class AddHabilitationScoreAjaxAction extends SqliBasicAction {
	private static final long serialVersionUID = -2896401833315200978L;
	
	@Autowired
	public HabilitationScoreMetier habilitationScoreMetier;
	@Autowired
	public HabilitationMetier habilitationMetier;
	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private String status;
	
	private Long idCollaborateur;
	private Long idHabilitation;
	private Integer score;
	
	@Override
	public String execute() throws Exception {
		try {
			Collaborateur collaborateur = collaborateurMetier.getCollaborateur(idCollaborateur);
			Habilitation habilitation = habilitationMetier.getHabilitation(idHabilitation);
			
			HabilitationScore habilitationScore = new HabilitationScore();
			habilitationScore.setCollaborateur(collaborateur);
			habilitationScore.setHabilitation(habilitation);
			habilitationScore.setScoreHabilitation(score);
			
			habilitationScoreMetier.addHabilitationScore(habilitationScore);
			
			status = ActionSupport.SUCCESS;
		} catch (Exception e) {
			status = ActionSupport.ERROR;
		}
		
		return ActionSupport.NONE;
	}

	public Long getIdCollaborateur() {
		return idCollaborateur;
	}

	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}

	public Long getIdHabilitation() {
		return idHabilitation;
	}

	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		if(score == null) this.score = 1;
		if(score < 1 || score > 5) this.score = 1;
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
