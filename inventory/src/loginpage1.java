import javax.swing.*;
import java.awt.*;
//this page for owner login

public class loginpage1{

    String oUsername="owner",oPassword="opass123";
    
    JFrame jf;
    JLabel jl1,jl2;
    JButton jb1;
    public loginpage1()
    {

        jf=new JFrame("loginPageForOwner");
        
        Toolkit t =jf.getToolkit();
        Dimension d=t.getScreenSize();
        int width =d.width*8/10;
        int height=d.height*8/10;
        jf.setBounds(width/8, height/8, width, height);

        
        jl1=new JLabel("oUsername");
        jl1.setBounds(20,20,200,150);
        jl2=new JLabel("oPassword");
        jl2.setBounds(20,60,200,150);
        
        jf.add(jl1);
        jf.add(jl2);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        
    }
}


