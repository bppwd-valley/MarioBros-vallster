package mariobros;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class StartScreen extends GameScreen{
    
    public StartScreen(){
        super();
        
    }
    public void draw(GraphicsContext gc){
        super.draw(gc);
        gc.setFill(Color.RED);
        gc.fillText("Press Enter To Start", 350, 350);
    }

    @Override
    public void processKey(KeyEvent event) {
        
    }

    @Override
    public void finalizeKey(KeyEvent event) {
        
    }
}
