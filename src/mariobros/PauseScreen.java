package mariobros;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class PauseScreen extends GameScreen {
    public PauseScreen(){
        super();
        objects.add(new Platform(0,0,900,900, Color.TURQUOISE));
    }
    
    public void draw (GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillText("      PAUSED     ", 350, 350);
        gc.fillText("Press P to Resume", 350, 375);
    }
    @Override
    public void processKey(KeyEvent event) {
       
    }

    @Override
    public void finalizeKey(KeyEvent event) {
        
    }
}
