/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pingpong;

import javax.swing.*;


public class Main {
    
    public static void main(String args[])
    {
        JFrame obj=new JFrame();
        PPgameplay ppg=new PPgameplay();
        obj.setTitle("Ping Pong");
        obj.setBounds(150,20,1000,800);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(ppg);
    }
    
    
}
