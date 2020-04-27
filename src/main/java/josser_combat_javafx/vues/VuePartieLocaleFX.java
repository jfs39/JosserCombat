package josser_combat_javafx.vues;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_client.commandes.FabriqueCommande;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import josser_combat.enumerations.Cadran;
import josser_combat.enumerations.Direction;
import josser_combat.modeles.monde2d.Dessin2D;
import josser_combat_client.commandes.bloquer.Bloquer;
import josser_combat_client.commandes.bloquer.BloquerPourEnvoi;
import josser_combat_client.commandes.bouger.Bouger;
import josser_combat_client.commandes.bouger.BougerPourEnvoi;
import josser_combat_client.commandes.puncher.Puncher;
import josser_combat_client.commandes.puncher.PuncherPourEnvoi;
import josser_combat_client.commandes.sauter.Sauter;
import josser_combat_client.commandes.sauter.SauterPourEnvoi;
import josser_combat_client.commandes.stopper.Stopper;
import josser_combat_client.commandes.stopper.StopperPourEnvoi;
import josser_combat_client.vues.VuePartieLocale;
import josser_combat_javafx.vues.composantes.MonDessin2D;


public class VuePartieLocaleFX implements VuePartieLocale, Initializable{
	
	@FXML 
	MonDessin2D canvasPartie;
	
	private SauterPourEnvoi sauterPourEnvoi;
	private BougerPourEnvoi bougerPourEnvoi;
	private StopperPourEnvoi stopperPourEnvoi;
	private PuncherPourEnvoi puncherPourEnvoi;
	private BloquerPourEnvoi bloquerPourEnvoi;

	
	Set<KeyCode> touchesEnfoncees = new HashSet<>();

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
		bougerPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Bouger.class);
		stopperPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Stopper.class);
		puncherPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Puncher.class);
		bloquerPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Bloquer.class);

	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		canvasPartie.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				J.appel(this);
				
				if(touchesEnfoncees.contains(event.getCode())){ return; }
				
				touchesEnfoncees.add(event.getCode());
				
				// faire sauter le personnage de GAUCHE
				if(event.getCode() == KeyCode.W) {
					
					sauterPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					sauterPourEnvoi.envoyerCommande();

				// bouger le personnage de GAUCHE vers la GAUCHE
				}else if(event.getCode() == KeyCode.A) {
					
					bougerPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					bougerPourEnvoi.setDirection(Direction.GAUCHE);
					bougerPourEnvoi.envoyerCommande();
					
				// bouger le personnage de GAUCHE vers la DROITE
				}else if(event.getCode() == KeyCode.D) {

					bougerPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					bougerPourEnvoi.setDirection(Direction.DROITE);
					bougerPourEnvoi.envoyerCommande();
					
				// faire puncher le personnage de GAUCHE
				}else if(event.getCode() == KeyCode.SPACE) {
					
					puncherPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					puncherPourEnvoi.envoyerCommande();
					
				//faire sauter Yasser	
				} else if(event.getCode() == KeyCode.UP) {
				
					sauterPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					sauterPourEnvoi.envoyerCommande();
					
				//faire marcher Yasser vers la droite
				} else if(event.getCode() == KeyCode.RIGHT) {
					
					bougerPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					bougerPourEnvoi.setDirection(Direction.DROITE);
					bougerPourEnvoi.envoyerCommande();
					
				//faire marcher Yasser vers la gauche
				} else if(event.getCode() == KeyCode.LEFT) {
					
					bougerPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					bougerPourEnvoi.setDirection(Direction.GAUCHE);
					bougerPourEnvoi.envoyerCommande();
				//faire puncher Yasser
				} else if(event.getCode() == KeyCode.NUMPAD0) {
					
					puncherPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					puncherPourEnvoi.envoyerCommande();
				//faire bloquer Yasser	
				} else if(event.getCode() == KeyCode.NUMPAD1) {
					
					bloquerPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					bloquerPourEnvoi.envoyerCommande();
				//Faire bloquer Joseph	
				} else if(event.getCode() == KeyCode.SHIFT) {
					
					bloquerPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					bloquerPourEnvoi.envoyerCommande();
				}
			}
		});

		canvasPartie.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				J.appel(this);
				
				touchesEnfoncees.remove(event.getCode());

				// arrêter de bouger le personnage à GAUCHE
				if(event.getCode() == KeyCode.A && !touchesEnfoncees.contains(KeyCode.D) ) {
					
					stopperPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					stopperPourEnvoi.envoyerCommande();

				} else if(event.getCode() == KeyCode.D && !touchesEnfoncees.contains(KeyCode.A)  ) {
					
					stopperPourEnvoi.setCadran(Cadran.PERSONNAGE_GAUCHE);
					stopperPourEnvoi.envoyerCommande();
					
				}else if(event.getCode() == KeyCode.RIGHT && !touchesEnfoncees.contains(KeyCode.LEFT) ) {
					
					stopperPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					stopperPourEnvoi.envoyerCommande();
					
				}else if(event.getCode() == KeyCode.LEFT && !touchesEnfoncees.contains(KeyCode.RIGHT) ) {
					
					stopperPourEnvoi.setCadran(Cadran.PERSONNAGE_DROIT);
					stopperPourEnvoi.envoyerCommande();
					
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
