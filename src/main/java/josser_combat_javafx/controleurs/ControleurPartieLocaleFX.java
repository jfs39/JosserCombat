package josser_combat_javafx.controleurs;

import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import josser_combat_client.controleurs.ControleurMenu;
import josser_combat_client.controleurs.ControleurParametres;
import josser_combat_client.controleurs.ControleurPartieLocale;
import josser_combat_javafx.Constantes;
import josser_combat_javafx.afficheurs.AfficheurMenuFX;
import josser_combat_javafx.afficheurs.AfficheurParametresFX;
import josser_combat_javafx.afficheurs.AfficheurPartieLocaleFX;
import josser_combat_javafx.vues.VueMenuFX;
import josser_combat_javafx.vues.VueParametresFX;
import josser_combat_javafx.vues.VuePartieLocaleFX;

public class ControleurPartieLocaleFX extends ControleurPartieLocale<VuePartieLocaleFX,AfficheurPartieLocaleFX>{

	AnimationTimer chronometre;

	@Override
	public void demarrer() {
		J.appel(this);

		installerChronometre();
		
		chronometre.start();
		
		
	}

	private void installerChronometre(){
		J.appel(this);
		
		chronometre =new AnimationTimer() {
			
			private double dernierAffichageNanosecondes;
			private double secondesEcouleesMax = 1.0 / Constantes.FPS_MAX;
			
			@Override
			public void start() {
				super.start();
				J.appel(this);
				
				dernierAffichageNanosecondes = System.nanoTime();
			}

			@Override
			public void handle(long maintenantNanosecondes) {
				J.setActif(false);
				J.appel(this);

				double secondesEcoulees = (maintenantNanosecondes - dernierAffichageNanosecondes) / 1E9;
				
				if(secondesEcoulees >= secondesEcouleesMax) {

					dernierAffichageNanosecondes = maintenantNanosecondes;
					reagirAuTempsQuiPasse(secondesEcoulees);
				}

				J.setActif(true);
			}
		};
	}

}
