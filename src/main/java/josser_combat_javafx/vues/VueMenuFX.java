package josser_combat_javafx.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import josser_combat_client.vues.VueMenu;
import josser_combat_javafx.Constantes;


public class VueMenuFX implements VueMenu, Initializable{

	@FXML
	private StackPane conteneurPrincipal;
	
	@FXML
	private Button boutonParametres;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		
		boutonParametres.setOnAction(e->{
		
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
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
	
	

}
