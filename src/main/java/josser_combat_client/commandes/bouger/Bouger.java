package josser_combat_client.commandes.bouger;

import commun.debogage.J;
import commun_client.commandes.Commande;
import josser_combat.enumerations.Cadran;
import josser_combat.enumerations.Direction;

public class      Bouger 
       extends    Commande<BougerPourEnvoi, BougerRecue>
	   implements BougerPourEnvoi, BougerRecue {
	
	private Cadran cadran;
	private Direction direction;

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

	@Override
	public Direction getDirection() {
		J.appel(this);

		return direction;
	}

	@Override
	public void setDirection(Direction direction) {
		J.appel(this);
		
		this.direction = direction;
	}

}
