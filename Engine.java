import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Point;

public class Engine
{
   public static void main(String args[])
   {
      int fX = 200;
      int fY = 50;
      int fW = 800;
      int fH = 700;
      BufferedImage cursorImage = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB); //removes the cursor array from the frame
      Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0),"blank cursor");
      JFrame frame = new JFrame();
      frame.setBounds(fX,fY,fW,fH);
      frame.setTitle("Pong");
      frame.setResizable(true);
      Pong game = new Pong(fW,fH); //makes game
      frame.add(game);
      frame.getContentPane().setCursor(blankCursor);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      while(true){ //infinite loop
         game.repaint();
      }
   }
}
