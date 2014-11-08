INSERT INTO profil (idProfil, description, elementaire, nomProfil, role) VALUES (NULL, NULL, '1', 'Administrateur', 'administrateur'), (NULL, NULL, '1', 'Responsable de formation', 'responsable_formation'),(NULL, NULL, '1', 'Formateur', 'formateur');


INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Creer Collaborateur', 'Creer_Collaborateur'),(NULL, 'Modifier Collaborateur', 'Modifier_Collaborateur'),(NULL, 'Supprimer Collaborateur', 'Supprimer_Collaborateur');

INSERT INTO action (idAction, description, nomAction) VALUES(NULL, 'Creer Administrateur', 'Creer_Administrateur'),(NULL, 'Modifier Administrateur', 'Modifier_Administrateur'),(NULL, 'Supprimer Administrateur', 'Supprimer_Administrateur');

INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Creer Responsable de Formation', 'Creer_Responsable_de_Formation'),(NULL, 'Modifier Responsable de Formation', 'Modifier_Responsable_de_Formation'),(NULL, 'Supprimer Responsable de Formation', 'Supprimer_Responsable_de_Formation');

INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Creer Formateur', 'Creer_Formateur'),(NULL, 'Modifier Formateur', 'Modifier_Formateur'),(NULL, 'Supprimer Formateur', 'Supprimer_Formateur');



INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Creer Session', 'Creer_Session'),(NULL, 'Modifier Session', 'Modifier_Session'),(NULL, 'Supprimer Session', 'Supprimer_Session');

INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Creer Formation', 'Creer_Formation'),(NULL, 'Supprimer Formation', 'Supprimer_Formation');

INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Inscrire Collaborateur', 'Inscrire_Collaborateur_a_la_Session_du_formation'),(NULL, 'Consulter Tableau de bord', 'Consulter_le_table_de_bord');


INSERT INTO action (idAction, description, nomAction) VALUES (NULL, 'Creer et Modifier Contenu de la formation', 'Creer_et_Modifier_le_Contenu_de_la_formation');


INSERT INTO `db_echallenge_gestion_formation`.`profil_action` (`Profil_idProfil`, `actions_idAction`) VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5'), ('1', '6'), ('1', '7'), ('1', '8'), ('1', '9'), ('1', '10'), ('1', '11'), ('1', '12');

INSERT INTO `db_echallenge_gestion_formation`.`profil_action` (`Profil_idProfil`, `actions_idAction`) VALUES ('2', '13'), ('2', '14'), ('2', '15'), ('2', '16'), ('2', '17'), ('2', '18'), ('2', '19');

INSERT INTO `db_echallenge_gestion_formation`.`profil_action` (`Profil_idProfil`, `actions_idAction`) VALUES ('3', '20');