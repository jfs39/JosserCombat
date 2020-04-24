package josser_combat_javafx.vues;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import commun.debogage.J;
import commun_javafx.ChargeurDeVue;
import commun_javafx.vues.composants.CanvasAjustable;
import commun_javafx.vues.composants.ImageAjustable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
	@FXML
	Canvas canvasPartie;
	
	ImageView punchJoseph;
	
	ImageView punchYasser;
	
	GraphicsContext gc;
	
	/*Tout mon code en commentaire est en rapport au Canevas,
	 *  je suis extrêmement confus sur quoi faire au sujet de comment bien implémenter ma composante et pourquoi mon contenu ne s'affiche pas*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		placerImagesJoueurs();
		initialiserCoups();
		chargerBarreDeVie(150,50);
		
		installerCapteursEvenementsUsager();
	//	canvasPartie = new Canvas();
		// gc = canvasPartie.getGraphicsContext2D();
		// Image img = genererImageJoueur("Joseph");
		// gc.drawImage(img, img.getWidth(), img.getHeight());
		 conteneurPrincipal.getChildren().addAll(imageJoueurUn,imageJoueurDeux,vieJoueurUn,vieJoueurDeux);
	}


	private void initialiserCoups() {
		J.appel(this);
		String url = "/img/Joseph/JosephPunch.png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		Image image = new Image(streamImage);
		punchJoseph = new ImageView(image);
		punchJoseph.setOpacity(0);
		conteneurPrincipal.getChildren().add(punchJoseph);
		StackPane.setAlignment(punchJoseph, Pos.BOTTOM_LEFT);
		
	}

	private void placerImagesJoueurs() {
		J.appel(this);
		imageJoueurUn = chargerPersonnage("Joseph");
		imageJoueurDeux = chargerPersonnage("Yasser");
		StackPane.setAlignment(imageJoueurUn, Pos.BOTTOM_LEFT);
		StackPane.setAlignment(imageJoueurDeux, Pos.BOTTOM_RIGHT);
	}
	
/*Méthode qui génère (possiblement) mon image afin de la dessiner avec mon Canevas*/
	private Image genererImageJoueur(String personnage) {
		String url = "/img/"+personnage+"/"+personnage+".png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		return new Image(streamImage);
	};
	
	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		conteneurPrincipal.setOnMousePressed(e->{
			imageJoueurUn.setOpacity(0);
			punchJoseph.setOpacity(100);
		});
		
		conteneurPrincipal.setOnMouseReleased(e->{
			imageJoueurUn.setOpacity(100);
			punchJoseph.setOpacity(0);
		});	
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		//Insérer si une telle commande est possible (EX: peux plus se déplacer dans un mur)
		
	}
	
	private ImageView chargerPersonnage(String personnage) {
		J.appel(this);
		
		String url = "/img/"+personnage+"/"+personnage+".png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		Image image = new Image(streamImage);
		ImageView imagePersonnage = new ImageView(image);
		
		return imagePersonnage;
	}
	
	private ImageView chargerImage(String image) {
		J.appel(this);
		
		String url = "/img/Other/"+image+".png";
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		Image monImage = new Image(streamImage);
		ImageView imagePersonnage = new ImageView(monImage);
		
		return imagePersonnage;
	}
	
	private void chargerBarreDeVie(double largeur, double hauteur) {
		J.appel(this);
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
