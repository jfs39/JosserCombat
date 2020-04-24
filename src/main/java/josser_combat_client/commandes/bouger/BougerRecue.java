package josser_combat_client.commandes.bouger;

import commun_client.commandes.CommandeRecue;
import josser_combat.enumerations.Cadran;
import josser_combat.enumerations.Direction;

public interface BougerRecue extends CommandeRecue {
	
	Cadran getCadran();
	Direction getDirection();

}
