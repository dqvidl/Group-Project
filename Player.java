import java.awt.*;

public class Player extends Blocks{

  int width;
  int height;
  
  // inherits xPosition, yPosition variables from Blocks

  public Player(){
    super(20); // creates a 20x20 square for player
    SPEED = 60; // just to make it easier to change the speed
    // starting position (x, y):
    xPosition = 70; 
    yPosition = 300; 
  }

  public void moveUp(){ 
    xPosition += 0;
    yPosition += -SPEED;
  }

  public void moveDown(){ 
    xPosition += 0;
    yPosition += SPEED;
  }

  public void moveLeft(){ 
    xPosition += -SPEED;
    yPosition += 0;
  }

  public void moveRight(){ 
    xPosition += SPEED;
    yPosition += 0;
  }

}