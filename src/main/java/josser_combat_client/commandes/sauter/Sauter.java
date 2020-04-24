package josser_combat_client.commandes.sauter;

import commun.debogage.J;
import commun_client.commandes.Commande;
import josser_combat.enumerations.Cadran;

public class      Sauter 
       extends    Commande<SauterPourEnvoi, SauterRecue>
	   implements SauterPourEnvoi, SauterRecue {
	
	private Cadran cadran;

	@Override
	public Cadran getCadran() {
		J.appel(this);
		
		return cadran;
	}

	@Override
	public void setCadran(Cadran cadran) {
		J.appel(this);
		
		this.cadran = cadran;
	}

}
