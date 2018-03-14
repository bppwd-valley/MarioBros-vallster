package mariobros;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LevelOne extends GameScreen{
    
    int enemyX, enemyXSpan, enemyY, enemyYSpan, platformX, platformXSpan, platformY, platformYSpan;
    public LevelOne(){
        super();
        Player player = new Player(50, 700, 50, 50, Color.BLUE);
        objects.add(player);
        objects.add(new Enemy(480, 245, 50, 50, Color.PINK));
        objects.add(new Platform(200, 400, 100, 50, Color.BLACK));
        objects.add(new Platform(10, 750, 800, 50, Color.BLACK));
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
                        ((Player) i).setVelY(-5);
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
            }
        }
        for (GameObject i : objects){
            if (i instanceof Platform){
                platformX = i.getX();
                platformXSpan = platformX + i.getW();
                platformY = i.getY();
                platformYSpan = platformY + i.getH();
            }
        }
        for (GameObject i : objects){
            if (i instanceof Player){
                System.out.println("Player X: " + i.getX() + "  " + "Enemy X: " + enemyX);
                if((i.getX() >= enemyX && i.getX() <= enemyXSpan || i.getX() + i.getW() >= enemyX && i.getX() + i.getW() <= enemyXSpan)&&(i.getY() >= enemyY && i.getY() <= enemyYSpan || i.getY() + i.getH() >= enemyY && i.getY() + i. getH() <= enemyYSpan)){                   
                    return false;
                } else if((i.getX() >= platformX && i.getX() <= platformXSpan || i.getX() + i.getW() >= platformX && i.getX() + i.getW() <= platformXSpan)&&(i.getY() >= platformY && i.getY() <= platformYSpan || i.getY() + i.getH() >= platformY && i.getY() + i. getH() <= platformYSpan)){
                    ((Player) i).setCollision(true);
                } else {
                    ((Player) i).setCollision(false);
                }
                if(i.getY() + i.getH() > 800) {
                    i.setY(800 - i.getH());
                } 
                if(i.getX() < 10) {
                    i.setX(10);
                } 
                if(i.getX() + i.getW() > 800) {
                    i.setX(800 - i.getW());
                }
                
                if(i.getX() + i.getW() < enemyX) {
                    enemyX -= 2;
                } else if(i.getX() > enemyX) {
                    enemyX += 2;
                }
            }
            
        }
        return true;
    }
    
}
