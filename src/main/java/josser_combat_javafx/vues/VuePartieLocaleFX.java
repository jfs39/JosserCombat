package josser_combat_javafx.vues;

import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import josser_combat.modeles.monde2d.Dessin2D;
import josser_combat_client.vues.VuePartieLocale;
import josser_combat_javafx.vues.composantes.MonDessin2D;


public class VuePartieLocaleFX implements VuePartieLocale, Initializable{
	
	@FXML 
	MonDessin2D canvasPartie;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(canvasPartie);
	}

	/*

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
	
	
	*/
	
	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		/*
		conteneurPrincipal.setOnMousePressed(e->{
			imageJoueurUn.setOpacity(0);
			punchJoseph.setOpacity(100);
		});
		
		conteneurPrincipal.setOnMouseReleased(e->{
			imageJoueurUn.setOpacity(100);
			punchJoseph.setOpacity(0);
		});	
		
		*/
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
	}

	@Override
	public Dessin2D getDessin2D() {
		J.appel(this);

		return canvasPartie;
	}
	
	/*
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
	
	*/

}
