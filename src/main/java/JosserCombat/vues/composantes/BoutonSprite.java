package JosserCombat.vues.composantes;

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
	private String url="";
	//private String url = "C:\\Users\\Jean-François\\SecondWorkSpace\\JosserCombat\\src\\main\\resources\\img\\prototypeJoseph.png";
	public BoutonSprite(@NamedArg("texte") String texte) {
		super();
		J.appel(this);
		
		
		Button bouton = new Button(texte);
		if (texte.equals("Confirmer")) {
			this.setAlignment(Pos.BOTTOM_CENTER);
			bouton.getStyleClass().add("boutonConfirmer");
		} else {
			this.setAlignment(Pos.BOTTOM_CENTER);
			bouton.getStyleClass().add("boutonAnnuler");
		}
		InputStream streamImage = ImageAjustable.class.getResourceAsStream(url);
		
		Image image = new Image(streamImage);
		
		imageView = new ImageView(image);
		
		this.getChildren().add(bouton);
		
		
		bouton.setOnMouseEntered((e)->{
			this.getChildren().add(imageView);
			
		});
		}
	


	
	
}
