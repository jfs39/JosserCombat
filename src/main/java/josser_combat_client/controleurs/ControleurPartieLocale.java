package josser_combat_client.controleurs;

import commun.debogage.J;
import commun_client.mvc.controleurs.ControleurModeleVue;
import commun_client.mvc.controleurs.RecepteurCommandeMVC;
import josser_combat.modeles.partie.PartieLocale;
import josser_combat.modeles.partie.PartieLocaleLectureSeule;
import josser_combat_client.afficheurs.AfficheurPartieLocale;
import josser_combat_client.commandes.bloquer.Bloquer;
import josser_combat_client.commandes.bloquer.BloquerRecue;
import josser_combat_client.commandes.bouger.Bouger;
import josser_combat_client.commandes.bouger.BougerRecue;
import josser_combat_client.commandes.puncher.Puncher;
import josser_combat_client.commandes.puncher.PuncherRecue;
import josser_combat_client.commandes.sauter.Sauter;
import josser_combat_client.commandes.sauter.SauterRecue;
import josser_combat_client.commandes.stopper.Stopper;
import josser_combat_client.commandes.stopper.StopperRecue;
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
		
		installerRecepteurCommande(Bouger.class, new RecepteurCommandeMVC<BougerRecue>() {
			@Override
			public void executerCommandeMVC(BougerRecue commande) {
				J.appel(this);
				
				modele.initierMouvement(commande.getCadran(), commande.getDirection());
			}
		});
		
		installerRecepteurCommande(Stopper.class, new RecepteurCommandeMVC<StopperRecue>() {
			@Override
			public void executerCommandeMVC(StopperRecue commande) {
				J.appel(this);
				
				modele.stopperMouvement(commande.getCadran());
			}
		});
		
		installerRecepteurCommande(Puncher.class, new RecepteurCommandeMVC<PuncherRecue>() {
			@Override
			public void executerCommandeMVC(PuncherRecue commande) {
				J.appel(this);
				
				modele.initierPunch(commande.getCadran());
			}
		});
		
		installerRecepteurCommande(Bloquer.class, new RecepteurCommandeMVC<BloquerRecue>() {
			@Override
			public void executerCommandeMVC(BloquerRecue commande) {
				J.appel(this);
				
				modele.initierBloquer(commande.getCadran());
			}
		});


	}
	
	protected void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		modele.reagirAuTempsQuiPasse(secondesEcoulees);
		
		modele.getMonde2D().afficher(vue.getDessin2D());
	}
	

}
