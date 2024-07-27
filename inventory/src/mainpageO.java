import java.awt.*;


public class mainpageO 
{
    Frame f;
    Button b;

   public mainpageO()
   {
    f=new Frame(); 
    f.setBounds(500, 200, 100, 25);

    b=new Button("welcome");
    b.setBounds(500, 200, 100, 25);

    f.add(b);

    
    
    Toolkit t =f.getToolkit();
    Dimension d=t.getScreenSize();
    int width =d.width*8/10;
    int height=d.height*8/10;

    f.setBounds(width/8, height/8, width, height);
    f.setLayout(null);
    
    f.setVisible(true);

   }


  }
    

