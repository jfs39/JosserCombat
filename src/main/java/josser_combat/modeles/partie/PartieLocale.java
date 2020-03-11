package josser_combat.modeles.partie;

import java.util.Locale;

import commun.debogage.J;
import commun.modeles.Modele;
import josser_combat_javafx.Constantes;


public final class PartieLocale extends Modele<PartieLocaleLectureSeule> implements PartieLocaleLectureSeule{



	private static final PartieLocale instance = new PartieLocale();
	

	
	public static PartieLocale getInstance() {
		J.appel(PartieLocale.class);
		return instance;
	}
	
	private PartieLocale() {
		J.appel(this);
	}
	
	
		
	}
	
	
	
	
	


