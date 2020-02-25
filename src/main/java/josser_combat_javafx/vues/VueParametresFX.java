package josser_combat_javafx.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import josser_combat_client.vues.VueParametres;
import josser_combat_javafx.controleurs.ControleurParametresFX;


public class VueParametresFX implements VueParametres, Initializable {

	
	@FXML
	private RadioButton sonON, sonOFF, fr, en;
	@FXML 
	private StackPane conteneurPrincipal;
	

	
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
		
		fr.setOnAction(e->{
			Locale.getDefault();
			Locale.setDefault(Locale.CANADA_FRENCH);
			ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
		
		});

		en.setOnAction(e->{
			
				Locale.getDefault();
				Locale.setDefault(Locale.ENGLISH);
				ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
				conteneurPrincipal.getChildren().setAll(chargeur.getParent());

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

		sonON.setSelected(true);
		

		
	}
	private void setLangue(){
		

	}

	
}