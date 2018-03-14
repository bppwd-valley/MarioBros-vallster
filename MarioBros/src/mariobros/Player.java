package mariobros;

import javafx.scene.paint.Color;

public class Player extends GameObject{
    
    private int velocityX;
    private int velocityY;
    private boolean collision, collideAtAll;
    

    public Player(int posX, int posY, int width, int height, Color c){
        super(posX, posY, width, height, c);
        collision = false;
    }
    
    public void move(){
        x += velocityX;
    }
    
     public void jump(){
        y += velocityY;
    }
     
    public void fall(){
        y += 2;
    }
    public void setVelY (int value){
        velocityY = value;
    }
    
    public void setVelX (int value){
        velocityX = value;
    }
    
    public void setCollision (boolean value){
        collision = value;
    }
    
    public boolean getCollision (){
        return collision;
    }
    
    public void setCollideAtAll (boolean value){
        collideAtAll = value;
    }
    
    public boolean getCollideAtAll (){
        return collideAtAll;
    }
    
    @Override
    public void update() {
        move();
        jump();
        if (collision == false)
            fall();
    }
    
}
