package josser_combat_javafx.controleurs;

import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import josser_combat_client.controleurs.ControleurMenu;
import josser_combat_client.controleurs.ControleurParametres;
import josser_combat_client.controleurs.ControleurPartieLocale;
import josser_combat_javafx.afficheurs.AfficheurMenuFX;
import josser_combat_javafx.afficheurs.AfficheurParametresFX;
import josser_combat_javafx.afficheurs.AfficheurPartieLocaleFX;
import josser_combat_javafx.vues.VueMenuFX;
import josser_combat_javafx.vues.VueParametresFX;
import josser_combat_javafx.vues.VuePartieLocaleFX;

public class ControleurPartieLocaleFX extends ControleurPartieLocale<VuePartieLocaleFX,AfficheurPartieLocaleFX>{
	
	@Override
	public void installerReceptionCommandes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demarrer() {
		J.appel(this);

		
	}
	


}
