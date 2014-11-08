package com.sqli.echallenge.formation.model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( Profil.class )
public class Profil_ {
	public static volatile SingularAttribute<Profil, Long> idProfil;
	public static volatile SingularAttribute<Profil, String> nomProfil;
	public static volatile SingularAttribute<Profil, Boolean> elementaire;
	public static volatile SingularAttribute<Profil, String> roleBase;
	public static volatile SingularAttribute<Profil, String> description;
	public static volatile SetAttribute<Profil, Action> actions;
}
