/*import java.awt.*;
import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;
import javax.swing.*;

//import javax.imageio.ImageIO;


class myframe implements ActionListener
{
    Frame f;
    Button submit;
    TextField user,pass;
    Label l1,l2;
   // BufferedImage bi;



    public String username="dhairyashil";
    public String Password="drpatil";

    String u,p;

    
    myframe(String s) //throws IOException
    {
        f=new Frame();
       
        user=new TextField();
        user.setBounds(500, 200, 100, 25);
        pass=new TextField();
        pass.setBounds(500, 250, 100, 25);
        submit=new Button("ok");
        submit.setBounds(500,300,100,25);
        submit.addActionListener(this);

        f.setBackground(Color.pink);
        
    

    

        l1=new Label("username");
        l2=new Label("password");

        l1.setBounds(420, 200, 70, 20);
        l2.setBounds(420, 250, 70, 20);


        f.add(l1);
        f.add(l2);
        f.add(user);
        f.add(pass);
        f.add(submit);
        
        //bi=ImageIO.read(new File("D:\\dhairyashil\\inventory\\inventory\\images\\background_login.jpg"));


        Toolkit t =f.getToolkit();
        Dimension d=t.getScreenSize();
        int width =d.width*8/10;
        int height=d.height*8/10;

        f.setBounds(width/8, height/8, width, height);
        
        f.setLayout(null);
        f.setVisible(true);
       
    }

    public void actionPerformed(ActionEvent e)
    {  
        String a=user.getText();
        String b=pass.getText();

        if(username.equals(a)&&Password.equals(b))
        {
            mainpage mp=new mainpage();
        } 
       
    }
    /*public void paint(Graphics g)
    {
        
        g.drawImage(bi, 0, 0, user);
    }
}


public class loginpage{
    public static void main(String[] args) throws IOException {

        myframe a=new myframe("loginpage");
        
    }
}

*/





import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myframe implements ActionListener
{
JFrame jf;
JButton jb,jb1;




    public myframe(String s)
    {
       jf=new JFrame(s);
      
       jf.setBounds(0,0,1500,850);

       jb=new JButton("OWNER",new ImageIcon("D:\\dhairyashil\\inventory\\inventory\\images\\owner.png"));
      
       jb.addActionListener(this);


       jb1=new JButton("EMPLOYEE",new ImageIcon("D:\\dhairyashil\\inventory\\inventory\\images\\employee.png"));
       
       jb1.addActionListener(this);


       jf.add(jb,BorderLayout.WEST);
       jf.add(jb1,BorderLayout.WEST);
     
       

      jf.setLayout(new FlowLayout());
       jf.setVisible(true);
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb)
        {
            loginpage1 l1=new loginpage1();
        }
        else if(e.getSource()==jb1)
        {
            loginpage2 l2=new loginpage2();

        }
        
    }



}

public class loginpage
{
    public static void main(String[] args) {
        myframe mf=new myframe("login page");
    }
}

