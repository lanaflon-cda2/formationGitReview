/**
 * 
 */
package com.sqli.echallenge.formation.dao;

import java.util.List;

import com.sqli.echallenge.formation.model.Habilitation;

/**
 * @author Mouad
 *
 */
public interface HabilitationDao {
	public Habilitation getHabilitation(Long idHabilitation) throws Exception;
	public void addHabilitation(Habilitation habilitation) throws Exception;
	public void removeHabilitation(Long idHabilitation) throws Exception;
	public void updateHabilitation(Habilitation habilitation) throws Exception;
	public List<Habilitation> getAllHabilitations() throws Exception;
}
