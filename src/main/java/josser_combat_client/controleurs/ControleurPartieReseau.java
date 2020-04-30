package josser_combat_client.controleurs;

import commun.debogage.J;
import commun.messages.FabriqueMessage;
import commun_client.mvc.controleurs.RecepteurMessageMVC;
import josser_combat.modeles.partie_reseau.PartieReseau;
import josser_combat.modeles.partie_reseau.PartieReseauLectureSeule;
import josser_combat_client.afficheurs.AfficheurPartieReseau;
import josser_combat_client.vues.VuePartieReseau;

public abstract class ControleurPartieReseau<V extends VuePartieReseau, 
                                             A extends AfficheurPartieReseau<V>>

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        V, 
                        A> {
}
