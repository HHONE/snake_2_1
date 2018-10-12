/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStart;
import Panels.*;
import static GameStart.GOF.GO;
import static GameStart.GOF.GO2;
import static GameStart.GOF.state;
import static GameStart.GameOver.gameoverframe;
import static GameStart.Start.B;
import static GameStart.Start.I;
import static GameStart.Start.startgameframe;
import Panels.Button;
import Panels.Images;
import RankingList.RankingList;
import Snake.Borke;
import Snake.TheSnake;
import static Snake.TheSnake.East;
import static Snake.TheSnake.North;
import static Snake.TheSnake.South;
import static Snake.TheSnake.West;
import Snake.head;
import WallFood.Food;
import WallFood.Wall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author 刘宇
 */
    public class Start extends JPanel{
    public static boolean Again=false;
    private TheSnake Snakes=new TheSnake();
    private int Score = 0;
    private RankingList RL=new RankingList();
    private int[] L=RL.getList();
    public void RetrySnake(){
        Snakes=new TheSnake();
        //wall=new Wall(1);
        //food=new Food(); 
        setScore();
        RL=new RankingList();
        L=RL.getList();
        GO2.setVisible(false);
        GO.setVisible(true);
        gameoverframe.add(GO);
    }
    /**
     * @param args the command line arguments
     */
    public static JFrame startgameframe=new JFrame("Snake Clear ！！！");
    public static Start panel = new Start();
    public static Button B=new Button();
    public static Images I=new Images();
    public static boolean StartIt=false; 
    public static void setSI(boolean a){
        StartIt=a;
    }
    /**
     *
     */
     public static void main(String[] args) throws InterruptedException {

        startgameframe.setLayout(new BorderLayout());
        startgameframe.add(I, BorderLayout.CENTER);
        startgameframe.add(B, BorderLayout.SOUTH);
        startgameframe.setVisible(true);
        startgameframe.setSize(1130, 700);
        startgameframe.setResizable(false);
        startgameframe.setLocationRelativeTo(null);  
        startgameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        panel.start(); 
        
    } 
     
    public void paint(Graphics g) { 
        super.paint(g);
        int l=20;
        Graphics2D g2=(Graphics2D)g;
	for(int i=20;i<=820;i=i+l) {
            g2.draw(new Line2D.Double(i, 20, i, 620));
	}
     	for(int i=20;i<=620;i=i+l) {
		g2.draw(new Line2D.Double(20, i, 820, i));
	}
        paintSnake(g);
        paintWall(g);
        paintFood(g);
        paintScore(g);
        paintRankingList(g);
    }
    private Color headcolor=Color.RED;
    private Color bodycolor=Color.BLACK;
    public void  setHC(Color color){
        headcolor=color;
    }
    public void  setBC(Color color){
        bodycolor=color;
    }
    public void paintSnake(Graphics g){ 
        Graphics2D g2=(Graphics2D)g;
        for(Borke c:Snakes.getSnakes())  
        {   if(c.getClass()==head.class){
            g2.setColor(headcolor);
            g2.fill(c.getBorkeRect());
            
        }else{
            g2.setColor(bodycolor);
            g2.fill(c.getBorkeRect());  
        }
        }
    }
    
    private Wall wall=new Wall(1);
    private Food food=new Food();
    public void setWall(int ch){
        wall=new Wall(ch);
    }
    public void setBegin(Color hc,Color bc,int ch,int sp){
        setHC(hc);
        setBC(bc);
        setWall(ch);
        setSpreed(sp);
    }
    public void paintWall(Graphics g){ 
        
        Graphics2D g2=(Graphics2D)g;
        for(Point2D p:wall.getWall())  
        {   
            g2.setColor(Color.GRAY);
            g2.fill(new Rectangle2D.Double(p.getX(),p.getY(),20,20));  
        }  
    }
    public int getScore(){
        return Score;
    }
    public void setScore(){
        Score=0;
    }
    public void paintScore(Graphics g) {  
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));  
        g.drawString("YOURSCORES:", 850, 225); 
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC+Font.BOLD, 60));  
        g.drawString(""+Score, 1000, 295);
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC+Font.BOLD, 50)); 
        int h=100;
        g.drawString("Snake", 860, h);  
        g.drawString("Clean!", 910, h+50);
    }
    public void paintRankingList(Graphics g) {  
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 35));  
        g.drawString("排行榜:", 850, 350);
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
        g.drawString("FIRST:    "+"  "+L[0], 850, 400);
        g.drawString("SECOND: "+L[1], 850,450);
        g.drawString("THIRD:    "+"  "+L[2], 850, 500);
        g.drawString("LAST:     "+"  "+L[9], 850, 550);
    }
    public void paintFood(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.green);
        while(FonWall()||FonSnake()){
            food.changeFoodRandom();
        }
        g2.fill(food.getFoodBorke());
        
    }
    public boolean FonWall(){
        for(Point2D p:wall.getWall())  
        {   
            if((p.getX()==food.getFoodBorke().getX())&&(p.getY()==food.getFoodBorke().getY())){
                return true;
            }
        }
        return false;
    }
    public boolean FonSnake(){
        for(Borke c:Snakes.getSnakes())  
        {   
            if((c.getX()==food.getFoodBorke().getX())&&(c.getY()==food.getFoodBorke().getY())){
                return true;
            }
        }
        return false;
    }
    public boolean HitThewall(){
        Point2D head=Snakes.getSnakes().getLast().getPoint();
        for(Point2D p:wall.getWall()){
            if((p.getX()==head.getX())&&(p.getY()==head.getY())){
                return true;
            }
        }
        return false;
    }
    public boolean EatItself(){
        Point2D head=Snakes.getSnakes().getLast().getPoint();
        for(Borke b:Snakes.getSnakes()){
            if(b!=Snakes.getSnakes().getLast()){
            if((b.getPoint().getX()==head.getX())&&(b.getPoint().getY()==head.getY())){
                return true;
            }}
        }
        return false;
    }
    public boolean isGameOver() {  
         if(EatItself()||HitThewall()){
            int[] temp=new int[11];
            for(int i=0;i<11;i++){
                if(i!=10){
                    temp[i]=L[i];
                }else{
                    temp[i]=Score;
                }
            }
            
            for(int i=0;i<11;i++){
                for(int k=i;k<11;k++){
                    if(temp[k]>temp[i]){
                        int m=temp[k];
                        temp[k]=temp[i];
                        temp[i]=m;
                    }
                }
            }
            for(int i=0;i<10;i++){
                L[i]=temp[i];
            }
             try {
                 RL.setRangingList(L);
             } catch (IOException ex) {
                 Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
             }
            return true;
         }
        return false;  
    }
    public void GamesOver(){
        new GameOver();
    }
    public void moveRightAction() {
        if(Snakes.getDirection()!=3)
        {Snakes.moveRight();
        }
        if(isGameOver()){
            startgameframe.setVisible(false);
            GamesOver();
        }
        EatFood();
    }
    public void moveLeftAction() { 
        if(Snakes.getDirection()!=1)
        {   Snakes.moveLeft();
        }  
        if(isGameOver()){
            startgameframe.setVisible(false);
            GamesOver();
        }
        EatFood();
    }
    public void moveUpAction() {  
        if(Snakes.getDirection()!=2) {
        Snakes.moveUp();  
        
        }
        if(isGameOver()){
            startgameframe.setVisible(false);
            GamesOver();
        }
        EatFood();
    }
    public void moveDownAction() {  
        if(Snakes.getDirection()!=0)
        Snakes.moveDown();  
        if(isGameOver()){
            startgameframe.setVisible(false);
            GamesOver();
        }
       EatFood();
              
    }
    public void EatFood() {
        Point2D head=Snakes.getSnakes().getLast().getPoint();
        Point2D foods=food.getPoint();
        if((head.getX()==foods.getX())&&(head.getY()==foods.getY())){
            Snakes.addSnakeBody(Snakes.gettheDel());
            food.changeFoodRandom();
            Score++;
        }
    }
    private int Spreed=500;
    public void setSpreed(int s){
        Spreed=s;
    }
    public void start() {
        KeyListener L = new KeyAdapter() {  
            @Override  
            public void keyPressed(KeyEvent e) {  
                int code = e.getKeyCode();          
                switch (code) {  
                case KeyEvent.VK_DOWN:  
                     moveDownAction();  
                    break;  
                case KeyEvent.VK_LEFT:  
                    moveLeftAction();  
                    break;  
                case KeyEvent.VK_RIGHT:  
                    moveRightAction();  
                    break;  
                case KeyEvent.VK_UP:  
                    moveUpAction();  
                    break;  
                default:  
                    break;  
                }  
                repaint();  
            }  
        };  
        this.addKeyListener(L);  
        this.requestFocus();  
         while(true) {  
            if(StartIt){
                        this.requestFocus();  
            try {  
                Thread.sleep(Spreed);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            automove();
            repaint();
            }else System.out.println();
         }
    }
    public void automove(){
        int d=Snakes.getDirection();
        switch (d){
            case 0:
                Snakes.moveUp();
                break;
            case 1:
                Snakes.moveRight();
                break;
            case 2:
                Snakes.moveDown();
                break;
            case 3:
                Snakes.moveLeft();
                break;    
        }
        if(isGameOver()){
            startgameframe.setVisible(false);
            new GameOver();
        }
        EatFood();
        
    }
    
}
