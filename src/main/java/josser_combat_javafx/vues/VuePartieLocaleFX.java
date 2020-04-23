package josser_combat_javafx.vues;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import commun_javafx.vues.composants.ImageAjustable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import josser_combat_client.vues.VueMenu;
import josser_combat_client.vues.VuePartieLocale;


public class VuePartieLocaleFX implements VuePartieLocale, Initializable{
	@FXML
	ImageView imageJoueurUn;
	@FXML
	ImageView imageJoueurDeux;
	@FXML
	StackPane conteneurPrincipal;
	@FXML
	HBox coteJoueurUn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		imageJoueurUn = chargerPersonnage("Joseph");
		imageJoueurDeux = chargerPersonnage("Yasser");
		conteneurPrincipal.getChildren().addAll(imageJoueurUn,imageJoueurDeux);
		StackPane.setAlignment(imageJoueurUn, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(imageJoueurDeux, Pos.BOTTOM_RIGHT);
		
		
		imageJoueurUn.setOnKeyPressed(new EventHandler<KeyEvent>(){
			  @Override
			  public void handle(KeyEvent event){

			    if (event.getCode() == KeyCode.D) {
			    	System.out.println(event.getCode());
			        imageJoueurUn.setLayoutX(imageJoueurUn.getLayoutX() + 5);
			    } else if (event.getCode() == KeyCode.A) {
			        imageJoueurUn.setLayoutX(imageJoueurUn.getLayoutX() - 5);
			    }
			  }
			});
		
//		EventHandler<KeyEvent> handler1 = key -> {
//			imageJoueurUn.setLayoutX(imageJoueurUn.getLayoutX() + 5);
//		};
//		conteneurPrincipal.getScene().addEventHandler(KeyEvent.KEY_PRESSED, handler1);
		
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
	
	private ImageView chargerPersonnage(String personnage) {
		
		String url = "/img/"+personnage+"/"+personnage+".png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		Image image = new Image(streamImage);
		ImageView imagePersonnage = new ImageView(image);
		
		return imagePersonnage;
	}

}
