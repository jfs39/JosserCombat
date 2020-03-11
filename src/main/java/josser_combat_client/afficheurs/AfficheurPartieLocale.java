package josser_combat_client.afficheurs;

import commun_client.mvc.Afficheur;
import josser_combat.modeles.partie.MenuLectureSeule;
import josser_combat.modeles.partie.ParametresLectureSeule;
import josser_combat.modeles.partie.PartieLocaleLectureSeule;
import josser_combat_client.vues.VueMenu;
import josser_combat_client.vues.VueParametres;
import josser_combat_client.vues.VuePartieLocale;

public abstract class AfficheurPartieLocale <V extends VuePartieLocale>	extends Afficheur<PartieLocaleLectureSeule, 
V> {

}
