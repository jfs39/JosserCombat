package josser_combat.modeles.partie;

import commun.modeles.ModeleLectureSeule;
import josser_combat.modeles.monde2d.Monde2DLectureSeule;

public interface PartieLocaleLectureSeule extends ModeleLectureSeule{
	
	Monde2DLectureSeule getMonde2D();

}

