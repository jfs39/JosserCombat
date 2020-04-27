package josser_combat.modeles.monde2d;

import commun.debogage.J;
import josser_combat.enumerations.Direction;

public class Personnage2D extends Objet2D {
	
	private double largeurMetres;
	private double hauteurMetres;
	
	private String srcImageRepos;
	private String srcImagePunch;
	private String srcImageBloquer;
	private String srcImageReposMirror;
	private String srcImagePunchMirror;
	private String srcImageBloquerMirror;
	
	private String srcImageCourante;
	
	private Direction directionCourante;
	
	private final double TEMPS_UN_PUNCH = 0.25;
	private final double TEMPS_UN_BLOQUE = 0.55;
	private double tempsRestantAuPunch = 0;
	private double tempsRestantAuBloque = 0;
	
	private double accelerationGraviteTerrestreMetresSecondesCarres =  9.81;
	private final double VITESSE_SAUT_METRES_PAR_SECONDE = 9;
	private final double VITESSE_BLESSURE_METRE_PAR_SECONDE = 5;

	private final double VITESSE_MOUVEMENT_METRES_PAR_SECONDE = 5;
	
	private boolean enMouvement = false;
	public boolean enSaut = false;
	private boolean punchConnect = false;
	
	
	
	public Personnage2D(double centreXMetres, 
			double centreYMetres, 
			double largeurMetres,
			double hauteurMetres,
			double vitesseInitialeMetresSecondes, 
			double angleInitialDegre,
			String srcImageRepos,
			String srcImagePunch, 
			String srcImageBloque,
			String srcImageReposMirror,
			String srcImagePunchMirror,
			String srcImageBloquerMirror) {

		super(centreXMetres, centreYMetres);
		
		this.largeurMetres = largeurMetres;
		this.hauteurMetres = hauteurMetres;
		this.srcImageRepos = srcImageRepos;
		this.srcImageReposMirror = srcImageReposMirror;
		this.srcImagePunch = srcImagePunch;
		this.srcImageBloquer = srcImageBloque;
		this.srcImagePunchMirror = srcImagePunchMirror;
		this.srcImageBloquerMirror = srcImageBloquerMirror;
		
		this.srcImageCourante = this.srcImageRepos;
		
		double angleInitialRadians = Math.toRadians(angleInitialDegre);
		
		this.vitesseXMetresSecondes = vitesseInitialeMetresSecondes * Math.cos(angleInitialRadians);
		this.vitesseYMetresSecondes = vitesseInitialeMetresSecondes * Math.sin(angleInitialRadians);

		this.accelerationYMetresSecondesCarres = - accelerationGraviteTerrestreMetresSecondesCarres;
	}

	public void chargerImages(Dessin2D dessin2d) {
		J.appel(this);

		dessin2d.chargerImage(srcImageRepos);
		dessin2d.chargerImage(srcImagePunch);
		dessin2d.chargerImage(srcImageBloquer);
		dessin2d.chargerImage(srcImageReposMirror);
		dessin2d.chargerImage(srcImagePunchMirror);
		dessin2d.chargerImage(srcImageBloquerMirror);
	}
	
	private boolean siPersonnageAuPlancher() {
		return centreYMetres <= (hauteurMetres/2);
	}

	@Override
	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		super.reagirAuTempsQuiPasse(secondesEcoulees);
		J.appel(this);

		if (siPersonnageAuPlancher()) {
			centreYMetres = hauteurMetres / 2;
			enSaut = false;

			if (!enMouvement) {
				vitesseXMetresSecondes = 0;
			}
		}

		if (tempsRestantAuPunch > 0) {
			punchConnect = true;
			gererDirectionPersonnage(srcImagePunchMirror, srcImagePunch);

			tempsRestantAuPunch -= secondesEcoulees;

		} else if (tempsRestantAuBloque > 0) {

			gererDirectionPersonnage(srcImageBloquerMirror, srcImageBloquer);

			tempsRestantAuBloque -= secondesEcoulees;

		} else if (directionCourante == Direction.GAUCHE) {

			if (srcImageCourante.contains("Joseph")) {

				srcImageCourante = srcImageReposMirror;
			} else if (srcImageCourante.contains("Yasser")) {

				srcImageCourante = srcImageRepos;
			}

		} else {
			if (srcImageCourante.contains("Joseph")) {

				srcImageCourante = srcImageRepos;
			} else if (srcImageCourante.contains("Yasser")) {

				srcImageCourante = srcImageReposMirror;
			} else {
				srcImageCourante = srcImageRepos;
			}

		}

	}

	private void gererDirectionPersonnage(String srcImageActionMirror, String srcImageActionDefaut) {
		if (srcImageCourante.contains("Joseph") && directionCourante == Direction.GAUCHE) {

			srcImageCourante = srcImageActionMirror;

		} else if (srcImageCourante.contains("Yasser") && directionCourante == Direction.DROITE) {

			srcImageCourante = srcImageActionMirror;

		} else {

			srcImageCourante = srcImageActionDefaut;

		}
	}
	
	@Override
	public void afficher(double facteurMetresEnPixelsX, double facteurMetresEnPixelsY, double hauteurDessinPixels,
			Dessin2D dessin2d) {
		J.appel(this);

		double centreXPixels = centreXMetres * facteurMetresEnPixelsX;
		double centreYPixels = hauteurDessinPixels - (centreYMetres * facteurMetresEnPixelsY);

		double largeurPixels = largeurMetres * facteurMetresEnPixelsX;
		double hauteurPixels = hauteurMetres * facteurMetresEnPixelsY;

		dessin2d.dessinerImage(centreXPixels, centreYPixels, largeurPixels, hauteurPixels, srcImageCourante);
	}

	public void initierSaut() {
		J.appel(this);

		// on peut sauter uniquement lorsqu'au plancher!
		if (siPersonnageAuPlancher()) {
			vitesseYMetresSecondes = VITESSE_SAUT_METRES_PAR_SECONDE;
			enSaut = true;
		}
	}

	public void initierMouvement(Direction direction) {
		J.appel(this);
		directionCourante = direction;
		enMouvement = true;

		switch (direction) {

		case GAUCHE:
			vitesseXMetresSecondes = -VITESSE_MOUVEMENT_METRES_PAR_SECONDE;

			break;

		case DROITE:
			vitesseXMetresSecondes = VITESSE_MOUVEMENT_METRES_PAR_SECONDE;

			break;
		}
	}

	public void stopperMouvement() {
		J.appel(this);

		enMouvement = false;

		if (!enSaut) {
			vitesseXMetresSecondes = 0;
		}
	}

	public void puncher() {
		J.appel(this);

		srcImageCourante = srcImagePunch;

		if (tempsRestantAuPunch <= 0) {
			tempsRestantAuPunch = TEMPS_UN_PUNCH;
		}
	}

	public void bloquer() {
		J.appel(this);
		srcImageCourante = srcImageBloquer;

		if (tempsRestantAuBloque <= 0) {
			tempsRestantAuBloque = TEMPS_UN_BLOQUE;
		}

	}
	
	public void initierSautBlessure() {
		J.appel(this);

		// on peut sauter uniquement lorsqu'au plancher!
		if (siPersonnageAuPlancher()) {
			vitesseYMetresSecondes = VITESSE_BLESSURE_METRE_PAR_SECONDE;
			enSaut = true;
		}
	}
	
	public boolean ispunching() {
		return punchConnect;
	}
	
}
