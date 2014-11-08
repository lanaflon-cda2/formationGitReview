/**
 * 
 */
package com.sqli.echallenge.formation.web.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.HabilitationMetier;
import com.sqli.echallenge.formation.model.Habilitation;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class GetHabilitationAjaxAction extends SqliBasicAction {
	private static final long serialVersionUID = -2524668479734635391L;
	
	@Autowired
	public HabilitationMetier habilitationMetier;
	
	private Long idHabilitation;
	private String status;
	
	private String nomHabilitation;
	private String descriptionHabilitation;
	
	public String execute() throws Exception {
		try {
			Habilitation habilitation = habilitationMetier.getHabilitation(idHabilitation);
			nomHabilitation = habilitation.getNomHabilitation();
			descriptionHabilitation = habilitation.getDescriptionHabilitation();
			
			status = ActionSupport.SUCCESS;
		} catch (Exception e) {
			status = ActionSupport.ERROR;
		}
		
		return ActionSupport.NONE;
	}

	public Long getIdHabilitation() {
		return idHabilitation;
	}

	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomHabilitation() {
		return nomHabilitation;
	}

	public void setNomHabilitation(String nomHabilitation) {
		this.nomHabilitation = nomHabilitation;
	}

	public String getDescriptionHabilitation() {
		return descriptionHabilitation;
	}

	public void setDescriptionHabilitation(String descriptionHabilitation) {
		this.descriptionHabilitation = descriptionHabilitation;
	}

}
