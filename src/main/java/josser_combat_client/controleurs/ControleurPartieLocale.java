package josser_combat_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import josser_combat.modeles.partie.PartieLocale;
import josser_combat.modeles.partie.PartieLocaleLectureSeule;
import josser_combat_client.afficheurs.AfficheurPartieLocale;
import josser_combat_client.commandes.sauter.Sauter;
import josser_combat_client.commandes.sauter.SauterRecue;
import josser_combat_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale <V extends VuePartieLocale, A extends AfficheurPartieLocale<V>>
extends ControleurModeleVue<PartieLocaleLectureSeule,PartieLocale,V,A>{
	

	
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(Sauter.class, new RecepteurCommandeMVC<SauterRecue>() {
			@Override
			public void executerCommandeMVC(SauterRecue commande) {
				J.appel(this);
				
				modele.initierSaut(commande.getCadran());
			}
		});

	}
	
	protected void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		modele.reagirAuTempsQuiPasse(secondesEcoulees);
		
		modele.getMonde2D().afficher(vue.getDessin2D());
	}
	

}
