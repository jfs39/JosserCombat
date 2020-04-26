package josser_combat_client.commandes.bloquer;

import commun_client.commandes.CommandeRecue;
import josser_combat.enumerations.Cadran;

public interface BloquerRecue extends CommandeRecue {
	
	Cadran getCadran();

}
