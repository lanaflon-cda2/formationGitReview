package com.sqli.echallenge.formation.dao;

import java.util.List;

import com.sqli.echallenge.formation.model.Utilisateur;


public interface UtilisateurDao {
	public Utilisateur getUtilisateur(Long idUtilisateur) throws Exception;
	public Utilisateur getUtilisateur(String email, String password) throws Exception;
	public void addUtilisateur(Utilisateur utilisateur) throws Exception;
	public void removeUtilisateur(Long idUtilisateur) throws Exception;
	public void updateUtilisateur(Utilisateur utilisateur) throws Exception;
	public List<Utilisateur> getAllUtilisateurs() throws Exception;
}
