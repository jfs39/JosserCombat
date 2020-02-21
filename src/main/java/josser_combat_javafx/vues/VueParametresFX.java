package josser_combat_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.RadioButton;

import josser_combat_client.vues.VueParametres;
import josser_combat_javafx.controleurs.ControleurParametresFX;


public class VueParametresFX implements VueParametres, Initializable {

	
	@FXML
	private RadioButton sonON, sonOFF;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		initialiserElements();
		
		sonON.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (sonON.isSelected()) {
					ControleurParametresFX.playAudio();
				}
			}
		});	
			
		sonOFF.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (sonOFF.isSelected()) {
					ControleurParametresFX.stopAudio();
				}
			}
		});
		
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		// TODO Auto-generated method stub
		J.appel(this);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		// TODO Auto-generated method stub
		J.appel(this);
		
	}

	@Override
	public void creerGrille(int largeur, int hauteur) {
		// TODO Auto-generated method stub
		J.appel(this);
		
	}
	
	private void initialiserElements() {
		J.appel(this);
		ControleurParametresFX.playAudio();
		sonON.setSelected(true);
		
	}

	
}