/**
 * 
 */
package com.sqli.echallenge.formation.dao;

import java.util.List;

import com.sqli.echallenge.formation.model.Collaborateur;

/**
 * @author Mouad
 *
 */
public interface CollaborateurDao {
	public Collaborateur getCollaborateur(Long idCollaborateur) throws Exception;
	public void addCollaborateur(Collaborateur collaborateur) throws Exception;
	public void removeCollaborateur(Long idCollaborateur) throws Exception;
	public void updateCollaborateur(Collaborateur collaborateur) throws Exception;
	public List<Collaborateur> getAllCollaborateurs() throws Exception;
}
