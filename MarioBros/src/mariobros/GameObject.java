package mariobros;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GameObject {
    
    protected int x, y, w, h, type;
    protected Color color;
    protected boolean enabled, colliTop, colliBottom, colliLeft, colliRight;
    GraphicsContext gc;
    
    public GameObject(int posX, int posY, int width, int height, Color c){

        x = posX;
        y = posY;
        w = width;
        h = height;
        color = c;
        enabled = true;
        
    }
    
    public abstract void update();
    
    public void draw(GraphicsContext gc){
        
        gc.setFill(color);
        if (enabled == true){
            gc.fillRect(x, y, w, h);
        }

    }
    
    public BoundingBox objBox(){
        return new BoundingBox(x, y, w, h);
    }
    
    public BoundingBox topBox(){
        return new BoundingBox(x, y, w, 1);
    }
    
    public BoundingBox bottomBox(){
        return new BoundingBox(x, y+h, w, 1);
    }
    
    public BoundingBox rightBox(){
        return new BoundingBox(x+w, y+1, 1, h-1);
    }
    
    public BoundingBox leftBox(){
        return new BoundingBox(x, y+1, 1, h-1);
    }
    
    public boolean isColliding(GameObject other){
        return objBox().intersects(other.objBox());
    }
    
    public boolean isCollidingTop(GameObject other){
        colliTop = topBox().intersects(other.bottomBox());
        return topBox().intersects(other.bottomBox());
    }
    
    public boolean isCollidingBottom(GameObject other){
        colliBottom = bottomBox().intersects(other.topBox());
        return bottomBox().intersects(other.topBox());
    }
    
    public boolean isCollidingLeft(GameObject other){
        colliLeft = leftBox().intersects(other.rightBox());
        return leftBox().intersects(other.rightBox());
    }
    
    public boolean isCollidingRight(GameObject other){
        colliRight = rightBox().intersects(other.leftBox());
        return rightBox().intersects(other.leftBox());
    }
    public void setX(int value){
        x = value;
    }
    
    public void setY(int value){
        y = value;
    }
    
    public void setW(int value){
        w = value;
    }
    
    public void setH(int value){
        h = value;
    }
    
    public void setEnabled(boolean value){
        enabled = value;
    }
    
    public int getX(){return x;}
    
    public int getY(){return y;}
     
    public int getW(){return w;}
    
    public int getH(){return h;}
    
    public Color getColor(){return color;}
    
    public boolean getColliTop(){return colliTop;}
    
    public boolean getColliBottom(){return colliBottom;}
    
    public boolean getColliLeft(){return colliLeft;}
    
    public boolean getColliRight(){return colliRight;}
    
}
