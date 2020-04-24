package josser_combat_javafx.vues.composantes;
import commun.debogage.J;
import commun_javafx.vues.composants.CanvasAjustable;
import javafx.scene.image.Image;
import josser_combat.modeles.monde2d.Dessin2D;


public class MonDessin2D extends CanvasAjustable implements Dessin2D {
	
	@Override
	protected void reagirLargeurInitiale(double largeurInitiale) {
		J.appel(this);
		
	}

	@Override
	protected void reagirHauteurInitiale(double hauteurInitiale) {
		J.appel(this);
		
	}

	@Override
	protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
		J.appel(this);
		
	}

	@Override
	protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
		J.appel(this);
		
	}
	
	@Override
	public double getLargeurPixels() {
		J.appel(this);
		
		return getWidth();
	}

	@Override
	public double getHauteurPixels() {
		J.appel(this);
		
		return getHeight();
	}

	@Override
	public void viderDessin() {
		J.appel(this);
		
		pinceau.clearRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void dessinerImage(double centreXPixels, double centreYPixels, double largeurPixels, double hauteurPixels,
			String src) {

		J.appel(this);
		
		double hautGaucheX = centreXPixels - largeurPixels / 2;
		double hautGaucheY = centreYPixels - hauteurPixels / 2;

		pinceau.drawImage(new Image(src), hautGaucheX, hautGaucheY, largeurPixels, hauteurPixels);
	}

}
