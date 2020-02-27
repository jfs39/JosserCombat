package josser_combat.modeles.partie;

import java.util.Locale;

import commun.debogage.J;
import commun.modeles.Modele;
import josser_combat_javafx.Constantes;


public final class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule{

	private static final Parametres instance = new Parametres();
	
	private boolean son;
	
	private double gradateurSon;
	
	private Locale langue;
	
	public static Parametres getInstance() {
		J.appel(Parametres.class);
		return instance;
	}
	
	private Parametres() {
		J.appel(this);
	}
	
	public void setLangue(Locale langue) 
	{
		J.appel(this);
		this.langue = langue;
	}
	
	public Locale getLangue() {
		return this.langue;
		
	}
	
	public void setSon(boolean son) {
		this.son = son;
	}
	
	public boolean getSon() {
		return this.son;
	}
	
	public void setGradateurSon(double son) {
		this.gradateurSon = son;
		
	}
	public double getGradateurSon() {
		J.appel(this);
		return this.gradateurSon;
		
	}
	
	public Locale genererLangueRandom() {
		
		Locale langueCourante;
		if(Constantes.RANDOM_NUMERO >= 0.5) {
			Locale.getDefault();
			Locale.setDefault(Locale.CANADA_FRENCH);
			langueCourante = Locale.CANADA_FRENCH;
			
		} else {
			
			Locale.getDefault();
			Locale.setDefault(Locale.ENGLISH);
			langueCourante = Locale.ENGLISH;
		}
		return langueCourante;
		
	}
	
		
	}
	
	
	
	
	


