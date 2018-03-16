package mariobros;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GameObject {
    
    protected int x, y, w, h, type;
    protected Color color;
    protected boolean enabled;
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
    public BoundingBox bbox(){
        return new BoundingBox(x, y, w, h);
    }
    public boolean isColliding(GameObject other){
        return bbox().intersects(other.bbox());
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
    
}
