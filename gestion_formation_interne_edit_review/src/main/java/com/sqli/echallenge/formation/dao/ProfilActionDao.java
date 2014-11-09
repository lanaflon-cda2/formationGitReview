/**
 * 
 */
package com.sqli.echallenge.formation.dao;

/**
 * @author Mouad
 *
 */
public interface ProfilActionDao {
	public void removeAllActionsFromProfil(Long idProfil) throws Exception;//delete All actions from Profil
	public void addActionToProfil(Long idAction, Long idProfil) throws Exception;
}
