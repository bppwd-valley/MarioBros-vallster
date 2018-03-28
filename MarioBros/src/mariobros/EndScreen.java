package mariobros;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class EndScreen extends GameScreen{
    
    public EndScreen(){
        super();
        
    }
    public void draw(GraphicsContext gc){
        super.draw(gc);
        gc.setFill(Color.RED);
        gc.fillText("      GAME OVER       ", 350, 300);
        gc.fillText("Press Enter To restart", 350, 375);
        gc.setFill(Color.BLACK);
        for (int i = 0; i<6000; i++){
            gc.fillText("EMAILS DISCOVERED", Math.random()*10000, Math.random()*10000);
        }
    }

    @Override
    public void processKey(KeyEvent event) {
        
    }

    @Override
    public void finalizeKey(KeyEvent event) {
       
    }
}
