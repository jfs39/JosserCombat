package josser_combat.modeles.partie;

import commun.debogage.J;
import commun.modeles.Modele;


public final class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule{

	private static final Parametres instance = new Parametres();
	
	private boolean son;
	
	private String langue;
	
	public static Parametres getInstance() {
		J.appel(Parametres.class);
		return instance;
	}
	
	private Parametres() {
		J.appel(this);
	}
	
	public void setLangue(String langue) 
	{
		this.langue = langue;
	}
	
	public String getLangue() {
		return this.langue;
	}
	
	public void setSon(boolean son) 
	{
		this.son = son;
	}
	
	public boolean getSon() {
		return this.son;
	}
	
	
	
	
	
}
