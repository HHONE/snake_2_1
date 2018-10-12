/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author 刘宇
 */
public class head extends Borke{
    public head(int row,int col){
        super.setRow(row);
        super.setCol(col);
        super.setBorkeRect(new Rectangle2D.Double(row, col, 20, 20) );
    }
}
