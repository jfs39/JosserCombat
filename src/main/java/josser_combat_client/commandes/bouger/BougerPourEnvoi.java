package josser_combat_client.commandes.bouger;

import commun_client.commandes.CommandePourEnvoi;
import josser_combat.enumerations.Cadran;
import josser_combat.enumerations.Direction;

public interface BougerPourEnvoi extends CommandePourEnvoi {
	
	void setCadran(Cadran cadran);
	void setDirection(Direction direction);

}
