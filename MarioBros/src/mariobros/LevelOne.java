package mariobros;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LevelOne extends GameScreen{
    
    int enemyX, enemyXSpan, enemyY, enemyYSpan, platformX, platformXSpan, platformY, platformYSpan;
    Player player;
    
    public LevelOne(){
        super();
        player = new Player(50, 0, 50, 50, Color.BLUE);
        objects.add(player);
        objects.add(new Enemy(800, 700, 50, 50, Color.PINK));
        objects.add(new Platform(50, 200, 100, 50, Color.BLACK)); 
        objects.add(new Platform(10, 750, 800, 50, Color.BLACK));
              
    }
    
    @Override
    public void processKey(KeyEvent event) {
        if (event.getCode() == KeyCode.A){
            player.setVelX(-5);
        }
        if (event.getCode() == KeyCode.D){
            player.setVelX(5);
        }
        if (event.getCode() == KeyCode.SPACE){
            if (player.getCollision() == true)
                player.setVelY(-10);
            else
                player.setVelY(0);
        }
    }
    
    
    @Override
    public void finalizeKey(KeyEvent event) {
        if (event.getCode() == KeyCode.A){
           for(GameObject i : objects){
               if (i instanceof Player){
                   ((Player) i).setVelX(0);
               }
           }
        }
        if (event.getCode() == KeyCode.D){
           for(GameObject i : objects){
               if (i instanceof Player){
                   ((Player) i).setVelX(0);
               }
           }
        }
        if (event.getCode() == KeyCode.SPACE){
            for(GameObject i : objects){
                if (i instanceof Player){
                    ((Player) i).setCollision(false);
                    ((Player) i).setVelY(0);
                }
            }
        }
        if (event.getCode() == KeyCode.DOWN){
            for(GameObject i : objects){
               if (i instanceof Player){
                   
               }
           }
        }
     }
    @Override
    public boolean update(){
        super.update();
        for (GameObject i : objects){
            if (i instanceof Enemy){

                if (i.getX() <= 0)
                    ((Enemy) i).reset();
                if(player.isColliding(i)){                   
                    return false;
                }
            }
            else if (i instanceof Platform){
                if(player.isColliding(i)){
                    player.setCollision(true);
                    System.out.println("Collision Detected");
                }
                if(!player.isColliding(i)){
                    player.setCollision(false);
                    System.out.println("No Collision");
                }
            }
            else if (i instanceof Player){ 
                if(i.getY() + i.getH() > 800) {
                    i.setY(800 - i.getH());
                } 
                if(i.getX() < 10) {
                    i.setX(10);
                } 
                if(i.getX() + i.getW() > 800) {
                    i.setX(800 - i.getW());
                }
                
            }
        }
        return true;
    }
    
}
