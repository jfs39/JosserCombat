package josser_combat_client.commandes.puncher;

import commun_client.commandes.CommandePourEnvoi;
import josser_combat.enumerations.Cadran;

public interface PuncherPourEnvoi extends CommandePourEnvoi {
	
	void setCadran(Cadran cadran);

}
