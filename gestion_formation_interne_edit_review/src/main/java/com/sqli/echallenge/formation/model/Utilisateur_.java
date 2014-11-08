package com.sqli.echallenge.formation.model;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( Utilisateur.class )
public class Utilisateur_ {
	 public static volatile SingularAttribute<Utilisateur, Long> idUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, String> nomUtilsateur;
	 public static volatile SingularAttribute<Utilisateur, String> prenomUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, String> emailUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, String> passwordUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, Date> dateNaissanceUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, String> telephoneUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, String> adresseUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, Boolean> sexeUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, String> urlPhotoUtilisateur;
	 public static volatile SingularAttribute<Utilisateur, Profil> profil;
}
