/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import Dialog.OD;
import static GameStart.Start.StartIt;
import static GameStart.Start.B;
import static GameStart.Start.Again;
import static GameStart.Start.I;
import static GameStart.Start.panel;
import static GameStart.Start.startgameframe;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author 刘宇
 */
public class Button extends JPanel{
    public Button() {
		JPanel p=new JPanel();
		setLayout(new BorderLayout());
		JButton B1=new JButton("开始");
		JButton B2=new JButton("设置");
		JButton B3=new JButton("退出");
		p.add(B1);
		p.add(B2);
		p.add(B3);
		add(p,BorderLayout.SOUTH);
		B3.addActionListener(new ExitAction());
		B1.addActionListener(new StartAction());
                B2.addActionListener(new SetAction());
	}
}
class ExitAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}	
class StartAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
                B.setVisible(false);
                I.setVisible(false);
                panel.setVisible(true);
                startgameframe.add(panel);
                if(Again){panel.RetrySnake();
                }
                panel.setSI(true);
	}
}
class SetAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new OD();
        }
}
 