package josser_combat_javafx.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import commun_javafx.ChargeurDeVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;


public class VuePrincipalFX  implements Initializable{

	final double randomNumber = Math.random();
	@FXML
	private VBox conteneurPrincipal;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (randomNumber >= 0.5) {
			
			setLangue("fr");
		} else {
			
			
			setLangue("en");
		}
		
	}

	private void setLangue(String lang) {
		if(lang.equals("fr")) {
			Locale.getDefault();
			Locale.setDefault(Locale.CANADA_FRENCH);

		} else {
			Locale.getDefault();
			Locale.setDefault(Locale.ENGLISH);
			ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/principal.xml","traductions.chaines","/css/parametres.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());

		}
		
		
	}
	
	

}
