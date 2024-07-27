import java.awt.*;

import javax.swing.*;



public class mainpageE 
{
    JFrame f;
    JButton b;

   public mainpageE()
   {
    f=new JFrame(); 
    f.setBounds(500, 200, 100, 25);

    b=new JButton("welcome");
    b.setBounds(500, 200, 100, 25);

    f.add(b);

    
    
    Toolkit t =f.getToolkit();
    Dimension d=t.getScreenSize();
    int width =d.width*8/10;
    int height=d.height*8/10;

    f.setBounds(width/8, height/8, width, height);
    f.setLayout(null);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);

   }


  }
    

