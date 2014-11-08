/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class HabilitationDeleteAction extends SqliBasicAction {
	private static final long serialVersionUID = -7126813807042170075L;
	
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long id;
		
	@Override
	public String execute() throws Exception {
		try {
			habilitationMetier.removeHabilitation(id);
			setSessionActionMessageText(getText("deleteHabilitation.error.delete.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			setSessionActionErrorText(getText("deleteHabilitation.error.delete.fail"));
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
