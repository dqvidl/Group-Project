import java.awt.*;

public class Cars extends Blocks{
  // inherits xPosition, yPosition variables from Blocks
  int length;

  public Cars(){
    super(20); // creates a 20x20 square for cars
    SPEED = 10;
    // starting position (x, y)
    xPosition = 130; 
    yPosition = 600; 
  }

  public void updatePosition(){ 
    yPosition += -SPEED;
    if (yPosition < 0){
      yPosition = 600;
    }
    super.updatePosition();
  }

}