/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author 刘宇
 */
public class Images extends JComponent{
    private BufferedImage image;
	private static final int W= 500;
	private static final int H = 500;
	private Image imag;
        public  Images(){
            try {
            image= ImageIO.read(Images.class.getResource("snake.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @Override
	public void paint(Graphics g) {
                if(image==null) {
			return ;
		}
                g.drawImage(image ,315,65, null);
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(W,H);
	}
}
