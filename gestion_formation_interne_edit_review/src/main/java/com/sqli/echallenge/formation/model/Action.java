package com.sqli.echallenge.formation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACTION")
public class Action {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTION")
	private Long idAction;
	@Column(name="NOM_ACTION", unique=true)
	private String nomAction;
	@Column(name="DESCRIPTION_ACTION")
	private String descriptionAction;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable (name = "PROFIL_ACTION" , joinColumns = @JoinColumn(name = "ID_ACTION"), inverseJoinColumns=@JoinColumn(name = "ID_PROFIL"))
	private Set<Profil> profils = new HashSet<Profil>();
	
	public Action() {
	}

	public Long getIdAction() {
		return idAction;
	}

	public void setIdAction(Long idAction) {
		this.idAction = idAction;
	}

	public String getNomAction() {
		return nomAction;
	}

	public void setNomAction(String nomAction) {
		this.nomAction = nomAction;
	}

	public String getDescriptionAction() {
		return descriptionAction;
	}

	public void setDescriptionAction(String descriptionAction) {
		this.descriptionAction = descriptionAction;
	}

	public Set<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Set<Profil> profils) {
		this.profils = profils;
	}

}
