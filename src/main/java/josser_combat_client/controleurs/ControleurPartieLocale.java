package josser_combat_client.controleurs;

import josser_combat.modeles.partie_locale.PartieLocale;
import josser_combat.modeles.partie_locale.PartieLocaleLectureSeule;
import josser_combat_client.afficheurs.AfficheurPartieLocale;
import josser_combat_client.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale, 
                                             A extends AfficheurPartieLocale<V>>

                extends ControleurPartie<PartieLocaleLectureSeule, 
                                         PartieLocale, 
                                         V, 
                                         A> {
	
}
