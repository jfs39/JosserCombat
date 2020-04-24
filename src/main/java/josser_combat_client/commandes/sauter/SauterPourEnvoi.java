package josser_combat_client.commandes.sauter;

import commun_client.commandes.CommandePourEnvoi;
import josser_combat.enumerations.Cadran;

public interface SauterPourEnvoi extends CommandePourEnvoi {
	
	void setCadran(Cadran cadran);

}
