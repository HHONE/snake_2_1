/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WallFood;

import java.awt.geom.Point2D;

/**
 *
 * @author 刘宇
 */
public class Wall {
    private Point2D[] theWallPoint=new Point2D[136];
    public Wall(int ch) {
        if(ch==1){
        int k=0;
        for(int i=20; i<=800 ;i=i+20){
		for(int j=20;j<=600;j=j+20){
			if((i==20)||(i==800)||(j==20)||(j==600)){
			 theWallPoint[k]=new Point2D.Double(i,j);
                         k++;
                }
            }
        }
	}else if(ch==2){
            int k=0;
	        for(int i=20; i<=800 ;i=i+20){
				 theWallPoint[k]=new Point2D.Double(i,20);
	                         k++;
	                }
	        
			for(int i=40; i<=20*10 ;i=i+20){
					theWallPoint[k]=new Point2D.Double(20,i);
                        k++;
               }
			for(int i=40; i<=20*10 ;i=i+20){
				theWallPoint[k]=new Point2D.Double(800,i);
                    k++;
				}
			for(int i=20*21; i<600 ;i=i+20){
				theWallPoint[k]=new Point2D.Double(20,i);
                    k++;
				}
			for(int i=20*21; i<600 ;i=i+20){
				theWallPoint[k]=new Point2D.Double(800,i);
                	k++;
				}
			for(int i=20*11; i<=20*20 ;i=i+20){
				theWallPoint[k]=new Point2D.Double(20*10,i);
                    k++;
				}
			for(int i=20*11; i<=20*20 ;i=i+20){
				theWallPoint[k]=new Point2D.Double(20*30,i);
                	k++;
				}
			for(int i=20; i<=800 ;i=i+20){
					theWallPoint[k]=new Point2D.Double(i,600);
							k++;
					}
        }
        else{
        int k=0;
        for(int i=20; i<=800 ;i=i+20){
		for(int j=20;j<=600;j=j+20){
			if((i==20)||(i==800)||(j==20)||(j==600)){
			 theWallPoint[k]=new Point2D.Double(i,j);
                         k++;
                }
            }
        }
	}
    }
    public Point2D[] getWall(){
        return theWallPoint;
    }
}
