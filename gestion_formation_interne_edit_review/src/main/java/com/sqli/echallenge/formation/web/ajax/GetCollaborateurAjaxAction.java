/**
 * 
 */
package com.sqli.echallenge.formation.web.ajax;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sqli.echallenge.formation.metier.CollaborateurMetier;
import com.sqli.echallenge.formation.model.Collaborateur;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class GetCollaborateurAjaxAction extends SqliBasicAction {
	private static final long serialVersionUID = 5033218013153478951L;

	@Autowired
	public CollaborateurMetier collaborateurMetier;
	
	private Long idCollaborateur;
	private String status;
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	private String telephone;
	private String adresse;
	private boolean sexe;
	
	@Override
	public String execute() throws Exception {
		try {
			Collaborateur collaborateur = collaborateurMetier.getCollaborateur(idCollaborateur);
			nom = collaborateur.getNomCollaborateur();
			prenom = collaborateur.getPrenomCollaborateur();
			email = collaborateur.getEmailCollaborateur();
			dateNaissance = new SimpleDateFormat("yyyy-MM-dd").format(collaborateur.getDateNaissanceCollaborateur());
			telephone = collaborateur.getTelephoneCollaborateur();
			adresse = collaborateur.getAdresseCollaborateur();
			sexe = collaborateur.isSexeCollaborateur();
			
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSexe() {
		return (sexe) ? "true" : "false";
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	
}
