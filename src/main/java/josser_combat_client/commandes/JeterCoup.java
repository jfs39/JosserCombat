package josser_combat_client.commandes;

import commun_client.commandes.Commande;

public class JeterCoup extends Commande<JeterCoupPourEnvoi, JeterCoupRecue>   
										implements JeterCoupPourEnvoi, 
										JeterCoupRecue{
	private int infoCoup;
	
	@Override
	public int getInfoCoup() {

		return infoCoup;
	}

	@Override
	public void setInfoCoup(int infoCoup) {

		this.infoCoup = infoCoup;
	}
/*Ne sais pas trop encore, le type de coup jeté (le int) peux changer dans le futur TODO*/
}
