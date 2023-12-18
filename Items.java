import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Items extends JFrame {

  private JLabel scoreLabel;
  private int score;

  public Items() {
    scoreLabel = new JLabel("Score: 0");
    add(scoreLabel, BorderLayout.NORTH);

    Timer timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        generateRandomItem();
      }
    });
    timer.start();

    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void generateRandomItem() {

  }
}