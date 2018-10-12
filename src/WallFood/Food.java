/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WallFood;

import Snake.Borke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

/**
 *
 * @author 刘宇
 * 产生实现在
 */
public class Food extends Borke{
    public Food (int row,int col){
        super(row,col);
    }
    public Food (){
        super((int)(Math.random()*37)*20+40,(int)(Math.random()*27)*20+40);
    }
    public void changeFoodRandom(){
        int row=(int)(Math.random()*37)*20+40; 
        int col=(int)(Math.random()*27)*20+40; 
        setRow(row);
        setCol(col);
        setBorkeRect(new Rectangle2D.Double(row, col, 20, 20));
    }
    public Rectangle2D getFoodBorke(){
          return getBorkeRect();
    }   
    
    
}
