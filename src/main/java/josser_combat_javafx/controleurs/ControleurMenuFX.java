package josser_combat_javafx.controleurs;

import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import josser_combat.modeles.partie.PartieLocale;
import josser_combat_client.controleurs.ControleurMenu;
import josser_combat_client.controleurs.ControleurParametres;
import josser_combat_javafx.afficheurs.AfficheurMenuFX;
import josser_combat_javafx.afficheurs.AfficheurParametresFX;
import josser_combat_javafx.vues.VueMenuFX;
import josser_combat_javafx.vues.VueParametresFX;

public class ControleurMenuFX extends ControleurMenu<VueMenuFX,AfficheurMenuFX>{
	
	
	private PartieLocale partieLocale = new PartieLocale();
	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}
	


}
