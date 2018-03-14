package mariobros;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public abstract class GameScreen {
    
    ArrayList<GameObject> objects;
    
    public GameScreen(){
         objects = new ArrayList();
    }
    
    public boolean update(){
        for (GameObject i : objects){
            i.update();
        }
        return true;
    }
    
    public void draw(GraphicsContext gc){
        for (GameObject i : objects){
            i.draw(gc);
        }
    }
    
    public void hide(){
        for (GameObject i : objects){
            i.setEnabled(false);
        }
    }
    
    public void show(){
        for (GameObject i : objects){
            i.setEnabled(true);
        }
    }

    public abstract void processKey(KeyEvent event);
    public abstract void finalizeKey(KeyEvent event);
    
}
