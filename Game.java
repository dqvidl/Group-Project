import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Game file hold all of the important code for getting the game to work, such as keyboard inputs and generating graphic
public class Game extends JFrame implements KeyListener, ActionListener {

  public Window panel; //Create an instance of Window called panel
  Timer timer;  //Declaring timer as a variable in the timer class
  Image offscreen;
  Graphics offG;

  Player player; 
  Backgrounds layout;
  Cars car;

  //This method sets the initial conditions for the game
  public void init()  {
    this.setVisible(true); // Setting window as visible
    this.setSize(900, 600); // Setting window size
    this.setTitle("Demo");  // Setting the title at the top of the window
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // Ensure the game to close upon exiting the game window
    
    this.addKeyListener(this); //So our game can check the keys we've pressed
    
    add(this.panel = new Window(this), BorderLayout.CENTER); //Adding the new panel from Window and putting it in the center of our original window
    offscreen = createImage(this.getWidth(), this.getHeight());
    offG = offscreen.getGraphics();

    player = new Player();
    layout = new Backgrounds();
    car = new Cars();

    timer = new Timer(20, this); // 20 is the number of milliseconds between each "tick" of the timer
    timer.start();  // Starting the ticking of the timer

    pack(); //Pack() ensure that the added panel is packed and compressed within the visible portion of game window
  }

  @Override
  public void keyTyped(KeyEvent e) { // empty method from keyListener
  }

  @Override
  //Handles the actions after a key is pressed
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) { // W Key is pressed
      player.moveUp();
    }
    if (e.getKeyCode() == KeyEvent.VK_A) { // A Key is pressed
      player.moveLeft();
    }
    if (e.getKeyCode() == KeyEvent.VK_D) { // D Key is pressed
      player.moveRight();
      // Debug: System.out.println(player.xPosition+", "+player.yPosition);
    }
    if (e.getKeyCode() == KeyEvent.VK_S) { // S Key is pressed
      player.moveDown();
    }
    //Repaint the visual to see the changes
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) { // empty method from keyListener
  }

  @Override
  // Everything within actionPerformed is going to be looped
  public void actionPerformed(ActionEvent e) {
    player.updatePosition();
    car.updatePosition();
  } 
}