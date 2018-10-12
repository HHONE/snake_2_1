/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStart;

import static GameStart.GOF.GO;
import static GameStart.GOF.GO2;
import static GameStart.GOF.state;
import static GameStart.GameOver.gameoverframe;
import static GameStart.Start.I;
import static GameStart.Start.Again;
import static GameStart.Start.B;
import static GameStart.Start.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static GameStart.Start.startgameframe;
import RankingList.RankingList;
import java.awt.Font;

/**
 *
 * @author 刘宇
 */

public class GameOver{
    public static GOF gameoverframe = new GOF();
    public GameOver(){
        EventQueue.invokeLater(()->{
                        
                        gameoverframe.setTitle("Snake");
                        gameoverframe.setBackground(Color.BLACK);
                        gameoverframe.setSize(1130, 700);
                        gameoverframe.setResizable(false);
                        gameoverframe.setLocationRelativeTo(null);
			gameoverframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gameoverframe.setVisible(true);
			});
    }    
}
class GOF  extends JFrame{
    public static int state=0;
    public static GOFPaint GO=new GOFPaint();
    public static GOFPaint2 GO2=new GOFPaint2();
    public GOF(){
        setLayout(new BorderLayout());
        add(GO2);
        add(GO);
	add(new GOFButton(),BorderLayout.SOUTH);  
        pack();
    }
}

class GOFPaint extends JComponent{
    private BufferedImage image;
    public GOFPaint (){
        try {
            image= ImageIO.read(GameOver.class.getResource("M.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(GOFPaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    @Override
	public void paint(Graphics g) {
                if(image==null) {
			return ;
		}
                g.drawImage(image ,245,100, null);
        g.setColor(Color.red);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        int h=550;
        int l=365;
        g.drawString("YOURSCORES:"+panel.getScore(),l , h); 
    }
}
  
class GOFPaint2 extends JComponent{
    private RankingList RL=new RankingList();
    private  int[] L=RL.getList();
    public GOFPaint2 (){
    }  
    @Override
	public void paint(Graphics g) {
        int j=20;
      for(;j<=650;j=j+60) {
    	  g.drawLine(282, j, 847, j);
      }
      g.drawLine(282, 20, 282,j-60);
      g.drawLine(847, 20, 847, j-60);
      g.drawLine(565, 20, 565, j-60);
      for(int i=65,k=1;i<650;i=i+60,k++) {
    	  g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
    	  g.drawString("第"+k+"名", 287+141/2, i);
    	  g.drawString(""+L[k-1], 565+141/2, i);
      }
        }
    }

      

class GOFButton extends JPanel{
	public GOFButton() {
		JPanel p=new JPanel();
		setLayout(new BorderLayout());
		JButton B1=new JButton("再试一次");
                JButton B4=new JButton("主菜单");
		JButton B2=new JButton("排行榜");
		JButton B3=new JButton("退出游戏");
		p.add(B1);
		p.add(B2);
                p.add(B4);
		p.add(B3);
		add(p,BorderLayout.NORTH);
		B3.addActionListener((ActionListener) new ExitAction());
		B1.addActionListener(new RetryAction());
                B2.addActionListener(new ShowAction());
                B4.addActionListener(new MainAction());
	}
	
}
class ShowAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
                GO2.setVisible(true);
                GO.setVisible(false);
                gameoverframe.add(GO2);
	}
}
class ExitAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}	
class RetryAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//welcomestart.open=false;
		gameoverframe.setVisible(false);
		panel.RetrySnake();
                startgameframe.setVisible(true);
                
	}
}
class MainAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
                gameoverframe.setVisible(false);
                startgameframe.setVisible(true);
                panel.setSI(false);
		panel.setVisible(false);
                B.setVisible(true);
                I.setVisible(true);
                Again=true;
	}
}
