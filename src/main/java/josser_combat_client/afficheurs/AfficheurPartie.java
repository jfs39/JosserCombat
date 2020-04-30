package josser_combat_client.afficheurs;

import java.util.List;

import commun.debogage.J;
import commun_client.mvc.Afficheur;
import josser_combat.modeles.partie.PartieLectureSeule;
import josser_combat_client.vues.VuePartie;

public abstract class   AfficheurPartie<PLS extends PartieLectureSeule, 
                                        V extends VuePartie> 

				extends Afficheur<PLS, V> {

	@Override
	public void initialiserAffichage(PLS modeleLectureSeule, V vue) {
		J.appel(this);
		
	}

	@Override
	public void rafraichirAffichage(PLS modeleLectureSeule, V vue) {
		J.appel(this);
		
	}
}
