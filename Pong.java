import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Pong extends JPanel implements KeyListener, ActionListener, FocusListener
{
   private int fW,fH;
   private int x1 = 350;
   private int x2 = 350;
   private int bX = 395;
   private int bY = 350;
   private int changeX = 1;
   private int changeY = 1;//the value bX or bY will change by
   private double xVel = 1;
   private double xVel2 = 1;
   private boolean acrL = false; //acr = acceleration
   private boolean acrR = false;
   private boolean acrL2 = false;
   private boolean acrR2 = false;
   private int speed = 7;
    
   public Pong(int fW,int fH)
   {
      this.fW = fW;
      this.fH = fH;
      
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
   }
  
   public void paint(Graphics g)
   {
      addBackground(g);
      addPaddles(g);
      if(acrL)
         moveLeft();
      if(acrR)
         moveRight();
      if(acrL2)
         moveLeft2();
      if(acrR2)
         moveRight2();
      if(!acrL && !acrR)
         slow();
      if(!acrL2 && !acrR2)
         slow2();
         
      addBall(g);
      //System.out.print(xVel+ " ");
      ballMove();
      
   }
   
   public void addBackground(Graphics g)
   {
      g.setColor(new Color(0,0,0));
      g.fillRect(0,0,fW,fH);
   }
  
   public void addPaddles(Graphics g)
   {
      g.setColor(Color.white);
      g.fillRect(x1,600,80,10);
      g.fillRect(x2,50,80,10);
   }
   
   public void addBall(Graphics g)
   {
      g.setColor(Color.lightGray);
      //g.fillRoundRect(bX,bY,10,10,30,10);
      g.fillRect(bX,bY,10,10);
   }
   public void ballMove()
   {
      if(bX==0 || bX == 745) //if the ball hits the sides
      {
         changeX = -changeX;
         //changeX = (int)(Math.random()*2+1);
      }
      if(bY==0 || bY == 645)
      {
         changeY = -changeY;
         //changeY = (int)(Math.random()*2+1);
      }
        
      if((bX>=x1&&bX<=x1+80)&&(bY==590))
      {
         //changeX = (int)(0.4*xVel);
         changeY = -changeY+(int)(0.4*xVel);
         speed-= (int)(speed*.4);
      }
      if((bX>=x2&&bX<=x2+80)&&(bY==60))
      {
         changeY = changeY = -changeY+(int)(0.4*xVel);
         speed-= (int)(speed*.4);
         }   
      bX+=changeX;
      bY+=changeY;
      try 
        {
            //thread to sleep for the specified number of milliseconds
            Thread.sleep(speed);
        } 
        catch ( java.lang.InterruptedException ie) 
        {
            System.out.println(ie);
        } 
        System.out.println(speed + " ");
   }
   
   public void slow()
   {
      xVel=1;
   }
   
   public void slow2()
   {
      xVel2 = 1;
   }
   
   public void moveLeft()
   {
      if(x1>=0){
      x1-=2;
      xVel+=1;
      if(xVel > 3)
         xVel = 3;
      }
      slow();
   }
   public void moveRight()
   {
      if(x1 <= 695){
         x1+=2;
         xVel+=1;
         if(xVel > 3)
            xVel = 3;
      }
      slow();
      
   }
   public void moveLeft2(){
   if(x2>=0){
      x2-=2;
      xVel2+=1;
      if(xVel2 > 3)
         xVel2 = 3;
      }
      slow2();
   }
   public void moveRight2(){
    if(x2 <= 695){
         x2+=2;
         xVel2+=1;
         if(xVel > 3)
            xVel = 3;
      }
      slow2();
   }
  
   @Override
   public void actionPerformed(ActionEvent e){ repaint();}
   
   @Override
   public void keyTyped(KeyEvent e){}
   
   @Override
   public void keyPressed(KeyEvent e)
   {
      int keyCode = e.getKeyCode();
      if(keyCode == KeyEvent.VK_LEFT)
         acrL = true;
      if(keyCode == KeyEvent.VK_RIGHT)
         acrR = true;
      if(keyCode == KeyEvent.VK_A)
         acrL2 = true;
      if(keyCode == KeyEvent.VK_D)
         acrR2 = true;
   }
   
   @Override
   public void keyReleased(KeyEvent c)
   {
      int keyCode = c.getKeyCode();
      if(keyCode == KeyEvent.VK_LEFT)
         acrL = false;
      if(keyCode == KeyEvent.VK_RIGHT)
         acrR = false;
      if(keyCode == KeyEvent.VK_A)
         acrL2 = false;
      if(keyCode == KeyEvent.VK_D)
         acrR2 = false;
   }
   
   @Override
   public void focusGained(FocusEvent e){}
   
   @Override
   public void focusLost(FocusEvent e){}
}
