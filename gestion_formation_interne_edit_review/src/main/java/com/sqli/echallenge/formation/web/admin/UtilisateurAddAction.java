/**
 * 
 */
package com.sqli.echallenge.formation.web.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.sqli.echallenge.formation.metier.ProfilMetier;
import com.sqli.echallenge.formation.metier.UtilisateurMetier;
import com.sqli.echallenge.formation.model.Profil;
import com.sqli.echallenge.formation.model.Utilisateur;
import com.sqli.echallenge.formation.util.SqliRandomGenerator;
import com.sqli.echallenge.formation.web.SqliBasicAction;

/**
 * @author Mouad
 *
 */
@Controller
public class UtilisateurAddAction extends SqliBasicAction {
	private static final long serialVersionUID = -8726907375865150372L;

	@Autowired
	public UtilisateurMetier utilisateurMetier;
	
	@Autowired
	public ProfilMetier profilMetier;
	
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String telephone;
	private String adresse;
	private Boolean sexe;

	private Long profil;//idProfil from select
	
	private Boolean sendEmail;
	
	@Override
	public String execute() throws Exception {
		try {
			//add success
			Utilisateur u = new Utilisateur();
			u.setNomUtilsateur(nom);
			u.setPrenomUtilisateur(prenom);
			u.setEmailUtilisateur(email);
			u.setDateNaissanceUtilisateur(dateNaissance);
			u.setTelephoneUtilisateur(telephone);
			u.setAdresseUtilisateur(adresse);
			u.setSexeUtilisateur(sexe);
			u.setPasswordUtilisateur(new SqliRandomGenerator().generateRandomString());//generatePassword
			
			Profil p = profilMetier.getProfil(profil);//add Profil
			u.setProfil(p);
			
			utilisateurMetier.addUtilisateur(u);
			
			setSessionActionMessageText(getText("addUtilisateur.message.add.success"));
			return ActionSupport.SUCCESS;
			
		} catch (Exception e) {
			//add fail
			setSessionActionErrorText(getText("addUtilisateur.error.email.deplicated"));
			return ActionSupport.ERROR;
		}
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="nom", shortCircuit=true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toLowerCase();
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="prenom", shortCircuit=true)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.toLowerCase();
	}

	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="email", shortCircuit=true)
	@EmailValidator(message="email", shortCircuit=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	@RequiredFieldValidator(shortCircuit=true)
	@DateRangeFieldValidator(message="dateFormat", dateFormat = "dd/MM/yyyy", shortCircuit=true)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="telephone", shortCircuit=true)
	@RegexFieldValidator(type = ValidatorType.SIMPLE, regex = "^0?[5-6]{1}\\d{8}",message = "Please enter a valid phone number")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	@RequiredStringValidator(message="adresse", shortCircuit=true)
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
	
	public Boolean getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(Boolean sendEmail) {
		this.sendEmail = sendEmail;
	}
	
	@RequiredFieldValidator(shortCircuit=true)
	public Long getProfil() {
		return profil;
	}

	public void setProfil(Long profil) {
		this.profil = profil;
	}
}
