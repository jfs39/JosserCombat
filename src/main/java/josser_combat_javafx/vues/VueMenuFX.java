package josser_combat_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;
import commun.debogage.J;
import commun_client.mvc.controleurs.FabriqueControleur;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import josser_combat.modeles.partie.PartieLocale;
import josser_combat_client.afficheurs.AfficheurPartieLocale;
import josser_combat_client.vues.VueMenu;
import josser_combat_javafx.afficheurs.AfficheurPartieLocaleFX;
import josser_combat_javafx.controleurs.ControleurPartieLocaleFX;


public class VueMenuFX implements VueMenu, Initializable{

	@FXML
	private StackPane conteneurPrincipal;
	
	@FXML
	private Button boutonParametres,boutonjeuHL;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		
		boutonParametres.setOnAction(e->{
		
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
			
		});
		boutonjeuHL.setOnAction(e->{
		
			ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>("/fxml/partieLocale.xml","traductions.chaines","/css/partieLocale.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
			
			
			// FIXME: ça va pas ici! Voir l'exemple tp01_pages
			
			VuePartieLocaleFX vuePartie = chargeur.getVue();

			PartieLocale partie = new PartieLocale();
			partie.initialiser();
			
			AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
			
			FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partie, vuePartie, afficheur);

			// FIXME: ci-haut ne va pas ici! Voir l'exemple tp01_pages
			
			
			
			
		});
		
	}
	
	@Override
	public void obtenirCommandesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifierCommandesPossibles() {
		// TODO Auto-generated method stub
		
	}
	
	

}
