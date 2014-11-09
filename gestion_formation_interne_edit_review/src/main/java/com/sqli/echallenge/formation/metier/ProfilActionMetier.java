/**
 * 
 */
package com.sqli.echallenge.formation.metier;

/**
 * @author Mouad
 *
 */
public interface ProfilActionMetier {
	public void removeAllActionsFromProfil(Long idProfil) throws Exception;//delete All actions from Profil
	public void addActionToProfil(Long idAction, Long idProfil) throws Exception;
	public void addActionsToProfil(Long[] idActions, Long idProfil) throws Exception;
}
