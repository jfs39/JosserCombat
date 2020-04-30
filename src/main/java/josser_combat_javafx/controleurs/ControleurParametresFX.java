package josser_combat_javafx.controleurs;

import java.io.File;
import commun.debogage.J;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import josser_combat.modeles.partie.Parametres;
import josser_combat_client.controleurs.ControleurParametres;
import josser_combat_javafx.afficheurs.AfficheurParametresFX;
import josser_combat_javafx.vues.VueParametresFX;

public class ControleurParametresFX extends ControleurParametres<VueParametresFX,AfficheurParametresFX> {

	
	private static Media media;
	public static MediaPlayer mediaPlayer;
	
	private static final String MEDIA_URL = "src/main/resources/sound/soundtrack.mp3";
	@Override
	public void installerReceptionCommandes() {
		J.appel(this);
	}

	@Override
	public void demarrer() {
		J.appel(this);
	}
	
	public static void playAudio() {
		J.appel(ControleurParametresFX.class);
		
		media = new Media(new File(MEDIA_URL).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		
	}
	
	public static void changerVolume(double niveau) {
		J.appel(ControleurParametresFX.class);
		Parametres.getInstance().setGradateurSon(niveau);
	}
	
	public static void stopAudio() {
		J.appel(ControleurParametresFX.class);
		mediaPlayer.stop();
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}

}
