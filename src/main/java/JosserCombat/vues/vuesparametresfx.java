package JosserCombat.vues;

import java.net.URL;
import java.util.ResourceBundle;
import JosserCombat.vues.composantes.BoutonSprite;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class vuesparametresfx implements Initializable {

	@FXML
	private StackPane canevasSprite;
	
	@FXML
	private BoutonSprite animationConfirmer;
	private BoutonSprite animationAnnuler;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		canevasSprite.setAlignment(Pos.BASELINE_RIGHT);
		Node myNode = canevasSprite.getChildren().get(0);
		Canvas canevas = new Canvas(500,500);
		
		GraphicsContext pinceau = canevas.getGraphicsContext2D();
		
		pinceau.drawImage(new Image("/img/Joseph/Joseph.png"), 0, 0);
		canevasSprite.getChildren().set(0, canevas);
		canevasSprite.getChildren().add(myNode);
		
	}
	
}