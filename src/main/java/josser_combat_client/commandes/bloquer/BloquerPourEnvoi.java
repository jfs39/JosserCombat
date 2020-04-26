package josser_combat_client.commandes.bloquer;

import commun_client.commandes.CommandePourEnvoi;
import josser_combat.enumerations.Cadran;

public interface BloquerPourEnvoi extends CommandePourEnvoi {
	
	void setCadran(Cadran cadran);

}
