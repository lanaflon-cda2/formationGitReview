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
@Table(name="PROFIL")
public class Profil {
	
	public static final String ROLE_ADMINISTRATEUR = "Administrateur";
	public static final String ROLE_RESPONSABLE_FORMATION = "Responsable de formation";
	public static final String ROLE_FORMATEUR = "Formateur";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROFIL")
	private Long idProfil;
	@Column(name="NOM_PROFIL", unique=true)
	private String nomProfil;
	@Column(name="ELEMENTAIRE")
	private boolean elementaire;
	@Column(name="ROLE_BASE")
	private String roleBase;
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable (name = "PROFIL_ACTION" , joinColumns = @JoinColumn(name = "ID_PROFIL"), inverseJoinColumns=@JoinColumn(name = "ID_ACTION"))
	private Set<Action> actions = new HashSet<Action>();
	
	public Profil() {
	}

	public boolean isElementaire() {
		return elementaire;
	}

	public void setElementaire(boolean elementaire) {
		this.elementaire = elementaire;
	}

	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	public String getNomProfil() {
		return nomProfil;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

	public String getRoleBase() {
		return roleBase;
	}

	public void setRoleBase(String roleBase) {
		this.roleBase = roleBase;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
