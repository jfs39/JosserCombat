package josser_combat_javafx.vues;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import josser_combat.modeles.partie.Parametres;
import josser_combat_client.vues.VueParametres;
import josser_combat_javafx.controleurs.ControleurParametresFX;
import josser_combat_javafx.vues.composantes.BoutonSprite;


public class VueParametresFX implements VueParametres, Initializable {

	@FXML
	private Slider sliderVolume;
	@FXML
	private RadioButton sonON, sonOFF, radioFR, radioEN;
	@FXML 
	private StackPane conteneurPrincipal;
	@FXML
	private BoutonSprite animationConfirmer,animationAnnuler;
	

	private Button boutonConfirmer,boutonAnnuler;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		initialiserElements();
		boutonConfirmer = (Button) animationConfirmer.lookup("#confirmer");
		boutonAnnuler = (Button) animationAnnuler.lookup("#cancel");
		
/*----------------------- Boutons confirmer et annuler -----------------------*/
		
		boutonConfirmer.setOnAction(e -> {
			Parametres.getInstance().setValeurCourante(sliderVolume.getValue());
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/principal.xml",
					"traductions.chaines", "/css/menuPrincipal.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());
			Parametres.getInstance().setSonON(sonON.isSelected());
			Parametres.getInstance().setSonOFF(sonOFF.isSelected());

		});
		
		boutonAnnuler.setOnAction(e -> {
			ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/principal.xml",
					"traductions.chaines", "/css/menuPrincipal.css");
			conteneurPrincipal.getChildren().setAll(chargeur.getParent());

		});
		
/*----------------------- RadioButton pour le son(ON ou OFF) -----------------------*/
		
		sonON.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (sonON.isSelected()) {
					ControleurParametresFX.playAudio();
					Parametres.getInstance().setSonON(true);
					sliderVolume.setValue(100);
				}
			}
		});
			
		sonOFF.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (sonOFF.isSelected()) {
					Parametres.getInstance().setSonOFF(false);
					ControleurParametresFX.stopAudio();
					sliderVolume.setValue(0);
				}
			}
		});
		
/*----------------------- RadioButton pour les langues(Francais ou Anglais) -----------------------*/
		
		radioFR.setOnAction(e->{

		rafraichirVue(Locale.CANADA_FRENCH);
		});

		radioEN.setOnAction(e->{
			rafraichirVue(Locale.ENGLISH);
		});
		
		sliderVolume.valueProperty().addListener(e -> {

			ControleurParametresFX.changerVolume(sliderVolume.getValue());
			ControleurParametresFX.mediaPlayer.setVolume((Parametres.getInstance().getGradateurSon() / 200));

			if (sliderVolume.getValue() > 0) {
				sonON.setSelected(true);
				sonOFF.setSelected(false);
			} else {
				sonON.setSelected(false);
				sonOFF.setSelected(true);
			}
			System.out.println(sliderVolume.getValue());
		});
		
/*----------------------- Autres méthodes -----------------------*/
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

		sonON.setSelected(Parametres.getInstance().ifSonON());
		sonOFF.setSelected(Parametres.getInstance().isSonOFF());
		sliderVolume.setMin(0);
		sliderVolume.setMax(100);
		sliderVolume.setValue(Parametres.getInstance().getValeurCouranteSon());
		sliderVolume.setValueChanging(true);
	}
	
	private void rafraichirVue(Locale locale) {
		J.appel(this);
		
		Locale.getDefault();
		Locale.setDefault(locale);
		ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>("/fxml/parametres.xml","traductions.chaines","/css/parametres.css");
		conteneurPrincipal.getChildren().setAll(chargeur.getParent());
	}
}