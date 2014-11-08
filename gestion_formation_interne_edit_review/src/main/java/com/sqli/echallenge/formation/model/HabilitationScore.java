/**
 * 
 */
package com.sqli.echallenge.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mouad
 *
 */
@Entity
@Table(name="HABILITATION_SCORE")
public class HabilitationScore {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_HABILITATION_SCORE")
	private Long idHabilitationScore;
	@Column(name="SCORE_HABILITATION", nullable=false)
	private Integer scoreHabilitation;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COLLABORATEUR")
	private Collaborateur collaborateur;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_HABILITATION")
	private Habilitation habilitation;
	
	public HabilitationScore() {
	}

	public Long getIdHabilitationScore() {
		return idHabilitationScore;
	}

	public void setIdHabilitationScore(Long idHabilitationScore) {
		this.idHabilitationScore = idHabilitationScore;
	}

	public Integer getScoreHabilitation() {
		if(scoreHabilitation==null) return 1;
		
		return scoreHabilitation;
	}

	public void setScoreHabilitation(Integer scoreHabilitation) {
		this.scoreHabilitation = scoreHabilitation;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Habilitation getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(Habilitation habilitation) {
		this.habilitation = habilitation;
	}
	
}
