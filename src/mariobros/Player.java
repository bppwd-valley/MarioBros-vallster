package mariobros;

import javafx.scene.paint.Color;

public class Player extends GameObject{
    
    private int velocityX;
    private int velocityY;
    
    

    public Player(int posX, int posY, int width, int height, Color c){
        super(posX, posY, width, height, c);
    }
    
    public void move(){
        x += velocityX;
    }
    
     public void jump(){
        y += velocityY;
    }
    
    public void setVelY (int value){
        velocityY = value;
    }
    
    public void setVelX (int value){
        velocityX = value;
    }
    
    
    @Override
    public void update() {
        move();
        System.out.println(x);
        jump();
    }
    
}
