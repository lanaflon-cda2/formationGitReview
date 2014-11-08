/**
 * 
 */
package com.sqli.echallenge.formation.model;

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

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="HABILITATION")
public class Habilitation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_HABILITATION")
	private Long idHabilitation;
	@Column(name="NOM_HABILITATION")
	private String nomHabilitation;
	@Column(name="DESCRIPTION_HABILITATION")
	private String descriptionHabilitation;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="habilitation")
	private Set<HabilitationScore> habilitations = new HashSet<HabilitationScore>();
	
	public Habilitation() {
	}
	
	public Long getIdHabilitation() {
		return idHabilitation;
	}
	public void setIdHabilitation(Long idHabilitation) {
		this.idHabilitation = idHabilitation;
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

	public Set<HabilitationScore> getHabilitations() {
		return habilitations;
	}

	public void setHabilitations(Set<HabilitationScore> habilitations) {
		this.habilitations = habilitations;
	}
	
}
