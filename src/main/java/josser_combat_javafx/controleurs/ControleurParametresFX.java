package josser_combat_javafx.controleurs;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import commun.debogage.J;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import josser_combat_client.controleurs.ControleurParametres;
import josser_combat_javafx.afficheurs.AfficheurParametresFX;
import josser_combat_javafx.vues.VueParametresFX;

public class ControleurParametresFX extends ControleurParametres<VueParametresFX,AfficheurParametresFX> {

	
	private static Media media;
	private static MediaPlayer mediaPlayer;
	
	private static final String MEDIA_URL = "src/main/resources/sound/soundtrack.mp3";
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
	}

	@Override
	public void demarrer() {
		J.appel(this);
		
		playAudio();
	}
	
	public static void playAudio() {
		//J.appel(this);
		media = new Media(new File(MEDIA_URL).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	
	
	public static void stopAudio() {
		
		mediaPlayer.stop();
	}

}
