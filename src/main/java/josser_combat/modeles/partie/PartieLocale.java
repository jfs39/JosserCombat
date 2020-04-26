package josser_combat.modeles.partie;


import java.util.HashMap;
import java.util.Map;

import commun.debogage.J;
import commun.modeles.Modele;
import josser_combat.enumerations.Cadran;
import josser_combat.enumerations.Direction;
import josser_combat.modeles.monde2d.Monde2D;
import josser_combat.modeles.monde2d.Monde2DLectureSeule;
import josser_combat.modeles.monde2d.Personnage2D;


public final class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule{
	
	private Monde2D monde2D;
	
	private Map<Cadran, Personnage2D> lesPersonnages = new HashMap<>();
	
	public void initialiser() {
		J.appel(this);
		
		monde2D = new Monde2D();
		
		Personnage2D joseph = monde2D.ajouterPersonnage(Cadran.GAUCHE, 
				"img/Joseph/Joseph.png", 
				"img/Joseph/JosephPunch.png",
				"img/Joseph/JosephEnergy.png");

		Personnage2D yasser = monde2D.ajouterPersonnage(Cadran.DROIT, 
				"img/Yasser/Yasser.png", 
				"img/Yasser/YasserPunch.png",
				"img/Yasser/YasserEnergy.png");

		lesPersonnages.put(Cadran.GAUCHE, joseph);
		lesPersonnages.put(Cadran.DROIT, yasser);
	}

	

	@Override
	public Monde2DLectureSeule getMonde2D() {
		J.appel(this);
		
		return monde2D;
	}
	
	public void reagirAuTempsQuiPasse(double secondesEcoulees) {
		J.appel(this);
		
		monde2D.reagirAuTempsQuiPasse(secondesEcoulees);
	}


	public void initierSaut(Cadran cadran) {
		J.appel(this);
		
		Personnage2D personnage = lesPersonnages.get(cadran);
		personnage.initierSaut();
	}



	public void initierMouvement(Cadran cadran, Direction direction) {
		J.appel(this);

		Personnage2D personnage = lesPersonnages.get(cadran);
		personnage.initierMouvement(direction);
	}



	public void stopperMouvement(Cadran cadran) {
		J.appel(this);

		Personnage2D personnage = lesPersonnages.get(cadran);
		personnage.stopperMouvement();
		
	}



	public void initierPunch(Cadran cadran) {
		J.appel(this);

		Personnage2D personnage = lesPersonnages.get(cadran);
		personnage.puncher();
	}
	
	
	public void initierBloquer(Cadran cadran) {
		J.appel(this);

		Personnage2D personnage = lesPersonnages.get(cadran);
		personnage.bloquer();
	}

}



	
	
	
	


