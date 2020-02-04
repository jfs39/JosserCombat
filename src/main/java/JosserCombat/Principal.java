package JosserCombat;



import commun.debogage.DoitEtre;
import commun.debogage.J;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        fenetrePrincipale.setMinHeight(400);
    }

    private void setLargeurFenetre(Stage fenetrePrincipale) {
        J.appel(this);

        fenetrePrincipale.setWidth(800);
        fenetrePrincipale.setMinWidth(400);
    }
	
	private Scene creerScenePrincipale() {
		
		J.appel(this);
		ChargeurDeVue chargeur = new ChargeurDeVue("/fxml/parametres.xml","traductions.chaines_en","/css/parametres.css");
		Scene scene = chargeur.nouvelleScene(600,400);
		DoitEtre.nonNul(scene);
		
		return scene;
	}
	
	@Override
	public void stop() {
		
		J.appel(this);
	}
}
