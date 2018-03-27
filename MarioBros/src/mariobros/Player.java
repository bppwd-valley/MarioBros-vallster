package mariobros;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Player extends GameObject{
    
    private int velocityX;
    private int velocityY;
    private boolean collision, colliTop, colliBottom, colliRight, colliLeft;

    public Player(int posX, int posY, int width, int height, Color c){
        super(posX, posY, width, height, c);
        collision = false;
        colliTop = false;
        colliBottom = false;
        colliRight = false;
        colliLeft = false;
        
    }
    
    public void move(){
        x += velocityX;
    }
    
     public void jump(){
        y += velocityY;
    }
     
    public void fall(){
        y += 5;
    }
    
    public void stopFall(){
        y += 0;
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
    
    public void setCollisionTop (boolean value){
        colliTop = value;
    }
    
    public void setCollisionBottom (boolean value){
        colliBottom = value;
    }
    
    public void setCollisionLeft (boolean value){
        colliLeft = value;
    }
    
    public void setCollisionRight (boolean value){
        colliRight = value;
    }
    
    public boolean getCollision (){
        return collision;
    }
    
    public boolean getCollisionTop (){
        return colliTop;
    }
    
    public boolean getCollisionBottom (){
        return colliBottom;
    }
    
    public boolean getCollisionLeft (){
        return colliLeft;
    }
    
    public boolean getCollisionRight (){
        return colliRight;
    }
    
    @Override
    public void update() {
        move();
        jump();
    }
    
}
