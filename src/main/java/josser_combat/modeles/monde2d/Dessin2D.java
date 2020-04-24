package josser_combat.modeles.monde2d;

public interface Dessin2D {
	
	double getLargeurPixels();
	double getHauteurPixels();
	
	void viderDessin();
	
	void dessinerImage(double centreXPixels, 
			double centreYPixels, 
			double largeurPixels, 
			double hauteurPixels, 
			String src);

}
