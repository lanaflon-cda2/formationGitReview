/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.model.Habilitation;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class HabilitationInfoAction extends SqliBasicAction {
	private static final long serialVersionUID = 5677488292196483352L;

	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long id;
	
	private Habilitation habilitation;
	
	@Override
	public String execute() throws Exception {
		try {
			
			setHabilitation(habilitationMetier.getHabilitation(id));
			return ActionSupport.SUCCESS;
		
		} catch (Exception e) {
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

	public Habilitation getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(Habilitation habilitation) {
		this.habilitation = habilitation;
	}
}
