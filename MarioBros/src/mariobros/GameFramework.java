package mariobros;

import javafx.animation.AnimationTimer; 

import javafx.application.Application; 
import javafx.scene.input.KeyEvent; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.canvas.Canvas; 
import javafx.scene.canvas.GraphicsContext; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.paint.Color; 
import javafx.stage.Stage; 

public class GameFramework extends Application  { 

    Game game; 
    // window properties 
    protected Color appBackground; 
    protected String appTitle; 
    protected int appWidth; 
    protected int appHeight; 
    // canvas properties 
    private Canvas canvas; 
    private GraphicsContext gc; 
    // represents the looping from update to draw 
    private GameLoop gameLoop; 

    public static void main(String[] args) { 
        launch(args); 
    } 

    @Override 

    public void start(Stage stage) { 
        game = new Game(this); 
        game.initialize(); 
        canvas = new Canvas(appWidth, appHeight); 
        gc = canvas.getGraphicsContext2D(); 
        Group root = new Group(); 
        root.getChildren().add(canvas); 
        Scene scene = new Scene(root); 
        
        scene.setOnKeyPressed((KeyEvent event) -> { 
            game.keyPressed(event); 
        }); 
        
        scene.setOnKeyReleased((KeyEvent event) -> { 
            game.keyReleased(event); 
        }); 

        scene.setOnMousePressed((MouseEvent event) -> { 
            game.mousePressed(event); 
        });  

        scene.setOnMouseReleased((MouseEvent event) -> { 
            game.mouseReleased(event); 
        }); 

        stage.setTitle(appTitle); 
        stage.setScene(scene); 
        stage.setResizable(false); 
        stage.show(); 

        gameLoop = new GameLoop(); 
        gameLoop.start(); 

    } 

    private class GameLoop extends AnimationTimer { 
       // time in nanoseconds at last update/loop 
       private long before = System.nanoTime(); 
       // timelapsed time since last update/loop 
       private float delta; 

       @Override 

       public void handle(long now) { 
           // calculate timelapse since last iteration 
           // print it out to see the values if you are interested 
           delta = (float) ((now - before) / 1E9); 
           // update the game objects 
           game.update(delta); 
           // clear the screen 
           gc.setFill(appBackground); 
           gc.fillRect(0,0,appWidth,appHeight); 
           // draw the game objects 
           game.draw(gc); 
           // store current time into before 
           before = now; 
       } 
   } 

    // used from child class to init title, dimensions & background 
    public void setWindow(String title, int width, int height, Color bg) { 
        appTitle = title; 
        appWidth = width; 
        appHeight = height; 
        appBackground = bg; 
    } 

     

} 