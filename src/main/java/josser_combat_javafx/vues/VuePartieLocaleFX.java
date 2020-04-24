package josser_combat_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import josser_combat.enumerations.Cadran;
import josser_combat.modeles.monde2d.Dessin2D;
import josser_combat_client.commandes.sauter.Sauter;
import josser_combat_client.commandes.sauter.SauterPourEnvoi;
import josser_combat_client.vues.VuePartieLocale;
import josser_combat_javafx.vues.composantes.MonDessin2D;


public class VuePartieLocaleFX implements VuePartieLocale, Initializable{
	
	@FXML 
	MonDessin2D canvasPartie;
	
	private SauterPourEnvoi sauterPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(canvasPartie);
		
		// XXX: pour que le canvas recoive les événements usager
		canvasPartie.setFocusTraversable(true);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		sauterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Sauter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		canvasPartie.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				J.appel(this);
				
				if(event.getCode() == KeyCode.W) {
					
					sauterPourEnvoi.setCadran(Cadran.GAUCHE);
					sauterPourEnvoi.envoyerCommande();
				}
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
	}

	@Override
	public Dessin2D getDessin2D() {
		J.appel(this);
		
		return canvasPartie;
	}
}
