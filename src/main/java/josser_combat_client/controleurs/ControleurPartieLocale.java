package josser_combat_client.controleurs;

import commun_client.mvc.controleurs.ControleurModeleVue;
import javafx.scene.control.Menu;
import josser_combat.modeles.partie.MenuLectureSeule;
import josser_combat.modeles.partie.MenuPrincipal;
import josser_combat.modeles.partie.Parametres;
import josser_combat.modeles.partie.ParametresLectureSeule;
import josser_combat.modeles.partie.PartieLocale;
import josser_combat.modeles.partie.PartieLocaleLectureSeule;
import josser_combat_client.afficheurs.AfficheurMenu;
import josser_combat_client.afficheurs.AfficheurParametres;
import josser_combat_client.afficheurs.AfficheurPartieLocale;
import josser_combat_client.vues.VueMenu;
import josser_combat_client.vues.VueParametres;
import josser_combat_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale <V extends VuePartieLocale, A extends AfficheurPartieLocale<V>>
extends ControleurModeleVue<PartieLocaleLectureSeule,PartieLocale,V,A>{

}
