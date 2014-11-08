package gestion_formation_interne_edit;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.echallenge.formation.metier.UtilisateurMetier;
import com.sqli.echallenge.formation.model.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
public class TestMetier {
	@Resource(name="utilisateur_metier")
    public UtilisateurMetier utilisateurMetier;
	
	@Test
	public void myTest(){
		Utilisateur u = new Utilisateur();
		u.setNomUtilsateur("Fkr");
		u.setPrenomUtilisateur("Mouad");
		u.setEmailUtilisateur("mouad.fkr@gmail.com");
		
		try {
			utilisateurMetier.addUtilisateur(u);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
		try {
			Assert.assertTrue(utilisateurMetier.getAllUtilisateurs().size()>0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		};
		
		
		
		
		
	}
}
