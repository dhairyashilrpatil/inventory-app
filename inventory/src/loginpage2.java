import javax.swing.*;
import java.awt.*;
//this page for owner login

public class loginpage2{

    String oUsername="employee",oPassword="epass123";
    
    JFrame jf;
    JLabel jl1,jl2;
    JButton jb1;
    public loginpage2()
    {

        jf=new JFrame("loginPageForEmployee");
        
        Toolkit t =jf.getToolkit();
        Dimension d=t.getScreenSize();
        int width =d.width*8/10;
        int height=d.height*8/10;
        jf.setBounds(width/8, height/8, width, height);

        jl1=new JLabel("eUsername");
        jl2=new JLabel("ePassword");
        jf.add(jl1);
        jf.add(jl2);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        
    }
}


