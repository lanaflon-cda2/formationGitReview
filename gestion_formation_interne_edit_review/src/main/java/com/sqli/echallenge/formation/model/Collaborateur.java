package com.sqli.echallenge.formation.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="COLLABORATEUR")
public class Collaborateur {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COLLABORATEUR")
	private Long idCollaborateur;
	@Column(name="NOM_COLLABORATEUR")
	private String nomCollaborateur;
	@Column(name="PRENOM_COLLABORATEUR")
	private String prenomCollaborateur;
	@Column(name="EMAIL_COLLABORATEUR", unique=true)
	private String emailCollaborateur;
	@Column(name="TELEPHONE_COLLABORATEUR")
	private String telephoneCollaborateur;
	@Column(name="DATE_NAISSANCE_COLLABORATEUR")
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceCollaborateur;
	@Column(name="ADRESSE_COLLABORATEUR")
	private String adresseCollaborateur;
	@Column(name="SEXE_COLLABORATEUR")
	private boolean sexeCollaborateur;//True = Male, false = Female
	@Column(name="URL_PHOTO_COLLABORATEUR")
	private String urlPhotoCollaborateur;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="collaborateur")
	private Set<HabilitationScore> habilitations = new HashSet<HabilitationScore>();
	
	public Collaborateur() {
	}
	
	public Long getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public String getNomCollaborateur() {
		return nomCollaborateur;
	}
	public void setNomCollaborateur(String nomCollaborateur) {
		this.nomCollaborateur = nomCollaborateur;
	}
	public String getPrenomCollaborateur() {
		return prenomCollaborateur;
	}
	public void setPrenomCollaborateur(String prenomCollaborateur) {
		this.prenomCollaborateur = prenomCollaborateur;
	}
	public String getEmailCollaborateur() {
		return emailCollaborateur;
	}
	public void setEmailCollaborateur(String emailCollaborateur) {
		this.emailCollaborateur = emailCollaborateur;
	}
	public String getTelephoneCollaborateur() {
		return telephoneCollaborateur;
	}
	public void setTelephoneCollaborateur(String telephoneCollaborateur) {
		this.telephoneCollaborateur = telephoneCollaborateur;
	}
	public Date getDateNaissanceCollaborateur() {
		return dateNaissanceCollaborateur;
	}
	public void setDateNaissanceCollaborateur(Date dateNaissanceCollaborateur) {
		this.dateNaissanceCollaborateur = dateNaissanceCollaborateur;
	}
	public String getAdresseCollaborateur() {
		return adresseCollaborateur;
	}
	public void setAdresseCollaborateur(String adresseCollaborateur) {
		this.adresseCollaborateur = adresseCollaborateur;
	}
	public boolean isSexeCollaborateur() {
		return sexeCollaborateur;
	}
	public void setSexeCollaborateur(boolean sexeCollaborateur) {
		this.sexeCollaborateur = sexeCollaborateur;
	}
	public String getUrlPhotoCollaborateur() {
		return urlPhotoCollaborateur;
	}
	public void setUrlPhotoCollaborateur(String urlPhotoCollaborateur) {
		this.urlPhotoCollaborateur = urlPhotoCollaborateur;
	}
	
	@Transient
	public String getFullname(){
		if(prenomCollaborateur==null || nomCollaborateur==null) return null;
		
		return prenomCollaborateur.substring(0, 1).toUpperCase() + prenomCollaborateur.substring(1) + " " + nomCollaborateur.toUpperCase();
	}
	
	@Transient
	public String getSexeString(){
		if(sexeCollaborateur) return "Male";
		return "Female";
	}

	public Set<HabilitationScore> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(Set<HabilitationScore> habilitations) {
		this.habilitations = habilitations;
	}
	
	public void setHabilitation(Habilitation habilitation, Integer score){
		HabilitationScore hs = new HabilitationScore();
		hs.setHabilitation(habilitation);
		hs.setScoreHabilitation(score);
		
		getHabilitations().add(hs);
		
		hs.setCollaborateur(this);
	}

}
