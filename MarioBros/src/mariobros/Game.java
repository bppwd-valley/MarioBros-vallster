 package mariobros;

import javafx.scene.canvas.GraphicsContext; 
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.paint.Color;

public class Game {
    GameScreen startScreen;
    GameScreen levelOne;
    GameScreen endScreen;
    GameScreen activeScreen;
    GameScreen pauseScreen;
    GameScreen tempScreen;
    boolean isPaused;
    int tempX;
    int tempXSpan;
    int tempY;
    int tempYSpan;

    
    public Game(GameFramework gf) { 
        
        gf.setWindow("Trump's Presidency", 800, 800, Color.WHITE);
        
    }
    
    protected void initialize() {
        startScreen = new StartScreen();
        levelOne = new LevelOne();
        endScreen = new EndScreen();
        pauseScreen = new PauseScreen();
        activeScreen = startScreen;
        isPaused = false;
    }
    
    protected void keyPressed(KeyEvent event) {
        activeScreen.processKey(event);
        if (event.getCode() == KeyCode.P){
            if(isPaused == true){
                isPaused = false;
                switchTo(tempScreen);
            }else if(isPaused == false){
                isPaused = true;
                tempScreen = activeScreen;
                switchTo(pauseScreen);
            }
        }
    }
    
    private void switchTo(GameScreen next){
        activeScreen.hide();
        activeScreen = next;
        activeScreen.show();
    }
    
    protected void keyReleased(KeyEvent event) {
        activeScreen.finalizeKey(event);
        if (event.getCode() == KeyCode.ENTER){
            if (activeScreen instanceof StartScreen || activeScreen instanceof EndScreen){
                switchTo(levelOne);
            }
        }
    }
    
    protected void mousePressed(MouseEvent event) { 

        

    }
    
    protected void mouseReleased(MouseEvent event) { 

        

    }
    
    protected void update(float dt) {
        activeScreen.update();
        if (activeScreen == levelOne){
            
        }
        if (activeScreen.update() == false){
            if(activeScreen == levelOne){ switchTo(endScreen);
                levelOne = new LevelOne();}
        }
        
    }
    
    protected void draw(GraphicsContext gc) {
        activeScreen.draw(gc);
    }
    
} 