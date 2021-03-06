package mariobros;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends GameObject{
    
    private int velocityX;
    private int velocityY;
    private boolean collision;

    public Player(int posX, int posY, int width, int height, Color c){
        super(posX, posY, width, height, c);
        collision = false;
        colliTop = false;
        colliBottom = false;
        colliRight = false;
        colliLeft = false;
    }
    
    public void stopMove(){
        move("Stop");
    }
    
    public void move(String dir){  
        if (dir == "Right"){
            setVelX(5);
        }
        if (dir == "Left"){
            setVelX(-5);
        }
        if (dir == "Stop"){
            setVelX(0);
        }
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
    
    public int getVelY (){
        return velocityY;
    }
    
    public int getVelX (){
        return velocityX;
    }
    
    public void setCollision (boolean value){
        collision = value;
    }
    
    public boolean getCollision (){
        return collision;
    }
    
    @Override
    public void update() {
        x+=velocityX;
        jump();
    }
    
    @Override
    public void draw(GraphicsContext gc){
        super.draw(gc);
        gc.setFill(Color.BLACK);
        gc.fillText("Hillary", x+7, y+(h/2));
    }
}
