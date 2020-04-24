package josser_combat_client.commandes.sauter;

import commun_client.commandes.CommandeRecue;
import josser_combat.enumerations.Cadran;

public interface SauterRecue extends CommandeRecue {
	
	Cadran getCadran();

}
