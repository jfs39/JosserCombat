package josser_combat_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import josser_combat.modeles.partie.PartieLocale;
import josser_combat.modeles.partie.PartieLocaleLectureSeule;
import josser_combat_client.afficheurs.AfficheurPartieLocale;
import josser_combat_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale <V extends VuePartieLocale, A extends AfficheurPartieLocale<V>>
extends ControleurModeleVue<PartieLocaleLectureSeule,PartieLocale,V,A>{
	
	
	protected void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		modele.reagirAuTempsQuiPasse(secondesEcoulees);
		
		modele.getMonde2D().afficher(vue.getDessin2D());
	}
	

}
