package mariobros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LevelOne extends GameScreen{
    
    int enemyX, enemyXSpan, enemyY, enemyYSpan, platformX, platformXSpan, platformY, platformYSpan;
    ArrayList<Boolean> isColliding;
    Player player ;
    
    public LevelOne(){
        super();
        player = new Player(50, 0, 50, 50, Color.BLUE);
        objects.add(player);
        objects.add(new Enemy(800, 700, 50, 50, Color.PINK));
        objects.add(new Platform(10, 750, 800, 50, Color.BLACK));
        objects.add(new Platform(50, 200, 100, 50, Color.BLACK));       
        isColliding = new ArrayList();
    }
    
    @Override
    public void processKey(KeyEvent event) {
        if (event.getCode() == KeyCode.A){
            for(GameObject i : objects){
                if (i instanceof Player){
                    ((Player) i).setVelX(-5);
                }
            }
        }
        if (event.getCode() == KeyCode.D){
            for(GameObject i : objects){
                if (i instanceof Player){
                    ((Player) i).setVelX(5);
                }
            }
        }
        if (event.getCode() == KeyCode.SPACE){
            for(GameObject i : objects){
                if (i instanceof Player){
                    if (((Player) i).getCollision() == true)
                        ((Player) i).setVelY(-10);
                    else
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
                enemyX = i.getX();
                enemyXSpan = enemyX + i.getW();
                enemyY = i.getY();
                enemyYSpan = enemyY + i.getH();
                if (i.getX() <= 0)
                    ((Enemy) i).reset();
                if((player.getX() >= enemyX && player.getX() <= enemyXSpan || player.getX() + player.getW() >= enemyX && player.getX() + player.getW() <= enemyXSpan)&&(player.getY() >= enemyY && player.getY() <= enemyYSpan || player.getY() + player.getH() >= enemyY && player.getY() + player.getH() <= enemyYSpan)){                   
                    return false;
                }
            }
            else if (i instanceof Platform){
                platformX = i.getX();
                platformXSpan = platformX + i.getW();
                platformY = i.getY();
                platformYSpan = platformY + i.getH();
                if((player.getX() >= platformX && player.getX() <= platformXSpan || player.getX() + player.getW() >= platformX && player.getX() + player.getW() <= platformXSpan)&&(player.getY() >= platformY && player.getY() <= platformYSpan || player.getY() + player.getH() >= platformY && player.getY() + player.getH() <= platformYSpan)){
                    player.setCollision(true);
                }
                if(!(player.getX() >= platformX && player.getX() <= platformXSpan || player.getX() + player.getW() >= platformX && player.getX() + player.getW() <= platformXSpan)&&(player.getY() >= platformY && player.getY() <= platformYSpan || player.getY() + player.getH() >= platformY && player.getY() + player.getH() <= platformYSpan)){
                    player.setCollision(false);
                } if(player.getCollision() == true){
                    if(!isColliding.contains(Boolean.TRUE)){
                        isColliding.add(Boolean.TRUE);
                        System.out.println("Inital Collision Detected");
                    }
                }
                else if(player.getCollision() == false && !isColliding.isEmpty()) {
                    isColliding.remove(0);
                    System.out.println("Initial Falling");
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
