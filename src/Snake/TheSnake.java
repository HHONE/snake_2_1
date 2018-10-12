/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import Snake.Borke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

/**
 *
 * @author 刘宇
 */
public class TheSnake {
    private LinkedList<Borke> snakes; 
    private int spread=300;
    public static final int North=0;
    public static final int East=1;
    public static final int South=2;
    public static final int West=3;
    private int Direction=East;
    private static Borke theDel;
    public TheSnake (){
        snakes=new  LinkedList<Borke>();
        addSnakeBody(new Borke(380,320));
        addSnakeHead(new head(400,320));
    }
    public void setDirection(int i){
        switch (i){
            case 0:
                Direction=North;
                break;
            case 1:
                Direction=East;
                break;
            case 2:
                Direction=South;
                break;
            case 3:
                Direction=West;
                break;    
        }
    }
    public int getDirection(){
        return Direction;
    }
    public void addSnakeHead(head snakeHead){
        snakes.addLast(snakeHead);
    }
    public void addSnakeBody(Borke bodyborke){
        snakes.addFirst(bodyborke);
    }
    public void RemoveTail(){
        theDel=snakes.getFirst();
        snakes.removeFirst();
    }
    public Borke gettheDel(){
        return theDel;
    }
    public LinkedList<Borke> getSnakes(){
        return snakes;
    }
    public void setSpread(int Spread){
        this.spread=spread;
    }
    public int getSpread(){
        //设置速度
        return spread;
    }
    public void moveLeft() {  
      Borke A=snakes.getLast();snakes.removeLast();
      snakes.addLast(new Borke(A));head B;
      if(A.getX()-20<20){
          B = new head(800,A.getY());
      }else{
          B = new head(A.getX()-20,A.getY());
}
      addSnakeHead(B);
      RemoveTail();
      setDirection(3);
    }  
    public void moveRight() {  
      Borke A=snakes.getLast();snakes.removeLast();
      snakes.addLast(new Borke(A));head B;
      if(A.getX()+20>800){
          B = new head(20,A.getY());
      }else{
          B = new head(A.getX()+20,A.getY());
}
      addSnakeHead(B);
      RemoveTail();
      setDirection(1);
    }  
    public void moveUp() {  
      Borke A=snakes.getLast();snakes.removeLast();
      snakes.addLast(new Borke(A));
      head B;
      if(A.getY()-20<20){
          B = new head(A.getX(),600);
      }else{
        B = new head(A.getX(),A.getY()-20);}
      addSnakeHead(B);
      RemoveTail();
      setDirection(0);
    }  
    /*四格方块向下移动*/  
    public void moveDown() {  
      Borke A=snakes.getLast();snakes.removeLast();
      snakes.addLast(new Borke(A));
      head B;
      if(A.getY()+20>600){
          B = new head(A.getX(),20);
      }else{
        B = new head(A.getX(),A.getY()+20);}
      addSnakeHead(B);
      RemoveTail();
      setDirection(2);
    } 
}
