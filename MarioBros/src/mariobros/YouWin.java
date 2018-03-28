package mariobros;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class YouWin extends GameScreen{
    
    public YouWin(){
        super();
        
    }
    public void draw(GraphicsContext gc){
        super.draw(gc);
        
        gc.setFill(Color.BLACK);
        for (int i = 0; i<20000; i++){
            gc.fillText("EMAILS DISCOVERED", Math.random()*1000-100, Math.random()*1000);
        }
        gc.setFill(Color.RED);
        gc.fillText("HA! YOU THOUGHT YOU COULD BEAT THE TRUMPINATOR", 300, 250);
        gc.fillText("                              GAME OVER       ", 300, 300);
        gc.fillText("                        Press Enter To restart", 300, 375);
    }

    @Override
    public void processKey(KeyEvent event) {
        
    }

    @Override
    public void finalizeKey(KeyEvent event) {
       
    }
}
