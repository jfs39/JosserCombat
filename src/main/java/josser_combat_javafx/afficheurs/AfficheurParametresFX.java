package josser_combat_javafx.afficheurs;

import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import josser_combat.modeles.partie.ParametresLectureSeule;
import josser_combat_client.afficheurs.AfficheurParametres;
import josser_combat_javafx.vues.VueParametresFX;

public class AfficheurParametresFX extends AfficheurParametres<VueParametresFX>{

	@FXML
	private StackPane conteneurPrincipal;
	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametresFX vue) {
		// TODO Auto-generated method stub
		J.appel(this);
		
	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametresFX vue) {
		// TODO Auto-generated method stub
		J.appel(this);
		ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
		conteneurPrincipal.getChildren().setAll(chargeur.getParent());
		
		
		
	}
	
	public void rafraichirVersMenuPrincipal() {
		J.appel(AfficheurParametresFX.class);
		ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/principal.xml","traductions.chaines","/css/menuPrincipal.css");
		conteneurPrincipal.getChildren().setAll(chargeur.getParent());
		
	}
	
	
	

}
