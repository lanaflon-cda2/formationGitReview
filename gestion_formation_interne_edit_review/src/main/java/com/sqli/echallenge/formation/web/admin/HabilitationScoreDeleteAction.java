/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

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
public class HabilitationScoreDeleteAction extends SqliBasicAction {
	private static final long serialVersionUID = 3061853567286534256L;

	@Autowired
	public HabilitationScoreMetier habilitationScoreMetier;
	
	//idHabilitationScore
	private Long id;
	
	@Override
	public String execute() throws Exception {
		try {
			habilitationScoreMetier.removeHabililitationScore(id);
			
			setSessionActionMessageText(getText("deleteHabilitationScore.message.delete.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("deleteHabilitationScore.error.delete.fail"));
			return ActionSupport.ERROR;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
