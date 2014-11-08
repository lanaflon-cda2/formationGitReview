/**
 * 
 */
package com.sqli.echallenge.formation.web.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.HabilitationScoreMetier;
import com.sqli.echallenge.formation.model.HabilitationScore;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class UpdateHabilitationScoreAjaxAction extends SqliBasicAction {
	private static final long serialVersionUID = 4779838472239091832L;

	@Autowired
	public HabilitationScoreMetier habilitationScoreMetier;
	
	private String status;
	
	private Long idHabilitationScore;
	private Integer score;
	
	@Override
	public String execute() throws Exception {
		try {
			HabilitationScore habilitationScore = habilitationScoreMetier.getHabilitationScore(idHabilitationScore);
			habilitationScore.setScoreHabilitation(score);
			
			habilitationScoreMetier.updateHabilitationScore(habilitationScore);
			setStatus(ActionSupport.SUCCESS);
		} catch (Exception e) {
			setStatus(ActionSupport.ERROR);
		}
		
		return ActionSupport.NONE;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getIdHabilitationScore() {
		return idHabilitationScore;
	}

	public void setIdHabilitationScore(Long idHabilitationScore) {
		this.idHabilitationScore = idHabilitationScore;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		if(score == null) this.score = 1;
		if(score < 1 || score > 5) this.score = 1;
		this.score = score;
	}
	
}
