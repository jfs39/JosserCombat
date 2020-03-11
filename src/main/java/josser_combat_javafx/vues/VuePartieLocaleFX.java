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
import josser_combat_client.vues.VuePartieLocale;


public class VuePartieLocaleFX implements VuePartieLocale, Initializable{

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
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
