package mariobros;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Coin extends GameObject {

    private static int coins;
    
    public Coin(int posX, int posY, int width, int height, Color c){
        
        super(posX, posY, width, height, c);
        
    }

    @Override
    public void update() {
        
    }
    
    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
    }
    
}
