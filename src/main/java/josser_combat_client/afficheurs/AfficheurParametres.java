package josser_combat_client.afficheurs;

import commun_client.mvc.Afficheur;
import josser_combat.modeles.partie.ParametresLectureSeule;
import josser_combat_client.vues.VueParametres;


public abstract class AfficheurParametres<V extends VueParametres>
									extends Afficheur<ParametresLectureSeule, 
									V> {

}
