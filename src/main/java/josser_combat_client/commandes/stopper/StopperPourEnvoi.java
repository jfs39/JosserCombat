package josser_combat_client.commandes.stopper;

import commun_client.commandes.CommandePourEnvoi;
import josser_combat.enumerations.Cadran;

public interface StopperPourEnvoi extends CommandePourEnvoi {
	
	void setCadran(Cadran cadran);

}
