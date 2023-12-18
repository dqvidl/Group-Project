import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
  //Create an instance of Game in order to access player & backgrounds
  private Game game;

  public Window(Game game){
    this.game = game;

    //Setting the size of the Window
    setPreferredSize(new Dimension(800, 600));
    //Setting the background color of the Window
    setBackground(Color.BLACK);
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g); 
    drawGame();
    
    //draws offscreen image onscreen
    g.drawImage(game.offscreen, 0, 0, this);
    //update the visual again 
    repaint();
  }

  public void drawGame(){ //Draws frames offscreen
    //Setting the color of the background
    game.offG.setColor(Color.BLACK);
    //Filling the background color
    game.offG.fillRect(0, 0, 900, 600);
    
    game.offG.setColor(Color.RED); // Setting the color of the next object drawn
    game.layout.paint(game.offG);  // Paint background

    game.offG.setColor(Color.WHITE);
    game.player.paint(game.offG); // Paint the player

    game.offG.setColor(Color.BLUE);
    game.car.paint(game.offG); // Paint the car

  }
}