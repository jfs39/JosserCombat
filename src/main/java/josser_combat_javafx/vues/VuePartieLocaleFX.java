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
	ImageView vieJoueurUn;
	@FXML
	ImageView vieJoueurDeux;
	@FXML
	StackPane conteneurPrincipal;
	
	ImageView punchJoseph;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		mettreJoueurs();
		initialiserCoups();
		chargerBarreDeVie(150,50);
		conteneurPrincipal.getChildren().addAll(imageJoueurUn,imageJoueurDeux,vieJoueurUn,vieJoueurDeux);

//		imageJoueurUn.setOnKeyReleased(new EventHandler<KeyEvent>(){
//			  @Override
//			  public void handle(KeyEvent event){
//				  J.appel(this);
//					System.out.println(event.getCode());
//			    if (event.getCode() == KeyCode.D) {
//			    
//			        imageJoueurUn.setLayoutX(imageJoueurUn.getLayoutX() + 5);
//			    } else if (event.getCode() == KeyCode.A) {
//			        imageJoueurUn.setLayoutX(imageJoueurUn.getLayoutX() - 5);
//			    }
//			  }
//			});
		
//		EventHandler<KeyEvent> handler1 = key -> {
//			imageJoueurUn.setLayoutX(imageJoueurUn.getLayoutX() + 5);
//		};
//		conteneurPrincipal.getScene().addEventHandler(KeyEvent.KEY_PRESSED, handler1);
		
		
		conteneurPrincipal.setOnMousePressed(e->{
			imageJoueurUn.setOpacity(0);
			punchJoseph.setOpacity(100);
		});
		
		conteneurPrincipal.setOnMouseReleased(e->{
			imageJoueurUn.setOpacity(100);
			punchJoseph.setOpacity(0);
		});
		
	}

	private void initialiserCoups() {
		String url = "/img/Joseph/JosephPunch.png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		Image image = new Image(streamImage);
		punchJoseph = new ImageView(image);
		punchJoseph.setOpacity(0);
		conteneurPrincipal.getChildren().add(punchJoseph);
		StackPane.setAlignment(punchJoseph, Pos.BOTTOM_LEFT);
		
	}

	private void mettreJoueurs() {
		imageJoueurUn = chargerPersonnage("Joseph");
		imageJoueurDeux = chargerPersonnage("Yasser");
		StackPane.setAlignment(imageJoueurUn, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(imageJoueurDeux, Pos.BOTTOM_RIGHT);
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
	
	private ImageView chargerImage(String image) {
		
		String url = "/img/Other/"+image+".png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		Image monImage = new Image(streamImage);
		ImageView imagePersonnage = new ImageView(monImage);
		
		return imagePersonnage;
	}
	
	private void chargerBarreDeVie(double largeur, double hauteur) {
		vieJoueurUn = chargerImage("life4");
		vieJoueurDeux = chargerImage("life4");
		vieJoueurDeux.setFitWidth(largeur);
		vieJoueurDeux.setFitHeight(hauteur);
		vieJoueurUn.setFitWidth(largeur);
		vieJoueurUn.setFitHeight(hauteur);
		StackPane.setAlignment(vieJoueurDeux,Pos.TOP_RIGHT);
		StackPane.setAlignment(vieJoueurUn,Pos.TOP_LEFT);
	}

}
