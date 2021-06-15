/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pingpong;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PPgameplay extends JPanel implements KeyListener ,ActionListener{
    private boolean play=false; 
    int delay=1,score1=0,score2=0;
    private int ballx=80,bally=440,balldx=-3,balldy=-2;
    private int playerx=350,playery=350;
    private  Timer time;
    
    PPgameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time=new Timer(delay,this);
        time.start();
    }
     
    @Override
   public void paint(Graphics g)
   {
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, 1000, 800);
       
       g.setColor(Color.BLACK);
       g.fillRect(0,0,1000,5);
       g.fillRect(0,758,1000,5);
       g.setColor(Color.white);
       g.fillRect(488,0,5,800);
       
       g.setColor(Color.BLUE);
       g.fillRect(0, playerx, 10,100 );
       g.setColor(Color.RED);
       g.fillRect(976, playery, 10,100 );
       
       g.setColor(Color.white);
       g.fillOval(ballx, bally, 20, 20);
       
       g.setColor(Color.green);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.drawString(""+score1,458,40);
        g.drawString(""+score2,504,40);
       if(ballx<0)
            {
                play=false;
                score2+=1;
                ballx=680;
                bally=350;
                balldx= 3;
                balldy= 2;
                playerx=350;
                playery=350;
            }
       if(ballx>=990)
       {
                play=false;
                score1+=1;
                ballx=280;
                bally=400;
                balldx= -3;
                balldy= +2;
                playerx=350;
                playery=350;
        }
       if(score1==10)
       {
            play=false;
            balldx=0;
            balldy=0;
            g.setColor(Color.white);
            g.setFont(new Font("arial",Font.BOLD,30));
            g.drawString("Player1 Won", 280, 400);
            g.drawString("Press 'Enter' to restart", 500, 400);
       }
       if(score2==10)
       {
            play=false;
            balldx=0;
            balldy=0;
            g.setColor(Color.white);
            g.setFont(new Font("arial",Font.BOLD,30));
            g.drawString("Player2 Won", 280, 400);
            g.drawString("Press 'Enter' to restart", 500, 400);
       }
       
       g.dispose();
       
   }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W)
        {
            
            if(playerx<=5)
                playerx=7;
            else
                moveW();
        }
        if(e.getKeyCode()==KeyEvent.VK_S)
        {
            if(playerx>=670)
            {
                playerx=660;
            }
            else
                moveS();
        }
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            
            if(playery<=5)
                playery=7;
            else
                moveup();
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            if(playery>=670)
            {
                playery=660;
            }
            else
                movedown();
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(!play)
            {
                play=false;
                score1=0;
                score2=0;
                ballx=80;
                bally=350;
                balldx= -3;
                balldy= -2;
                playerx=350;
                playery=350;
                repaint();
                
            }
        }
    }

    void moveS() {
       play=true;
       playerx+=10;
    }

     void moveW() {
        play=true;
       playerx-=10;
    }
     void movedown() {
       play=true;
       playery+=10;
    }

     void moveup() {
        play=true;
       playery-=10;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(play)
        {
            if(new Rectangle(ballx,bally,20,20).intersects(new Rectangle(0, playerx, 10,100)) || 
                    new Rectangle(ballx,bally,20,20).intersects(new Rectangle(976, playery, 10,100)))
            {
                balldx=-balldx;
            }
            ballx+=balldx;
            bally+=balldy;
            if(bally < 0)
                balldy=-balldy;
            if(bally >740)
                balldy=-balldy;
            
            
        }
        
       repaint();
    }
    
    
}
