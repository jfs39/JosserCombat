package josser_combat_javafx;

import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import josser_combat_javafx.controleurs.ControleurParametresFX;
import commun_javafx.ChargeurDeVue;
import commun_javafx.Initialisateur;

public class Principal extends Application {
	
	static {
		J.appel(Principal.class);
		
		Initialisateur.initialiser();
	}
	
	public static void main(String[] args) {
		
		J.appel(Principal.class);
		
		launch(args);
	}
	
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		
		J.appel(this);
		
		Scene scene = creerScenePrincipale();
		ControleurParametresFX.playAudio();

        afficherFenetre(fenetrePrincipale, scene);
    }

    private void afficherFenetre(Stage fenetrePrincipale, Scene scene) {
        J.appel(this);

        setLargeurFenetre(fenetrePrincipale);
        setHauteurFenetre(fenetrePrincipale);

        fenetrePrincipale.setScene(scene);
        fenetrePrincipale.show();
    }

    private void setHauteurFenetre(Stage fenetrePrincipale) {
        J.appel(this);

        fenetrePrincipale.setHeight(700);
        fenetrePrincipale.setMinHeight(600);
    }

    private void setLargeurFenetre(Stage fenetrePrincipale) {
        J.appel(this);

        fenetrePrincipale.setWidth(900);
        fenetrePrincipale.setMinWidth(700);
    }
	
	private Scene creerScenePrincipale() {
		
		J.appel(this);
		ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/principal.xml","traductions.chaines","/css/menuPrincipal.css");
		Scene scene = chargeur.nouvelleScene(600,400);
		DoitEtre.nonNul(scene);
		
		return scene;
	}
	
	@Override
	public void stop() {
		
		J.appel(this);
	}
}
