package josser_combat_client.commandes.stopper;

import commun.debogage.J;
import commun_client.commandes.Commande;
import josser_combat.enumerations.Cadran;

public class      Stopper 
       extends    Commande<StopperPourEnvoi, StopperRecue>
	   implements StopperPourEnvoi, StopperRecue {
	
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
