/**
 * 
 */
package com.sqli.echallenge.formation.web.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.HabilitationScoreMetier;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class DeleteHabilitationScoreAjaxAction extends SqliBasicAction {
	private static final long serialVersionUID = 7556224515517828276L;

	@Autowired
	public HabilitationScoreMetier habilitationScoreMetier;
	
	private Long idHabilitationScore;//idHabilitationScore
	private String status;
	
	@Override
	public String execute() throws Exception {
		try {
			habilitationScoreMetier.removeHabililitationScore(idHabilitationScore);
			status = ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			status = ActionSupport.ERROR;
		}
		return ActionSupport.NONE;
	}

	public Long getIdHabilitationScore() {
		return idHabilitationScore;
	}

	public void setIdHabilitationScore(Long idHabilitationScore) {
		this.idHabilitationScore = idHabilitationScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
