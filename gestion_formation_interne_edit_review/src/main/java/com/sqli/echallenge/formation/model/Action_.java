package com.sqli.echallenge.formation.model;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( Action.class )
public class Action_ {
	public static volatile SingularAttribute<Action, Long> idAction;
	public static volatile SingularAttribute<Action, String> nomAction;
	public static volatile SingularAttribute<Action, String> descriptionAction;
	public static volatile SetAttribute<Action, Profil> profils;
}
