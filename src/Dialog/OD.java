/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dialog;

import Dialog.ODFrame;
import java.awt.*;
import javax.swing.*;

public class OD
{ 
   public static JFrame frame = new ODFrame();
   public OD()
   {
      EventQueue.invokeLater(() -> {
         
         frame.setTitle("Set");
         frame.setSize(1130/2, 700/2);
         frame.setResizable(false);
         frame.setLocationRelativeTo(null);  
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setVisible(true);
      });
   }
}
