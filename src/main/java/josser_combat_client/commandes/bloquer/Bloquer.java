package josser_combat_client.commandes.bloquer;

import commun.debogage.J;
import commun_client.commandes.Commande;
import josser_combat.enumerations.Cadran;
import josser_combat_client.commandes.sauter.SauterPourEnvoi;
import josser_combat_client.commandes.sauter.SauterRecue;

public class      Bloquer 
       extends    Commande<BloquerPourEnvoi, BloquerRecue>
	   implements BloquerPourEnvoi, BloquerRecue {
	
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
