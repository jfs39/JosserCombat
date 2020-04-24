package josser_combat.modeles.partie;


import commun.debogage.J;
import commun.modeles.Modele;
import josser_combat.enumerations.Cadran;
import josser_combat.modeles.monde2d.Monde2D;
import josser_combat.modeles.monde2d.Monde2DLectureSeule;


public final class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule{
	
	private Monde2D monde2D;
	
	public void initialiser() {
		J.appel(this);
		
		monde2D = new Monde2D();
		
		monde2D.ajouterPersonnage(Cadran.GAUCHE, 
				"img/Joseph/Joseph.png", 
				"img/Joseph/JosephPunch.png");

		monde2D.ajouterPersonnage(Cadran.DROIT, 
				"img/Yasser/Yasser.png", 
				"img/Yasser/YasserPunch.png");
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

}



	
	
	
	


