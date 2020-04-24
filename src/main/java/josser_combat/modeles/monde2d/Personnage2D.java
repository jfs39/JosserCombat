package josser_combat.modeles.monde2d;

import commun.debogage.J;

public class Personnage2D extends Objet2D {
	
	private double largeurMetres;
	private double hauteurMetres;
	
	private String srcImageRepos;
	private String srcImagePunch;
	
	private String srcImageCourante;
	
	private final double TEMPS_UN_PUNCH = 0.3;
	private Double tempsRestantAuPunch = null;

	public Personnage2D(double centreXMetres, 
			double centreYMetres, 
			double largeurMetres,
			double hauteurMetres,
			double vitesseInitialeMetresSecondes, 
			double angleInitialDegre,
			String srcImageRepos,
			String srcImagePunch) {

		super(centreXMetres, centreYMetres);
		
		this.largeurMetres = largeurMetres;
		this.hauteurMetres = hauteurMetres;
		this.srcImageRepos = srcImageRepos;
		this.srcImagePunch = srcImagePunch;
		
		this.srcImageCourante = this.srcImageRepos;
		
		double angleInitialRadians = Math.toRadians(angleInitialDegre);
		
		this.vitesseXMetresSecondes = vitesseInitialeMetresSecondes * Math.cos(angleInitialRadians);
		this.vitesseYMetresSecondes = vitesseInitialeMetresSecondes * Math.sin(angleInitialRadians);
		
		double accelerationGraviteTerrestreMetresSecondesCarres =  9.81;
		
		this.accelerationYMetresSecondesCarres = - accelerationGraviteTerrestreMetresSecondesCarres;
	}

	@Override
	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		super.reagirAuTempsQuiPasse(secondesEcoulees);
		J.appel(this);
		
		// Ajouter un plancher!
		if(centreYMetres <= (hauteurMetres/2)) {
			
			centreYMetres = hauteurMetres/2;
		}
	}
	@Override
	public void afficher(double facteurMetresEnPixelsX, 
			             double facteurMetresEnPixelsY, 
			             double hauteurDessinPixels,
			             Dessin2D dessin2d) {
		J.appel(this);
		
		double centreXPixels = centreXMetres * facteurMetresEnPixelsX;
		double centreYPixels = hauteurDessinPixels - (centreYMetres * facteurMetresEnPixelsY);
		
		double largeurPixels = largeurMetres * facteurMetresEnPixelsX;
		double hauteurPixels = hauteurMetres * facteurMetresEnPixelsY;
		
		dessin2d.dessinerImage(centreXPixels, centreYPixels, largeurPixels, hauteurPixels, srcImageCourante);
	}

}
