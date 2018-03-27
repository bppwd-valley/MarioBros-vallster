package mariobros;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class LevelOne extends GameScreen{
    
    int enemyX, enemyXSpan, enemyY, enemyYSpan, platformX, platformXSpan, platformY, platformYSpan, coins;
    Player player;
    boolean pressedOnce;
    
    public LevelOne(){
        super();
        player = new Player(50, 0, 50, 50, Color.BLUE);
        objects.add(player);
        objects.add(new Enemy(800, 700, 50, 50, Color.PINK));
        objects.add(new Platform(80, 650, 100, 50, Color.BLACK));
        objects.add(new Platform(160, 500, 100, 50, Color.BLACK)); 
        objects.add(new Platform(320, 450, 100, 50, Color.BLACK));
        objects.add(new Platform(400, 300, 100, 50, Color.BLACK)); 
        objects.add(new Platform(500, 450, 100, 50, Color.BLACK)); 
        objects.add(new Platform(10, 750, 800, 50, Color.BLACK));
        objects.add(new Coin(400, 710, 30, 30, Color.YELLOW));
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
            if (player.getCollision() == true)
                player.setVelY(-10);
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
//        if (player.getCollision() == false) {
//            player.setVelY(0);
//        } else {
//            player.setCollision(true);
//        }
        
        for (GameObject i : objects){
            if (i instanceof Enemy){
                if(player.isColliding(i)){                   
                    return false;
                }
            }
            else if (i instanceof Platform){
                if(player.isColliding(i)){
                    player.setCollision(true);
                    sf = false;
                }
                if(player.isCollidingBottom(i)){
                    sf = false;
                }
                if(player.isCollidingTop(i)){
                    sf = true;
                }
                if(player.isCollidingLeft(i)){
                    sf = true;
                }
                if(player.isCollidingRight(i)){
                    sf = true;
                } 
            }
            else if(i instanceof Coin){
                if(player.isColliding(i)){
                    coins += 1;
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
    
    @Override
    public void draw(GraphicsContext gc){
        super.draw(gc);
        gc.fillText("Coins: " + coins, 50, 50);
    }
}
