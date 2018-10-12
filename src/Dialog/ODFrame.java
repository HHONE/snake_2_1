/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dialog;

import static Dialog.OD.frame;
import static GameStart.Start.panel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class ODFrame extends JFrame
{
   private ButtonPanel ColorHead;
   private ButtonPanel ColorBody;
   private ButtonPanel Spreed;
   private ButtonPanel Wall;
   
   public ODFrame()
   {
      JPanel gridPanel = new JPanel();
      gridPanel.setLayout(new GridLayout(2, 2));

      ColorHead = new ButtonPanel("HEADCOlOR", "RED", "YELLOW", "PINK","BLUE"  );
      ColorBody = new ButtonPanel("BODYCOlOR", "BLACK","GREEN"  , "ORAHNGE", "CYAN");
      Wall = new ButtonPanel("地图", "地图一", "地图二");
      Spreed = new ButtonPanel("速度", "NORMAL","SLOW" , "FAST");

      gridPanel.add(ColorHead);
      gridPanel.add(ColorBody);
      gridPanel.add(Wall);
      gridPanel.add(Spreed);

      JPanel OK = new JPanel();
      JButton OKBUTTON = new JButton("OK");
      OKBUTTON.addActionListener(new OKAction());
      OK.add(OKBUTTON);

      add(gridPanel, BorderLayout.CENTER);
      add(OK, BorderLayout.SOUTH);
      pack();
   }
   public Color getHC()
   {
      String s = ColorHead.getSelection();
      if (s.equals("BLUE")) return Color.BLUE;
      else if (s.equals("YELLOW")) return Color.YELLOW;
      else if (s.equals("PINK")) return Color.PINK;
      else if (s.equals("RED")) return Color.RED;
      else return Color.RED;
   }
   public Color getBC()
   {
      String s = ColorBody.getSelection();
      if (s.equals("GREEN")) return Color.GREEN;
      else if (s.equals("BLACK")) return Color.BLACK;
      else if (s.equals("ORAHNGE")) return Color.ORANGE;
      else if (s.equals("CYAN")) return Color.CYAN;
      else return Color.BLACK;
   }
   public int getSpreed()
   {
      String s = Spreed.getSelection();
      if (s.equals("NORMAL")) return 500;
      else if (s.equals("SLOW")) return 800;
      else if (s.equals("FAST")) return 300;
      else return 500;
   }
   public int getWall()
   {
      String s = Spreed.getSelection();
      if (s.equals("地图一")) return 1;
      else if (s.equals("地图二")) return 2;
      else return 2;
   }
   private class OKAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
          panel.setBegin(getHC(),getBC(), getWall(), getSpreed());
          frame.setVisible(false);
      }
   }
   
}