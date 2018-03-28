package mariobros;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy extends GameObject{

    private boolean collision;
    int velocityX, origin;
    
    public Enemy(int posX, int posY, int width, int height, Color c){
        super(posX, posY, width, height, c);
        velocityX = -3;
        origin = posX;
        
        
    }
    public void reset(){
        x = origin; 
    }
    public void move(){
        x += velocityX;
    }
    
    @Override
    public void update() {

    }
    
    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        gc.setFill(Color.BLACK);
        gc.fillText("Trump", x+7, y+(h/2));
    }
}
