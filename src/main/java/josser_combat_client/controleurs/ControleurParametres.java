package josser_combat_client.controleurs;
import commun_client.mvc.controleurs.ControleurModeleVue;
import josser_combat.modeles.partie.Parametres;
import josser_combat.modeles.partie.ParametresLectureSeule;
import josser_combat_client.afficheurs.AfficheurParametres;
import josser_combat_client.vues.VueParametres;

public abstract class ControleurParametres<V extends VueParametres, A extends AfficheurParametres<V>>
									extends ControleurModeleVue<ParametresLectureSeule,Parametres,V,A> { 
	
}
