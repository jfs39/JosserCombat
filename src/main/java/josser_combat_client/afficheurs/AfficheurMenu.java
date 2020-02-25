package josser_combat_client.afficheurs;

import commun_client.mvc.Afficheur;
import josser_combat.modeles.partie.MenuLectureSeule;
import josser_combat.modeles.partie.ParametresLectureSeule;
import josser_combat_client.vues.VueMenu;
import josser_combat_client.vues.VueParametres;

public abstract class AfficheurMenu <V extends VueMenu>	extends Afficheur<MenuLectureSeule, 
V> {

}
