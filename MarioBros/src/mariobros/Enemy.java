package mariobros;

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
       move();
    }
    
}
