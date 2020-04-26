package josser_combat.modeles.monde2d;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import commun.debogage.J;
import josser_combat.enumerations.Cadran;

public class Monde2D implements Monde2DLectureSeule {
	
	protected double largeurMetres = 12;
	protected double hauteurMetres = 10;

	protected Set<Objet2D> lesObjets = new HashSet<>();

	public Personnage2D ajouterPersonnage(Cadran cadran, 
			String srcRepos,
			String srcPunch, 
			String srcBloque,
			String srcMirror,
			String srcPunchMirror,
			String srcBloqueMirror) {
		J.appel(this);
		
		double centreX = 2;
		
		if(cadran == Cadran.DROIT) {
			centreX = largeurMetres - 2;
		}

		double largeur = 2;
		double hauteur = 3;
		
		double centreY = 5 + hauteur/2;
		
		Personnage2D lePersonnage = new Personnage2D(centreX, 
				centreY,
				largeur,
				hauteur,
				0,
				0,
				srcRepos,
				srcPunch,
				srcBloque,
				srcMirror,
				srcPunchMirror,
				srcBloqueMirror);

		lesObjets.add(lePersonnage);
		
		return lePersonnage;
	}

	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		for(Objet2D objet2d : lesObjets) {
			
			objet2d.reagirAuTempsQuiPasse(secondesEcoulees);
		}
	}

	@Override
	public void chargerImages(Dessin2D dessin2d) {
		J.appel(this);

		for(Objet2D objet2d : lesObjets) {
			if(objet2d instanceof Personnage2D) {
				((Personnage2D)objet2d).chargerImages(dessin2d);
			}
		}
	}

	@Override
	public void afficher(Dessin2D dessin2d) {
		J.appel(this);
		
		dessin2d.viderDessin();
		
		double facteurMetresPixelsX = dessin2d.getLargeurPixels() / largeurMetres;
		double facteurMetresPixelsY = dessin2d.getHauteurPixels() / hauteurMetres;

		for(Objet2D objet2d : lesObjets) {
			
			objet2d.afficher(facteurMetresPixelsX, 
					         facteurMetresPixelsY, 
					         dessin2d.getHauteurPixels(),
					         dessin2d);
		}
	}
}
