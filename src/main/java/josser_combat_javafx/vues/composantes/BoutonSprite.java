package josser_combat_javafx.vues.composantes;

import java.io.InputStream;

import commun.debogage.J;
import commun_javafx.vues.composants.ImageAjustable;
import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BoutonSprite extends HBox {

	private ImageView imageView;
	private String urlJoseph = "/img/Joseph/JosephHit.gif";
	private String urlYasser="/img/Yasser/YasserHit.gif";
	
	public BoutonSprite(@NamedArg("texte") String texte) {
		super();
		J.appel(this);
		
		Button bouton = new Button(texte);
		
		if (texte.equals("Confirmer")) {
			
			genererBouton(bouton, "boutonConfirmer");
			genererImage(urlJoseph);
			
		} else {
			
			genererBouton(bouton,"boutonAnnuler");
			genererImage(urlYasser);
		}
		
		bouton.setOnMouseEntered((e)->{
			imageView.setStyle("-fx-opacity:100;");
			
		});
		
		bouton.setOnMouseExited((e)->{
			imageView.setStyle("-fx-opacity:0;");
			
		});
		}
	
		private void genererImage(String url) {
			J.appel(this);
			InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
			Image image = new Image(streamImage);
			imageView = new ImageView(image);
			imageView.setFitHeight(175);
			imageView.setFitWidth(175);
			imageView.setTranslateX(70);
			this.getChildren().add(imageView);
			imageView.setStyle("-fx-opacity:0;");
			
		}
		
		private void genererBouton(Button bouton, String type) {
			J.appel(this);
			this.setAlignment(Pos.BOTTOM_LEFT);
			bouton.getStyleClass().add(type);
			this.getChildren().add(bouton);
			bouton.setMinWidth(95);
			bouton.setMinHeight(45);
		}

}