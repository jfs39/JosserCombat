package josser_combat_client.commandes.stopper;

import commun_client.commandes.CommandeRecue;
import josser_combat.enumerations.Cadran;

public interface StopperRecue extends CommandeRecue {
	
	Cadran getCadran();

}
