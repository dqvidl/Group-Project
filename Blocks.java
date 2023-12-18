import java.awt.*;

public class Blocks{
  Polygon shape, drawShape;

  int xPosition;
  int yPosition;
  int SPEED;
  int width;
  int height;

  public Blocks(int s){
    //Declare variable shape as a new polygon and give value to its points
    shape = new Polygon();
    shape.addPoint (s, -s);
    shape.addPoint (s, s);
    shape.addPoint (-s, s);
    shape.addPoint (-s, -s);

    //Make an identical polygon that will actually be drawn onto the screen
    drawShape = new Polygon();

    drawShape.addPoint (s, -s);
    drawShape.addPoint (s, s);
    drawShape.addPoint (-s, s);
    drawShape.addPoint (-s, -s);
  }

  public void paint(Graphics g){
    //Drawing the visual of Polygon shape
    g.drawPolygon(drawShape);
    g.fillPolygon(drawShape);
  }

  //This method updates the movement of shape
  public void updatePosition() {

    for (int i = 0; i < shape.npoints; i++) {
      drawShape.xpoints[i] = (int) Math.round(shape.xpoints[i]);
      drawShape.ypoints[i] = (int) Math.round(shape.ypoints[i]);
    }

    //Ensure drawShape's lines stay in shape while rotating
    drawShape.translate((int) Math.round(xPosition), (int) Math.round(yPosition));
  }

  public boolean detectCollision(Player player) {
    int px = player.xPosition;
    int py = player.yPosition;
    int pw = player.width;
    int ph = player.height; //need player length and width variables
    int ox = this.xPosition;
    int oy = this.yPosition;
    int ow = this.width;
    int oh = this.height;
    
    if(pw == 0 || ph == 0 || ow == 0 || oh == 0) {
      return false;
    }
    
    pw += px;
    ph += py; 
    ow += ox; //set boundaries of the object and player
    oh += oy;

    return ((ow < ox || ow > px) && //determine intersection
            (oh < oy || oh > py) &&
            (pw < px || pw > ox) &&
            (ph < py || ph > oy));
  }

  public void edge(int y) {
    if(y == 0 && direction.equals("going up")) {
      y = 600; //if touching the top edge return to the bottom edge
    }
    else if(y == 600 && direction.equals("going down")) {
      y = 0; //if touching the bottom edge return to the top edge
    }

  }
}
