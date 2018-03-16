package mariobros;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LevelOne extends GameScreen{
    
    int enemyX, enemyXSpan, enemyY, enemyYSpan, platformX, platformXSpan, platformY, platformYSpan;
    Player player;
    boolean pressedOnce;
    
    public LevelOne(){
        super();
        player = new Player(50, 0, 50, 50, Color.BLUE);
        objects.add(player);
        objects.add(new Enemy(800, 700, 50, 50, Color.PINK));
        objects.add(new Platform(50, 200, 100, 50, Color.BLACK)); 
        objects.add(new Platform(10, 750, 800, 50, Color.BLACK));
        pressedOnce = false;
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
            if (player.getCollision() == true && pressedOnce == false) {
                pressedOnce = true;
                player.setVelY(-10);
            } else
                player.setVelY(0);
        }
    }
    
    
    @Override
    public void finalizeKey(KeyEvent event) {
        if (event.getCode() == KeyCode.A){
            player.setVelX(0);
        }
        if (event.getCode() == KeyCode.D){
            player.setVelX(0);
        }
        if (event.getCode() == KeyCode.SPACE){
            pressedOnce = false;
            player.setVelY(0);
        }
     }
    @Override
    public boolean update(){
        super.update();
        boolean sf = true;
        player.setCollision(false);
        for (GameObject i : objects){
            if (i instanceof Enemy){
                ((Enemy) i).x -= 3;
                if (i.getX() <= 0)
                    ((Enemy) i).reset();
                if(player.isColliding(i)){                   
                    return false;
                }
            }
            else if (i instanceof Platform){
                if(player.isColliding(i)){
                    player.setCollision(true);
                    sf = false;
                }
            }    
        }
        if(player.getY() + player.getH() > 800) {
            player.setY(800 - player.getH());
        } 
        if(player.getX() < 10) {
            player.setX(10);
        } 
        if(player.getX() + player.getW() > 800) {
            player.setX(800 - player.getW());
        }
        if(sf)
            player.fall();
        else
            player.stopFall();
        return true;
    }
    
}
