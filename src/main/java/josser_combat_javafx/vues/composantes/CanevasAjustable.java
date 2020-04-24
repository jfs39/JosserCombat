package josser_combat_javafx.vues.composantes;
import commun.debogage.J;
import javafx.scene.canvas.Canvas;


public class CanevasAjustable extends Canvas{

	@Override
	public boolean isResizable() {
		J.appel(this);
		return true;
	}
	
	@Override
	public double prefWidth(double height) {
		J.appel(this);
		return getWidth();
	}
	
	@Override
	public double prefHeight(double width) {
		J.appel(this);
		return getHeight();
	}


}
