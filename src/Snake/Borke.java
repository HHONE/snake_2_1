

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
/**
 *
 * @author 刘宇
 */
public class Borke {
    private int row;
    private int col;
    private Rectangle2D BorkeRect;
    public String toString(){
        return "("+row+10+","+col+10+")";
    }
    public int getX(){
        return row;
    }
    public void setRow(int row) {  
        this.row = row;  
    } 
    public int getY(){
         return col;
    }
    public void setCol(int col) {  
        this.col = col;  
    }
    public Rectangle2D getBorkeRect() {  
        return BorkeRect;  
    }
    public void setBorkeRect(Rectangle2D bodyborke) {  
        this.BorkeRect = bodyborke;  
    }
    public Point2D getPoint(){
        return new Point2D.Double(row, col);
    }
    //构造
    public Borke(){};
    public Borke(int row,int col){
        this.row=row;
        this.col=col;
        this.BorkeRect=new Rectangle2D.Double(row,col,20,20);
    }
    public Borke(Borke B){
        this.row=B.getX();
        this.col=B.getY();
        this.BorkeRect=new Rectangle2D.Double(B.getX(),B.getY(),20,20);
    }
}