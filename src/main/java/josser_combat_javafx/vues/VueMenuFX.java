package josser_combat_javafx.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import commun.debogage.DoitEtre;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import josser_combat_client.vues.VueMenu;
import josser_combat_javafx.Constantes;


public class VueMenuFX implements VueMenu, Initializable{

	final double randomNumber = Constantes.RANDOM_NUMERO;
	@FXML
	private StackPane conteneurPrincipal;
	@FXML
	private Button boutonParametres;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		if (randomNumber >= 0.5) {
			
			setLangue("fr");
		} else {
			
			setLangue("en");
		}
		
		boutonParametres.setOnAction(e->{
		
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
			Scene scene = chargeur.nouvelleScene(600,400);
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
			DoitEtre.nonNul(scene);	
			
		});
		
	}

	private void setLangue(String lang) {
		J.appel(this);
		
		if(lang.equals("fr")) {
			Locale.getDefault();
			Locale.setDefault(Locale.CANADA_FRENCH);
			
		} else {
			
			Locale.getDefault();
			Locale.setDefault(Locale.ENGLISH);
		}
		
		
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
