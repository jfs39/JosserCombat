package josser_combat_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import josser_combat_client.vues.VueMenu;


public class VueMenuFX implements VueMenu, Initializable{

	@FXML
	private StackPane conteneurPrincipal;
	
	@FXML
	private Button boutonParametres,boutonjeuHL;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		
		boutonParametres.setOnAction(e->{
		
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
			
		});
		boutonjeuHL.setOnAction(e->{
		
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/partieLocale.xml","traductions.chaines","/css/partieLocale.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
			
		});
		
	}
	
	@Override
	public void obtenirCommandesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifierCommandesPossibles() {
		// TODO Auto-generated method stub
		
	}
	
	

}
